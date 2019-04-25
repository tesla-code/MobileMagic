package com.example.eartrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TutorialActivity extends AppCompatActivity
{
    Button mOkBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        mOkBtn = findViewById(R.id.btn_okBtn);

        mOkBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //if clicked ,return to main activity
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                //make sure we are returning to original main activity instead of just putting
                //another activity on the stack
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}
