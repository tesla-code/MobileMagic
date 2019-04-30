package com.example.eartrain.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.eartrain.models.Achievement;
import com.example.eartrain.models.Score;

import java.util.List;

@Dao
public interface ScoreDao
{
    //-----------------ALL_STATEMENTS_FOR_SCORE-------------------------
    @Query("Select * FROM scores")
    List<Score> getScores();

    @Insert
    void insert(Score score);

}
