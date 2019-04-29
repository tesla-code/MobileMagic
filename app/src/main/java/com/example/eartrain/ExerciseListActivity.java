package com.example.eartrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ExerciseListActivity extends AppCompatActivity
{
    RecyclerView m_recyclerView;
    RecyclerView.Adapter m_adapter;
    RecyclerView.LayoutManager m_layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        setUp();
    }

    void setUp()
    {
        m_recyclerView = findViewById(R.id.recycler_view);
        m_layoutManager = new LinearLayoutManager(this);
        m_recyclerView.setLayoutManager(m_layoutManager);

        // m_adapter = new ExerciseListAdapter(exercises);
        m_recyclerView.setAdapter(m_adapter);
    }
}
