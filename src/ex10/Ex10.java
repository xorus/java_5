package ex10;

import com.sun.javafx.font.directwrite.RECT;
import com.sun.javafx.geom.*;
import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by xorus on 03/06/16.
 */
public class Ex10 extends JFrame {
    JTextField inputField;
    JLabel resultat;

    JPanel center;
    Rectangle rect;
    Color rectColor = Color.red;

    /* Reprendre l’exercice précédent en modifiant le tracé du carré : au lieu de la faire évoluer
horizontalement, faites le prendre une direction aléatoire à chaque itérations. On se limitera à 8
directions (N, NE, E, SE, S, SO, O, NO). On pourra utiliser la fonction Maths.random() qui renvoie un
double entre 0 (compris) et 1 (exclu). A chaque itération, ne pourront être choisies que des directions
qui gardent le carré visible dans la fenêtre. */
    Random random = new Random();

    enum Direction {
        N(0, -1), E(1, 0), S(0, 1), O(1, 0), NE(-1, -1), SE(-1, 1), SO(1, 1), NO(1, -1);

        public final int dx;
        public final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public static Direction randomDirection(Random random) {
            Direction values[] = Direction.values();
            return values[random.nextInt(values.length)];
        }
    }

    Direction direction;

    private void drawFrame() {
        Graphics g = center.getGraphics();
        g.setColor(center.getBackground());
        g.drawRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
        rect.translate(direction.dx, direction.dy);
        g.setColor(rectColor);
        g.drawRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
    }

    public Ex10() {
        super("Coupe au carré");
        random = new Random();
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        center = new JPanel();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(center, BorderLayout.CENTER);

        setVisible(true);

        rect = new Rectangle(center.getWidth() / 2 - 10, center.getHeight() / 2 - 10, 20, 20);

        Rectangle nextPosition;
        while (true) {
            do {
                direction = Direction.randomDirection(random);
                nextPosition = (Rectangle) rect.clone();
                nextPosition.translate(direction.dx, direction.dy);
            } while (nextPosition.getX() < 0 || nextPosition.getX() > center.getWidth()
                    || nextPosition.getY() < 0 || nextPosition.getY() > center.getHeight());

            // change the hue of the color for rainbow purposes
            float[] hsb = new float[3];
            Color.RGBtoHSB(rectColor.getRed(), rectColor.getGreen(), rectColor.getBlue(), hsb);
            rectColor = new Color(Color.HSBtoRGB(hsb[0] + 0.01f, hsb[1], hsb[2]));

            drawFrame();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        setVisible(false);
//        dispose();
    }

    public static void main(String[] args) {
        new Ex10();
    }
}
