package animal;

import java.awt.Image;
import javax.swing.ImageIcon;
import resizer.PictureResizer;

/**
 * Created by nim_13515090 on 22/04/17.
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

  /*
   * Ctor untuk animal
   * @param id id dari animal
   * @param idcage id cage dari animal
   * @param x posisi absis dari animal
   * @param y posisi ordinat dari animal
   * @param behaviour clue dari animal
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

  /*
   * 
   */
  public Animal(final Animal animal) {
    this.absis = animal.absis;
    this.ordinat = animal.ordinat;
    this.id = animal.id;
    this.idcage = animal.idcage;
    behaviour = new String(animal.behaviour);
    icon = new ImageIcon(animal.icon.getImage());
  }

  //Getter
  public int getAbsis() {
    return absis;
  }

  public int getOrdinat() {
    return ordinat;
  }

  public int getId() {
    return id;
  }

  public int getIdcage() {
    return idcage;
  }

  public ImageIcon getIcon() {
    if (alreadyCaught) {
      return icon;
    } else {
      return box;
    }
  }

  public boolean isAlreadyCaught() {
    return alreadyCaught;
  }

  //Setter
  public void setAbsis(int absis) {
    this.absis = absis;
  }

  public void setOrdinat(int ordinat) {
    this.ordinat = ordinat;
  }

  public void setAlreadyCaught() {
    this.alreadyCaught = true;
  }

  //Clue
  @Override
  public String clue() {
    return behaviour;
  }

  //Resize

  @Override
  public ImageIcon resizePicture(String path, int height, int width) {
    ImageIcon picture = new ImageIcon(path);
    Image image = picture.getImage();
    Image resizeimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    ImageIcon picturetemp = new ImageIcon(resizeimage);
    return picturetemp;
  }
}
