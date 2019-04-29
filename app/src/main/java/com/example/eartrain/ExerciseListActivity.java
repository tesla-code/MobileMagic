package com.example.eartrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class ExerciseListActivity extends AppCompatActivity
{
    private final String TAG = "ExerciseListActivity";
    RecyclerView m_recyclerView;
    RecyclerView.Adapter m_adapter;
    RecyclerView.LayoutManager m_layoutManager;
    Exercise[] exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        setUp();
    }

    void setUp()
    {
        Log.d(TAG, "setUp: REE");
        exercises = generateExercises();
        m_recyclerView = findViewById(R.id.recycler_view);
        m_layoutManager = new LinearLayoutManager(this);
        m_recyclerView.setLayoutManager(m_layoutManager);

        m_adapter = new ExerciseListAdapter(this, exercises);
        m_recyclerView.setAdapter(m_adapter);
    }

    Exercise[] generateExercises()
    {
        return new Exercise[]{
            new Exercise(
                    "Unisons and ascending seconds",
                    "Start here.",
                    new Interval[]{
                            Interval.UNISON,
                            Interval.MINOR_SECOND,
                            Interval.MAJOR_SECOND
                    },
                    null,
                    0,  // TODO: Fetch last 3 from storage
                    0,
                    0
            ),
            new Exercise(
                    "Unisons and ascending seconds",
                    "Start here.",
                    new Interval[]{
                            Interval.UNISON,
                            Interval.MINOR_SECOND,
                            Interval.MAJOR_SECOND,
                            Interval.MINOR_THIRD,
                            Interval.MAJOR_THIRD
                    },
                    null,
                    0,  // TODO: Fetch last 3 from storage
                    0,
                    0
            )
        };
    }
}
