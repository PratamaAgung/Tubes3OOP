package view;

import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nim_13515090 on 23/04/17.
 */
public class CreditView {
    private JPanel panel;
    private JTextArea credit;
    private JButton exit;
    //private JLabel label;

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
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(mainPanel, "one");
            }
        });
    }
}
