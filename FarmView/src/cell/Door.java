package cell;

/**
 * Created by reiva5 on 22/04/17.
 */
public class Door extends Cell {

  private boolean locked;
  private int cage_id;

  /**
   * Constructor dengan parameter
   * @param sumbuX
   * @param sumbuY
   * @param cage_id
   */
  public Door(int sumbuX, int sumbuY, int cage_id) {
    super(sumbuX, sumbuY, -1);
    this.cage_id = cage_id;
    locked = true;
  }

  /**
   * Method untuk mengubah status pintu
   * menjadi tidak terkunci
   */
  public void openLock() {
    locked = false;
  }

  /**
   * Method untuk mengambil cage_id
   * @return int cage_id
   */
  public int getCage_id() {
    return this.cage_id;
  }
}
