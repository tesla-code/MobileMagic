package com.example.eartrain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.SeekBar;

public class SettingsActivity extends AppCompatActivity
{
    int mSensitivity = 0;
    SeekBar mSensitivityBar;

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
        mSensitivity = storageHandler.getSensitivity();

        //set up Sensitivity bar
        mSensitivityBar = findViewById(R.id.m_SensitivityBar);
        mSensitivityBar.setProgress((mSensitivity-5)*5);
        mSensitivityBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                //can't set min/max on a seekbar, this makes the range 5-30
                mSensitivity = mSensitivityBar.getProgress()/5;
                storageHandler.setSensitivity(mSensitivity+5);
            }
        });

    }

}
