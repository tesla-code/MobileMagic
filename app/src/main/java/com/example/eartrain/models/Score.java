package com.example.eartrain.models;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import java.util.Date;

@Entity(tableName = "scores")
public class Score
{
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String type;
    public int score;
    //public Date timeStamp;

}
