package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by iftitakhul on 18/04/17.
 */
//import java.lang.*;

public class Player implements ResizePicture {
    private String name;
    private int score;
    private int absis, ordinat;
    private ImageIcon avatar;

    public Player(String name, int absis, int ordinat) {
        this.name = name;
        this.score = 0;
        this.absis = absis;
        this.ordinat = ordinat;
        this.avatar = resizePicture("/home/iftitakhul/Documents/Tingkat2/Semester4/OOP/tubes/Tubes3/Tubes3OOP/bebek.png",25,25);
    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public  int getAbsis() {return  absis;}

    public  int getOrdinat() {return  ordinat;}

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setAbsis(int absis) {this.absis = absis; }

    public void setOrdinat(int ordinat) {this.ordinat = ordinat; }

    public ImageIcon resizePicture(String path, int height, int width) {
        ImageIcon picture = new ImageIcon(path);
        Image image = picture.getImage();
        Image resizeimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon picturetemp = new ImageIcon(resizeimage);
        return  picturetemp;
    }

}
