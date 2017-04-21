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

    public View(){
        frame = new JFrame("TryIt");
        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setBounds(100, 100, 1000, 750);

        //frame.addKeyListener(new Controller());
        map = new JTextPane[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                map[i][j] = new JTextPane();
                map[i][j].setBounds(50 + i * 25, 100 + j * 25, 25, 25);
                map[i][j].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                map[i][j].setBackground(Color.CYAN);
                frame.getContentPane().add(map[i][j]);
            }
        }

        frame.setVisible(true);
    }
}
