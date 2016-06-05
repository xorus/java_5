package ex1;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by xorus on 03/06/16.
 */
public class Ex1v2 extends JFrame {
    public Ex1v2() {
        super("Fenêtre de fou");
        setSize(800, 600);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Appui à " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Relâchement à " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex1();
    }
}
