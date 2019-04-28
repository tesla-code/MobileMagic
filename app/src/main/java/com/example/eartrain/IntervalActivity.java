package com.example.eartrain;


import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class IntervalActivity extends AppCompatActivity
{
    private final String TAG = "IntervalActivity";

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

    Interval m_correctInterval;     // The interval that was played to the user
    boolean m_firstTry;             // Did the user get the correct interval on their first try?
    int m_currentRound;             // The current round
    int m_correctAnswers;           // The amount of correct answers
    int m_score;                    // The current score
    double m_lastNanoTime;          // The last elapsed time in nanoseconds
    double m_totalTime;             // The time spent in total since training started
    double m_totalRoundTime;        // The time so far this round
    Mode m_mode;                    // The exercise mode
    SoundManager m_soundManager;    // Plays sounds

    // UI elements
    TextView m_txtSuccessCounter;   // Displays amount of correct answers
    Button m_btnPlay;               // Replays the interval
    Button m_btnUnison;             // |
    Button m_btnMinorSecond;        // | Player answer buttons
    Button m_btnMajorSecond;        // |
    // Button m_btnMinorThird;
    // Button m_btnMajorThird;
    // Button m_btnPerfectFourth;
    // Button m_btnAugmentedFourth;
    // Button m_btnPerfectFifth;
    // Button m_btnMinorSixth;
    // Button m_btnMajorSixth;
    // Button m_btnMinorSeventh;
    // Button m_btnMajorSeventh;
    // Button m_btnOctave;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval);

        // Fetch UI elements
        m_txtSuccessCounter = findViewById(R.id.txt_success_counter);
        m_btnPlay = findViewById(R.id.btn_play);
        m_btnUnison = findViewById(R.id.btn_unison);
        m_btnMinorSecond = findViewById(R.id.btn_minor_second);
        m_btnMajorSecond = findViewById(R.id.btn_major_second);

        m_currentRound = 0;
        m_correctAnswers = 0;
        m_totalTime = 0;
        m_lastNanoTime = System.nanoTime();

        m_mode = Mode.values()[getIntent().getIntExtra("MODE", 0)];

        m_soundManager = new SoundManager();

        startNextRound();
    }

    /**
     * Generates a new interval and prepares for user input.
     */
    private void startNextRound()
    {
        m_txtSuccessCounter.setText(m_correctAnswers + "/" + m_currentRound);
        m_currentRound++;

        // Randomise interval and root note, and play sound
        m_correctInterval = Interval.values()[new Random().nextInt(3)];
        final int note1 = new Random().nextInt(12) + 40 ; // TODO: Let user decide vocal range
        final int note2 = note1 + m_correctInterval.size();

        m_btnPlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Repeat the sound
                switch (m_mode)
                {
                    case ASCENDING:
                        new SoundManager().play(getApplicationContext(), note2);
                        new Handler().postDelayed(new Runnable()
                        {

                            @Override
                            public void run()
                            {
                                new SoundManager().play(getApplicationContext(), note2);
                            }
                        }, 1000);
                        break;
                    case DESCENDING:
                        new SoundManager().play(getApplicationContext(), note2);
                        new Handler().postDelayed(new Runnable()
                        {

                            @Override
                            public void run()
                            {
                                new SoundManager().play(getApplicationContext(), note1);
                            }
                        }, 1000);
                        break;
                    case HARMONIC:
                        new SoundManager().play(getApplicationContext(), note1);
                        new SoundManager().play(getApplicationContext(), note2);
                        break;
                }
            }
        });

        m_btnPlay.callOnClick();

        setUpIntervalButton(Interval.UNISON, m_btnUnison);
        setUpIntervalButton(Interval.MINOR_SECOND, m_btnMinorSecond);
        setUpIntervalButton(Interval.MAJOR_SECOND, m_btnMajorSecond);
        m_firstTry = true;
    }

    /**
     * Sets up onClickListener for an interval answer button.
     * @param interval The corresponding interval
     * @param button The button to be set up.
     */
    private void setUpIntervalButton(final Interval interval, final Button button)
    {
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                selectAnswer(interval, button);
            }
        });

        button.setBackgroundColor(Color.GRAY);
    }

    /**
     * Selects the interval to be checked against the correct one and responds appropriately.
     * @param interval The interval to be compared against the correct interval
     * @param button The button that was pressed
     */
    private void selectAnswer(Interval interval, Button button)
    {
        if (interval == m_correctInterval)
        {
            button.setBackgroundColor(Color.GREEN);

            double time = System.nanoTime();
            double seconds = time - m_lastNanoTime / 1000000000.0;
            m_totalRoundTime += seconds;
            m_totalTime += seconds;
            m_lastNanoTime = time;
            Log.d("SECONDS", "" + m_totalRoundTime);

            if (m_firstTry)
            {
                // The user was successful
                m_correctAnswers++;
                m_score += 100; // TODO: Don't hardcode the score calculation constants
                m_score += (10.0 - m_totalRoundTime) * 50;
            }

            if (m_currentRound == 10 /* TODO: Don't magic number */)
            {
                // Go to results screen.
                Intent intent = new Intent(IntervalActivity.this, TrainingResultActivity.class);
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
