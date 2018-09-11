package com.sda.writeObjectToFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) {
        AppProperties ap = Config.loadProperties();
        WeatherService weatherService = new WeatherService(
                ap.getUrl(), ap.getKey()
        );

        weatherService.getCityWeather("paris");

//        ObjectMapper objectMapper = new ObjectMapper();
//        File filename = new File("weather.json");
//        try {
//            objectMapper.writeValue(filename, weatherList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Weather[] readWeather = objectMapper.readValue(filename, Weather[].class);
//            for (Weather weather : readWeather) {
//                System.out.println(weather.getCity());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Config.saveConfiguration();
        launch();

    }

    public Stage stage;
    public VBox vBox;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage=primaryStage;
        WeatherView w=new WeatherView(this.stage);
       // FileInputStream inputStream=new FileInputStream("C:\\workspace\\sceneBuilder\\src\\main\\resources");
        //Image image= new Image(inputStream);
        w.loadView();
    }

}
