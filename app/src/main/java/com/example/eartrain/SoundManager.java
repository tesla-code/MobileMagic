package com.example.eartrain;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
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
    public void play(Context i_context, int i_midiNumber) // throws NullPointerException
    {
        m_mediaPlayer = MediaPlayer.create(i_context, midiToResId(i_midiNumber));
        m_mediaPlayer.start();


        new Handler().postDelayed(new Runnable()
        {

            @Override
            public void run()
            {
                m_mediaPlayer.reset();
            }
        }, 5000);
    }

    void playInterval(final Context i_context, int i_midiNo1, final int i_midiNo2, int i_delay)
    {
        play(i_context, i_midiNo1);
        new Handler().postDelayed(new Runnable()
        {

            @Override
            public void run()
            {
                new SoundManager().play(i_context, i_midiNo2);
            }
        }, i_delay);
    }

    void playChord(final Context i_context, final int[] i_midiNumbers, int i_delay)
    {
        for (int i = 0; i < i_midiNumbers.length; i++)
        {
            final int index = i;
            new Handler().postDelayed(new Runnable()
            {

                @Override
                public void run()
                {
                    new SoundManager().play(i_context, i_midiNumbers[index]);
                }
            }, i_delay * i);
        }
    }

    void reset()
    {
        m_mediaPlayer.reset();
    }

    private int midiToResId(int i_midiNumber)
    {
        switch(i_midiNumber)
        {
            case 23:
                return R.raw.b0;
            case 24:
                return R.raw.c1;
            case 25:
                return R.raw.db1;
            case 26:
                return R.raw.d1;
            case 27:
                return R.raw.eb1;
            case 28:
                return R.raw.e1;
            case 29:
                return R.raw.f1;
            case 30:
                return R.raw.gb1;
            case 31:
                return R.raw.g1;
            case 32:
                return R.raw.ab1;
            case 33:
                return R.raw.a1;
            case 34:
                return R.raw.bb1;
            case 35:
                return R.raw.b1;
            case 36:
                return R.raw.c2;
            case 37:
                return R.raw.db2;
            case 38:
                return R.raw.d2;
            case 39:
                return R.raw.eb2;
            case 40:
                return R.raw.e2;
            case 41:
                return R.raw.f2;
            case 42:
                return R.raw.gb2;
            case 43:
                return R.raw.g2;
            case 44:
                return R.raw.ab2;
            case 45:
                return R.raw.a2;
            case 46:
                return R.raw.bb2;
            case 47:
                return R.raw.b2;
            case 48:
                return R.raw.c3;
            case 49:
                return R.raw.db3;
            case 50:
                return R.raw.d3;
            case 51:
                return R.raw.eb3;
            case 52:
                return R.raw.e3;
            case 53:
                return R.raw.f3;
            case 54:
                return R.raw.gb3;
            case 55:
                return R.raw.g3;
            case 56:
                return R.raw.ab3;
            case 57:
                return R.raw.a3;
            case 58:
                return R.raw.bb3;
            case 59:
                return R.raw.b3;
            case 60:
                return R.raw.c4;
            case 61:
                return R.raw.db4;
            case 62:
                return R.raw.d4;
            case 63:
                return R.raw.eb4;
            case 64:
                return R.raw.e4;
            case 65:
                return R.raw.f4;
            case 66:
                return R.raw.gb4;
            case 67:
                return R.raw.g4;
            case 68:
                return R.raw.ab4;
            case 69:
                return R.raw.a4;
            case 70:
                return R.raw.bb4;
            case 71:
                return R.raw.b4;
            case 72:
                return R.raw.c5;
            case 73:
                return R.raw.db5;
            case 74:
                return R.raw.d5;
            case 75:
                return R.raw.eb5;
            case 76:
                return R.raw.e5;
            case 77:
                return R.raw.f5;
            case 78:
                return R.raw.gb5;
            case 79:
                return R.raw.g5;
            case 80:
                return R.raw.ab5;
            case 81:
                return R.raw.a5;
            case 82:
                return R.raw.bb5;
            case 83:
                return R.raw.b5;
            case 84:
                return R.raw.c6;
            case 85:
                return R.raw.db6;
            case 86:
                return R.raw.d6;
            case 87:
                return R.raw.eb6;
            case 88:
                return R.raw.e6;
            case 89:
                return R.raw.f6;
            case 90:
                return R.raw.gb6;
            case 91:
                return R.raw.g6;
            case 92:
                return R.raw.ab6;
            case 93:
                return R.raw.a6;
            case 94:
                return R.raw.bb6;
            case 95:
                return R.raw.b6;
            case 96:
                return R.raw.c7;
            case 97:
                return R.raw.db7;
            case 98:
                return R.raw.d7;
            case 99:
                return R.raw.eb7;
            case 100:
                return R.raw.e7;
            case 101:
                return R.raw.f7;
                /*
            case 102:
                return R.raw.gb7;
            case 103:
                return R.raw.g7;
            case 104:
                return R.raw.ab7;
            case 105:
                return R.raw.a7;
            case 106:
                return R.raw.bb7;
            case 107:
                return R.raw.b7;
            case 108:
                return R.raw.c8;
                */
            default:
                return R.raw.c8;
        }
    }
}
