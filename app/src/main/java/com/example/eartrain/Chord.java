package com.example.eartrain;

public enum Chord
{
    MAJOR,
    MINOR,
    DIMINISHED,
    AUGMENTED;

    Interval[] getIntervals()
    {
        switch (this)
        {
            case MAJOR:
                return new Interval[]{Interval.MAJOR_THIRD, Interval.PERFECT_FIFTH};
            case MINOR:
                return new Interval[]{Interval.MINOR_THIRD, Interval.PERFECT_FIFTH};
            case DIMINISHED:
                return new Interval[]{Interval.MINOR_THIRD, Interval.AUGMENTED_FOURTH};
            case AUGMENTED:
                return new Interval[]{Interval.PERFECT_FOURTH, Interval.MINOR_SIXTH};
        }
        return null;
    }
}
