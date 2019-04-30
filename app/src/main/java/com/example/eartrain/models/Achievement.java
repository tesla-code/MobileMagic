package com.example.eartrain.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "achievements")
public class Achievement
{
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String description;
    public boolean achieved;
    //public Date timeStamp;
}
