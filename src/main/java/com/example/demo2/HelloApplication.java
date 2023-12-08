package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("newdemo2fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 620);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        Pane root=new Pane();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}