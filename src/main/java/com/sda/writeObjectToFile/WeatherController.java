package com.sda.writeObjectToFile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class WeatherController {

    public WeatherView weatherView;

    public void setWeatherView(WeatherView weatherView) {
        this.weatherView = weatherView;
    }

    public Weather weatherFound;

    @FXML
    public Button searchCity;

    @FXML
    public TextField writtenCity;

    @FXML
    public ImageView imageView;

    @FXML
    public Label cityName;
    @FXML
    public Label temp_C;
    @FXML
    public Label feelsLike;

    public void setWeatherFound(Weather weatherFound) {
        this.weatherFound = weatherFound;
    }


    @FXML
    public void initialize() {

    }

    public void handleSearchCity(ActionEvent actionEvent) {
        AppProperties ap = Config.loadProperties();
        WeatherService weatherService = new WeatherService(ap.getUrl(), ap.getKey());

        setWeatherFound(weatherService.getCityWeather(writtenCity.getText()));
        cityName.setText(weatherFound.getCity());
        feelsLike.setText(String.valueOf(weatherFound.getTemperature()));
        temp_C.setText(String.valueOf(weatherFound.getFeelslikeC()));
        Image image = new Image("http:" + weatherFound.getIconUrl(), true);

        imageView.setImage(image);

        //  weatherView.loadSearchView();

        System.out.println(weatherFound.toString());
        // http://api.apixu.com/v1/current.json?key=3a7c14511afc42169e4155255180709&q=Paris
    }


}
