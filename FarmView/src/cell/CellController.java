package cell;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JTextPane;

/**
 * Created by reiva5 on 22/04/17.
 */
public class CellController {
  private Cell[][] cell;
  private int length;
  private int width;
  private JTextPane[][] map;
  private Random rand;

  /* MACROS FOR COLOR */
  private final Color colorCell = Color.black;
  private final Color colorDoor = Color.gray;

  /* MACROS FOR BORDER */
  private final int up = 3;
  private final int right = 5;
  private final int down = 7;
  private final int left = 11;
  private final int all = up + right + left + down;
  private final int thickDef = 0;


  /**
   * Constructor dengan parameter cell controller.
   * I.S. : map terdefinisi.
   * F.S. : data member map tersimpan pada cell controller.
   * @param map merupakan kondisi map saat ini.
   */
  public CellController(JTextPane[][] map) {
    this.map = map;
    length = map[0].length;
    width = map.length;
    this.cell = new Cell[width][length];

    for (int i = 0; i < width; ++i) {
      for (int j = 0; j < length; ++j) {
        this.cell[i][j] = new Field(j,i);
      }
    }

    for (int i = 0; i < 5; ++i) {
      for (int j = 0; j < 5; ++j) {
        this.cell[i][j] = new Cage(j,i,1);
      }
    }
    this.cell[1][4] = new Door(4,1,1);

    for (int i = 8; i < 13; ++i) {
      for (int j = 3; j < 8; ++j) {
        this.cell[i][j] = new Cage(j,i,2);
      }
    }
    this.cell[8][4] = new Door(4,8,2);

    for (int i = width - 4; i < width; ++i) {
      for (int j = length - 4; j < length; ++j) {
        this.cell[i][j] = new Cage(j,i,3);
      }
    }
    this.cell[width - 3][length - 4] = new Door(length - 4, width - 3, 3);

    for (int i = width - 4; i < width; ++i) {
      for (int j = 0; j < 4; ++j) {
        this.cell[i][j] = new Cage(j,i,4);
      }
    }
    this.cell[width - 4][2] = new Door(2,width - 4,4);

    for (int i = 0; i < 5; ++i) {
      for (int j = length - 5; j < length; ++j) {
        this.cell[i][j] = new Cage(j,i,5);
      }
    }
    this.cell[4][length - 4] = new Door(length - 4,4,5);

    for (int i = 8; i < 13; ++i) {
      for (int j = width - 8; j < width - 3; ++j) {
        this.cell[i][j] = new Cage(j,i,6);
      }
    }
    this.cell[8][width - 5] = new Door(width - 5,8,6);

    createCage(1);
    createCage(2);
    createCage(3);
    createCage(4);
    createCage(5);
    createCage(6);
  }

  /**
   * Setter untuk memberikan border pada cell.
   * @param absis merupakan posisi absis dari cell.
   * @param ordinat merupakan posisi ordinat dari cell.
   * @param location merupakan lokasi margin yang ingin di border.
   */
  public void setBorder(int ordinat, int absis, int location, int thick) {
    if (location == right) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thickDef, thickDef, thickDef, thick, Color.BLACK));
    } else if (location == up) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thickDef, thickDef, thickDef, Color.BLACK));
    } else if (location == left) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thickDef, thick, thickDef, thickDef, Color.BLACK));
    } else if (location == down) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thickDef, thickDef, thick, thickDef, Color.BLACK));
    } else if (location == up + right) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thickDef, thickDef, thick, Color.BLACK));
    } else if (location == up + down) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thickDef, thick, thickDef, Color.BLACK));
    } else if (location == up + left) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thick, thickDef, thickDef, Color.BLACK));
    } else if (location == left + right) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thickDef, thick, thickDef, thick, Color.BLACK));
    } else if (location == left + down) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thickDef, thick, thick, thickDef, Color.BLACK));
    } else if (location == right + down) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thickDef, thickDef, thick, thick, Color.BLACK));
    } else if (location == all - up) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thickDef, thick, thick, thick, Color.BLACK));
    } else if (location == all - left) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thickDef, thick, thick, Color.BLACK));
    } else if (location == all - down) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thick, thickDef, thick, Color.BLACK));
    } else if (location == all - right) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thick, thick, thickDef, Color.BLACK));
    } else if (location == all) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thick, thick, thick, Color.BLACK));
    } else {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thickDef, thickDef, thickDef, thickDef, Color.BLACK));
    }
  }

  /**
   * Method menginisiasi border untuk cage berinisial id.
   * @param id nomor identitas cage.
   */
  public void createCage(int id) {
    boolean found = false;
    int i;
    int j;
    if (id != 0) {
      i = 0;
      j = 0;
      while (!found && i < width) {
        j = 0;
        while (!found && j < length) {
          if (cell[i][j].getId() == -1
                  && ((Door) cell[i][j]).getCage_id() == id) {
            found = true;
          } else {
            ++j;
          }
        }
        if (!found) {
          ++i;
        }
      }

      boolean[][] visited = new boolean[width][length];
      int k;
      int l;
      for (k = 0; k < width; ++k) {
        for (l = 0; l < length; ++l) {
          visited[k][l] = !(cell[k][l].getId() == id);
          setColorAsCell(l,k);
        }
      }
      Cage start = new Cage(j,i,id);
      Queue<Cage> cageQueue = new ArrayDeque<Cage>();
      cageQueue.add(start);
      int val = all;
      while (!cageQueue.isEmpty()) {
        Cage temp = (Cage) cageQueue.remove();
        if (temp.getOrdinat() - 1 >= 0
                && (cell[temp.getOrdinat() - 1][temp.getAbsis()].getId() == id
                || cell[temp.getOrdinat() - 1][temp.getAbsis()].getId() == -1)) {
          val -= up;
          if (!visited[temp.getOrdinat() - 1][temp.getAbsis()]) {
            visited[temp.getOrdinat() - 1][temp.getAbsis()] = true;
            Cage junks = new Cage(temp.getAbsis(),temp.getOrdinat() - 1,id);
            cageQueue.add(junks);
          }
        }

        if (temp.getOrdinat() + 1 < width
                && (cell[temp.getOrdinat() + 1][temp.getAbsis()].getId() == id
                || cell[temp.getOrdinat() + 1][temp.getAbsis()].getId() == -1)) {
          val -= down;
          if (!visited[temp.getOrdinat() + 1][temp.getAbsis()]) {
            visited[temp.getOrdinat() + 1][temp.getAbsis()] = true;
            Cage junks = new Cage(temp.getAbsis(),temp.getOrdinat() + 1,id);
            cageQueue.add(junks);
          }
        }
        if (temp.getAbsis() - 1 >= 0
                && (cell[temp.getOrdinat()][temp.getAbsis() - 1].getId() == id
                || cell[temp.getOrdinat()][temp.getAbsis() - 1].getId() == -1)) {
          val -= left;
          if (!visited[temp.getOrdinat()][temp.getAbsis() - 1]) {
            visited[temp.getOrdinat()][temp.getAbsis() - 1] = true;
            Cage junks = new Cage(temp.getAbsis() - 1,temp.getOrdinat(),id);
            cageQueue.add(junks);
          }
        }
        if (temp.getAbsis() + 1 < length
                && (cell[temp.getOrdinat()][temp.getAbsis() + 1].getId() == id
                || cell[temp.getOrdinat()][temp.getAbsis() + 1].getId() == -1)) {
          val -= right;
          if (!visited[temp.getOrdinat()][temp.getAbsis() + 1]) {
            visited[temp.getOrdinat()][temp.getAbsis() + 1] = true;
            Cage junks = new Cage(temp.getAbsis() + 1, temp.getOrdinat(),id);
            cageQueue.add(junks);
          }
        }
        setBorder(temp.getOrdinat(),temp.getAbsis(),val,3);
        val = all;
      }
      Door pintu = new Door(j,i,id);
      setBorder(pintu.getOrdinat(),pintu.getAbsis(),0,0);
    } else {
      found = true;
    }
  }

  /**
   * Setter untuk mengubah warna untuk kelas Default Cell.
   * @param absis untuk menentukan posisi absis dari cell yang akan diubah warnanya.
   * @param ordinat untuk menentukan posisi ordinat dari cell yang akan diubah warnanya.
   */
  public void setColorAsCell(int absis, int ordinat) {
    map[ordinat][absis].setBackground(colorCell);
  }

  /**
   * Setter untuk mengubah warna untuk kelas Door.
   * @param absis untuk menentukan posisi absis dari door yang akan diubah warnanya.
   * @param ordinat untuk menentukan posisi ordinat dari door yang akan diubah warnanya.
   */
  public void setColorAsDoor(int absis, int ordinat) {
    map[ordinat][absis].setBackground(colorDoor);
  }

  /**
   * Method mengambil cell pada posisi tertentu.
   * @param absis posisi absis dari dari cel.
   * @param ordinat posisi ordinat dari cell.
   * @return Cell pada posisi ordinat dan absis input.
   */
  public Cell getCell(int absis, int ordinat) {
    return cell[ordinat][absis];
  }

  /**
   * Method mengambil cell pada cell controller.
   * @return Cell[][] merupakan array of cell dari cell controller.
   */
  public Cell[][] getCell() {
    return cell;
  }
}