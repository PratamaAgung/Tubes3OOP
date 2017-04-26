package animal;

/**
 * Kelas Kuda representasi hewan kuda.
 * @author Annisa Muzdalifa.
 */
public class Kuda extends Animal {
  public Kuda(int id, int absis, int ordinat, String behaviour) {
    super(id, 5, absis, ordinat, behaviour);
    icon = resizePicture("data/Kuda.png",25,25);
  }
}
