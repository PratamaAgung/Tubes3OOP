package animal;

/**
 * Kelas Bebek representasi hewan bebek.
 * @author Annisa Muzdalifa.
 */
public class Bebek extends Animal {
  public Bebek(int id, int absis, int ordinat, String behaviour) {
    super(id, 2, absis, ordinat, behaviour);
    icon = resizePicture("data/Bebek.png",25,25);
  }

}
