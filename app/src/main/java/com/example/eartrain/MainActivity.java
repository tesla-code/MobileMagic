package com.example.eartrain;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.PrecomputedText;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.eartrain.helpers.DataTransferHelper;
import com.example.eartrain.helpers.ScoreAddHelper;
import com.example.eartrain.models.Achievement;
import com.example.eartrain.models.Score;
import com.example.eartrain.singletons.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    StorageHandler storageHandler;
    Button chordButton, intervalButton, statButton, replicationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storageHandler = new StorageHandler(getApplicationContext());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setUp();
        tutorial();
        addScore(9001, "test");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

    private void setUp() {
        //Registering buttons
        chordButton = findViewById(R.id.btn_chord);
        chordButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChordActivity.class);
                intent.putExtra("MODE", ChordActivity.Mode.HARMONIC.getValue());
                startActivity(intent);
            }
        });

        intervalButton = findViewById(R.id.btn_interval);
        intervalButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExerciseListActivity.class);

                startActivity(intent);
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

                getStatistics();
            }
        });
    }

    /**
     * Checks whether a tutorial should be played
     */
    private void tutorial() {
        StorageHandler storageHandler = new StorageHandler(this);

        //if this is the first time the app is opened
        if (storageHandler.getFirstTime()) {
           // DatabaseHandler.getInstance(getApplicationContext()).getAppDatabase().achievementDao().insert(new Achievement("test", "this is not a love song"));
            //set the first time flag to false
            storageHandler.setFirstTime(false);
            //launch tutorial
            startActivity(new Intent(MainActivity.this, TutorialActivity.class));
            addAchievementTest();
        }
    }

    private void addAchievementTest() {
        class AddAchievement extends AsyncTask<Void, Void, Void>
        {

            @Override
            protected Void doInBackground(Void... voids)
            {
                Achievement achievement = new Achievement("test", "this is not a love song");
                DatabaseHandler.getInstance(getApplicationContext()).getAppDatabase().achievementDao().insert(achievement);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid)
            {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

            }
        }
        AddAchievement ac = new AddAchievement();
        ac.execute();
    }

    private void getStatistics()
    {
        class GetStatistics extends AsyncTask<Void, Void, DataTransferHelper>
        {
            @Override
            protected DataTransferHelper doInBackground(Void... voids)
            {
                DataTransferHelper transfer = new DataTransferHelper();
                transfer.allAchievements = DatabaseHandler.getInstance(getApplicationContext()).getAppDatabase().achievementDao().getAllAchievements();
                transfer.achievedAchievements = DatabaseHandler.getInstance(getApplicationContext()).getAppDatabase().achievementDao().getAchievedAchievements();
                transfer.allScores = DatabaseHandler.getInstance(getApplicationContext()).getAppDatabase().scoreDao().getScores();
                return transfer;
            }

            @Override
            protected void onPostExecute(DataTransferHelper transferHelper)
            {
                super.onPostExecute(transferHelper);
                Intent intent = new Intent(getApplicationContext(),StatisticActivity.class);
                intent.putExtra("achievementsList",(ArrayList<Achievement>) transferHelper.allAchievements);
                intent.putExtra("achievedAchievementList",(ArrayList<Achievement>)transferHelper.achievedAchievements);
                intent.putExtra("scoreList",(ArrayList<Score>) transferHelper.allScores);
                startActivity(intent);
            }
        }
        GetStatistics gt = new GetStatistics();
        gt.execute();
    }

    private void addScore(int score, String type)
    {
        class AddScoreTask extends AsyncTask<ScoreAddHelper, Void, Void>
        {
            @Override
            protected Void doInBackground(ScoreAddHelper... params)
            {
                ScoreAddHelper addHelper = params[0];
                Score score1 = new Score(addHelper.score,addHelper.type);
                DatabaseHandler.getInstance(getApplicationContext()).getAppDatabase().scoreDao().insert(score1);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid)
            {
            }
        }
        AddScoreTask addScore = new AddScoreTask();
        addScore.execute(new ScoreAddHelper(score,type));
    }
}

