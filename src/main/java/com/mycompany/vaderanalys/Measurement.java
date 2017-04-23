/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vaderanalys;

/**
 *
 * @author Vikke
 */
public class Measurement 
{
    private String time;
    private int year;
    private int month;
    private float temp;
    private float wind;
    
    public Measurement(String time, int y, int m, float t, float w)
    {
        this.time = time;
        year = y;
        month = m;
        temp = t;
        wind = w;
    }
    public String getTime()
    {
    return time;
    }
    
    public int getYear()
    {
       return year;
    }
    
    public int getMonth()
    {
       return month;
    }
    
    public float getTemp()
    {
        return temp;
    }
    
    public float getWind()
    {
        return wind;
    }
}
