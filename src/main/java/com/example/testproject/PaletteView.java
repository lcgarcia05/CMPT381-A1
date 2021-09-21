package com.example.testproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Arrays;

public class PaletteView extends Pane {

    Circle[] circleList = new Circle[3];
    private Circle circle1;
    private Circle circle2;
    private Circle circle3;
    ColorPalette colorPalette;

    public PaletteView(ColorPalette cp) {
        if (cp == null){
            colorPalette = new ColorPalette();
        }else{
            this.colorPalette = cp;
        }
        HBox circles = new HBox();

        circle1 = new Circle(50);
        circle2 = new Circle(50);
        circle3 = new Circle(50);
        circle1.setFill(this.colorPalette.firstColor);
        circle2.setFill(this.colorPalette.secondColor);
        circle3.setFill(this.colorPalette.thirdColor);


        circles.getChildren().addAll(circle1,circle2,circle3);
        this.getChildren().add(circles);

    }

    public Circle[] getCircleList(){
        circleList[0] = circle1;
        circleList[1] = circle2;
        circleList[2] = circle3;

        return circleList;
    }

}
