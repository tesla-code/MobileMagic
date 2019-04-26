package com.example.eartrain;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

public class ReplicationActivity extends AppCompatActivity
{
    int m_targetNote;           // The note the user should hit
    double m_noteTime;          // How long the user has held a note
    double m_lastTime;          // The last measured time
    int m_correctAnswers;       // The amount of correct notes sung.

    // UI elements
    Button m_btnPlay;
    Button m_btnMicrophone;
    ProgressBar m_barNoteTime;

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
            Log.d("AYYY", "Permission granted");
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
    }

    /**
     * Handles pitch update
     * @param pitch The new pitch
     */
    protected void handlePitchUpdate(final float pitch)
    {
        if (pitch != -1)
        {
            // Get time since last update.
            double time = System.nanoTime();
            double dt = time - m_lastTime;
            m_noteTime += dt;
            m_lastTime = time;

            // Perform pitch calculations
            double midiNumber = 69 + 12 * Math.log(pitch / 440.0) / Math.log(2);

            // Check if user has held a pitch for more than the required amount of time
            if (m_noteTime > 1.0 /* TODO: Magic number */)
            {
                // Check if the note is correct
                if (midiNumber == m_targetNote)
                {
                    m_correctAnswers++;
                }
            }
        }
        else
        {
            // No pitch detected
            m_noteTime = 0.0;
        }
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
}
