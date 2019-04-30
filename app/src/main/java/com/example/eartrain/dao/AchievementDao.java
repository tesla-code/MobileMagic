package com.example.eartrain.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.eartrain.models.Achievement;

import java.util.List;

@Dao
public interface AchievementDao
{
    @Query("SELECT * FROM achievements")
    List<Achievement> getAllAchievements();

    @Insert
    void insert(Achievement achievement);


}
