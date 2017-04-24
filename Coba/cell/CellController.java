package cell;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.*;
import java.util.*;
import javax.swing.*;

/**
 * Created by reiva5 on 22/04/17.
 */
public class CellController extends KeyAdapter implements Runnable{
  private JTextPane[][] map;
  private int x, y;
  private final Color cell = Color.black;
  private final Color door = Color.gray;
  private final Color field = Color.green;

  private Random rand;

  private final int UP = 3;
  private final int RIGHT = 4;
  private final int DOWN = 5;
  private final int LEFT = 6;
  private final int ALL = UP + RIGHT + LEFT + DOWN;
  private final int DEFAULT = 1;


  /**
   * Setter untuk memberikan border pada cell
   * @param _absis merupakan posisi absis dari cell
   * @param _ordinat merupakan posisi ordinat dari cell
   * @param location merupakan lokasi margin yang ingin di border
   */
  public void setBorder(int _absis, int _ordinat, int location) {
    if (location == RIGHT) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(DEFAULT, DEFAULT, DEFAULT, 5, Color.BLACK));
    } else if (location == UP) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(5, DEFAULT, DEFAULT, DEFAULT, Color.BLACK));
    } else if (location == LEFT) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(DEFAULT, 5, DEFAULT, DEFAULT, Color.BLACK));
    } else if (location == DOWN) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(DEFAULT, DEFAULT, 5, DEFAULT, Color.BLACK));
    } else if (location == UP + RIGHT) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(5, DEFAULT, DEFAULT, 5, Color.BLACK));
    } else if (location == UP + DOWN) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(5, DEFAULT, 5, DEFAULT, Color.BLACK));
    } else if (location == UP + LEFT) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(5, 5, DEFAULT, DEFAULT, Color.BLACK));
    } else if (location == LEFT + RIGHT) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(DEFAULT, 5, DEFAULT, 5, Color.BLACK));
    } else if (location == LEFT + DOWN) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(DEFAULT, 5, 5, DEFAULT, Color.BLACK));
    } else if (location == RIGHT + DOWN) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(DEFAULT, DEFAULT, 5, 5, Color.BLACK));
    } else if (location == ALL - UP) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(DEFAULT, 5, 5, 5, Color.BLACK));
    } else if (location == ALL - LEFT) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(5, DEFAULT, 5, 5, Color.BLACK));
    } else if (location == ALL - DOWN) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(5, 5, DEFAULT, 5, Color.BLACK));
    } else if (location == ALL - RIGHT) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(5, 5, 5, DEFAULT, Color.BLACK));
    } else if (location == ALL) {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
    } else {
      map[_ordinat][_absis].setBorder(BorderFactory.createMatteBorder(DEFAULT, DEFAULT, DEFAULT, DEFAULT, Color.BLACK));
    }
  }

  /**
   * Constructor cell controller
   * @param map
   * @param absis
   * @param ordinat
   */
  public CellController(JTextPane[][] map, int absis, int ordinat) {
    this.map = map;
    this.x = absis;
    this.y = ordinat;
  }

  /**
   * Setter untuk mengubah warna untuk kelas Default Cell
   * @param _absis
   * @param _ordinat
   */
  public void setColorAsCell(int _absis, int _ordinat) {
    map[_ordinat][_absis].setBackground(cell);
  }

  /**
   * Setter untuk mengubah warna untuk kelas Field
   * @param _absis
   * @param _ordinat
   */
  public void setColorAsField(int _absis, int _ordinat) {
    map[_ordinat][_absis].setBackground(field);
  }

  /**
   * Setter untuk mengubah warna untuk kelas Door
   * @param _absis
   * @param _ordinat
   */
  public void setColorAsDoor(int _absis, int _ordinat) {
    map[_ordinat][_absis].setBackground(door);
  }

  @Override
  public void keyPressed(KeyEvent event) {
    int keyCode = event.getKeyCode();
    if (keyCode == 37) {
      if (y - 1 >= 0) {
        setColorAsDoor(x, y);
        y--;
        setColorAsField(x, y);
      }
    } else if (keyCode == 39) {
      if (y + 1 < 5) {
        setColorAsDoor(x, y);
        y++;
        setColorAsCell(x, y);
      }
    } else if (keyCode == 38) {
      if (x - 1 >= 0) {
        setColorAsField(x, y);
        x--;
        setColorAsCell(x, y);
      }
    } else if (keyCode == 40) {
      if (x + 1 < 5) {
        setColorAsCell(x, y);
        x++;
        setColorAsDoor(x, y);
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent event) {

  }

  @Override
  public void run() {
    while (true) {
      int start = 1;
      boolean found = false;
      while (!found) {
        if (start == 1) {
          if (x - 1 >= 0) {
            found = true;
            setColorAsField(x, y);
            x--;
            setColorAsCell(x, y);
          } else {
            start = start % 4 + 1;
          }
        } else if (start == 2) {
          if (y - 1 >= 0) {
            found = true;
            setColorAsDoor(x, y);
            y--;
            setColorAsField(x, y);
          } else {
            start = start % 4 + 1;
          }
        } else if (start == 3) {
          if (x + 1 < 5) {
            found = true;
            setColorAsCell(x, y);
            x++;
            setColorAsDoor(x, y);
          } else {
            start = start % 4 + 1;
          }
        } else if (start == 4) {
          if (y + 1 < 5) {
            found = true;
            setColorAsDoor(x, y);
            y++;
            setColorAsCell(x, y);
          } else {
            start = start % 4 + 1;
          }
        }
      }
      try {
        Thread.sleep(250);
      } catch (Exception e){}
    }
  }
}