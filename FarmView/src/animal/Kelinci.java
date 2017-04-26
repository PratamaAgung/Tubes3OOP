package animal;

/**
 * Kelas Kelinci representasi hewan kelinci.
 * @author Annisa Muzdalifa.
 */
public class Kelinci extends Animal {
  public Kelinci(int id, int absis, int ordinat, String behaviour) {
    super(id, 4, absis, ordinat, behaviour);
    icon = resizePicture("data/Kelinci.png",25,25);
  }
}
