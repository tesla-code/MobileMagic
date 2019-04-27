package com.example.eartrain;

public class ScoreTable
{
    /**
     * Database table and column names
     */
    public static final String TABLE_NAME = "score";
    public static final String COLUMN_POINTS = "points";
    public static final String COLUMN_TIMESTAMP = "date"; //Used as PPK together with COLUMN_TYPE
    public static final String COLUMN_TYPE = "type"; //Used as PPK together with COLUMN_DATE

    /**
     * Create table string
     */
    public static final String CREATE_TABLE =
            "CREATE TABLE" + TABLE_NAME +"(" +
                    COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                    COLUMN_TYPE + " VARCHAR, " +
                    COLUMN_POINTS + " FLOAT,"
                    + " PRIMARY KEY (" + COLUMN_TIMESTAMP + ", " + COLUMN_TYPE + "))";

    public enum ScoreType
    {
        INTERVAL,
        REPLICATION,
        CHORD
    }
}
