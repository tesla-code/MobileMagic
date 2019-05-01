package com.example.eartrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CompInterval extends AppCompatActivity
{
    private Player player1;
    private Player player2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        player1 = new Player();
        player2 = new Player();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_interval);
    }
}
