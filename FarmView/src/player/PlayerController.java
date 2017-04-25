package player;

import resizer.PictureResizer;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * Created by pratamaagung on 21/04/17.
 */
public class PlayerController extends KeyAdapter implements PictureResizer {
    private JTextPane [][] map;
    private Player player;
    private JLabel name;
    private JLabel score;

    public PlayerController(JTextPane[][] map, int x, int y, int isGirl, String nama){
        this.map = map;
        player = new Player(nama,x,y,isGirl);
        if (isGirl == 1) {
            map[y][x].setText("");
            map[y][x].insertIcon(resizePicture("data/FarmGirl.png", 25, 25));
        } else {
            map[y][x].setText("");
            map[y][x].insertIcon(resizePicture("data/FarmBoy.png", 25, 25));
        }
    }

    @Override
    public void keyPressed(KeyEvent event){
        int keyCode = event.getKeyCode();
        ImageIcon icon = resizePicture("data/Bebek.png",25,25);
        ImageIcon grass = resizePicture("data/grass.png", 25, 25);
        int x = player.getAbsis();
        int y = player.getOrdinat();
        if (keyCode == 37) {
            if(y - 1 >= 0) {
                map[y][x].setText("");
                map[y][x].insertIcon(grass);
                player.setOrdinat(y-1);
                map[y - 1][x].setText("");
                map[y - 1][x].insertIcon(player.getAvatar());
            }
        } else if (keyCode == 39){
            if(y + 1 < 20) {
                map[y][x].setText("");
                map[y][x].insertIcon(grass);
                player.setOrdinat(y + 1);
                map[y + 1][x].setText("");
                map[y + 1][x].insertIcon(player.getAvatar());
            }
        } else if (keyCode == 38){
            if(x - 1 >= 0) {
                map[y][x].setText("");
                map[y][x].insertIcon(grass);
                player.setAbsis(x - 1);
                map[y][x - 1].setText("");
                map[y][x - 1].insertIcon(player.getAvatar());
            }
        } else if (keyCode == 40) {
            if (x + 1 < 20) {
                map[y][x].setText("");
                map[y][x].insertIcon(grass);
                player.setAbsis(x + 1);
                map[y][x + 1].setText("");
                map[y][x + 1].insertIcon(player.getAvatar());
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
