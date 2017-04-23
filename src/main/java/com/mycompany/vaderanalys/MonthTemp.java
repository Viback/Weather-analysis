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
public class MonthTemp extends YearTemp {
    private int month;
    
    public MonthTemp(int month, int year, float temp) {
        super(year, temp);
    }
    public int getMonthM()
    {
    return month;
    }
    
}
