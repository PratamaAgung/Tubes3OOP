package animal;

/**
 * Kelas Domba representasi hewan domba.
 * @author Annisa Muzdalifa.
 */
public class Domba extends Animal {

  public Domba(int id, int absis, int ordinat, String behaviour) {
    super(id, 3, absis, ordinat, behaviour);
    icon = resizePicture("data/Domba.png",25,25);
  }
}
