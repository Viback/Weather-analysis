/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vaderanalys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author karlssoj
 */
public class Stats 
{
    public float getMax(ArrayList<Measurement> dataset)
    {
        float max = dataset.get(0).getTemp();
        
        for(int i = 0; i < dataset.size(); i++)
        {
            if(dataset.get(i).getTemp() > max)
            {
                max = dataset.get(i).getTemp();
            }
        }
        
        return max;

    }
    public float getMaxWind(ArrayList<Measurement> dataset)
    {
         
        
        float maxwind = dataset.get(0).getWind();

        for(int i = 0; i < dataset.size(); i++)
            
        {

            if(dataset.get(i).getWind() > maxwind)
            {
                maxwind = dataset.get(i).getWind();
                
            }
        }
        
        return maxwind;

    }
    public String getMaxWindDate(ArrayList<Measurement> dataset)
    {
         
        
        float maxwind = dataset.get(0).getWind();
        String winddate = dataset.get(0).getTime();

        for(int i = 0; i < dataset.size(); i++)
            
        {

            if(dataset.get(i).getWind() > maxwind)
            {
                maxwind = dataset.get(i).getWind();
                winddate = dataset.get(i).getTime();
                
            }
        }
        
        return winddate;

    }
    
    public float getMin(ArrayList<Measurement> dataset)
    {
        float min = dataset.get(0).getTemp();
        
        for(int i = 0; i < dataset.size(); i++)
        {
            if(dataset.get(i).getTemp() < min)
            {
                min = dataset.get(i).getTemp();
            }
        }
        
        return min;
    }
    
    public float getAverage(ArrayList<Measurement> dataset)
    {
        float sum = 0;
        
        for(int i = 0; i < dataset.size(); i++)
        {
              sum += dataset.get(i).getTemp();
        }
        
        float average = sum / dataset.size();
        
        return average;
    }    
    public float getAverageByYear(ArrayList<Measurement> dataset)
    {
        ArrayList<YearTemp> datasetyear = new ArrayList();
        float sum = 0;
        int year;
        int lastyear=0;
        for(int i = 0; i < dataset.size(); i++)
        {
            if(dataset.get(i).getYear()>2008)
            {
            year = dataset.get(i).getYear();
            //Om året byts, kalkylera medeltemperatur
            if(lastyear != 0 && lastyear != year)
            {
            float yearAverageTemp = sum/datasetyear.size();
            System.out.println("Medeltemperaturen för år " + lastyear + " var " + yearAverageTemp);
            //nolla summa och arraylistan
            sum = 0;
            datasetyear = new ArrayList();
            }
            float temp = dataset.get(i).getTemp();
            sum += dataset.get(i).getTemp();
            YearTemp tempY = new YearTemp(year, temp);
            datasetyear.add(tempY);
            
            //Uppdaterar lastyear
            lastyear = year;
            }
              
        }
        

return 1;
    }   
    
    public float getMedian(ArrayList<Float> dataset)
    {
        float median;
        
        Collections.sort(dataset);
        
        if((dataset.size() % 2) == 0)
        {
            median = (dataset.get(dataset.size()/2) + dataset.get(dataset.size()/2 - 1))/2;
        }
        
        else
        {
            median = dataset.get(dataset.size()/2);
        }
             
        return median;
    }
    
    public float getStdev(ArrayList<Measurement> dataset)
    {
        float m = getAverage(dataset);
        float sumQuad = 0;
        
        for(int i = 0; i < dataset.size(); i++)
        {
            sumQuad += ((dataset.get(i).getTemp() - m)*(dataset.get(i).getTemp() - m));
        }
        
        float stdev = (float) Math.sqrt(sumQuad/dataset.size());
        
        return stdev;
    }
    public float getStdevByMonth(ArrayList<Measurement> dataset)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Vilket år (2009-2015) vill du ha standardavikelsen för de uppmätta temperaturvärdena månadsvis? ");
        while (!reader.hasNextInt()) reader.next();
        int n = reader.nextInt();
        ArrayList<MonthTemp> datasetmonth = new ArrayList();
        float sum = 0;
        int month = 1;
        int lastmonth =1;
        int year =n;
        int lastyear=n;
        for(int i = 0; i < dataset.size(); i++)
        {
            if(dataset.get(i).getYear()>=n && dataset.get(i).getYear()<n+2)
            {
            year = dataset.get(i).getYear();
            month = dataset.get(i).getMonth();
            //Om månaden byts, kalkylera stdev på temperatur
            if(lastmonth != month)
            {
            float monthAverageTemp = sum/datasetmonth.size();
            float sumQuad = 0;
            for(int l = 0; l < datasetmonth.size(); l++)
            {
            sumQuad += ((dataset.get(i).getTemp() - monthAverageTemp)*(dataset.get(i).getTemp() - monthAverageTemp));
            }
            float stdev = (float) Math.sqrt(sumQuad/datasetmonth.size());
            
            System.out.println("Temperaturens standardavvikelse för år " + n + ", månad " + lastmonth+ " var " + stdev);
            //nolla summa och arraylistan
            sum = 0;
            datasetmonth = new ArrayList();
            }
            float temp = dataset.get(i).getTemp();
            sum += dataset.get(i).getTemp();
            MonthTemp tempM = new MonthTemp(month, year, temp);
            datasetmonth.add(tempM);
            
            //Uppdaterar lastmonth och avbryter loopen efter att året bytts och sista månadens Stdev printats ut
            lastmonth = month;
            if (lastyear != year) {break;}
            lastyear = year;
            }
              
        }
        
        

return 1;
    }
    

    
}
