package com.example.eartrain;

import android.content.SharedPreferences;
import android.content.Context;

/**
 * Class for handling all acsess to storage.
 * Implementing both SQLite and SharedPreferences
 */
public class StorageHandler
{
    SharedPreferences sharedPreferences;
    private static final String FILENAME = "Preferences";
    private static final String FIRSTTIME = "FirstTime";
    private static final String LOWNOTE = "LowNote";
    private static final String HIGHNOTE = "HighNote";
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

    /**
     *
     *
     * @return double lower bound on notes to be played back
     */
    public double getLowNote()
    {
        return sharedPreferences.getFloat(LOWNOTE, 40);
    }


    /**
     *
     *
     * @param l lower bound on notes to be played back
     */
    public void setLowNote(double l)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(LOWNOTE, (float)l);
        editor.commit();
    }

    /**
     *
     *
     * @return double upper bound on note to be played back
     */
    public double getHighNote()
    {
        return sharedPreferences.getFloat(HIGHNOTE, 120);
    }

    /**
     *
     *
     * @param h upper bound on note to be played back
     */
    public void setHighNote(double h)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(HIGHNOTE, (float)h);
        editor.commit();
    }
}
