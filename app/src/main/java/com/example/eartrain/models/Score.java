package com.example.eartrain.models;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "scores")
public class Score implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String type;
    public int score;
    public Date timeStamp;

    public Score(int score, String type)
    {
        this.score = score;
        this.type = type;
        timeStamp = new Date(System.currentTimeMillis());
    }

    public int getScore()
    {
        return this.score;
    }

}
