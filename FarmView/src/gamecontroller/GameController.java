package gamecontroller;

import animal.*;
import cell.CellController;
import cell.Door;
import countdown.CountDownController;
import player.PlayerController;

import javax.swing.*;

/**
 * Created by iftitakhul on 25/04/17.
 */
public class GameController implements Runnable {
    private PlayerController playerController;
    private CellController cellController;
    private AnimalController animalController;
    private CountDownController countDownController;
    private JTextPane [][] map;
    private JFrame frame;
    private JLabel name;
    private JLabel score;
    private JLabel timer;
    private JPanel panel;
    private Animal animal;

    public GameController(JTextPane[][] map, JFrame frame, int isGirl, String nama, JLabel name, JLabel score, JLabel timer) {
        this.map = map;
        this.name = name;
        this.score = score;
        this.timer = timer;
        this.frame = frame;

        cellController = new CellController(map);
        countDownController = new CountDownController(timer);
        playerController = new PlayerController(map, 9, 9, isGirl, nama, cellController);
        animalController = new AnimalController(map, cellController);

        new Thread(animalController).start();

        this.name.setText("<html>Nama Player : <br>" + playerController.getPlayer().getName() + "</html>");
        this.score.setText("<html>Score : <br>" + playerController.getPlayer().getScore() + "</html>");

    }

    @Override
    public void run() {
        frame.addKeyListener(playerController);
        while (true) {
            catchAnimal();
            releaseAnimal();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    public void catchAnimal() {
        int x = playerController.getPlayer().getAbsis();
        int y =  playerController.getPlayer().getOrdinat();
        System.out.println(x+" "+y);
        if (!cellController.getCell(x,y).isEmpty() && animal == null) {
            animal = cellController.getCell(x,y).getAnimal();
            animalController.setAnimalstatus(animal.getId(),false);
            cellController.getCell(x,y).eraseAnimal();
            JOptionPane.showMessageDialog(frame,animal.clue(),"You catch an animal",JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void releaseAnimal() {
        int x = playerController.getPlayer().getAbsis();
        int y = playerController.getPlayer().getOrdinat();
        System.out.println("Jehian sayang mamah");
        if (cellController.getCell(x,y).getId() == -1) {
            if (animal != null
                && ((Door) cellController.getCell(x,y)).getCage_id() == animal.getIdcage()) {
                if (cellController.getCell(x - 1,y).getId()
                   == animal.getIdcage()) {
                  animalController.setAnimalstatus(animal.getId(),true);
                  animalController.getAnimalById(animal.getId()).setAbsis(x-1);
                  animalController.getAnimalById(animal.getId()).setOrdinat(y);
                }
                else {
                  animalController.setAnimalstatus(animal.getId(),true);
                  animalController.getAnimalById(animal.getId()).setAbsis(x+1);
                  animalController.getAnimalById(animal.getId()).setOrdinat(y);
                }
                int score = playerController.getPlayer().getScore();
                playerController.getPlayer().setScore(score+10);
                animalController.getAnimalById(animal.getId()).setAlreadyCaught();
                this.score.setText("<html>Score : <br>" + playerController.getPlayer().getScore() + "</html>");
                animal = null;
            } else if (animal != null) {
              JOptionPane
                  .showMessageDialog(frame
                      , "You put animal in wrong cage\nAnimal clue: "+animal.clue()
                      , "Try Again"
                      , JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane
                        .showMessageDialog(frame
                                , "You are not bring an animal with you :*"
                                , "Catch"
                                , JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
