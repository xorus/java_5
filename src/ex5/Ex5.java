package ex5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by xorus on 03/06/16.
 */
public class Ex5 extends JFrame {
    JButton lineBtn;
    JButton eraseBtn;
    JButton colorBtn;
    JPanel center;

    Color colors[] = {Color.black, Color.red, Color.yellow, Color.blue, Color.magenta, Color.orange};
    Integer currentColor = 0;
    Point lastPoint = null;

    public Ex5() {
        super("Ardoise");
        setSize(800, 600);

        colorBtn = new JButton();
        lineBtn = new JButton("Nouvelle ligne");
        eraseBtn = new JButton("Effacer");

        JPanel south = new JPanel();
        south.add(colorBtn);
        south.add(lineBtn);
        south.add(eraseBtn);

        JPanel center = new JPanel();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(center, BorderLayout.CENTER);
        getContentPane().add(south, BorderLayout.SOUTH);

        colorBtn.setBackground(colors[currentColor]);

        center.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                Graphics g = center.getGraphics();
                g.setColor(colors[currentColor]);

                if (lastPoint != null) {
                    g.drawLine(
                            lastPoint.x,
                            lastPoint.y,
                            e.getX(),
                            e.getY()
                    );
                }

                lastPoint = new Point(e.getX(), e.getY());
            }
        });

        lineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastPoint = null;
            }
        });

        colorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor++;
                if (currentColor >= colors.length) {
                    currentColor = 0;
                }
                colorBtn.setBackground(colors[currentColor]);
            }
        });

        eraseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastPoint = null;
                center.getGraphics().clearRect(0, 0, center.getWidth(), center.getHeight());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex5();
    }
}
