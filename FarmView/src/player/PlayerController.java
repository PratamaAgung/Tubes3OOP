package player;

import cell.CellController;
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
    private CellController cellController;

    public PlayerController(JTextPane[][] map, int x, int y, int isGirl, String nama, CellController cellController){
        this.map = map;
        player = new Player(nama,x,y,isGirl);
        this.cellController = cellController;
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
        if (keyCode == 38) {
            if(y - 1 >= 0 && (cellController.getCell(x,y - 1).getId() == 0 || cellController.getCell(x,y - 1).getId() == -1)) {
                map[x][y].setText("");
                map[x][y].insertIcon(grass);
                player.setOrdinat(y-1);
                map[x][y-1].setText("");
                map[x][y-1].insertIcon(player.getAvatar());
            }
        } else if (keyCode == 40) {
            if(y + 1 < 20 && (cellController.getCell(x,y + 1).getId() == 0 || cellController.getCell(x,y + 1).getId() == -1)) {
                map[x][y].setText("");
                map[x][y].insertIcon(grass);
                player.setOrdinat(y + 1);
                map[x][y+1].setText("");
                map[x][y+1].insertIcon(player.getAvatar());
            }
        } else if (keyCode == 37) {
            //System.out.println((x-1) + " " + y+ " " +cellController.getCell(x-1,y).getId());
            if(x - 1 >= 0 && (cellController.getCell(x - 1, y).getId() == 0 || cellController.getCell(x - 1,y).getId() == -1)) {
                map[x][y].setText("");
                map[x][y].insertIcon(grass);
                player.setAbsis(x - 1);
                map[x-1][y].setText("");
                map[x-1][y].insertIcon(player.getAvatar());
            }
        } else if (keyCode == 39) {
            //System.out.println((x+1) + " " + y+ " " +cellController.getCell(x+1,y).getId());
            if (x + 1 < 20 && (cellController.getCell(x + 1,y).getId() == 0 || cellController.getCell(x + 1,y).getId() == -1)) {
                map[x][y].setText("");
                map[x][y].insertIcon(grass);
                player.setAbsis(x + 1);
                map[x+1][y].setText("");
                map[x+1][y].insertIcon(player.getAvatar());
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
