package com.example.testproject;


import javafx.scene.paint.Color;

import java.util.*;

public class ColorPalette {
    Color firstColor = Color.WHITE;
    Color secondColor = Color.WHITE;
    Color thirdColor = Color.WHITE;

    int cur = 0;

//    Deque<Color> colorList = new LinkedList<>(Arrays.asList(Color.rgb(50,50,50), Color.rgb(50,50,50), Color.rgb(50,50,50)));

    public void addColor(Color c){
//        colorList.add(c);
//        colorList.removeFirst();
//        if (colorList.size() > 3){
//            colorList.removeFirst();
//        }
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

    public ArrayList<Color> getColorList(){
        ArrayList<Color> colorList = new ArrayList<>();
        colorList.add(firstColor);
        colorList.add(secondColor);
        colorList.add(thirdColor);
        return colorList;
    }

    public int[] getRGB(String rgb){

        final int[] ret = new int[3];
        for (int i = 0; i< 3; i++){
            ret[i] = Integer.parseInt(rgb.substring(i*2, i*2+2), 16);
        }
        return ret;
    }



//    @Override
//    public String toString() {
//        return "ColorPalette{" +
//                "colorLinkedList=" + colorList +
//                '}';
//    }

    public static void main(String[] args){
        ColorPalette c = new ColorPalette();
        Color red = Color.rgb(255,255,255);
        Color green = Color.rgb(150,25,150);
        Color blue = Color.rgb(25,255,255);
        Color yellow = Color.rgb(12,35,23);
        Color brown = Color.rgb(17,23,85);

        List<Integer> rgb = new ArrayList<>();

        Deque<Color> cc = new LinkedList<>();

        c.addColor(red);
        c.addColor(green);
        c.addColor(blue);
        System.out.println(c);

        c.addColor(yellow);
        System.out.println(c);

    }
}
