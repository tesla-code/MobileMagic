package com.example.eartrain.helpers;

public class ScoreAddHelper
{
    public int score;
    public String type;

    public static final String CHORD_TYPE = "CHORD";
    public static final String INTERVAL_TYPE = "INTERVAL";
    public static final String REPLICATION_TYPE = "REPLICATION";


    public ScoreAddHelper(int score, String type)
    {
        this.score = score;
        this.type = type;
    }
}
