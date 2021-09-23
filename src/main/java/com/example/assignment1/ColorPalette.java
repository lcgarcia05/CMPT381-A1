package com.example.assignment1;


import javafx.scene.paint.Color;

public class ColorPalette {
    private Color firstColor = Color.WHITE;
    private Color secondColor = Color.WHITE;
    private Color thirdColor = Color.WHITE;

    // Keeps track of the current index to specify which circle to be updated
    private int cur = 0;

    // Adds a color to the specific color circle
    public void addColor(Color c){
        if (cur == 0){
            firstColor = c;
            cur++;
        }
        else if(cur == 1){
            secondColor = c;
            cur++;
        }
        else{
            thirdColor = c;
            cur = 0;
        }
    }

    // Getter used for cycling around the palette circle
    public Color getColor(int i){
        if (i == 0){
            return firstColor;
        }
        else if (i == 1){
            return secondColor;
        }
        else {
            return thirdColor;
        }
    }

    @Override
    public String toString() {
        return (int)((firstColor.getRed()) * 255)+ "," + (int)(firstColor.getGreen()* 255) + "," +(int) (firstColor.getBlue()* 255) + "\n" +
                (int) (secondColor.getRed() * 255)+ "," + (int)(secondColor.getGreen()* 255) + "," + (int)(secondColor.getBlue()* 255)+ "\n" +
                (int) (thirdColor.getRed() * 255)+ "," + (int)(thirdColor.getGreen()* 255) + "," + (int)(thirdColor.getBlue()* 255);
    }

    // Getters
    public Color getFirstColor() {
        return firstColor;
    }

    public Color getSecondColor() {
        return secondColor;
    }

    public Color getThirdColor() {
        return thirdColor;
    }
}
