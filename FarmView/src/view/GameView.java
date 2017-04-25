package view;

import animal.AnimalController;
import cell.CellController;
import countdown.CountDownController;
import gamecontroller.GameController;
import player.PlayerController;
import resizer.PictureResizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class GameView implements PictureResizer {
    private JFrame frame;
    private JTextPane[][] map;
    private JLabel name;
    private JLabel score;
    private JLabel timer;
    private JPanel panel;
    private JButton exit;
    private ImageIcon[] manyicon;
    private CountDownController countDown;
    private GameController gameController;

    @Override
    public ImageIcon resizePicture(String path, int height, int width) {
        ImageIcon picture = new ImageIcon(path);
        Image image = picture.getImage();
        Image resizeimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon picturetemp = new ImageIcon(resizeimage);
        return  picturetemp;
    }

    public GameView(JFrame frame, CardLayout card, JPanel mainPanel, JPanel panelTwo, String nama,int isGirl) {
        this.frame = frame;
        this.panel = panelTwo;
        manyicon = new ImageIcon[12];
        manyicon[0] = resizePicture("data/grass.png",25,25);
        manyicon[1] = resizePicture("data/dirt.png",25,25);
        manyicon[2] = resizePicture("data/fence.jpeg",25,25);
        manyicon[3] = resizePicture("data/gate.jpeg",25,25);
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
                map[i][j].setBackground(Color.GREEN);
                if (i == 9 && j == 9) {
                    map[i][j].insertIcon(manyicon[1]);
                }
                map[i][j].setEditable(false);
                panelTwo.add(map[i][j]);
            }
        }

        name = new JLabel();
        name.setBounds(600,200,200,100);
        panel.add(name);

        score = new JLabel();
        score.setBounds(600,300,200,100);
        panel.add(score);

        timer = new JLabel();
        timer.setBounds(600,400,200,100);
        panel.add(timer);

        countDown = new CountDownController(timer);


        gameController = new GameController(map, frame, isGirl, nama, name, score, timer);
        new Thread(gameController).start();


        exit = new JButton("Back to menu");
        exit.setBounds(250,650, 300,30);
        panel.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(mainPanel, "one");
            }
        });
    }
}
