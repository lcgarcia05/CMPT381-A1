package com.example.testproject;

import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

public class ColorSlider extends Pane {
    private Label title;
    public Slider slider;
    private Label value;

    public ColorSlider(String t) {
        this.title = new Label(t);
        this.slider = new Slider(0, 255, 50);
        this.value = new Label();

        this.getChildren().addAll(title, slider, value);
    }

    public void setValue(int i){
        value.setText(String.valueOf(i));
    }

    public int getSliderValue(){
        return slider.valueProperty().getValue().intValue();
    }

    public Label getTitle(){
        return this.title;
    }

    public DoubleProperty getValueProperty(){
        return this.slider.valueProperty();
    }

    public Slider getSlider(){
        return this.slider;
    }

    public Label getValue(){
        return this.value;
    }

}