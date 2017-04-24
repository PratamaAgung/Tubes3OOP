package animal;

import resizer.ImageResizer;
import javax.swing.*;
import java.awt.*;

/**
 * Created by nim_13515090 on 22/04/17.
 */
public abstract class Animal implements Behaviour, ImageResizer {
    private final int id;
    private final int idcage;
    private int absis;
    private int ordinat;
    private String behaviour;
    protected ImageIcon icon;

    //Ctor
    public Animal(int _id, int idcage, int x, int y, String _behaviour) {
        this.absis = x;
        this.ordinat = y;
        this.id = _id;
        this.idcage = idcage;
        icon = null;
        behaviour = new String(_behaviour);
    }
    public Animal(final Animal animal) {
        this.absis = animal.absis;
        this.ordinat = animal.ordinat;
        this.id = animal.id;
        this.idcage = animal.idcage;
        behaviour = new String(animal.behaviour);
        icon = new ImageIcon(animal.icon.getImage());
    }

    //Getter
    public int getAbsis() {
        return absis;
    }
    public int getOrdinat() {
        return ordinat;
    }
    public int getId() {
        return id;
    }
    public int getIdcage() {
        return idcage;
    }
    public ImageIcon getIcon() {
        return icon;
    }

    //Setter
    public void setAbsis(int absis) {
        this.absis = absis;
    }
    public void setOrdinat(int ordinat) {
        this.ordinat = ordinat;
    }

    //Clue
    @Override
    public String clue() {
        return behaviour;
    }

    //Resize

    @Override
    public Image resizeImage(String filename) {
        ImageIcon icon = new ImageIcon(filename);
        return icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    }
}
