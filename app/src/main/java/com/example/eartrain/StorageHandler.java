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
}
