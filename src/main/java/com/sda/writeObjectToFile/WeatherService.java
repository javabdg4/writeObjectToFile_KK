package com.sda.writeObjectToFile;

import org.json.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {
    private String finalUrl;

    public WeatherService(String url, String key) {

        finalUrl=url+"?key="+key;
    }

    public Weather getCityWeather(String city){

        Weather weather= new Weather();
        String url = finalUrl +"&q="+city;
        JSONObject jsonObject=null;
        try {
            jsonObject=new JSONObject(
                    IOUtils.toString(new URL(url),
                            Charset.forName("UTF-8")));
            //IOUtils pobiera dane z adresu url i przekonwertowuje je na string
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.getJSONObject("location").get("name"));
        weather.setCity(jsonObject.getJSONObject("location").get("name").toString());
        weather.setLat((Double)jsonObject.getJSONObject("location").get("lat"));
        weather.setLon((Double)jsonObject.getJSONObject("location").get("lon"));
        weather.setTemperature((Double)jsonObject.getJSONObject("current").get("temp_c"));
        weather.setConditionText(jsonObject.getJSONObject("current").getJSONObject("condition").get("text").toString());
        weather.setFeelslikeC((Double)jsonObject.getJSONObject("current").get("feelslike_c"));
        weather.setIconUrl(jsonObject.getJSONObject("current").getJSONObject("condition").get("icon").toString());
        return weather;
    }
}
