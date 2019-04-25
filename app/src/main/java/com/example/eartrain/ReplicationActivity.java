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
            }
        }
        else
        {
            // No pitch detected
            m_noteTime = 0.0;
        }
    }
}
