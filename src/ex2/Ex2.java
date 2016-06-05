package ex2;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

/**
 * Created by xorus on 03/06/16.
 */
public class Ex2 {
    public static void creerFenetres(Integer count) {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Appui à " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Relâchement à " + e.getX() + ", " + e.getY() + " "
                        + ((JFrame)e.getSource()).getTitle());
            }
        };


        Integer i;
        for (i = 0; i < count; i++) {
            JFrame frame = new JFrame(i.toString());
            frame.setSize(200, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.addMouseListener(adapter);
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nb fenêtres");
        Integer count = sc.nextInt();
        if (count > 20) {
            System.out.println("Haha, non.");
            return;
        }
        creerFenetres(count);
    }
}
