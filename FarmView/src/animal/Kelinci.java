package animal;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class Kelinci extends Animal {
  public Kelinci(int id, int absis, int ordinat, String behaviour) {
    super(id, 4, absis, ordinat, behaviour);
    icon = resizePicture("data/Kelinci.png",25,25);
  }
}
