package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DollarDash extends JFrame{

    Container window;

    // Displays text, image, or both
    JLabel lab;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    Icon pic;

    int lifeTotal = 5;
    int speed = 1;

    public DollarDash() {
        window = getContentPane();

        //sets the window transparent
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));

        //size of window
        setSize(500,500);

        //window details
        pic = new ImageIcon("assets\\dollar.gif");
        lab = new JLabel(pic,JLabel.CENTER);
        lab.setFont(new Font("Monospaced", Font.BOLD, 55));
        lab.setHorizontalTextPosition(JLabel.CENTER);

        //add listener for mouse clicks
        lab.addMouseListener(new Mouse());

        //add label to container
        window.add(lab);

    }

    // Mouse Listener
    public class Mouse extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            lab.setText(lifeTotal-- +" ");
            speed +=2;
        }
    }


    public void run() throws Exception {

        //start location
        int y = 300;
        int x = 500;
        boolean yb = false;
        boolean xb = false;

        //loop for the steps
        while (lifeTotal >= 0) {
            Thread.sleep(10);
            setLocation(x,y);

            // direction
            if (y >= dim.getHeight() - 200) {
                yb = true;
            }else if (y <= -200) {
                yb = false;
            }

            if (x >= dim.getWidth() - 200) {
                xb = true;
            }else if(x <= -200) {
                xb = false;
            }

            if (yb) {
                y -= speed;
            } else {
                y += speed;
            }

            if (xb) {
                x -= speed;
            }else {
                x += speed;
            }


        }

        lab.setText(" ");
        lab.setIcon(new ImageIcon("assets\\splode.gif"));
        //wait for 1.8 seconds
        Thread.sleep(1800);
        System.exit(0);

    }

    //main
    public static void main(String[] args) {

        DollarDash frame = new DollarDash();
        frame.setVisible(true);

        try {
            frame.run();
        } catch (Exception e) {
        }

    }

}