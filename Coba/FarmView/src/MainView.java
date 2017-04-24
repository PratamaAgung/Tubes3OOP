import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class MainView {
    public JFrame frame;
    public final JPanel mainPanel = new JPanel();
    public JPanel panelOne = new JPanel();
    public JPanel panelTwo = new JPanel();
    public JPanel panelCredit = new JPanel();
    public final CardLayout card = new CardLayout();
    public JButton startGame;
    public JButton credit;
    public ImageIcon logo;
    public JTextPane picPane;
    private int width, heigth;

    public MainView() {
        Font courierNew = new Font("Courier New", Font.PLAIN, 18);
        width = 800;
        heigth = 750;
        frame = new JFrame("MyFarm");
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,width, heigth);

        mainPanel.setLayout(card);
        mainPanel.add(panelOne, "one");
        mainPanel.add(panelTwo, "two");
        mainPanel.add(panelCredit, "three");

        new CreditView(card, mainPanel, panelCredit);
        new GameView(card, mainPanel, panelTwo);

        panelOne.setLayout(null);
        panelTwo.setLayout(null);
        panelCredit.setLayout(null);

        //AddLOGO
        picPane = new JTextPane();
        picPane.setBounds((width-500)/2, 100, 500,300);
        picPane.setEditable(false);
        picPane.setOpaque(false);
        ImageIcon icon = new ImageIcon("logo.png");
        Image img = icon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        logo = new ImageIcon(img);

        panelOne.add(picPane);
        picPane.insertIcon(logo);


        startGame = new JButton("Start Game");
        startGame.setFont(courierNew);
        startGame.setBounds((width-200)/2,400, 200,30);
        panelOne.add(startGame, Component.CENTER_ALIGNMENT);
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = (String)JOptionPane.showInputDialog(frame, "What's your name?", "Let Us Know You", JOptionPane.QUESTION_MESSAGE);
                if ((s != null) && (s.length()>0)) {
                    Object[] options = {"Farm Boy", "Farm Girl"};
                    int n = JOptionPane.showOptionDialog(frame, "Choose your character", "Let Us Know You", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    card.show(mainPanel, "two");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter your player name to play", "Try Again", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        credit = new JButton("Credit");
        credit.setFont(courierNew);
        credit.setBounds((width-200)/2,450, 200,30);
        panelOne.add(credit);
        credit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.show(mainPanel, "three");
            }
        });


        frame.add(mainPanel);
        frame.setFocusable(true);
        frame.setVisible(true);
    }

}
