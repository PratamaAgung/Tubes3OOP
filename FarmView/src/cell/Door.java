package cell;

/**
 * Created by reiva5 on 22/04/17.
 */
public class Door extends Cell {
    
  private boolean locked;

  /**
   * Constructor dengan parameter
   * @param sumbuX
   * @param sumbuY
   * @param id
   */
  public Door(int sumbuX, int sumbuY, int id) {
    super(sumbuX, sumbuY, id);
    locked = true;
  }

  /**
   * Method untuk mengubah status pintu
   * menjadi tidak terkunci
   */
  public void openLock() {
    locked = false;
  }

}
