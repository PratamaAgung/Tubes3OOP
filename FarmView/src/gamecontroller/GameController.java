package gamecontroller;

import animal.Animal;
import animal.AnimalController;
import cell.CellController;
import countdown.CountDownController;
import player.PlayerController;

import javax.swing.*;

/**
 * Created by iftitakhul on 25/04/17.
 */
public class GameController {
    private PlayerController playerController;
    private CellController cellController;
    private AnimalController animalController;
    private CountDownController countDownController;

    public GameController(JTextPane[][] map, int x, int y, int isGirl, String nama, JPanel gamepanel, Animal animal, JLabel label) {
        playerController = new PlayerController(map,x,y,isGirl,nama);
        cellController = new CellController(map);
//        animalController = new AnimalController(gamepanel, animal);
        countDownController = new CountDownController(label);

    }



}
