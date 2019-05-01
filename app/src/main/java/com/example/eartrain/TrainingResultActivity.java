package com.example.eartrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class TrainingResultActivity extends AppCompatActivity
{
    // UI elements
    TextView m_txtCorrect;
    TextView m_txtScore;
    TextView m_txtTime;
    Button m_btnQuit;
    Button m_btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_result);

        setUp();

        // TODO: Record training activity
    }

    void setUp()
    {
        // Set up UI references
        m_txtCorrect = findViewById(R.id.txt_correct);
        m_txtScore = findViewById(R.id.txt_score);
        m_txtTime = findViewById(R.id.txt_time);
        m_btnQuit = findViewById(R.id.btn_quit);
        m_btnContinue = findViewById(R.id.btn_continue);

        // Fetch extras and set text views
        Intent intent = getIntent();
        // TODO: Don't hardcode these strings
        m_txtCorrect.setText("" + intent.getIntExtra("CORRECT", 0));
        m_txtScore.setText("" + intent.getIntExtra("SCORE", 0));
        m_txtTime.setText("" + String.format(Locale.ENGLISH, "%.2f", intent.getDoubleExtra("TIME", 0))+"s");

        // Set up quit and continue buttons
        m_btnQuit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
        m_btnContinue.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
                Intent continueIntent = new Intent(
                        TrainingResultActivity.this,
                        IntervalActivity.class
                );
                startActivity(continueIntent);
            }
        });
    }
}
