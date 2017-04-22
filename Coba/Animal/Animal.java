import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * Created by nim_13515090 on 22/04/17.
 */
public class Animal implements Behaviour {
    private final int id;
    private final int idcage;
    private int absis;
    private int ordinat;
    private final char inisial;
    private String behaviour;


    //Ctor
    public Animal(int _id, int idcage, int x, int y, char _init, String _behaviour) {
        this.absis = x;
        this.ordinat = y;
        this.id = _id;
        this.idcage = idcage;
        this.inisial = _init;
        behaviour = new String(_behaviour);
    }
    public Animal(final Animal animal) {
        this.absis = animal.absis;
        this.ordinat = animal.ordinat;
        this.id = animal.id;
        this.idcage = animal.idcage;
        this.inisial = animal.inisial;
        behaviour = new String(animal.behaviour);
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
    public char getInisial() {
        return inisial;
    }

    //Setter
    public void setAbsis(int absis) {
        this.absis = absis;
    }

    public void setOrdinat(int ordinat) {
        this.ordinat = ordinat;
    }

    //
    @Override
    public String clue() {
        return behaviour;
    }
}
