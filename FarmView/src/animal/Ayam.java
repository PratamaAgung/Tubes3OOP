package animal;

/**
 * Kelas Ayam representasi hewan ayam.
 * @author Annisa Muzdalifa.
 */
public class Ayam extends Animal {

  public Ayam(int id, int absis, int ordinat, String behaviour) {
    super(id, 1, absis, ordinat, behaviour);
    icon = resizePicture("data/Ayam.png",25,25);
  }
}
