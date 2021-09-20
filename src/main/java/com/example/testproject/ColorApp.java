package com.example.testproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class ColorApp extends Application {

    Text headline;
    Circle circle;
    ListView<String> listView;
    Label label1;

    Color currentColor;

    Slider redSlider;
    Slider greenSlider;
    Slider blueSlider;
    ColorPalette colorPalette;

    int pointer = 0;
    static final int NUMBER_OF_ELEMENTS = 3;

    @Override
    public void start(Stage stage) throws IOException {


        VBox root = new VBox();
        VBox left = new VBox();
        VBox right = new VBox();
        VBox palette = new VBox();


        // Circle VBox
        VBox cir = new VBox();
        circle = new Circle();
        circle.setRadius(75);
        cir.setAlignment(Pos.CENTER);

        cir.getChildren().addAll(circle);


        // Instantiation
        VBox sliderCaption= new VBox();
        VBox sliders = new VBox();
        HBox allSliderElement = new HBox();

        // Labels for the colors
        Label red = new Label("Red:");
        Label green = new Label("Green:");
        Label blue = new Label("Blue:");

        ColorSlider colorSlider1 = new ColorSlider("Red");
        System.out.println(colorSlider1.slider);

        // Sliders
        Label redVal = new Label();
        redSlider = new Slider(0,255,50);
        redVal.setText(String.valueOf((int)redSlider.getValue()));
        redSlider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            redVal.setText(String.valueOf(newValue.intValue()));
            setColor();
//            System.out.println(currentColor);
        });

        Label greenVal = new Label();
        greenSlider = new Slider(0,255,50);
        greenVal.setText(String.valueOf((int)greenSlider.getValue()));
        greenSlider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            greenVal.setText(String.valueOf(newValue.intValue()));
            setColor();
//            System.out.println(currentColor);


        });

        Label blueVal = new Label();
        blueSlider = new Slider(0,255,50);
        blueVal.setText(String.valueOf((int)blueSlider.getValue()));
        blueSlider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            blueVal.setText(String.valueOf(newValue.intValue()));
            setColor();
//            System.out.println(currentColor);

        });

        // Slider's names
        sliderCaption.setSpacing(5);
        sliderCaption.setPadding(new Insets(10));
        sliderCaption.getChildren().addAll(red,green,blue);

        // Actual sliders
        sliders.setSpacing(10);
        sliders.setPadding(new Insets(10));
        sliders.getChildren().addAll(redSlider,greenSlider,blueSlider);

        // Slider values
        VBox sliderValues = new VBox();
        sliderValues.setSpacing(10);
        sliderValues.setPadding(new Insets(5));
        sliderValues.getChildren().addAll(redVal, greenVal, blueVal);

        // Add all the elements into HBox to get a column layout
        allSliderElement.getChildren().addAll(sliderCaption, sliders, sliderValues);

        setColor();


        // Palette Elements

        // Palette circles
        HBox circles = new HBox();
        Circle[] circleList = new Circle[NUMBER_OF_ELEMENTS];
        for (int i = 0; i  < circleList.length; i++){
            circleList[i] = new Circle(50);
            circleList[i].setFill(Color.rgb(50,50,50));
            circles.getChildren().add(circleList[i]);
        }

        circles.setAlignment(Pos.CENTER);
        circles.setPadding(new Insets(15));


        // add to palette button
        Button pButton = new Button();
        pButton.setText("Add to Palette");
        colorPalette = new ColorPalette();

        pButton.setOnAction(e -> colorPalette.addColor(currentColor));
        pButton.setOnMouseClicked(e -> {
            circleList[pointer].setFill(colorPalette.getColor(pointer));
            pointer++;

            if (pointer == NUMBER_OF_ELEMENTS){
                pointer = 0;
            }
        });

        // List View
        listView = new ListView<>();
        ObservableList<String> listItems = FXCollections.observableArrayList("Test1", "Test2");
        listView.setItems(listItems);
        listView.setPrefHeight(415);

        // Add to list button
        Button lButton = new Button();
        lButton.setText("Add to List");
        lButton.setOnAction(e -> {
            listItems.add(colorPalette.getColorList().toString());

        });

        palette.setAlignment(Pos.CENTER);
        palette.getChildren().addAll(pButton,circles, lButton);


        // left and right
        left.getChildren().addAll(cir, allSliderElement,palette);
        right.getChildren().addAll(listView);

        // Combine panels
        HBox combined = new HBox();
        combined.getChildren().addAll(left,right);


        // Root
        root.getChildren().addAll(combined);
        stage.setTitle("Color Palette!");
        stage.setScene(new Scene(root, 580, 415));
        stage.show();
    }

    public void setColor(){
        int red = redSlider.valueProperty().getValue().intValue();
        int green = greenSlider.valueProperty().getValue().intValue();
        int blue = blueSlider.valueProperty().getValue().intValue();

        currentColor = Color.rgb(red, green, blue);
        circle.setFill(currentColor);
    }

    public List<Integer> getRGB(){
        int red = redSlider.valueProperty().getValue().intValue();
        int green = greenSlider.valueProperty().getValue().intValue();
        int blue = blueSlider.valueProperty().getValue().intValue();

        return Arrays.asList(red, green, blue);
    }

    public static void main(String[] args) {
        launch();
    }
}