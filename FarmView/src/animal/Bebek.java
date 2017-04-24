package animal;

import javax.swing.*;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class Bebek extends Animal {
    public Bebek(int id, int absis, int ordinat, String behaviour) {
        super(id, 2, absis, ordinat, behaviour);
        icon = new ImageIcon(resizeImage("data/Bebek.png"));
    }
}
