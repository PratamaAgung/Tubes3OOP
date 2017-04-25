package gamecontroller;

import animal.*;
import cell.CellController;
import com.sun.java.browser.plugin2.DOM;
import countdown.CountDownController;
import player.PlayerController;

import javax.swing.*;
import java.util.Random;

/**
 * Created by iftitakhul on 25/04/17.
 */
public class GameController {
    private PlayerController playerController;
    private CellController cellController;
    private AnimalController animalController;
    private CountDownController countDownController;

    public GameController(JTextPane[][] map, int x, int y, int isGirl, String nama, JLabel label, CellController cellController) {
       // playerController = new PlayerController(map,x,y,isGirl,nama,cellController);
        cellController = new CellController(map);
//        animalController = new AnimalController(map);
        countDownController = new CountDownController(label);

    }



}
