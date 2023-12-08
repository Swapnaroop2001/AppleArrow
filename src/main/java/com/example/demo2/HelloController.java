package com.example.demo2;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class HelloController {
    @FXML
    public Pane Apane;
    @FXML
    public Circle Arrow;
    @FXML
    Circle ball;
    @FXML
    public TextField VelocityBox;
    @FXML
    public TextField AngleBox;

    public double initialVelocity;
    public double angle;
    double initialXVelocity;
    double initialYVelocity;
    double timeOfFlight;


    public void Input(){
        initialVelocity=Double.parseDouble(VelocityBox.getText());
        angle=Math.toRadians(Double.parseDouble(AngleBox.getText()));
        initialXVelocity = initialVelocity * Math.cos(angle)*1.4;
        initialYVelocity = initialVelocity * Math.sin(angle)*1.4;
        System.out.println(initialVelocity+" "+angle);
        timeOfFlight = (2 * initialVelocity) / GRAVITY;
    }


    Double posX;
    Double posY;

    Double appleSpeed;
    //public double INITIAL_SPEED = 20; // Initial horizontal speed (m/s)
    //double horizontalDistance = INITIAL_SPEED * timeOfFlight;
    private static final double GRAVITY = 9.81; // Acceleration due to gravity (m/s^2)
    @FXML
    public Label label3;


    public void GenerateAppleSpeed(){
        double randomNumber = 100*Math.random();
        randomNumber=Math.round(randomNumber * 100.0) / 100.0;
        String strNumber1 = String.valueOf(randomNumber);
        label3.setText(strNumber1);
        appleSpeed=randomNumber;
    }




    public void motion(){

        new AnimationTimer() {
            double time = 0;
            @Override
            public void handle(long now) {
                //Arrow
                updateBallPosition();
                Arrow.setCenterX(posX);
                Arrow.setCenterY(posY);
                Circle dot=new Circle(posX+800, posY+602, 1, Color.BLACK);
                Apane.getChildren().add(dot);
                time += 0.01;
                if (posY >=9) {
                    stop();
                }
            }
            private void updateBallPosition() {
                posX =5-initialXVelocity * time;
                posY =5-initialYVelocity * time + 0.5 * GRAVITY * time * time;
                if (posY >= 455) {
                    posY = Double.valueOf(455);
                    time = 0.0;
                }
                time += 0.05; // Increment time for the next frame
            }
        }.start();
        new AnimationTimer() {
            double time = 0;
            @Override
            public void handle(long now) {
                //Apple
                double x = appleSpeed * time;
                double y=0.5*GRAVITY*time*time;
                ball.setCenterY(y);
                ball.setCenterX(x);
                Circle dot=new Circle(x+30, y+225, 1, Color.BLACK);
                Apane.getChildren().add(dot);
                time += 0.05;
                if (y >=387) {
                    stop();
                }
            }
        }.start();
    }
}