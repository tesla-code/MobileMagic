package com.example.eartrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

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
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUp()
    {
        //Registering buttons
        chordButton = findViewById(R.id.btn_chord);
        chordButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
            }
        });

        intervalButton = findViewById(R.id.btn_interval);
        intervalButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
            }
        });

        replicationButton = findViewById(R.id.btn_replication);
        replicationButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
            }
        });

        statButton = findViewById(R.id.btn_stats);
        statButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
            }
        });
    }
}
