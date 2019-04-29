package com.example.eartrain;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ViewHolder>
{
    Exercise[] m_exercises;
    Context m_context;

    public ExerciseListAdapter(Context context, Exercise[] exercises)
    {
        Log.d(TAG, "ExerciseListAdapter: NOT DAB");
        m_exercises = exercises;
        m_context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        Log.d(TAG, "onCreateViewHolder: DABn'n't");
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.exercise_list_layout, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i)
    {
        viewHolder.m_txtTitle.setText(m_exercises[i].getTitle());
        viewHolder.m_txtDescription.setText(m_exercises[i].getDescription());
        viewHolder.m_txtSuccesses.setText("" + m_exercises[i].getSuccesses());
        viewHolder.m_txtScore.setText("" + m_exercises[i].getScore());
        viewHolder.m_txtTime.setText("" + m_exercises[i].getTime());

        viewHolder.m_btnStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(m_context, IntervalActivity.class);
                intent.putExtra("MODE", IntervalActivity.Mode.DESCENDING.getValue());
                Interval[] intervals = m_exercises[i].getIntervals();
                ArrayList<Integer> intervalHalfSteps = new ArrayList<>();
                for (int i = 0; i < intervals.length; i++)
                {
                    intervalHalfSteps.add(intervals[i].size());
                }
                int[] arr = new int[intervalHalfSteps.toArray().length];
                for (int i = 0; i < arr.length; i++)
                {
                    arr[i] = (int)intervalHalfSteps.toArray()[i];
                }
                Log.d(TAG, "onClick: " + (int)intervalHalfSteps.toArray()[1]);
                intent.putExtra("INTERVALS", arr);
                m_context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return m_exercises.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView m_txtTitle;
        TextView m_txtDescription;
        TextView m_txtSuccesses;
        TextView m_txtScore;
        TextView m_txtTime;
        Button m_btnStart;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            m_txtTitle = itemView.findViewById(R.id.txt_title);
            m_txtDescription = itemView.findViewById(R.id.txt_description);
            m_txtSuccesses = itemView.findViewById(R.id.txt_successes);
            m_txtScore = itemView.findViewById(R.id.txt_score);
            m_txtTime = itemView.findViewById(R.id.txt_time);
            m_btnStart = itemView.findViewById(R.id.btn_start);
        }
    }
}
