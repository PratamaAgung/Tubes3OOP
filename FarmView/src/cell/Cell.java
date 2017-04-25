package cell;

import animal.*;
/**
 * Created by reiva5 on 22/04/17.
 */
public abstract class Cell {
  protected Animal animal;
  protected boolean empty = true;
  protected final int absis;
  protected final int ordinat;
  protected final int id;

  /**
   * Constructor tanpa parameter
   */
  public Cell() {
    this.absis = 0;
    this.ordinat = 0;
    this.id = 0;
  }

  /**
   * Constructor dengan parameter
   * @param absis
   * @param ordinat
   * @param id
   */
  public Cell(int absis, int ordinat, int id) {
    this.absis = absis;
    this.ordinat = ordinat;
    //this.animal = null;
    this.id = id;
  }

  /**
   * Getter dari data atribut animal.
   * @return animal yang berada pada cell.
   */
  public Animal getAnimal() {
    return animal;
  }

  /**
   * Setter dari data atribut animal.
   * @param hewan animal yang berada pada cell.
   */
  public void setAnimal(Animal hewan) {
    animal = hewan;
  }

  /**
   * Penghapus dari keberadaan animal pada suatu cell.
   */
  public void eraseAnimal() {
    animal = null;
  }

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

  /**
   * Method untuk mengecek apakah cell kosong
   * @return boolean apakah kosong
   */
  public boolean isEmpty() {
    return empty;
  }
}