package animal;

import javax.swing.*;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class Ayam extends Animal {

    public Ayam(int id, int absis, int ordinat, String behaviour) {
        super(id, 1, absis, ordinat, behaviour);
        icon = resizePicture("data/Ayam.png",25,25);
    }
}
