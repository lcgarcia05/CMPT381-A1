package com.example.testproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PaletteView extends Pane {

    Circle[] circleList = new Circle[3];
    Circle circle1;
    Circle circle2;
    Circle circle3;

    ColorPalette colorPalette;

    public PaletteView(ColorPalette cp) {
        if (cp == null){
            colorPalette = new ColorPalette();
        }else{
            this.colorPalette = cp;
            circle1 = new Circle(50);
            circle2 = new Circle(50);
            circle3 = new Circle(50);
            circleFill();
        }

    }
    private void circleFill(){
        circle1.setFill(colorPalette.firstColor);
        circle2.setFill(colorPalette.secondColor);
        circle3.setFill(colorPalette.thirdColor);
    }

    public Circle[] getCircleList(){
        circleList[0] = circle1;
        circleList[1] = circle2;
        circleList[2] = circle3;

        return circleList;
    }

}
