package com.example.eartrain;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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

        setUpChordButton(Chord.MAJOR, m_btnMaj);
        setUpChordButton(Chord.MINOR, m_btnMin);
        setUpChordButton(Chord.AUGMENTED, m_btnAug);
        setUpChordButton(Chord.DIMINISHED, m_btnDim);
        m_btnPlay.callOnClick();

        m_firstTry = true;
    }

    private void setUpChordButton(final Chord chord, final Button button)
    {
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                selectAnswer(chord, button);
            }
        });

        button.setBackgroundColor(Color.GRAY);
    }
    private void selectAnswer(Chord chord, Button button)
    {
        if (chord == m_correctChord)
        {
            button.setBackgroundColor(Color.GREEN);

            double seconds = (System.nanoTime() - m_lastNanoTime) / 1000000000.0;
            Log.d("SECONDS", "" + seconds);
            m_totalTime += seconds;

            if (m_firstTry)
            {
                // The user was successful
                m_correctAnswers++;
                m_score += 100; // TODO: Don't hardcode the score calculation constants
                m_score += (10.0 - seconds) * 50;
            }

            if (m_currentRound == 10 /* TODO: Don't magic number */)
            {
                // Go to results screen.
                Intent intent = new Intent(ChordActivity.this, TrainingResultActivity.class);
                intent.putExtra("SCORE", m_score);
                intent.putExtra("TIME", m_totalTime);
                intent.putExtra("CORRECT", m_correctAnswers);
                finish();
                startActivity(intent);
            }
            else
            {
                // More rounds to go
                startNextRound();
            }
        }
        else
        {
            button.setBackgroundColor(Color.RED);
            m_firstTry = false;
        }
    }
}
