package com.example.eartrain.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.eartrain.dao.AchievementDao;
import com.example.eartrain.dao.ScoreDao;
import com.example.eartrain.models.Achievement;
import com.example.eartrain.models.Score;

//Setting exportSchema to false
@Database(entities = {Score.class, Achievement.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract ScoreDao scoreDao();
    public abstract AchievementDao achievementDao();
}
