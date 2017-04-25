package cell;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

/**
 * Created by reiva5 on 22/04/17.
 */
public class CellController{
  private Cell[][] cell;
  private int length, width;
  private JTextPane[][] map;
  private Random rand;

  /* MACROS FOR COLOR */
  private final Color CELL = Color.black;
  private final Color DOOR = Color.gray;
  private final Color FIELD = Color.green;

  /* MACROS FOR BORDER */
  private final int UP = 3;
  private final int RIGHT = 5;
  private final int DOWN = 7;
  private final int LEFT = 11;
  private final int ALL = UP + RIGHT + LEFT + DOWN;
  private final int DEFAULT = 0;


  /**
   * Constructor cell controller
   * @param map
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
    this.cell[0][5] = new Door(5,0,1);

    for (int i = 8; i < 13; ++i) {
      for (int j = 3; j < 8; ++j) {
        this.cell[i][j] = new Cage(j,i,2);
      }
    }
    this.cell[7][3] = new Door(3,8,2);

    for (int i = width - 4; i < width; ++i) {
      for (int j = length - 4; j < length; ++j) {
        this.cell[i][j] = new Cage(j,i,3);
      }
    }
    this.cell[width - 4][length - 3] = new Door(length - 3, width - 4, 3);

    for (int i = width - 4; i < width; ++i) {
      for (int j = 0; j < 4; ++j) {
        this.cell[i][j] = new Cage(j,i,4);
      }
    }
    this.cell[width - 4][4] = new Door(4,width - 4,4);

    for (int i = 0; i < 5; ++i) {
      for (int j = width - 5; j < width; ++j) {
        this.cell[i][j] = new Cage(j,i,5);
      }
    }
    this.cell[5][width - 5] = new Door(width - 5,5,5);

    for (int i = 8; i < 13; ++i) {
      for (int j = width - 8; j < width - 3; ++j) {
        this.cell[i][j] = new Cage(j,i,6);
      }
    }
    this.cell[8][width - 3] = new Door(width - 3,8,6);

    createCage(1);
    createCage(2);
    createCage(3);
    createCage(4);
    createCage(5);
    createCage(6);
  }

  /**
   * Setter untuk memberikan border pada cell
   * @param absis merupakan posisi absis dari cell
   * @param ordinat merupakan posisi ordinat dari cell
   * @param location merupakan lokasi margin yang ingin di border
   */
  public void setBorder(int ordinat, int absis, int location, int thick) {
    if (location == RIGHT) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(DEFAULT, DEFAULT, DEFAULT, thick, Color.BLACK));
    } else if (location == UP) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, DEFAULT, DEFAULT, DEFAULT, Color.BLACK));
    } else if (location == LEFT) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(DEFAULT, thick, DEFAULT, DEFAULT, Color.BLACK));
    } else if (location == DOWN) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(DEFAULT, DEFAULT, thick, DEFAULT, Color.BLACK));
    } else if (location == UP + RIGHT) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, DEFAULT, DEFAULT, thick, Color.BLACK));
    } else if (location == UP + DOWN) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, DEFAULT, thick, DEFAULT, Color.BLACK));
    } else if (location == UP + LEFT) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thick, DEFAULT, DEFAULT, Color.BLACK));
    } else if (location == LEFT + RIGHT) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(DEFAULT, thick, DEFAULT, thick, Color.BLACK));
    } else if (location == LEFT + DOWN) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(DEFAULT, thick, thick, DEFAULT, Color.BLACK));
    } else if (location == RIGHT + DOWN) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(DEFAULT, DEFAULT, thick, thick, Color.BLACK));
    } else if (location == ALL - UP) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(DEFAULT, thick, thick, thick, Color.BLACK));
    } else if (location == ALL - LEFT) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, DEFAULT, thick, thick, Color.BLACK));
    } else if (location == ALL - DOWN) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thick, DEFAULT, thick, Color.BLACK));
    } else if (location == ALL - RIGHT) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thick, thick, DEFAULT, Color.BLACK));
    } else if (location == ALL) {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(thick, thick, thick, thick, Color.BLACK));
    } else {
      map[absis][ordinat]
          .setBorder(BorderFactory
          .createMatteBorder(DEFAULT, DEFAULT, DEFAULT, DEFAULT, Color.BLACK));
    }
  }

  /**
   * Method menginisiasi border untuk cage berinisial id
   * @param id, nomor identitas cage
   */
  public void createCage(int id) {
    boolean found = false;
    if (id != 0) {
      int i = 0, j = 0;
      while (!found && i < width) {
        j = 0;
        while (!found && j < length) {
          if (cell[i][j].getId() == -1
              && ((Door) cell[i][j]).getCage_id() == id) {
            found = true;
          }
          else {
            ++j;
          }
        }
        if (!found) {
          ++i;
        }
      }

      Cage Start = new Cage(j,i,id);
      Door pintu = new Door(j,i,id);

      boolean[][] visited = new boolean[width][length];
      for (i = 0; i < width; ++i) {
        for (j = 0; j < length; ++j) {
          visited[i][j] = !(cell[i][j].getId() == id);
          setColorAsCell(j,i);
        }
      }
      Queue<Cage> Q = new ArrayDeque<Cage>();
      Q.add(Start);
      int val = ALL;
      while (!Q.isEmpty()) {
        Cage temp = (Cage) Q.remove();
        if (temp.getOrdinat() - 1 >= 0
            && (cell[temp.getOrdinat() - 1][temp.getAbsis()].getId() == id
            || cell[temp.getOrdinat() - 1][temp.getAbsis()].getId() == -1)) {
          val -= UP;
          if (!visited[temp.getOrdinat() - 1][temp.getAbsis()]) {
            visited[temp.getOrdinat() - 1][temp.getAbsis()] = true;
            Cage junks = new Cage(temp.getAbsis(),temp.getOrdinat() - 1,id);
            Q.add(junks);
          }
        }

        if (temp.getOrdinat() + 1 < width
            && (cell[temp.getOrdinat() + 1][temp.getAbsis()].getId() == id
            || cell[temp.getOrdinat() + 1][temp.getAbsis()].getId() == -1)) {
          val -= DOWN;
          if (!visited[temp.getOrdinat() + 1][temp.getAbsis()]) {
            visited[temp.getOrdinat() + 1][temp.getAbsis()] = true;
            Cage junks = new Cage(temp.getAbsis(),temp.getOrdinat() + 1,id);
            Q.add(junks);
          }
        }
        if (temp.getAbsis() - 1 >= 0
            && (cell[temp.getOrdinat()][temp.getAbsis() - 1].getId() == id
            || cell[temp.getOrdinat()][temp.getAbsis() - 1].getId() == -1)) {
          val -= LEFT;
          if (!visited[temp.getOrdinat()][temp.getAbsis() - 1]) {
            visited[temp.getOrdinat()][temp.getAbsis() - 1] = true;
            Cage junks = new Cage(temp.getAbsis() - 1,temp.getOrdinat(),id);
            Q.add(junks);
          }
        }
        if (temp.getAbsis() + 1 < length
            && (cell[temp.getOrdinat()][temp.getAbsis() + 1].getId() == id
            || cell[temp.getOrdinat()][temp.getAbsis() + 1].getId() == -1)) {
          val -= RIGHT;
          if (!visited[temp.getOrdinat()][temp.getAbsis() + 1]) {
            visited[temp.getOrdinat()][temp.getAbsis() + 1] = true;
            Cage junks = new Cage(temp.getAbsis() + 1, temp.getOrdinat(),id);
            Q.add(junks);
          }
        }
        setBorder(temp.getOrdinat(),temp.getAbsis(),val,3);
        val = ALL;
      }
      setBorder(pintu.getOrdinat(),pintu.getAbsis(),0,0);
    }
    else {
      found = true;
    }
  }

  /**
   * Setter untuk mengubah warna untuk kelas Default Cell
   * @param absis
   * @param ordinat
   */
  public void setColorAsCell(int absis, int ordinat) {
    map[ordinat][absis].setBackground(CELL);
  }

  /**
   * Setter untuk mengubah warna untuk kelas Door
   * @param absis
   * @param ordinat
   */
  public void setColorAsDoor(int absis, int ordinat) {
    map[ordinat][absis].setBackground(DOOR);
  }

  /**
   * Method mengambil cell pada posisi tertentu
   * @param absis posisi absis dari dari cel;
   * @param ordinat posisi ordinat dari cell
   * @return Cell pada posisi ordinat dan absis input
   */
  public Cell getCell(int absis, int ordinat) {
    return cell[ordinat][absis];
  }

  public Cell[][] getCell() {
    return cell;
  }
}