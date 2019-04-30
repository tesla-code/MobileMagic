package com.example.eartrain;

import java.util.Date;

/**
 *
 */
public class Achievement
{
    private int id;
    private String name;
    private String desc;
    private boolean achieved;   // basicly unlocked
    private String iconPath;    // instead of storing the image, we store the path to it.
    private Date date;

}