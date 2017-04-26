package view;

import countdown.CountDownController;
import gamecontroller.GameController;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import resizer.PictureResizer;

/**
 * Kelas untuk view saat game berjalan.
 * @author Pratamamia Agung.
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

  /**
   * Implementasi methos resizePicture dari interface PictureResizer.
   * I.S : path merupakan relative path ke gambar yang ingin dimuat, height dan width
   *   adalah ukuran gambar setelah resize.
   * F.S : mengembalikan imageIcon dari gambar yang telah di-resize.
   * @param path path relative dari file gambar.
   * @param height tinggi dari gambar hasil resize.
   * @param width lebar gambar setelah resize.
   */
  @Override
  public ImageIcon resizePicture(String path, int height, int width) {
    ImageIcon picture = new ImageIcon(path);
    Image image = picture.getImage();
    Image resizeimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    ImageIcon picturetemp = new ImageIcon(resizeimage);
    return  picturetemp;
  }

  /**
   * Constructor untuk kelas GameView
   * @param frame frame utama.
   * @param card layout yang berlaku.
   * @param mainPanel panel utama.
   * @param panelTwo panel tampat game view.
   * @param nama nama pengguna.
   * @param isGirl integer yang melambangkan apakah pengguna berjenis kelamin perempuan.
   */
  public GameView(JFrame frame, CardLayout card, JPanel mainPanel,
                  JPanel panelTwo, String nama,int isGirl) {
    this.frame = frame;
    this.panel = panelTwo;
    manyicon = new ImageIcon[12];
    manyicon[0] = resizePicture("data/grass.png",25,25);
    manyicon[1] = resizePicture("data/dirt.png",25,25);
    manyicon[2] = resizePicture("data/fence.jpeg",25,25);
    manyicon[3] = resizePicture("data/gate.jpeg",25,25);

    map = new JTextPane[20][20];
    for (int i = 0; i < 20; i++) {
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

      /**
       * Method untuk menjalankan listener button exit.
       * I.S : event terdefinisi(mouse click).
       * F.S : kembali ke main panel.
       * @param event event yang diterima oleh button exit.
       */
      @Override
      public void actionPerformed(ActionEvent event) {
        card.show(mainPanel, "one");
      }
    });
  }
}
