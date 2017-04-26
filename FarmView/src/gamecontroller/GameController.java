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
    private Animal animal;
    private AnimalController animalController;
    private boolean viewed = false;
    private CellController cellController;
    private CountDownController countDownController;
    private int nbAnimal;
    private JTextPane [][] map;
    private JFrame frame;
    private JLabel name;
    private JLabel score;
    private JLabel timer;
    private JPanel panel;
    private PlayerController playerController;

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
        this.name.setText("<html>Nama Player : <br>" + playerController.getPlayer().getName() + "</html>");
        this.score.setText("<html>Score : <br>" + playerController.getPlayer().getScore() + "</html>");
    }

    @Override
    public void run() {
        Thread animalThread = new Thread(animalController);
        animalThread.start();
        frame.addKeyListener(playerController);
        boolean timeOver = false;
        boolean allCaught = false;
        nbAnimal = 15;
        while (!timeOver && !allCaught) {
            catchAnimal();
            releaseAnimal();
            allCaught = (nbAnimal == 0);
            timeOver = (countDownController.getDurasi() <= 0);
        }
        if (allCaught) {
          JOptionPane.showMessageDialog(frame,"Selamat KAMU NANGKEP SEMUAA!!!","Congratulation",JOptionPane.PLAIN_MESSAGE);
        }
        else {
          JOptionPane.showMessageDialog(frame,"GAME OVER","GAME OVER",JOptionPane.PLAIN_MESSAGE);
        }
        //animalController.stop();
        countDownController.stop();
    }

    public void catchAnimal() {
        int x = playerController.getPlayer().getAbsis();
        int y =  playerController.getPlayer().getOrdinat();
        if (!cellController.getCell(x,y).isEmpty() && animal == null) {
            animal = cellController.getCell(x,y).getAnimal();
            animalController.setAnimalstatus(animal.getId(),false);
            cellController.getCell(x,y).eraseAnimal();
            JOptionPane.showMessageDialog(frame,animal.clue(),"You catch an animal",JOptionPane.PLAIN_MESSAGE);
            viewed = false;
        } else if (cellController.getCell(x,y).getId() == 0) {
          viewed = false;
        }
    }

    public void releaseAnimal() {
        int x = playerController.getPlayer().getAbsis();
        int y = playerController.getPlayer().getOrdinat();
        if (cellController.getCell(x,y).getId() == -1 && !viewed) {
            if (animal != null
                && ((Door) cellController.getCell(x,y)).getCage_id() == animal.getIdcage()) {
                if (cellController.getCell(x - 1,y).getId()
                   == animal.getIdcage()) {
                  animalController.setAnimalstatus(animal.getId(),true);
                  animalController.getAnimalById(animal.getId()).setAbsis(x-1);
                  animalController.getAnimalById(animal.getId()).setOrdinat(y);
                } else {
                  animalController.setAnimalstatus(animal.getId(),true);
                  animalController.getAnimalById(animal.getId()).setAbsis(x+1);
                  animalController.getAnimalById(animal.getId()).setOrdinat(y);
                }
                animalController.getAnimalById(animal.getId()).setAlreadyCaught();
                --nbAnimal;
                JOptionPane.
                      showMessageDialog(frame, "You put animal in the right cage\nGo get another one", "Congratulation", JOptionPane.PLAIN_MESSAGE);
                animal = null;
                viewed = true;
                int score = playerController.getPlayer().getScore();
                playerController.getPlayer().setScore(score+10);
                this.score.setText("<html>Score : <br>" + playerController.getPlayer().getScore() + "</html>");
            } else if (animal != null) {
              JOptionPane
                  .showMessageDialog(frame
                      , "You put animal in wrong cage\nAnimal clue: "+animal.clue()
                      , "Try Again"
                      , JOptionPane.WARNING_MESSAGE);
              viewed = true;
            } else if (!viewed) {
              JOptionPane
                  .showMessageDialog(frame
                      , "You are not bring an animal with you"
                      , "Catch"
                      , JOptionPane.WARNING_MESSAGE);
              viewed = true;
            }
        }
    }
}
