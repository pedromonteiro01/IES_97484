package com.MyWeatherRadar;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.logging.Logger;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class Main {

    private static final int CITY_ID_AVEIRO = 1010500;
    /*
    loggers provide a better alternative to System.out.println
    https://rules.sonarsource.com/java/tag/bad-practice/RSPEC-106
     */
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void  main(String[] args ) {

        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        int cityCode = 0;
        if (args.length == 0) {
            logger.info( "Invalid city code!");
            System.exit(0);
        } else{
            cityCode = Integer.parseInt(args[0]);
        }
        
        IpmaService service = retrofit.create(IpmaService.class);
        Call<IpmaCityForecast> callSync = service.getForecastForACity(cityCode);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                logger.info( "max temp for today: " + forecast.getData().
                        listIterator().next().getTMax()+"ºC");
            } else {
                logger.info( "No results!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}   