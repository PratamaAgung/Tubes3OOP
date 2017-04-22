package cell;

/**
 * Created by reiva5 on 22/04/17.
 */
public class Door extends Cell {
    
  private boolean locked;

  /**
   * Constructor dengan parameter
   * @param kar
   * @param sumbuX
   * @param sumbuY
   * @param lock
   */
  public Door(char kar, int sumbuX, int sumbuY, int id, boolean lock) {
    super(kar, sumbuX, sumbuY, id);
    locked = lock;
  }

  /**
   * Method untuk mengubah status pintu
   * menjadi tidak terkunci
   */
  public void openLock() {
    locked = false;
  }

}
