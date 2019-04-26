package com.example.eartrain;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
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

    /**
     *
     * @param i_context the context that the method is called from
     * @param
     */
    public void play(Context i_context, int i_MDINoteNumber) // throws NullPointerException
    {
        m_mediaPlayer = MediaPlayer.create(i_context, play(i_MDINoteNumber));
        m_mediaPlayer.start();
        Log.i("Sound::Play", "Playing sound with MDINote " + i_MDINoteNumber);
        //m_mediaPlayer.reset();
    }


    /**
     * Takes an midi note number and returns the path to the file.
     * @param mdi
     * @return
     */
    public int play(int mdi)
    {
        switch (mdi)
        {
            case 21:
                return R.raw.a0vh;
        }
        return R.raw.a0vh;
    }

}
