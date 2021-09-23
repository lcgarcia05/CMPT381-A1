package com.example.assignment1;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PaletteView extends Pane {

    Circle[] circleList = new Circle[3];
    private final Circle circle1;
    private final Circle circle2;
    private final Circle circle3;
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

        circle1.setFill(this.colorPalette.getFirstColor());
        circle1.setStroke(Color.BLACK);

        circle2.setFill(this.colorPalette.getSecondColor());
        circle2.setStroke(Color.BLACK);

        circle3.setFill(this.colorPalette.getThirdColor());
        circle3.setStroke(Color.BLACK);

        circles.getChildren().addAll(circle1,circle2,circle3);
        this.getChildren().add(circles);

    }

    // Method used to cycle around the palette circles
    public Circle[] getCircleList(){
        circleList[0] = circle1;
        circleList[1] = circle2;
        circleList[2] = circle3;

        return circleList;
    }

}
