package animal;

import javax.swing.*;
import java.lang.*;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class Bebek extends Animal {
    public Bebek(int id, int absis, int ordinat, String behaviour) {
        super(id, 2, absis, ordinat, behaviour);
        icon = resizePicture("data/Bebek.png",25,25);
    }

}
