package com.sda.writeObjectToFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Weather>weatherList=new ArrayList<Weather>();


        Weather weather1 =new Weather("Torun",
                "www",
                40.0,
                60.0,
                "slonecznie",
                54.54,
                21.23);
        Weather weather2=new Weather("Bydgoszcz",
                "www",
                40.0,
                50.0,
                "upalnie",
                53.1,
                23.13);
        Weather weather3=new Weather("Warszawa",
                "www",
                32.0,
                28.0,
                "pochmurno",
                51.9,
                20.0);
weatherList.add(weather1);
weatherList.add(weather2);
weatherList.add(weather3);
        ObjectMapper objectMapper=new ObjectMapper();
        File filename=new File("weather.json");
        try {
            objectMapper.writeValue(filename,weatherList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
