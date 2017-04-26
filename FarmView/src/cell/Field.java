package cell;

/**
 * Kelas untuk Field turunan dari Cell.
 * @author Jehian Norman Saviero.
 */
public class Field extends Cell {

  /**
   * Contructor dari field.
   * @param absis posisi absis dari Cell bertipe Field.
   * @param ordinat posisi ordinat dari Cell bertipe Field.
   */
  public Field(int absis, int ordinat) {
    super(absis,ordinat,0);
  }

}
