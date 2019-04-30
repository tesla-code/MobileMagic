package com.example.eartrain.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "achievements")
public class Achievement
{
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String name;
    public String description;
    public boolean achieved = false;
    //public Date timeStamp;

    public Achievement(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
}
