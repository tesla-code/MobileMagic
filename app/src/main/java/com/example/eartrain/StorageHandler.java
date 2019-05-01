package com.example.eartrain;

import android.content.SharedPreferences;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Class for handling SharedPreferences
 */
public class StorageHandler
{
    SharedPreferences sharedPreferences;
    private static final String FILENAME = "Preferences";
    private static final String DATABASENAME = "Database";
    private static final String FIRSTTIME = "FirstTime";
    private static String SENSITIVITY = "Sensitivity";

    /**
     *
     * @param context Creates StorageHandler with application context
     */
    public StorageHandler(@org.jetbrains.annotations.NotNull Context context)
    {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(FILENAME,0);
    }

    /**
     *
     * @return integer note sensitivity
     */
    public int getSensitivity()
    {
        return sharedPreferences.getInt(SENSITIVITY, 0);
    }

    /**
     *
     * @param s stored to SharedPrefereneces
     */
    public void setSensitivity(int s)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SENSITIVITY,s);
        editor.commit();
    }

    /**
     *
     * @return boolean firstTime
     */
    public boolean getFirstTime()
    {
        return sharedPreferences.getBoolean(FIRSTTIME, true);
    }

    /**
     *
     * @param f stored to SharedPreferences
     */
    public void setFirstTime(boolean f)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(FIRSTTIME,f);
        editor.commit();
    }
}
