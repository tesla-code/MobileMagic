package com.example.eartrain;

public class Exercise
{
    String m_title;
    String m_description;
    Interval[] m_intervals;
    Chord[] m_chords;
    int m_successes;
    int m_score;
    float m_time;

    public Exercise(
            String title,
            String description,
            Interval[] intervals,
            Chord[] chords,
            int successes,
            int score,
            float time)
    {
        m_title = title;
        m_description = description;
        m_intervals = intervals;
        m_chords = chords;
        m_successes = successes;
        m_score = score;
        m_time = time;
    }

    public String getTitle()
    {
        return m_title;
    }

    public String getDescription()
    {
        return m_description;
    }

    public Interval[] getIntervals()
    {
        return m_intervals;
    }

    public Chord[] getChords()
    {
        return m_chords;
    }

    public int getSuccesses()
    {
        return m_successes;
    }

    public int getScore()
    {
        return m_score;
    }

    public float getTime()
    {
        return m_time;
    }
}
