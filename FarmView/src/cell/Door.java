package cell;

/**
 * Created by reiva5 on 22/04/17.
 */
public class Door extends Cell {

  private boolean locked;
  private int cageId;

  /**
   * Constructor dengan parameter.
   * @param sumbuX merupakan posisi absis dari Cell bertipe Door.
   * @param sumbuY merupakan posisi ordinat dari Cell bertipe Door.
   * @param cageId merupakn id dari cage yan akan diperantarai dari Field.
   */
  public Door(int sumbuX, int sumbuY, int cageId) {
    super(sumbuX, sumbuY, -1);
    this.cageId = cageId;
    locked = true;
  }

  /**
   * Method untuk mengubah status pintu.
   * menjadi tidak terkunci.
   */
  public void openLock() {
    locked = false;
  }

  /**
   * Method untuk mengambil cage_id.
   * @return int cage_id.
   */
  public int getCage_id() {
    return this.cageId;
  }
}
