package com.sda.writeObjectToFile;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherView {

    private VBox vBox;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public WeatherView(Stage stage) {
        this.stage = stage;
    }

    public void loadView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/weatherView.fxml"));
        try {
            vBox = (VBox) loader.load();
            Scene scene = new Scene(vBox);
            stage.setScene(scene);
            stage.show();

            WeatherController weatherController = loader.getController();
            weatherController.setWeatherView(this);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadSearchView() {
        loadView();
    }
}
