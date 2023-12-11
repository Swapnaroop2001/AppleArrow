package com.example.demo2;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HelloController {
    int count=10;
    @FXML
    public Pane Apane;
    public Label label3;
    Double appleSpeed;


    public void initialize() {
        Image backgroundImage = new Image("bg2.jpeg");
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true)
        );
        Apane.setBackground(new Background(background));
        String j=String.valueOf(count);
        LabelCount.setText(j);
        double randomNumber = 100*Math.random();
        randomNumber=Math.round(randomNumber * 100.0) / 100.0;
        String strNumber1 = String.valueOf(randomNumber);
        label3.setText(strNumber1);
        appleSpeed=randomNumber;
    }




    @FXML
    public Circle Arrow;
    @FXML
    public Circle ball;
    @FXML
    public TextField VelocityBox;
    @FXML
    public TextField AngleBox;

    public double initialVelocity;
    public double angle;
    double initialXVelocity;
    double initialYVelocity;




    Double posX;
    Double posY;
    private static final double GRAVITY = 9.81; // Acceleration due to gravity (m/s^2)

    @FXML
    Label LabelCount;
    public void Reset(){
        count=10;
        initialize();
        LabelCount.setText(String.valueOf(count));
    }

    public void motion(){
        if (count>0){
            initialVelocity=Double.parseDouble(VelocityBox.getText());
            angle=Math.toRadians(Double.parseDouble(AngleBox.getText()));
            initialXVelocity = initialVelocity * Math.cos(angle)*4.5;
            initialYVelocity = initialVelocity * Math.sin(angle)*4.5;

            AnimationTimer appleTimer= new AnimationTimer() {
                double time = 0;
                @Override
                public void handle(long now) {
                    //Apple
                    double x = appleSpeed * time;
                    double y=0.5*GRAVITY*time*time;
                    ball.setCenterY(y);
                    ball.setCenterX(x);
                    Circle dot=new Circle(x+30, y+225, 1, Color.WHITE);
                    Apane.getChildren().add(dot);
                    time += 0.05;
                    double n=833+Arrow.getCenterX();
                    double m=ball.getCenterX();
                    double k=388-ball.getCenterY();
                    double l=6-Arrow.getCenterY();
                    System.out.println(n+"   "+m);
                    if( Math.abs(k-l)<18 && Math.abs(m-n)<10){
                        stop();
                    }
                    if (y >=387 ) {
                        stop();
                    }
                }
            };
            appleTimer.start();

            AnimationTimer arrowTimer=new AnimationTimer() {
                //Arrow
                double time = 0;
                @Override
                public void handle(long now) {
                    posX =-initialXVelocity * time;
                    posY =(-initialYVelocity * time )+ (0.5 * GRAVITY * time * time);
                    if (posY >= 455) {
                        posY = Double.valueOf(455);
                        time = 0.0;
                    }
                    time += 0.05;
                    Arrow.setCenterX(posX);
                    Arrow.setCenterY(posY);
                    Circle dot=new Circle(posX+860, posY+602, 1, Color.WHITE);
                    Apane.getChildren().add(dot);
                    double n=833+Arrow.getCenterX();
                    double m=ball.getCenterX();
                    double k=388-ball.getCenterY();
                    double l=6-Arrow.getCenterY();

                    System.out.println();

                    if( Math.abs(k-l)<18 && Math.abs(m-n)<10){
                        stop();
                    }
                    if (posY>=9) {
                        stop();
                    }
                }
            };
            arrowTimer.start();
            count=count-1;
            String c=String.valueOf(count);
            LabelCount.setText(c);
        }
        else {
            LabelCount.setText("0");
        }

    }
}