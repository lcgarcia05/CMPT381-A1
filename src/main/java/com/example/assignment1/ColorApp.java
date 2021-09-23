package com.example.assignment1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ColorApp extends Application {
    Circle circle;
    ColorPalette colorPalette;
    ListView<ColorPalette> listView;
    Color currentColor;
    PaletteView pv;
    ColorSlider redSlider;
    ColorSlider greenSlider;
    ColorSlider blueSlider;
    Button pButton;
    ObservableList<ColorPalette> listItems;

    // Pointer used to change the index of the current palette circle
    private int pointer = 0;
    static final int NUMBER_OF_ELEMENTS = 3;

    @Override
    public void start(Stage stage){

        VBox root = new VBox();
        VBox left = new VBox();
        VBox right = new VBox();

        // Circle VBox
        VBox cir = new VBox();
        circle = new Circle();
        circle.setRadius(100);
        cir.setPadding(new Insets(10));
        cir.setAlignment(Pos.CENTER);
        cir.getChildren().addAll(circle);

        // Instantiation
        VBox sliderCaption= new VBox();
        VBox sliders = new VBox();
        HBox allSliderElement = new HBox();

        // Sliders
        redSlider = new ColorSlider("Red:");
        redSlider.setValue(redSlider.getSliderValue());
        redSlider.getValueProperty().addListener(((observableValue, oldValue, newValue) -> {
            redSlider.setValue(newValue .intValue());
            setColor();
        }));

        greenSlider = new ColorSlider("Green:");
        greenSlider.setValue(greenSlider.getSliderValue());
        greenSlider.getValueProperty().addListener(((observableValue, oldValue, newValue) -> {
            greenSlider.setValue(newValue.intValue());
            setColor();
        }));

        blueSlider = new ColorSlider("Blue:");
        blueSlider.setValue(blueSlider.getSliderValue());
        blueSlider.getValueProperty().addListener(((observableValue, oldValue, newValue) -> {
            blueSlider.setValue(newValue .intValue());
            setColor();
        }));

        // Slider's names
        sliderCaption.setSpacing(5);
        sliderCaption.setPadding(new Insets(10));
        sliderCaption.getChildren().addAll(redSlider.getTitle(),greenSlider.getTitle(),blueSlider.getTitle());

        // Actual sliders
        sliders.setSpacing(10);
        sliders.setPadding(new Insets(10));
        sliders.getChildren().addAll(redSlider.getSlider(),greenSlider.getSlider(), blueSlider.getSlider());

        // Slider values
        VBox sliderValues = new VBox();
        sliderValues.setSpacing(10);
        sliderValues.setPadding(new Insets(5));
        sliderValues.getChildren().addAll(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());

        // Add all the elements into HBox to get a column layout
        allSliderElement.getChildren().addAll(sliderCaption, sliders, sliderValues);

        // Palette Elements
        // add to palette button
        pButton = new Button();
        pButton.setText("Add to Palette");
        colorPalette = new ColorPalette();
        pButton.setOnAction(this::addToPaletteHandle);
        pv = new PaletteView(colorPalette);

        // List View
        createListView();

        // Add to list button
        Button lButton = new Button();
        lButton.setText("Add to List");
        lButton.setOnAction(this::addToListHandle);

        VBox palette = new VBox();
        palette.setSpacing(20);
        palette.setAlignment(Pos.CENTER);
        palette.getChildren().addAll(pButton, pv, lButton);

        // left and right
        left.getChildren().addAll(cir, allSliderElement,palette);
        right.getChildren().add(listView);

        // Combine panels
        HBox combined = new HBox();
        combined.getChildren().addAll(left,right);

        // Root
        root.getChildren().addAll(combined);
        stage.setTitle("Color Palette");
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Method for setting the current color based on the slider values
    public void setColor(){
        int red = redSlider.getSliderValue();
        int green = greenSlider.getSliderValue();
        int blue = blueSlider.getSliderValue();

        currentColor = Color.rgb(red, green, blue);
        circle.setFill(currentColor);
    }

    // Method for handling the event whenever addToPalette button has received an action
    public void addToPaletteHandle(ActionEvent actionEvent){
        colorPalette.addColor(currentColor);
        pv.getCircleList()[pointer].setFill(colorPalette.getColor(pointer));
        pv.getCircleList()[pointer].setStroke(Color.BLACK);
        pointer++;
        if (pointer == NUMBER_OF_ELEMENTS) {
            pointer = 0;
        }
    }

    // Method for handling the event whenever addToList button has received an action
    public void addToListHandle(ActionEvent actionEvent){
        ColorPalette newCP = new ColorPalette();
        newCP.addColor(colorPalette.getFirstColor());
        newCP.addColor(colorPalette.getSecondColor());
        newCP.addColor(colorPalette.getThirdColor());
        listItems.add(newCP);
    }

    // Initialize listview
    public void createListView(){
        listView = new ListView<>();
        listItems = FXCollections.observableArrayList();
        listView.setItems(listItems);
        listView.setCellFactory(listItem -> new PaletteCell());
        listView.setPrefWidth(330);
        listView.setPrefHeight(550);
    }

    public static void main(String[] args) {
        launch();
    }
}