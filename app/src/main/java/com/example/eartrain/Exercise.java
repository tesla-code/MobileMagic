package com.example.eartrain;

public class Exercise
{
    int m_id;
    String m_title;
    String m_description;
    Interval[] m_intervals;
    Chord[] m_chords;
    IntervalActivity.Mode m_mode;
    int m_successes;
    int m_score;
    float m_time;

    public Exercise(
            int id,
            String title,
            String description,
            Interval[] intervals,
            Chord[] chords,
            IntervalActivity.Mode mode)
    {
        m_id = id;
        m_title = title;
        m_description = description;
        m_intervals = intervals;
        m_chords = chords;
        m_mode = mode;
        m_successes = 0;        // TODO: Fetch last 3 from db
        m_score = 0;
        m_time = 0;
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

    public IntervalActivity.Mode getMode()
    {
        return m_mode;
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
