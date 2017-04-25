package player;

import resizer.PictureResizer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by iftitakhul on 18/04/17.
 */
//import java.lang.*;

public class Player implements PictureResizer {
    private String name;
    private int score;
    private int absis, ordinat;
    private ImageIcon avatar;

    public Player(String name, int absis, int ordinat, int isGirl) {
        this.name = name;
        this.score = 0;
        this.absis = absis;
        this.ordinat = ordinat;
        if (isGirl == 1) {
            this.avatar = resizePicture("data/FarmGirl.png",25,25);
        } else   {
            this.avatar = resizePicture("data/FarmBoy.png",25,25);
        }

    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public int getAbsis() {return  absis;}

    public int getOrdinat() {return  ordinat;}

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

    @Override
    public ImageIcon resizePicture(String path, int height, int width) {
        ImageIcon picture = new ImageIcon(path);
        Image image = picture.getImage();
        Image resizeimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon picturetemp = new ImageIcon(resizeimage);
        return  picturetemp;
    }

}
