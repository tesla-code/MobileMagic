package com.example.eartrain;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

public class ReplicationActivity extends AppCompatActivity
{
    private final String TAG = "ReplicationActivity";

    enum Mode
    {
        ASCENDING(0),
        DESCENDING(1),
        MIXED(2);

        private int m_value;

        Mode(int value)
        {
            m_value = value;
        }

        int getValue()
        {
            return m_value;
        }
    }

    Mode m_mode;
    int m_targetNote;               // The note the user should hit
    double m_noteTime;              // How long the user has held a note
    double m_lastTime;              // The last measured time
    int m_correctAnswers;           // The amount of correct notes sung.
    int m_currentRound;             // The current round
    int m_score;                    // The current score
    long m_lastNanoTime;            // The last nano time
    double m_totalTime;             // The total time so far
    double m_currentRoundTime;      // The total time in the current round so far

    // UI elements
    TextView m_txtSuccessCounter;   // Measures successful interval singing
    Button m_btnPlay;               // Replays audio
    TextView m_txtInstruction;      // Instructs the user to sing an interval
    Button m_btnMicrophone;         // Mutes/unmutes microphone if pressed
    SeekBar m_barNoteTime;          // Shows how long a note has been held for
    TextView m_txtPitch;            // DEBUG: Displays pitch

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replication);

        ActivityCompat.requestPermissions(
                ReplicationActivity.this,
                new String[]{Manifest.permission.RECORD_AUDIO},
                1
        );

        m_txtSuccessCounter = findViewById(R.id.txt_success_counter);
        m_btnPlay = findViewById(R.id.btn_play);
        m_txtInstruction = findViewById(R.id.txt_instruction);
        m_btnMicrophone = findViewById(R.id.btn_microphone);
        m_barNoteTime = findViewById(R.id.bar_note_time);
        m_txtPitch = findViewById(R.id.txt_pitch);

        m_mode = Mode.values()[getIntent().getIntExtra("MODE", 0)];
    }

    /**
     * Sets up the activity if permission granted and leaves if not
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults)
    {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            // Permission granted
            AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);
            PitchDetectionHandler pdh = new PitchDetectionHandler()
            {
                @Override
                public void handlePitch(PitchDetectionResult pitchDetectionResult, AudioEvent audioEvent)
                {
                    final float pitch = pitchDetectionResult.getPitch();
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            handlePitchUpdate(pitch);
                        }
                    });
                }
            };

            AudioProcessor audioProcessor = new PitchProcessor(
                    PitchProcessor.PitchEstimationAlgorithm.FFT_YIN,
                    22050,
                    1024,
                    pdh
            );
            dispatcher.addAudioProcessor(audioProcessor);
            new Thread(dispatcher, "Audio Dispatcher").start();
        }
        else
        {
            // Permission denied
            Toast.makeText(getApplicationContext(), "FUCK", Toast.LENGTH_LONG).show();
            finish();
        }

        m_currentRound = 0;
        m_totalTime = 0;
        m_lastNanoTime = System.nanoTime();
        startNextRound();
    }

    private void startNextRound()
    {
        m_currentRoundTime = 0.0f;
        m_currentRound++;
        m_noteTime = 0.0f;

        m_txtSuccessCounter.setText(m_correctAnswers + "/10");

        // Randomise target note and interval
        // TODO: Base target note on pitch range in prefs
        m_targetNote = new Random().nextInt(24) + 48;
        int halfSteps = new Random().nextInt(Interval.values().length);
        Interval interval = Interval.values()[halfSteps];

        int tempRootNote = m_targetNote;
        boolean ascending = true;
        switch(m_mode)
        {
            case ASCENDING:
                ascending = true;
                break;
            case DESCENDING:
                ascending = false;
                break;
            case MIXED:
                if (new Random().nextInt(2) == 1)
                {
                    ascending = true;
                }
                else
                {
                    ascending = false;
                }
                break;
        }
        final int rootNote = tempRootNote;

        if (ascending)
        {
            tempRootNote -= halfSteps;
        }
        else
        {
            tempRootNote += halfSteps;
        }

        // Play the root note
        m_btnPlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().play(getApplicationContext(), rootNote);
            }
        });
        m_btnPlay.callOnClick();

        // Display instruction to sing the interval
        String instruction = String.format(
                getString(R.string.interval_singing_instruction),
                interval,
                ascending ? ("above") : ("below")
        );
        m_txtInstruction.setText(instruction);
    }

    /**
     * Handles pitch update
     * @param pitch The new pitch
     */
    protected void handlePitchUpdate(final float pitch)
    {
        long time = System.nanoTime();
        double seconds = (time - m_lastNanoTime) / 1000000000.0;
        m_totalTime += seconds;
        m_currentRoundTime += seconds;
        m_lastNanoTime = time;
        if (m_currentRoundTime < 4.5f)
        {
            return; // Safeguard against played note being recognised as the user singing
        }
        m_txtPitch.setText("" + pitch);
        if (pitch != -1)
        {
            // Get time since last update.
            m_noteTime += seconds;

            // Perform pitch calculations
            // TODO: Fetch cent range from prefs
            int midiNumber = (int) Math.round(69 + 12 * Math.log(pitch / 440.0) / Math.log(2));

            // Check if user has held a pitch for more than the required amount of time
            if (m_noteTime > 2.5f /* TODO: Magic number */)
            {
                // Check if the note is correct
                if (midiNumber == m_targetNote)
                {
                    m_correctAnswers++;
                    m_score += 100; // TODO: Don't hardcode the score calculation constants
                    m_score += (10.0 - m_currentRoundTime) * 50;
                }

                if (m_currentRound == 10)
                {
                    m_currentRound = 0;
                    // Go to results screen.
                    Intent intent = new Intent(
                            ReplicationActivity.this,
                            TrainingResultActivity.class
                    );
                    intent.putExtra("SCORE", m_score);
                    intent.putExtra("TIME", m_totalTime);
                    intent.putExtra("CORRECT", m_correctAnswers);
                    finish();
                    startActivity(intent);
                }
                else
                {
                    startNextRound();
                }
            }
        }
        else
        {
            // No pitch detected
            m_noteTime = 0.0;
        }

        m_barNoteTime.setProgress((int) (m_noteTime * 100 / 2.5f));
    }

    /**
     * Converts a midi number to standard note names.
     * @param n The midi number
     * @return
     */
    private String midiNumberToNoteName(final double n)
    {
        String note;
        int roundedN = (int)Math.round(n);
        switch (roundedN % 12)
        {
            case 0:
                note = "C";
                break;
            case 1:
                note = "C#"; // TODO: #/b should be preference / key based
                break;
            case 2:
                note = "D";
                break;
            case 3:
                note = "D#";
                break;
            case 4:
                note = "E";
                break;
            case 5:
                note = "F";
                break;
            case 6:
                note = "F#";
                break;
            case 7:
                note = "G";
                break;
            case 8:
                note = "G#";
                break;
            case 9:
                note = "A";
                break;
            case 10:
                note = "A#";
                break;
            case 11:
                note = "B";
                break;
            default:
                note = "THIS NOTE DOES NOT EXIST";
                break;
        }
        note += ((int)Math.round(n) / 12 - 1);

        return note;
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}
