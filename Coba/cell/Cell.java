package cell;

/**
 * Created by reiva5 on 22/04/17.
 */
public abstract class Cell {
  //protected Animal animal;
  protected final char type;
  protected final int absis;
  protected final int ordinat;
  protected final int id;
  protected boolean inCage = false;

  /**
   * Constructor tanpa parameter
   */
  public Cell() {
    this.type = 'F';
    this.absis = 0;
    this.ordinat = 0;
    this.id = 0;
  }
  /**
   * Constructor dengan parameter
   * @param _type
   * @param _absis
   * @param _ordinat
   * @param _id
   */
  public Cell(char _type, int _absis, int _ordinat, int _id) {
    this.type = _type;
    this.absis = _absis;
    this.ordinat = _ordinat;
    //this.animal = null;
    this.id = _id;
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