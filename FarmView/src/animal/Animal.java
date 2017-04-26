package animal;

import java.awt.Image;
import javax.swing.ImageIcon;
import resizer.PictureResizer;

/**
 * Kelas abstract untuk Animal.
 * @author Annisa Muzdalifa.
 */
public abstract class Animal implements Behaviour, PictureResizer {
  private final int id;
  private final int idcage;
  private int absis;
  private int ordinat;
  private boolean alreadyCaught;
  private String behaviour;
  protected ImageIcon icon;
  protected ImageIcon box;

  /**
   * Ctor untuk animal.
   * I.S : -.
   * F.S : tercipta instance objek animal.
   * @param id id dari animal.
   * @param idcage id cage dari animal.
   * @param x posisi absis dari animal.
   * @param y posisi ordinat dari animal.
   * @param behaviour clue dari animal.
   */
  public Animal(int id, int idcage, int x, int y, String behaviour) {
    this.absis = x;
    this.ordinat = y;
    this.id = id;
    this.idcage = idcage;
    icon = null;
    this.behaviour = new String(behaviour);
    alreadyCaught = false;
    box = resizePicture("data/box.png", 25, 25);
  }

  /**
   * CCTOR untuk kelas animal
   * I.S : -.
   * F.S : tercipta instance Animal yang sama isinya dengan animal.
   * @param animal animal yang akan di-copy.
   */
  public Animal(final Animal animal) {
    this.absis = animal.absis;
    this.ordinat = animal.ordinat;
    this.id = animal.id;
    this.idcage = animal.idcage;
    behaviour = new String(animal.behaviour);
    icon = new ImageIcon(animal.icon.getImage());
  }

  /**
   * Getter untuk data atribut absis.
   * I.S : -.
   * F.S : dikembalikan data absis Animal.
   */
  public int getAbsis() {
    return absis;
  }

  /**
   * Getter untuk data atribut ordinat.
   * I.S : -.
   * F.S : dikembalikan data atribut ordinat.
   */
  public int getOrdinat() {
    return ordinat;
  }

  /**
   * Getter untuk id dari hewan.
   * I.S : -.
   * F.S : dikembalikan data id hewan.
   */
  public int getId() {
    return id;
  }

  /**
   * Getter untuk data member id cage.
   * I.S : -.
   * F.S : dikembalikan data id kandang hewan berada.
   */
  public int getIdcage() {
    return idcage;
  }

  /**
   * Getter untuk data member icon hewan.
   * I.S : -.
   * F.S :dikembalikan gambar icon hewan.
   */
  public ImageIcon getIcon() {
    if (alreadyCaught) {
      return icon;
    } else {
      return box;
    }
  }

  /**
   * Getter untuk data member alreadCaught
   * I.S : -.
   * F.S : mengembalikan boolean apakah hewan telah ditangkap.
   */
  public boolean isAlreadyCaught() {
    return alreadyCaught;
  }

  /**
   * Setter untuk data member absis.
   * F.S : data absis hewan diganti.
   * I.S : absis terdefinisi, bernilai 0<=absis<=19.
   * @param absis absis dari animal
   */
  public void setAbsis(int absis) {
    this.absis = absis;
  }

  /**
   * Setter untuk data member ordinat.
   * I.S : ordinat terdefinisi, bernilai 0<=ordinat<=19.
   * F.S : data ordinat hewan diganti.
   * @param ordinat ordinat dari animal.
   */
  public void setOrdinat(int ordinat) {
    this.ordinat = ordinat;
  }

  /**
   * Implementasi methos resizePicture dari interface PictureResizer.
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
    return picturetemp;
  }


  /**
   * Setter untuk data member alreadyCaught.
   * I.S : -.
   * F.S : data member alreadyCaught menajdi true.
   */
  public void setAlreadyCaught() {
    this.alreadyCaught = true;
  }

  /**
   * Implementasi method clue dari interface Behaviour.
   * I.S : -.
   * F.S : mengembalikan string data member behaviour.
   */
  @Override
  public String clue() {
    return behaviour;
  }
}
