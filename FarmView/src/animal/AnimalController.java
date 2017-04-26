package animal;

import cell.CellController;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import resizer.PictureResizer;

/**
 * Kelas AnimalController untuk mengatur jalannya Animal.
 * @author Annisa Muzdalifa.
 */
public class AnimalController implements Runnable, PictureResizer {
  private Animal[] animal;
  private JTextPane[][] map;
  private Random rand;
  private int nbAnimal;
  private CellController cellController;
  private boolean[] animalstatus;
  private boolean exit;

  /**
   * Ctor untuk kelas AnimalController.
   * @param map map dimana animalcontroller akan bekerja.
   * @param cellController cellcontroller yang ada pada map.
   */
  public AnimalController(JTextPane[][] map, CellController cellController) {
    this.map = map;
    animal = new Animal[15];
    animalstatus = new boolean[15];
    rand = new Random();
    exit = false;
    this.cellController = cellController;
    animal[0] = new Ayam(1, 3, 6, "Kukuruyuuk");
    animal[1] = new Ayam(2, 7, 18, "I'm an aves but i can't fly");
    animal[2] = new Ayam(3, 10, 15, "Why did i cross the road?");
    animal[3] = new Bebek(4, 2, 10, "Kwek kwek kwek");
    animal[4] = new Bebek(5, 11, 6, "An aves that can swim");
    animal[5] = new Bebek(6, 5, 14, "Mickey mouse is my friend");
    animal[6] = new Domba(7, 7, 6, "People use my wool");
    animal[7] = new Domba(8, 18, 9, "Baa Baa Black Sheep");
    animal[8] = new Kelinci(9, 9, 11, "I hop a lot");
    animal[9] = new Kelinci(10, 14, 17, "People say i love carrot");
    animal[10] = new Kelinci(11, 9, 9, "i am a fluffy ball of fur");
    animal[11] = new Kuda(12, 16, 5, "if i have wings, people "
        + "will call me pegasus");
    animal[12] = new Kuda(13, 15, 7, "I can be used for transportation");
    animal[13] = new Sapi(14, 9, 19, "People love my milk");
    animal[14] = new Sapi(15, 8, 8, "Moo");
    nbAnimal = 15;
    for (int i = 0; i < nbAnimal; i++) {
      animalstatus[i] = true;
      map[animal[i].getAbsis()][animal[i].getOrdinat()].setText("");
      map[animal[i].getAbsis()][animal[i].getOrdinat()].insertIcon(animal[i].getIcon());
      cellController.getCell(animal[i].getAbsis(),animal[i].getOrdinat()).setAnimal(animal[i]);
    }
  }

  /**
   * Methos untuk menambahkan animal ke dalam AnimalController.
   * I.S : anAnimal merupakan instance dari animal.
   * F.S : anAnimal ditambahkan ke dalam array animal.
   * @param anAnimal Animal yang akan ditambahkan.
   */
  public void addAnimal(Animal anAnimal) {
    animal[nbAnimal] = anAnimal;
    nbAnimal++;
  }

  /**
   * Method untuk mendapatkan status dari setiap animal (sudah ditangkap/belum).
   * I.S : -.
   * F.S : mengembalikan array status semua hewan.
   */
  public boolean[] getAnimalstatus() {
    return animalstatus;
  }

  /**
   * Method untuk mengatur status dari animal dengan id.
   * I.S : -.
   * F.S : status dari animal diatur.
   * @param id id dari animal yang akan diatur statusnya.
   * @param status status dari animal tersebut.
   */
  public void setAnimalstatus(int id, boolean status) {
    animalstatus[id - 1] = status;
  }

  /**
   * Getter untuk data member nbAnimal.
   * I.S : -.
   * F.S : mengembalikan banyaknya hewan yang ada.
   */
  public int getNbAnimal() {
    return nbAnimal;
  }

  /**
   * Getter untuk mendapatkan data animal berdasarkan id tertentu.
   * I.S : -.
   * F.S : mengembalikan hewan dengan id jika ada, mengembalikan null jika tidak ada.
   * @param id id dari hean yang ingin diambil.
   */
  public Animal getAnimalById(int id) {
    int i = 0;
    boolean found = false;
    while (i < animal.length && !found) {
      if (animal[i].getId() == id) {
        found = true;
      } else {
        i++;
      }
    }
    if (found) {
      return animal[i];
    } else {
      return null;
    }
  }

  /**
   * Method untuk menjalankan thread animalController.
   * I.S : -.
   * F.S : thread baru dijalankan.
   */
  @Override
  public void run() {
    ImageIcon grass = resizePicture("data/grass.png", 25, 25);
    while (!exit) {
      for (int i = 0; i < nbAnimal; i++) {
        if (animalstatus[i]) {
          int x = animal[i].getAbsis();
          int y = animal[i].getOrdinat();
          int start = rand.nextInt(4) + 1;
          boolean found = false;
          while (!found) {
            if (start == 1) {
              if (x - 1 >= 0
                  && ((!animal[i].isAlreadyCaught()
                  && cellController.getCell(x - 1, y).getId() == 0)
                  || (animal[i].isAlreadyCaught()
                  && cellController.getCell(x - 1, y).getId() == animal[i].getIdcage()))) {
                found = true;
                map[x][y].setText("");
                map[x][y].insertIcon(grass);
                cellController.getCell(x, y).eraseAnimal();
                x--;
                map[x][y].setText("");
                map[x][y].insertIcon(animal[i].getIcon());
                cellController.getCell(x, y).setAnimal(animal[i]);
              } else {
                start = start % 4 + 1;
              }
            } else if (start == 2) {
              if (y - 1 >= 0
                  && ((!animal[i].isAlreadyCaught()
                  && cellController.getCell(x, y - 1).getId() == 0)
                  || (animal[i].isAlreadyCaught()
                  && cellController.getCell(x, y - 1).getId()
                  == animal[i].getIdcage()))) {
                found = true;
                map[x][y].setText("");
                map[x][y].insertIcon(grass);
                cellController.getCell(x, y).eraseAnimal();
                y--;
                map[x][y].setText("");
                map[x][y].insertIcon(animal[i].getIcon());
                cellController.getCell(x, y).setAnimal(animal[i]);
              } else {
                start = start % 4 + 1;
              }
            } else if (start == 3) {
              if (x + 1 < 20
                  && ((!animal[i].isAlreadyCaught()
                  && cellController.getCell(x + 1, y).getId() == 0)
                  || (animal[i].isAlreadyCaught()
                  && cellController.getCell(x + 1, y).getId()
                  == animal[i].getIdcage()))) {
                found = true;
                map[x][y].setText("");
                map[x][y].insertIcon(grass);
                cellController.getCell(x, y).eraseAnimal();
                x++;
                map[x][y].setText("");
                map[x][y].insertIcon(animal[i].getIcon());
                cellController.getCell(x, y).setAnimal(animal[i]);
              } else {
                start = start % 4 + 1;
              }
            } else if (start == 4) {
              if ((y + 1 < 20)
                  && ((!animal[i].isAlreadyCaught()
                  && cellController.getCell(x, y + 1).getId() == 0)
                  || (animal[i].isAlreadyCaught()
                  && cellController.getCell(x, y + 1).getId()
                  == animal[i].getIdcage()))) {
                found = true;
                map[x][y].setText("");
                map[x][y].insertIcon(grass);
                cellController.getCell(x, y).eraseAnimal();
                y++;
                map[x][y].setText("");
                map[x][y].insertIcon(animal[i].getIcon());
                cellController.getCell(x, y).setAnimal(animal[i]);
              } else {
                start = start % 4 + 1;
              }
            }
          }
          animal[i].setAbsis(x);
          animal[i].setOrdinat(y);
        }
      }
      try {
        Thread.sleep(800);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Method untuk menghentikan thread animalController.
   * I.S : ada thread yang berjalan.
   * F.S : thread dimatikan.
   */
  public void stop() {
    exit = true;
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
    return  picturetemp;
  }
}
