package ex3;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * Created by xorus on 03/06/16.
 */
public class Ex3 extends JFrame {
    JButton addBtn;
    JButton delBtn;
    JPanel center;
    List<JButton> buttons;

    public Ex3() {
        super("Ta face");
        setSize(300, 400);

        buttons = new ArrayList<>();

        addBtn = new JButton("+");
        delBtn = new JButton("-");

        JPanel south = new JPanel();
        south.add(delBtn);

        JPanel north = new JPanel();
        north.add(addBtn);

        JPanel center = new JPanel();
        center.setLayout(new FlowLayout());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(north, BorderLayout.NORTH);
        getContentPane().add(south, BorderLayout.SOUTH);
        getContentPane().add(center, BorderLayout.CENTER);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = new JButton("WOW!");
                btn.setBackground(Color.YELLOW);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (btn.getBackground().equals(Color.yellow)) {
                            btn.setBackground(Color.red);
                        } else {
                            btn.setBackground(Color.yellow);
                        }
                    }
                });

                buttons.add(btn);
                center.add(btn);
                revalidate();
                repaint();
            }
        });

        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListIterator<JButton> it = buttons.listIterator();
                while (it.hasNext()) {
                    JButton btn = it.next();
                    if (btn.getBackground().equals(Color.red)) {
                        center.remove(btn);
                        it.remove();
                    }
                }
                revalidate();
                repaint();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex3();
    }
}
