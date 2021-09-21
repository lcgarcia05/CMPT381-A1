package com.example.testproject;


import javafx.scene.paint.Color;

import java.util.*;

public class ColorPalette {
    Color firstColor = Color.WHITE;
    Color secondColor = Color.WHITE;
    Color thirdColor = Color.WHITE;

    private int cur = 0;

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

    public static void main(String[] args){
//        ColorPalette c = new ColorPalette();
        Color red = Color.rgb(255,255,255);
//        Color green = Color.rgb(150,25,150);
//        Color blue = Color.rgb(25,255,255);
//        Color yellow = Color.rgb(12,35,23);
//        Color brown = Color.rgb(17,23,85);
//
//        List<Integer> rgb = new ArrayList<>();
//
//        Deque<Color> cc = new LinkedList<>();
//
//        c.addColor(red);
//        c.addColor(green);
//        c.addColor(blue);
//        System.out.println(c);
//
//        c.addColor(yellow);
//        System.out.println(c);

    }
}
