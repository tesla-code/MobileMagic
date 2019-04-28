package com.example.eartrain;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ChordActivity extends AppCompatActivity
{
    final String TAG = "ChordActivity";
    public enum Mode
    {
        ASCENDING(0),
        DESCENDING(1),
        HARMONIC(2);

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

    Chord m_correctChord;           // The chord that was played to the user
    boolean m_firstTry;             // Did the user get the correct interval on their first try?
    int m_currentRound;             // The current round
    int m_correctAnswers;           // The amount of correct answers
    int m_score;                    // The current score
    double m_lastNanoTime;          // The last elapsed time in nanoseconds
    double m_totalTime;             // The time spent in total since training started
    Mode m_mode;                    // The exercise mode
    SoundManager m_soundManager;    // Plays sounds

    // UI elements
    TextView m_txtSuccessCounter;   // Displays amount of correct answers
    Button m_btnPlay;
    Button m_btnMaj;                // Replays the interval
    Button m_btnMin;                // |
    Button m_btnDim;                // | Player answer buttons
    Button m_btnAug;                // |

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord);

        // Fetch UI elements
        m_txtSuccessCounter = findViewById(R.id.txt_success_counter);
        m_btnPlay = findViewById(R.id.btn_play);
        m_btnMin = findViewById(R.id.btn_min);
        m_btnMaj = findViewById(R.id.btn_maj);
        m_btnDim = findViewById(R.id.btn_dim);
        m_btnAug = findViewById(R.id.btn_aug);

        m_currentRound = 0;
        m_correctAnswers = 0;
        m_totalTime = 0;

        m_mode = Mode.values()[getIntent().getIntExtra("MODE", 0)];

        m_soundManager = new SoundManager();

        startNextRound();
    }

    private void startNextRound()
    {
        m_txtSuccessCounter.setText(m_correctAnswers + "/" + m_currentRound);
        m_currentRound++;

        m_lastNanoTime = System.nanoTime();

        // Randomise interval and root note, and play sound
        m_correctChord = Chord.values()[new Random().nextInt(Chord.values().length)];
        final int root = new Random().nextInt(23) + 50;

        m_btnPlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Repeat the sound
                switch (m_mode)
                {
                    case ASCENDING:
                        Log.d(TAG, "onClick: ASCENDING");
                        new SoundManager().playChord(
                                getApplicationContext(),
                                root,
                                m_correctChord,
                                1000,
                                SoundManager.ChordPlayMode.ASCENDING
                        );
                        break;
                    case DESCENDING:
                        Log.d(TAG, "onClick: DESCENDING");
                        new SoundManager().playChord(
                                getApplicationContext(),
                                root,
                                m_correctChord,
                                1000,
                                SoundManager.ChordPlayMode.DESCENDING
                        );
                        break;
                    case HARMONIC:
                        Log.d(TAG, "onClick: HARMONIC");
                        new SoundManager().playChord(
                                getApplicationContext(),
                                root,
                                m_correctChord,
                                1000,
                                SoundManager.ChordPlayMode.HARMONIC
                        );
                        break;
                }
            }
        });

        m_btnPlay.callOnClick();

        //setUpIntervalButton(Interval.UNISON, m_btnUnison);
        //setUpIntervalButton(Interval.MINOR_SECOND, m_btnMinorSecond);
        //setUpIntervalButton(Interval.MAJOR_SECOND, m_btnMajorSecond);
        m_firstTry = true;
    }
}
