package view;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import player.PlayerController;

/**
 * Kelas Myang mengatur view halaman awal aplikasi.
 * @author Pratamamia Agung.
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
  private PlayerController player;
  private int width;
  private int heigth;

  /**
   * Counstructor untuk kelas MainView.
   * I.S : -.
   * F.S : objek dari minview diciptakan.
   */
  public MainView() {
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


    panelOne.setLayout(null);
    panelTwo.setLayout(null);
    panelCredit.setLayout(null);

    //AddLOGO
    picPane = new JTextPane();
    picPane.setBounds((width - 500) / 2, 100, 500,300);
    picPane.setEditable(false);
    picPane.setOpaque(false);
    ImageIcon icon = new ImageIcon("data/logo.png");
    Image img = icon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
    logo = new ImageIcon(img);

    panelOne.add(picPane);
    picPane.insertIcon(logo);

    Font courierNew = new Font("Courier New", Font.PLAIN, 18);
    startGame = new JButton("Start Game");
    startGame.setFont(courierNew);
    startGame.setBounds((width - 200) / 2,400, 200,30);
    panelOne.add(startGame, Component.CENTER_ALIGNMENT);
    startGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String nama = (String)JOptionPane.showInputDialog(frame, "What's your name?",
            "Let Us Know You", JOptionPane.QUESTION_MESSAGE);
        if ((nama != null) && (nama.length() > 0)) {
          Object[] options = {"Farm Boy", "Farm Girl"};
          int isGirl = JOptionPane.showOptionDialog(frame, "Choose your character", ""
              + "Let Us Know You", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
              null, options, options[0]);
          new GameView(frame, card, mainPanel, panelTwo,nama,isGirl);
          card.show(mainPanel, "two");
        } else {
          JOptionPane.showMessageDialog(frame, "Please enter your player name to play",
              "Try Again", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    credit = new JButton("Credit");
    credit.setFont(courierNew);
    credit.setBounds((width - 200) / 2,450, 200,30);
    panelOne.add(credit);
    credit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new CreditView(card, mainPanel, panelCredit);
        card.show(mainPanel, "three");
      }
    });


    frame.add(mainPanel);
    frame.setFocusable(true);
    frame.setVisible(true);
  }

}
