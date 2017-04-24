import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class GameView {
    public JTextPane[][] map;
    public JPanel panel;
    public JButton exit;
    public ImageIcon[] manyicon;

    public static Image resizeIcon(String filename) {
        ImageIcon icon = new ImageIcon(filename);
        return icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    }

    public GameView(CardLayout card, JPanel mainPanel, JPanel panelTwo) {
        this.panel = panelTwo;
        manyicon = new ImageIcon[12];
        manyicon[0] = new ImageIcon(resizeIcon("grass.png"));
        manyicon[1] = new ImageIcon(resizeIcon("dirt.png"));
        manyicon[2] = new ImageIcon(resizeIcon("fence.jpeg"));
        manyicon[3] = new ImageIcon(resizeIcon("gate.jpeg"));
        manyicon[4] = new ImageIcon(resizeIcon("Ayam.png"));
        manyicon[5] = new ImageIcon(resizeIcon("Bebek.png"));
        manyicon[6] = new ImageIcon(resizeIcon("Domba.png"));
        manyicon[7] = new ImageIcon(resizeIcon("Kelinci.png"));
        manyicon[8] = new ImageIcon(resizeIcon("Kuda.png"));
        manyicon[9] = new ImageIcon(resizeIcon("Sapi.png"));
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
                    map[i][j].insertIcon(manyicon[5]);
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
