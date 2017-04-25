package animal;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class Domba extends Animal {

  public Domba(int id, int absis, int ordinat, String behaviour) {
    super(id, 3, absis, ordinat, behaviour);
    icon = resizePicture("data/Domba.png",25,25);
  }
}
