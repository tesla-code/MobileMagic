package com.example.eartrain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity
{
    private int m_Sensitivity = 0;
    private SeekBar mSensitivityBar;
    private TextView mSenseLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //retrieve sensitivity
        final StorageHandler storageHandler = new StorageHandler(this);
        m_Sensitivity = storageHandler.getSensitivity();

        //set up Sensitivity bar
        mSensitivityBar = findViewById(R.id.m_SensitivityBar);
        mSensitivityBar.setProgress((m_Sensitivity-5)*5);
        mSenseLabel = findViewById(R.id.lbl_SensitivityValue);

        mSensitivityBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                mSenseLabel.setText("Value: " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                // can't set min/max on a seekbar, this makes the range 5-30
                // (the reason we cant use setMin and setMax is because the
                // api level that we use is to low for that functionality)
                m_Sensitivity = mSensitivityBar.getProgress()/5;
                storageHandler.setSensitivity(m_Sensitivity+5);
            }
        });
    }
}
