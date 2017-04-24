package view;

import resizer.ImageResizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class GameView implements ImageResizer {
    public JTextPane[][] map;
    public JPanel panel;
    public JButton exit;
    public ImageIcon[] manyicon;

    @Override
    public Image resizeImage(String filename) {
        ImageIcon icon = new ImageIcon(filename);
        return icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    }

    public GameView(CardLayout card, JPanel mainPanel, JPanel panelTwo) {
        this.panel = panelTwo;
        manyicon = new ImageIcon[12];
        manyicon[0] = new ImageIcon(resizeImage("data/grass.png"));
        manyicon[1] = new ImageIcon(resizeImage("data/dirt.png"));
        manyicon[2] = new ImageIcon(resizeImage("data/fence.jpeg"));
        manyicon[3] = new ImageIcon(resizeImage("data/gate.jpeg"));
        //manyicon[10] = new ImageIcon(resizeIcon("FarmBoy.png"));
        //manyicon[11] = new ImageIcon(resizeIcon("FarmGirl.png"));


        //Inisialisasi Map
        map = new JTextPane[20][20];
        for(int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = new JTextPane();
                map[i][j].setBounds(50 + i * 25, 100 + j * 25, 25, 25);
                map[i][j].setBorder(BorderFactory.createLineBorder(Color.gray, 0));
                map[i][j].insertIcon(manyicon[0]);
                if (i == 9 && j == 9) {
                    map[i][j].setText("X");
                }
                map[i][j].setEditable(false);
                panelTwo.add(map[i][j]);
            }
        }

        exit = new JButton("Back to menu");
        exit.setBounds(250,650, 300,30);
        panelTwo.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(mainPanel, "one");
            }
        });
    }
}
