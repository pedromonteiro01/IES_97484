package com.ipmaapiclient;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.*;

public class Main{
    public static CityForecast getAllData(String local) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);

        Call<Cities> allcities= service.getAll();

        try {
            Response<Cities> api = allcities.execute();
            Cities cities = api.body();
            List<City> city = cities.getData();
            int idlocal = 0;
            for (City c: city) {
                if (c.getLocal().equalsIgnoreCase(local)) {
                    idlocal = c.getGlobalIdLocal();
                }
            }
            Call<IpmaCityForecast> callSync = service.getForecastForACity(idlocal);

            try {
                Response<IpmaCityForecast> apiResponse = callSync.execute();
                IpmaCityForecast forecast = apiResponse.body();

                return forecast.getData().listIterator().next();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
    