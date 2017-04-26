package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Kelas CreditView untuk menampilkan credit.
 * @author Pratamamia Agung.
 */
public class CreditView {
  private JPanel panel;
  private JTextArea credit;
  private JButton exit;

  /**
   * Constructor kelas CreditView.
   * I.S : setiap parameter terdefinisi.
   * F.S : kelas creditView diciptakan.
   * @param card cardLayout yang berlaku.
   * @param mainPanel panel utama.
   * @param panelCredit panel untuk menampilkan credit.
   */
  public CreditView(CardLayout card, JPanel mainPanel, JPanel panelCredit) {
    this.panel = panelCredit;
    credit = new JTextArea();
    credit.setBounds(150,100,500,300);
    credit.setFont(new Font("Courier New", Font.PLAIN, 20));
    credit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    credit.append("Game ini diciptakan oleh:\n");
    credit.append("13515090 - Annisa Muzdalifa\n");
    credit.append("13515114 - Ifttitakhul Zakiah\n");
    credit.append("13515139 - Jehian Norman Saviero\n");
    credit.append("13515142 - Pratamamia Agung Prihatmaja\n");
    credit.setEditable(false);
    credit.enableInputMethods(false);

    panel.add(credit);
    exit = new JButton("Back to Menu");
    exit.setBounds(250,650, 300,30);
    panel.add(exit);
    exit.addActionListener(new ActionListener() {
      /**
       * Method untuk menjalankan listener button exit.
       * I.S : event terdefinisi(mouse click).
       * F.S : kembali ke main panel.
       * @param event event yang diterima oleh button exit.
       */
      @Override
      public void actionPerformed(ActionEvent event) {
        card.show(mainPanel, "one");
      }
    });
  }
}
