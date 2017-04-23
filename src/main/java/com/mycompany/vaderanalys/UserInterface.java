/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vaderanalys;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author bacvikto
 */
public class UserInterface {
    public UserInterface()
    {
        menu();
    }
    
    //metod som beräknar statistik på temperaturvärden för en specifik måndad. Dataset, innehåller Temperature-objekt
    //för en specifik månad och month-variabeln berättar vilken månad det är frågan om
    public void calculateAndShowMonthStats(ArrayList<Measurement> dataset, int month)
    {
               Stats st = new Stats();
               
               float max = st.getMax(dataset);  
               System.out.println("Maxtemperaturen för alla mätvärden var " + max);
               float min = st.getMin(dataset);  
               System.out.println("Mintemperaturen för alla mätvärden var " + min);
               float average = st.getAverage(dataset);  
               System.out.println("Medeltemperaturen för alla mätvärden var " + average);
               float maxwind = st.getMaxWind(dataset);
               String winddate = st.getMaxWindDate(dataset);
               System.out.println("Den högsta uppmätta vindstyrkan var " + maxwind + " vid tidpunkten " + winddate);
               float stdev = st.getStdev(dataset);  
               System.out.println("------------------------------------------------------------------------");
               st.getAverageByYear(dataset);
               st.getStdevByMonth(dataset);



    }

    public void menu()
    {      

        ArrayList<Measurement> dataset = new ArrayList();
        try
        {
        FileReader fr = new FileReader("weather.json");
        JSONParser jp = new JSONParser();
        JSONObject jo = (JSONObject)jp.parse(fr);     
        JSONArray ja = (JSONArray)jo.get("measurements");
        for (int i = 0; i < ja.size(); i++) {
            JSONObject weatherObject = (JSONObject)ja.get(i);
            String time = weatherObject.get("time").toString();
            int year = Integer.parseInt(time.substring(1, 5));
            int month = Integer.parseInt(time.substring(6, 8));
            float temperature = Float.parseFloat((String) weatherObject.get("temp"));
            float wind = Float.parseFloat((String) weatherObject.get("wind"));
            Measurement temp = new Measurement(time, year, month, temperature, wind);
            dataset.add(temp);


        }
        }
        catch(IOException | ParseException | NumberFormatException e)
        {
            System.out.println("Något gick fel: " + e.getMessage());
        }
 
        
        int month = 0;
        calculateAndShowMonthStats(dataset, month);       
    }
}

