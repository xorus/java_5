package ex6;

import sun.swing.SwingAccessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by xorus on 03/06/16.
 */
public class Ex6 extends JFrame {
    JTextField inputField;
    JLabel resultat;

    private void compute() {
        Integer input;
        try {
            input = Integer.parseInt(inputField.getText());
        } catch (NumberFormatException e) {
            resultat.setText("Écris un vrai nombre, conn*rd.");
            return;
        }

        resultat.setText("" + (input * input));
    }

    public Ex6() {
        super("Coupe au carré");
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        inputField = new JTextField();
        resultat = new JLabel();

        JPanel south = new JPanel();
        south.add(resultat);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputField, BorderLayout.CENTER);
        getContentPane().add(south, BorderLayout.SOUTH);

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compute();
            }
        });

        inputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                compute();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex6();
    }
}
