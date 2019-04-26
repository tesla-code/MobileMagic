package com.example.eartrain;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

/**
 *  SoundManager class is used to play sounds, to play the default sound from main
 *  do this:
 *      SoundManager soundManager = new SoundManager();
 *      soundManager.play(this);
 *
 * @author victor
 * @version 1.0
 */
public class SoundManager
{
    private MediaPlayer m_mediaPlayer;

    public enum soundType {
        a0h, // a0vh
        a0l, // a0vl
        a1h, // a1vh
    }

    /**
     * Default Constructor
     */
    public SoundManager()
    {
        m_mediaPlayer = new MediaPlayer();
    }

    public void play(Context i_context)
    {
        m_mediaPlayer = MediaPlayer.create(i_context, R.raw.a1);
        m_mediaPlayer.start();
        Log.i("Sound", "Playing sound");
    }

}
