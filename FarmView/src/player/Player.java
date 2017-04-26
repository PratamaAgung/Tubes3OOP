package player;

import java.awt.Image;
import javax.swing.ImageIcon;
import resizer.PictureResizer;

/**
 * Kelas Player digunakan untuk merepresentasikan player dalam games.
 * @author iftitakhul on 18/04/17.
 */
public class Player implements PictureResizer {
  private String name;
  private int score;
  private int absis;
  private int ordinat;
  private ImageIcon avatar;

  /**
   * Constructor Player.
   * I.S : -.
   * F.S : Menghasilkan player sesuai dengan parameter input.
   * @param name merepresentasikan nama player dari input.
   * @param absis merepresentasikan posisi awal player pada absis.
   * @param ordinat merepresentasikan posisi awal player pada ordinat.
   * @param isGirl digunakan untuk membedakan apakah player wanita atau pria.
   */
  public Player(String name, int absis, int ordinat, int isGirl) {
    this.name = name;
    this.score = 0;
    this.absis = absis;
    this.ordinat = ordinat;
    if (isGirl == 1) {
      this.avatar = resizePicture("data/FarmGirl.png",25,25);
    } else {
      this.avatar = resizePicture("data/FarmBoy.png",25,25);
    }
  }

  /**
   * Getter avatar.
   * I.S : Player terdefinisi.
   * F.S : Mengembalikan avatar player dalam bentuk ImageIcon.
   */
  public ImageIcon getAvatar() {
    return avatar;
  }

  /**
   * Getter Absis.
   * I.S : Player terdefinisi.
   * F.S : Mengembalikan posisi player sekarang pada absis.
   */
  public int getAbsis() {
    return  absis;
  }

  /**
   * Getter Ordinat.
   * I.S : Player terdefinisi.
   * F.S : Mengembalikan posisi player sekarang pada ordinat.
   */
  public int getOrdinat() {
    return  ordinat;
  }

  /**
   * Getter Nama.
   * I.S : Player terdefinisi.
   * F.S : Mengembalikan nama player.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter Score.
   * I.S : Player terdefinisi.
   * F.S : Mengembalikan nilai score dari player.
   */
  public int getScore() {
    return score;
  }

  /**
   * Setter Name.
   * I.S : Player terdefinisi.
   * F.S : name berhasil dimasukkan ke atribut name.
   * @param name yang dimasukkan ke atribut.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Setter Score.
   * I.S : Player terdefinisi.
   * F.S : score berhasil dimasukkan ke atribut score.
   * @param score yang dimasukkan ke atribut.
   */
  public void setScore(int score) {
    this.score = score;
  }

  /**
   * Setter Ordinat.
   * I.S : Player terdefinisi.
   * F.S : absis berhasil dimasukkan ke atribut absis.
   * @param absis yang dimasukkan ke atribut.
   */
  public void setAbsis(int absis) {
    this.absis = absis;
  }

  /**
   * Setter Ordinat.
   * I.S : Player terdefinisi.
   * F.S : ordinat berhasil dimasukkan ke atribut ordinat.
   * @param ordinat yang dimasukkan ke atribut.
   */
  public void setOrdinat(int ordinat) {
    this.ordinat = ordinat;
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

}
