package com.example.eartrain;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

enum Interval
{
    UNISON,
    MINOR_SECOND,
    MAJOR_SECOND,
    MINOR_THIRD,
    MAJOR_THIRD,
    PERFECT_FOURTH,
    AUGMENTED_FOURTH,
    PERFECT_FIFTH,
    MINOR_SIXTH,
    MAJOR_SIXTH,
    MINOR_SEVENTH,
    MAJOR_SEVENTH,
    OCTAVE
}

public class IntervalTrainingActivity extends AppCompatActivity
{
    Interval m_correctInterval;     // The interval that was played to the user
    boolean m_firstTry;             // Did the user get the correct interval on their first try?
    int m_currentRound;             // The current round
    int m_correctAnswers;           // The amount of correct asnwers

    // UI elements
    TextView m_txtSuccessCounter;   // Counts correct answers
    Button m_btnPlay;               // Replays the interval
    Button m_btnUnison;             // |
    Button m_btnMinorSecond;        // | Player answer buttons
    Button m_btnMajorSecond;        // |

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval_training);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Fetch UI elements
        m_txtSuccessCounter = findViewById(R.id.txt_success_counter);
        m_btnPlay = findViewById(R.id.btn_play);
        m_btnUnison = findViewById(R.id.btn_unison);
        m_btnMinorSecond = findViewById(R.id.btn_minor_second);
        m_btnMajorSecond = findViewById(R.id.btn_major_second);

        m_currentRound = 0;
        m_correctAnswers = 0;
        startNextRound();
    }

    /**
     * Generates a new interval and prepares for user input.
     */
    private void startNextRound()
    {
        m_txtSuccessCounter.setText(m_correctAnswers + "/" + m_currentRound);
        m_currentRound++;
        m_correctInterval = Interval.values()[new Random().nextInt(3)];

        m_btnPlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Repeat the sound
            }
        });

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

            if (m_firstTry)
            {
                // The user was successful
                m_correctAnswers++;
            }
            else
            {
                // The user was not successful
            }

            if (m_currentRound == 10 /* TODO: Don't magic number */)
            {
                // Go to results screen.
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
