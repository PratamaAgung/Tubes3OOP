package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * Created by pratamaagung on 21/04/17.
 */
public class PlayerController extends KeyAdapter{
    private JTextPane [][] map;
    private int x, y;

    public PlayerController(JTextPane[][] map, int x, int y){
        this.map = map;
        this.x = x;
        this.y = y;
    }

    @Override
    public void keyPressed(KeyEvent event){
        int keyCode = event.getKeyCode();
        if (keyCode == 37) {
            if(y-1 >=0) {
                map[y][x].setText("");
                y--;
                map[y][x].setText("X");
            }
        } else if (keyCode == 39){
            if(y+1 < 5) {
                map[y][x].setText("");
                y++;
                map[y][x].setText("X");
            }
        } else if (keyCode == 38){
            if(x-1 >= 0) {
                map[y][x].setText("");
                x--;
                map[y][x].setText("X");
            }
        } else if (keyCode == 40) {
            if (x + 1 < 5) {
                map[y][x].setText("");
                x++;
                map[y][x].setText("X");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent event){

    }
}
