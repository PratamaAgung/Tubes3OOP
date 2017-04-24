package player;

import resizer.ResizePicture;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * Created by pratamaagung on 21/04/17.
 */
public class PlayerController extends KeyAdapter implements ResizePicture {
    private JTextPane [][] map;
    private Player player;
    private JLabel name;
    private JLabel score;

    public PlayerController(JTextPane[][] map, int x, int y, int isGirl, String nama){
        this.map = map;
        player = new Player(nama,x,y,isGirl);
        if (isGirl == 1) {
            map[y][x].insertIcon(resizePicture("data/bebek.png", 25, 25));
        } else {
            map[y][x].insertIcon(resizePicture("data/bebek.png", 25, 25));
        }
    }

    @Override
    public void keyPressed(KeyEvent event){
        int keyCode = event.getKeyCode();
        ImageIcon icon = resizePicture("/home/iftitakhul/Documents/Tingkat2/Semester4/OOP/tubes/Tubes3/Tubes3OOP/bebek.png",25,25);
        System.out.println(keyCode);
        int x = player.getAbsis();
        int y = player.getOrdinat();
        if (keyCode == 37) {
            if(y - 1 >= 0) {
                map[y][x].setText("");
                player.setOrdinat(y-1);
                map[y-1][x].insertIcon(icon);
            }
        } else if (keyCode == 39){
            if(y + 1 < 20) {
                map[y][x].setText("");
                player.setOrdinat(y + 1);
                map[y + 1][x].insertIcon(icon);
            }
        } else if (keyCode == 38){
            if(x - 1 >= 0) {
                map[y][x].setText("");
                player.setAbsis(x - 1);
                map[y][x - 1].insertIcon(icon);
            }
        } else if (keyCode == 40) {
            if (x + 1 < 20) {
                map[y][x].setText("");
                player.setAbsis(x + 1);
                map[y][x + 1].insertIcon(icon);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    public void catchAnimal() {

    }

    public void releaseAnimal() {

    }

    @Override
    public ImageIcon resizePicture(String path, int height, int width) {
        ImageIcon picture = new ImageIcon(path);
        Image image = picture.getImage();
        Image resizeimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon picturetemp = new ImageIcon(resizeimage);
        return  picturetemp;
    }

    public Player getPlayer() {
        return player;
    }

}
