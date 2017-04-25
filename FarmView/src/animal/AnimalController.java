package animal;

import cell.Cell;
import resizer.PictureResizer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by nim_13515090 on 24/04/17.
 */
public class AnimalController implements Runnable, PictureResizer {
    private Animal[] animal;
    private JTextPane[][] map;
    private Random rand;
    private int nbAnimal;
    private Cell[][] farm;

    public AnimalController(JTextPane[][] map, Cell[][] cell) {
        this.map = map;
        animal = new Animal[15];
        rand = new Random();
        farm = cell;
        animal[0] = new Ayam(1, 3, 6, "Kukuruyuuk");
        animal[1] = new Ayam(2, 7, 18, "I'm an aves but i can't fly");
        animal[2] = new Ayam(3, 10, 15, "Why did i cross the road?");
        animal[3] = new Bebek(4, 3, 10, "Kwek kwek kwek");
        animal[4] = new Bebek(5, 11, 6, "An aves that can swim");
        animal[5] = new Bebek(6, 5, 14, "Mickey mouse is my friend");
        animal[6] = new Domba(7, 7, 6, "People use my wool");
        animal[7] = new Domba(8, 18, 9, "Baa Baa Black Sheep");
        animal[8] = new Kelinci(9, 9, 11, "I hop a lot");
        animal[9] = new Kelinci(10, 17, 17, "People say i love carrot");
        animal[10] = new Kelinci(11, 9, 9, "i am a fluffy ball of fur");
        animal[11] = new Kuda(12, 16, 2, "if i have wings, people will call me pegasus");
        animal[12] = new Kuda(13, 15, 8, "I can be used for transportation");
        animal[13] = new Sapi(14, 9, 19, "People love my milk");
        animal[14] = new Sapi(15, 8, 8, "Moo");
        nbAnimal = 15;
        for (int i = 0; i < nbAnimal; i++) {
            map[animal[i].getAbsis()][animal[i].getOrdinat()].insertIcon(animal[i].getIcon());
        }
    }

    public void addAnimal(Animal anAnimal) {
        animal[nbAnimal] = anAnimal;
        nbAnimal++;
    }

    public Animal getAnimalById(int id) {
        int i = 0;
        boolean found = false;
        while (i < animal.length && !found) {
            if(animal[i].getId() == id) {
                found = true;
            } else {
                i++;
            }
        }
        if (found) {
            return animal[i];
        } else {
            return null;
        }
    }

    @Override
    public void run() {
        ImageIcon grass = resizePicture("data/grass.png", 25, 25);
        while (true) {
            for(int i = 0; i < nbAnimal; i++) {
                int x = animal[i].getAbsis();
                int y = animal[i].getOrdinat();
                int start = rand.nextInt(4) + 1;
                boolean found = false;
                while (!found) {
                    if (start == 1) {
                        if (x - 1 >= 0 && farm[x-1][y].getId() == 0) {
                            found = true;
                            map[x][y].insertIcon(grass);
                            x--;
                            map[x][y].insertIcon(animal[i].getIcon());
                        } else {
                            start = start % 4 + 1;
                        }
                    } else if (start == 2) {
                        if (y - 1 >= 0 && farm[x][y-1].getId() == 0) {
                            found = true;
                            map[x][y].insertIcon(grass);
                            y--;
                            map[x][y].insertIcon(animal[i].getIcon());
                        } else {
                            start = start % 4 + 1;
                        }
                    } else if (start == 3) {
                        if (x + 1 < 20 && farm[x+1][y].getId() == 0) {
                            found = true;
                            map[x][y].insertIcon(grass);
                            x++;
                            map[x][y].insertIcon(animal[i].getIcon());
                        } else {
                            start = start % 4 + 1;
                        }
                    } else if (start == 4) {
                        if (y + 1 < 20 && farm[x][y+1].getId() == 0) {
                            found = true;
                            map[x][y].insertIcon(grass);
                            y++;
                            map[x][y].insertIcon(animal[i].getIcon());
                        } else {
                            start = start % 4 + 1;
                        }
                    }
                }
                animal[i].setAbsis(x);
                animal[i].setOrdinat(y);
            }
            try {
                Thread.sleep(800);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public ImageIcon resizePicture(String path, int height, int width) {
        ImageIcon picture = new ImageIcon(path);
        Image image = picture.getImage();
        Image resizeimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon picturetemp = new ImageIcon(resizeimage);
        return  picturetemp;
    }
}
