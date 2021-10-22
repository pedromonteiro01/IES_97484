package com.weatherforecast;

import com.ipmaapiclient.Main;
import com.ipmaapiclient.CityForecast;

public class App {
    public static void main(String[] args) {
        try {
            CityForecast api = Main.getAllData(args[0]);
            System.out.println("Max temp for today:" + api.getTMax()+"ºC");
        } 
        
        catch (NullPointerException e) {
            // handle exception when api not working (or network is off)
            System.out.println("API not working!");
        }
    }
}