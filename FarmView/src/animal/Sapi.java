package animal;

import javax.swing.*;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class Sapi extends Animal {
    public Sapi(int id, int absis, int ordinat, String behaviour) {
        super(id, 6, absis, ordinat, behaviour);
        icon = new ImageIcon(resizeImage("data/Sapi.png"));
    }
}
