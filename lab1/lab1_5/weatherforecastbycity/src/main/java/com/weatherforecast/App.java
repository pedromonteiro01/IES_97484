package com.weatherforecast;

import com.ipmaapiclient.Main;
import com.ipmaapiclient.CityForecast;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class App {
    public static void main(String[] args) {

        final Logger logger = LogManager.getLogger(Main.class.getName());

        try {
            CityForecast api = Main.getAllData(args[0]);
            logger.info("Max temp for today: " + api.getTMax()+"ºC");
        } 
        
        catch (NullPointerException e) {
            // handle exception when api not working (or network is off)
            logger.info("API not working!");
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}