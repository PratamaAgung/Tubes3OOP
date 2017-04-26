package countdown;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Kelas untuk mengatur timer.
 * @author Iftitakhul Zakiah.
 */

public class CountDownController extends  JPanel {
  private long startTime = -1;
  private long waktu;
  private int durasi = 150000;
  private Timer timer;
  private JLabel label;

  /**
   * Constructor untuk kelas COuntDownController.
   * I.S : label terdefinisi dan sudah diinisialisasi.
   * F.S : objek CountDownController diciptakan.
   * @param label label untuk menaruh timer.
   */
  public CountDownController(JLabel label) {
    this.label = label;
    timer = new Timer(0, new ActionListener() {

      /**
       * Method untuk memberikan listener terhadap timer.
       * I.S : -.
       * F.S : timer berjalan.
       * @param event event yang menginisiasi timer.
       */
      @Override
      public void actionPerformed(ActionEvent event) {
        if (startTime < 0) {
          startTime = System.currentTimeMillis();
        }
        long now = System.currentTimeMillis();
        waktu = now - startTime;
        if (waktu >= durasi) {
          waktu = durasi;
          timer.stop();
        }
        SimpleDateFormat simpleform = new SimpleDateFormat("mm:ss");
        label.setText(simpleform.format(durasi - waktu));
      }
    });
    timer.setInitialDelay(0);
    if (!timer.isRunning()) {
      startTime = -1;
      timer.start();
    }
  }

  /**
   * Getter untuk data member timer.
   * I.S : -.
   * @return meengembalikan timer.
   */
  public Timer getTimer() {
    return timer;
  }

  /**
   * Setter untuk timer.
   * I.S : timer terdefinisi.
   * F.S : timer diganti.
   * @param timer timer yang akan di set.
   */
  public void setTimer(Timer timer) {
    this.timer = timer;
  }

  /**
   * Getter untuk mengambil durasi yang masih ada.
   * I.S : -.
   * @return durasi yang masih tersedia.
   */
  public long getDurasi() {
    return durasi - waktu;
  }

  /**
   * Method untuk menghentikan timer.
   * I.S : -.
   * F.S : timer dihentikan.
   */
  public void stop() {
    waktu = durasi;
    timer.stop();
  }
}
