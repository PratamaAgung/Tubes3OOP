package cell;

/**
 * Created by reiva5 on 22/04/17.
 */
abstract class Cell {
  //protected Animal animal;
  protected final char type;
  protected final int absis;
  protected final int ordinat;
  protected final int id;

  /**
   * Constructor dengan parameter
   * @param kar
   * @param sumbuX
   * @param sumbuY
   * @param id
   */
  public Cell(char kar, int sumbuX, int sumbuY, int id) {
    this.type = kar;
    this.absis = sumbuX;
    this.ordinat = sumbuX;
    //this.animal = null;
    this.id = id;
  }

  /**
   * Method mengambil jenis cage
   * @return type cage yang saat ini
   */
  public char getType() {
    return type;
  }

  /**
   * Getter dari data atribut animal.
   * @return animal yang berada pada cell.
   */
  //public Animal getAnimal() {
    //return animal;
  //}

  /**
   * Setter dari data atribut animal.
   * @param hewan animal yang berada pada cell.
   */
  //public void setAnimal(Animal hewan) {
    //animal = hewan;
  //}

  /**
   * Penghapus dari keberadaan animal pada suatu cell.
   */
  //public void eraseAnimal() {
    //animal = null;
  //}

  /**
   * Getter dari data atribut absis.
   * @return lokasi absis dari cell.
   */
  public int getAbsis() {
    return absis;
  }

  /**
   * Getter dari data atribut ordinat.
   * @return lokasi ordinat dari cell.
   */
  public int getOrdinat() {
    return ordinat;
  }

  /**
   * Getter id dari cell
   * @return id dari cell
   */
  public int getId() {
    return id;
  }
}