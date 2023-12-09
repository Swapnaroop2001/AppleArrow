package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("newdemo2fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 620);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        // Add your other JavaFX nodes to the root VBox





        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}