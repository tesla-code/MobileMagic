package com.example.eartrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CompActivity extends AppCompatActivity
{
    private Button m_btn_interval;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp);

        m_btn_interval =findViewById(R.id.btn_interval);
        m_btn_interval.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(CompActivity.this, CompInterval.class);
                startActivity(intent);
            }
        });

    }
}
