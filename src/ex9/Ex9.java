package ex9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by xorus on 03/06/16.
 */
public class Ex9 extends JFrame {
    JTextField inputField;
    JLabel resultat;

    JPanel center;
    Rectangle rect;

    private void drawFrame() {
        Graphics g = center.getGraphics();
        g.setColor(center.getBackground());
        g.drawRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
        rect.translate(1, 0);
        g.setColor(Color.red); // THUG LIFE MON CARRÉ EST ROUGE
        g.drawRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
    }

    public Ex9() {
        super("Coupe au carré");
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        center = new JPanel();
        rect = new Rectangle(0, 50, 20, 20);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(center, BorderLayout.CENTER);

        setVisible(true);

        while (rect.getX() < getWidth()) {
            drawFrame();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        setVisible(false);
        dispose();
    }

    public static void main(String[] args) {
        new Ex9();
    }
}
