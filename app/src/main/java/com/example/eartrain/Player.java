package com.example.eartrain;

public class Player
{
    private int m_score;

    Player(){
        m_score = 0;
    }

    public void addScore(int i_score)
    {
        m_score += i_score;
    }

    public int getScore()
    {
        return m_score;
    }
}
