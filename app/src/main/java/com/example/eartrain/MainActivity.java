package com.example.eartrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    StorageHandler storageHandler;
    Button chordButton, intervalButton, statButton, replicationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        storageHandler = new StorageHandler(getApplicationContext());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUp();
        tutorial();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUp()
    {
        //Registering buttons
        chordButton = findViewById(R.id.btn_chord);
        chordButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChordActivity.class));

            }
        });

        intervalButton = findViewById(R.id.btn_interval);
        intervalButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), IntervalActivity.class));
            }
        });

        replicationButton = findViewById(R.id.btn_replication);
        replicationButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ReplicationActivity.class));
            }
        });

        statButton = findViewById(R.id.btn_stats);
        statButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StatisticActivity.class));
            }
        });
    }

    /**
     *
     * Checks whether a tutorial should be played
     */
    private void tutorial()
    {
        StorageHandler storageHandler = new StorageHandler(this);

        //if this is the first time the app is opened
        if (storageHandler.getFirstTime())
        {
            //set the first time flag to false
            storageHandler.setFirstTime(false);
            //launch tutorial
            startActivity(new Intent(MainActivity.this, TutorialActivity.class));
        }
    }
}
