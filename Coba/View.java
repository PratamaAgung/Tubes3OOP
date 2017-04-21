package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by pratamaagung on 21/04/17.
 */
public class View {
    private JFrame frame;
    private JTextPane[][] map;
    private JPanel panel;
    private int x, y;

    public View(){
        x = 0;
        y = 0;
        frame = new JFrame("TryIt");
        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setBounds(100, 100, 1000, 750);

        map = new JTextPane[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                map[i][j] = new JTextPane();
                map[i][j].setBounds(50 + i * 25, 100 + j * 25, 25, 25);
                map[i][j].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                map[i][j].setBackground(Color.CYAN);
                if(i == y && j == x){
                    map[i][j].setText("X");
                }
                map[i][j].setEditable(false);
                frame.getContentPane().add(map[i][j]);
            }
        }

        frame.addKeyListener(new PlayerController(map, x, y));
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
