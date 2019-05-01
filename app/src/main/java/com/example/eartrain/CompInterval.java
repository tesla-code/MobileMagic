package com.example.eartrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CompInterval extends AppCompatActivity
{
    private Player player1;
    private Player player2;

    private final String TAG = "CompInterval";


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
    IntervalActivity.Mode m_mode;                    // The exercise mode
    SoundManager m_soundManager;    // Plays sounds



    // UI elements
    TextView m_txtSuccessCounter;   // Displays amount of correct answers
    Button m_btnPlay;               // Replays the interval
    Button m_btnUnison;             // |
    Button m_btnMinorSecond;        // | Player answer buttons
    Button m_btnMajorSecond;        // |


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        player1 = new Player();
        player2 = new Player();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_interval);






    }
}
