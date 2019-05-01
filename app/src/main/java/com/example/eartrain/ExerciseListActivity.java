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
                        0,
                        "Unisons and ascending seconds",
                        "Start here.",
                        new Interval[]{
                                Interval.UNISON,
                                Interval.MINOR_SECOND,
                                Interval.MAJOR_SECOND
                        },
                        null,
                        IntervalActivity.Mode.ASCENDING
                ),
                new Exercise(
                        1,
                        "Unisons and descending seconds",
                        "Continue here.",
                        new Interval[]{
                                Interval.UNISON,
                                Interval.MINOR_SECOND,
                                Interval.MAJOR_SECOND
                        },
                        null,
                        IntervalActivity.Mode.DESCENDING
                ),
                new Exercise(
                        2,
                        "Harmonic unisons and seconds",
                        "Do these even need descriptions?",
                        new Interval[]{
                                Interval.UNISON,
                                Interval.MINOR_SECOND,
                                Interval.MAJOR_SECOND
                        },
                        null,
                        IntervalActivity.Mode.HARMONIC
                ),
                new Exercise(
                        3,
                        "Ascending thirds",
                        "Hello.",
                        new Interval[]{
                                Interval.MINOR_THIRD,
                                Interval.MAJOR_THIRD
                        },
                        null,
                        IntervalActivity.Mode.ASCENDING
                ),
                new Exercise(
                        4,
                        "Descending thirds",
                        "(:.",
                        new Interval[]{
                                Interval.MINOR_THIRD,
                                Interval.MAJOR_THIRD
                        },
                        null,
                        IntervalActivity.Mode.DESCENDING
                ),
                new Exercise(
                        5,
                        "Harmonic thirds",
                        ":)",
                        new Interval[]{
                                Interval.MINOR_THIRD,
                                Interval.MAJOR_THIRD
                        },
                        null,
                        IntervalActivity.Mode.HARMONIC
                ),
                new Exercise(
                        6,
                        "Ascending fourths and fifths",
                        "Time to finish up those chords.",
                        new Interval[]{
                                Interval.PERFECT_FOURTH,
                                Interval.AUGMENTED_FOURTH,
                                Interval.PERFECT_FIFTH
                        },
                        null,
                        IntervalActivity.Mode.ASCENDING
                ),
                new Exercise(
                        7,
                        "Ascending sixths and sevenths",
                        "You like jazz?",
                        new Interval[]{
                                Interval.MINOR_SIXTH,
                                Interval.MAJOR_SIXTH,
                                Interval.MINOR_SEVENTH,
                                Interval.MAJOR_SEVENTH
                        },
                        null,
                        IntervalActivity.Mode.ASCENDING
                ),
                new Exercise(
                        8,
                        "Ascending everything",
                        "Oh boy.",
                        new Interval[]{
                                Interval.UNISON,
                                Interval.MINOR_SECOND,
                                Interval.MAJOR_SECOND,
                                Interval.MINOR_THIRD,
                                Interval.MAJOR_THIRD,
                                Interval.PERFECT_FOURTH,
                                Interval.AUGMENTED_FOURTH,
                                Interval.PERFECT_FIFTH,
                                Interval.MINOR_SIXTH,
                                Interval.MAJOR_SIXTH,
                                Interval.MINOR_SEVENTH,
                                Interval.MAJOR_SEVENTH,
                                Interval.OCTAVE
                        },
                        null,
                        IntervalActivity.Mode.ASCENDING
                ),
        };
    }
}
