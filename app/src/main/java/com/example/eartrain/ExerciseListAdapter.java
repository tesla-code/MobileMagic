package com.example.eartrain;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ViewHolder>
{
    Exercise[] m_exercises;

    public ExerciseListAdapter(Exercise[] exercises)
    {
        m_exercises = exercises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.exercise_list_layout, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        viewHolder.m_txtTitle.setText(m_exercises[i].getTitle());
        viewHolder.m_txtDescription.setText(m_exercises[i].getTitle());
        viewHolder.m_txtSuccesses.setText(m_exercises[i].getSuccesses());
        viewHolder.m_txtScore.setText(m_exercises[i].getScore());
        viewHolder.m_txtTime.setText("" + m_exercises[i].getTime());
    }

    @Override
    public int getItemCount()
    {
        return 0;
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
