package animal;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class Kuda extends Animal {
  public Kuda(int id, int absis, int ordinat, String behaviour) {
    super(id, 5, absis, ordinat, behaviour);
    icon = resizePicture("data/Kuda.png",25,25);
  }
}
