package com.weatherforecast;

import com.ipmaapiclient.Main;
import com.ipmaapiclient.CityForecast;

public class App {
    public static void main(String[] args) {
        CityForecast api = Main.getAllData(args[0]);
        System.out.println("Max temp for today:" + api.getTMax()+"ªC");
    }
}