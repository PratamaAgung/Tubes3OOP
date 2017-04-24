package countdown;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 * Created by iftitakhul on 18/04/17.
 */

public class CountDownController extends  JPanel {
    private long startTime = -1;
    private int durasi = 75000;
    private Timer timer;
    private JLabel label;

    public CountDownController(JLabel label) {
        this.label = label;
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime < 0) {
                    startTime = System.currentTimeMillis();
                }
                long now = System.currentTimeMillis();
                long time = now - startTime;
                if (time >= durasi) {
                    time = durasi;
                    timer.stop();
                }
                SimpleDateFormat simpleform = new SimpleDateFormat("mm:ss");
                label.setText(simpleform.format(durasi-time));
            }
        });
        timer.setInitialDelay(0);
        if(!timer.isRunning()) {
            startTime = -1;
            timer.start();
        }
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

}
