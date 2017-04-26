package player;

import cell.CellController;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import resizer.PictureResizer;

/**
 * Kelas yang digunakan untuk mmengatur player dalam games.
 * @author pratamaagung and iftitakhul on 21/04/17.
 */
public class PlayerController extends KeyAdapter implements PictureResizer {
  private JTextPane [][] map;
  private Player player;
  private JLabel name;
  private JLabel score;
  private CellController cellController;

  /**
   * Constructor PlayerController.
   * I.S : -.
   * F.S : PlayerController terbentuk sesuai dengan parameter input.
   * @param map merepresentasikan peta yang digunakan.
   * @param x merupakan letak awal player pada absis.
   * @param y merupakan letak awal player pada ordinat.
   * @param isGirl merepresentasikan apakah player wanita atau pria.
   * @param nama merupakan nama player yang diinput.
   * @param cellController digunakan untuk sumber informasi tentang cell.
   */
  public PlayerController(JTextPane[][] map, int x, int y, int isGirl,
      String nama, CellController cellController) {
    this.map = map;
    player = new Player(nama,x,y,isGirl);
    this.cellController = cellController;
    if (isGirl == 1) {
      map[y][x].setText("");
      map[y][x].insertIcon(resizePicture("data/FarmGirl.png", 25, 25));
    } else {
      map[y][x].setText("");
      map[y][x].insertIcon(resizePicture("data/FarmBoy.png", 25, 25));
    }
  }

  /**
   * I.S : Event terdefinisi, yaitu panah ke atas, bawah, kanan, dan kiri.
   * F.S : Player bergerak sesuai dengan keyevent yang dimasukkan.
   */
  @Override
  public void keyPressed(KeyEvent event) {
    int keyCode = event.getKeyCode();
    ImageIcon icon = resizePicture("data/Bebek.png",25,25);
    ImageIcon grass = resizePicture("data/grass.png", 25, 25);
    int x = player.getAbsis();
    int y = player.getOrdinat();
    if (keyCode == 38) {
      if (y - 1 >= 0 && (cellController.getCell(x,y - 1).getId() == 0
          || cellController.getCell(x,y - 1).getId() == -1)) {
        map[x][y].setText("");
        map[x][y].insertIcon(grass);
        player.setOrdinat(y - 1);
        map[x][y - 1].setText("");
        map[x][y - 1].insertIcon(player.getAvatar());
      }
    } else if (keyCode == 40) {
      if (y + 1 < 20 && (cellController.getCell(x,y + 1).getId() == 0
          || cellController.getCell(x,y + 1).getId() == -1)) {
        map[x][y].setText("");
        map[x][y].insertIcon(grass);
        player.setOrdinat(y + 1);
        map[x][y + 1].setText("");
        map[x][y + 1].insertIcon(player.getAvatar());
      }
    } else if (keyCode == 37) {
      if (x - 1 >= 0 && (cellController.getCell(x - 1, y).getId() == 0
          || cellController.getCell(x - 1,y).getId() == -1)) {
        map[x][y].setText("");
        map[x][y].insertIcon(grass);
        player.setAbsis(x - 1);
        map[x - 1][y].setText("");
        map[x - 1][y].insertIcon(player.getAvatar());
      }
    } else if (keyCode == 39) {
      if (x + 1 < 20 && (cellController.getCell(x + 1,y).getId() == 0
          || cellController.getCell(x + 1,y).getId() == -1)) {
        map[x][y].setText("");
        map[x][y].insertIcon(grass);
        player.setAbsis(x + 1);
        map[x + 1][y].setText("");
        map[x + 1][y].insertIcon(player.getAvatar());
      }
    }
  }

  /**
   * Implementasi method resizePicture dari interface PictureResizer.
   * I.S : path merupakan relative path ke gambar yang ingin dimuat, height dan width
   *     adalah ukuran gambar setelah resize.
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
   * Getter Player.
   * I.S : Player terdefinisi.
   * F.S. : mengambalikan atribut player.
   */
  public Player getPlayer() {
    return player;
  }
}
