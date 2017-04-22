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

  public CellController(JTextPane[][] map, int absis, int ordinat) {
    this.map = map;
    this.x = absis;
    this.y = ordinat;
  }

  public void setColorAsCell(int x, int y) {
    map[y][x].setBackground(cell);
  }

  public void setColorAsField(int x, int y) {
    map[y][x].setBackground(field);
  }

  public void setColorAsDoor(int x, int y) {
    map[y][x].setBackground(door);
  }

  @Override
  public void keyPressed(KeyEvent event) {
    int keyCode = event.getKeyCode();
    if (keyCode == 37) {
      if (y - 1 >= 0) {
        map[y][x].setText("");
        y--;
        map[y][x].setText("X");
      }
    } else if (keyCode == 39) {
      if (y + 1 < 5) {
        map[y][x].setText("");
        y++;
        map[y][x].setText("X");
      }
    } else if (keyCode == 38) {
      if (x - 1 >= 0) {
        map[y][x].setText("");
        x--;
        map[y][x].setText("X");
      }
    } else if (keyCode == 40) {
      if (x + 1 < 5) {
        map[y][x].setText("");
        x++;
        map[y][x].setText("X");
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
