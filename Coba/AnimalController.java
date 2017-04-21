package com.company;
import javax.swing.*;
import java.util.Random;

/**
 * Created by pratamaagung on 21/04/17.
 */
public class AnimalController implements Runnable{
    private JTextPane[][] map;
    private int x, y;
    Random rand;

    public AnimalController(JTextPane[][] map, int x, int y){
        this.map = map;
        this.x = x;
        this.y = y;
        rand = new Random();
    }

    @Override
    public void run(){
        while (true) {
            int start = rand.nextInt(4) + 1;
            boolean found = false;
            while(!found){
                if(start == 1){
                    if(x-1 >= 0){
                        found = true;
                        map[y][x].setText("");
                        x--;
                        map[y][x].setText("?");
                    } else {
                        start= start%4 + 1;
                    }
                } else if (start == 2) {
                    if(y-1 >= 0){
                        found = true;
                        map[y][x].setText("");
                        y--;
                        map[y][x].setText("?");
                    } else {
                        start= start%4 + 1;
                    }
                } else if (start ==3) {
                    if(x+1 < 5){
                        found = true;
                        map[y][x].setText("");
                        x++;
                        map[y][x].setText("?");
                    } else {
                        start= start%4 + 1;
                    }
                } else if (start == 4) {
                    if(y+1 < 5){
                        found = true;
                        map[y][x].setText("");
                        y++;
                        map[y][x].setText("?");
                    } else {
                        start= start%4 + 1;
                    }
                }
            }
            try{
                Thread.sleep(1000);
            } catch (Exception e){}
        }
    }
}
