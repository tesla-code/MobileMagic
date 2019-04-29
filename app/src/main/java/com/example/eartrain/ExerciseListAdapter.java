package com.example.eartrain;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ViewHolder>
{
    String[] m_dataset;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {

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

        public ViewHolder(
                @NonNull View itemView,
                TextView m_txtTitle,
                TextView m_txtDescription,
                TextView m_txtSuccesses,
                TextView m_txtScore,
                TextView m_txtTime)
        {
            super(itemView);
            this.m_txtTitle = m_txtTitle;
            this.m_txtDescription = m_txtDescription;
            this.m_txtSuccesses = m_txtSuccesses;
            this.m_txtScore = m_txtScore;
            this.m_txtTime = m_txtTime;
        }
    }
}
