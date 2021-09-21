package com.example.testproject;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PaletteView extends Pane {

    Circle[] circleList = new Circle[3];
    HBox circles = new HBox();
    ColorPalette colorPalette;

    public PaletteView(ColorPalette cp) {
        this.colorPalette = cp;
        drawCircles();
    }

    public PaletteView(){
        colorPalette = new ColorPalette();
        drawCircles();
    }

    private void drawCircles(){
        for (int i = 0; i < circleList.length; i++){
            circleList[i] = new Circle(50);
            circleList[i].setFill(Color.rgb(50,50,50));
            circles.getChildren().add(circleList[i]);

        }
    }

    public HBox getCircles(){
        return circles;
    }

    public Circle[] getCircleList(){
        return circleList;
    }

}
