package com.example.testproject;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

public class ColorSlider extends Pane {
    Label title;
    Slider slider;
    Label value;

    public ColorSlider(String title) {
        this.title = new Label(title);
        this.slider = new Slider(0, 255, 50);
    }




}