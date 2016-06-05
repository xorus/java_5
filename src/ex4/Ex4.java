package ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by xorus on 03/06/16.
 */
public class Ex4 extends JFrame {
    JPanel center;

    Point lastPoint = null;

    public Ex4() {
        super("Super dessin !");
        setSize(800, 600);

        JPanel center = new JPanel();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(center, BorderLayout.CENTER);

        center.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (lastPoint != null) {
                    center.getGraphics().drawLine(
                            lastPoint.x,
                            lastPoint.y,
                            e.getX(),
                            e.getY()
                    );
                }

                lastPoint = new Point(e.getX(), e.getY());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex4();
    }
}
