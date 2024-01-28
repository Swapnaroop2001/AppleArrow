package com.example.demo2;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class HelloController {

    int count=5;
    @FXML
    Label YW;
    @FXML
    public Pane Apane;
    public Label label3;
    Double appleSpeed;
    Image arr= new Image("ty.png");
    Image appleimg=new Image("aedapl.png");
    ImageView imgv=new ImageView();
    ImageView imgvapple=new ImageView();


    public void initialize() {
        imgv.setImage(arr);
        imgv.setFitHeight(100*0.4);
        imgv.setFitWidth(100*0.5);
        imgv.setX(838);
        imgv.setY(588);
        Apane.getChildren().add(imgv);
        Apane.getChildren().remove(Arrow);
        imgvapple.setImage(appleimg);
        imgvapple.setFitHeight(100*0.4);
        imgvapple.setFitWidth(100*0.7);
        imgvapple.setX(-16);
        imgvapple.setY(199);
        Apane.getChildren().add(imgvapple);
        Apane.getChildren().remove(ball);

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
    private static final double GRAVITY = 9.81;

    @FXML
    Label LabelCount;
    public void Reset(){
        YW.setText("");
        imgv.setX(838);
        imgv.setY(590);
        imgvapple.setX(-16);
        imgvapple.setY(199);
        count=5;
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
                    imgvapple.setY(y+199);
                    imgvapple.setX(x-15);
                    ball.setCenterX(x);
                    Circle dot=new Circle(x+10, y+217, 1, Color.WHITE);
                    Apane.getChildren().add(dot);
                    time += 0.05;
                    double n=833+Arrow.getCenterX();
                    double m=ball.getCenterX();
                    double k=388-ball.getCenterY();
                    double l=6-Arrow.getCenterY();
                    if( Math.abs(k-l)<15 && Math.abs(m-n)<15){
                        YW.setText("You Won!");
                        stop();
                    }
                    if (y >=380 ) {
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
                    //Arrow Image
                    posX =-initialXVelocity * time;
                    posY =(-initialYVelocity * time )+ (0.5 * GRAVITY * time * time);
                    if (posY >= 455) {
                        posY = Double.valueOf(455);
                        time = 0.0;
                    }
                    time += 0.05;
                    Arrow.setCenterX(posX);
                    Arrow.setCenterY(posY);
                    Circle dot=new Circle(posX+872, posY+598, 1, Color.WHITE);
                    Apane.getChildren().add(dot);
                    double n=833+Arrow.getCenterX();
                    double m=ball.getCenterX();
                    double k=388-ball.getCenterY();
                    double l=6-Arrow.getCenterY();
                    imgv.setX(n);
                    imgv.setY(590-l);

                    if( Math.abs(k-l)<15 && Math.abs(m-imgv.getX())<15){
                        YW.setText("You Won!");
                        stop();
                    }
                    if (posY>=3) {
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
            YW.setText("Your Trials Are Over");
            LabelCount.setText("0");
        }

    }
}