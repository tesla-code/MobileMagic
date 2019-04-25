package com.example.eartrain;

public enum Interval
{
    // Interval name    Half-steps
    UNISON,             // 0
    MINOR_SECOND,       // 1
    MAJOR_SECOND,       // 2
    MINOR_THIRD,        // 3
    MAJOR_THIRD,        // 4
    PERFECT_FOURTH,     // 5
    AUGMENTED_FOURTH,   // 6
    PERFECT_FIFTH,      // 7
    MINOR_SIXTH,        // 8
    MAJOR_SIXTH,        // 9
    MINOR_SEVENTH,      // 10
    MAJOR_SEVENTH,      // 11
    OCTAVE;             // 12


    @Override
    public String toString()
    {
        switch (this)
        {
            case UNISON:
                return "unison";
            case MINOR_SECOND:
                return "minor second";
            case MAJOR_SECOND:
                return "major second";
            case MINOR_THIRD:
                return "minor third";
            case MAJOR_THIRD:
                return "major third";
            case PERFECT_FOURTH:
                return "perfect fourth";
            case AUGMENTED_FOURTH:
                return "augmented fourth";
            case PERFECT_FIFTH:
                return "perfect fifth";
            case MINOR_SIXTH:
                return "minor sixth";
            case MAJOR_SIXTH:
                return "major sixth";
            case MINOR_SEVENTH:
                return "minor seventh";
            case MAJOR_SEVENTH:
                return "major seventh";
            case OCTAVE:
                return "octave";
            default:
                return "NOT AN INTERVAL";
        }
    }
}