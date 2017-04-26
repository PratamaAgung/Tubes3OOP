package animal;

/**
 * Kelas Sapi representasi hewan Sapi.
 * @author Annisa Muzdalifa.
 */
public class Sapi extends Animal {
  public Sapi(int id, int absis, int ordinat, String behaviour) {
    super(id, 6, absis, ordinat, behaviour);
    icon = resizePicture("data/Sapi.png",25,25);
  }
}
