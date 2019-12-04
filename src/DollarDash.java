package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * DollarDash is a game that tests user agility
 * @author Louis
 */
public class DollarDash extends JFrame{

    // Our Container object window
    Container window;

    // Window parameters
    JLabel lab;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    Icon pic;

    // The amount of clicks and speed of a dollar
    int dollarHP = 5;
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
        /**
         * Method of MouseAdapter
         * @param e event parameter
         */
        public void mousePressed(MouseEvent e) {
            lab.setText(dollarHP-- +" ");
            speed +=2;
        }
    }

    /**
     * Run handles the game loop
     * @throws Exception
     */
    public void run() throws Exception {

        //start location
        int y = 300;
        int x = 500;
        boolean yb = false;
        boolean xb = false;

        //changes the location of the dollar while it has more than 0 HP
        while (dollarHP >= 0) {
            Thread.sleep(10);
            setLocation(x,y);

            // sets the dollar in motion on the condition of how close it is to the screen's bounds
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

        // changes the animation if the user succeeds
        lab.setText(" ");
        lab.setIcon(new ImageIcon("assets\\splode.gif"));

        //holds the splode animation for 1.8 seconds
        Thread.sleep(1800);
        System.exit(0);

    }

    public static void main(String[] args) {

        DollarDash frame = new DollarDash();
        frame.setVisible(true);

        try {
            frame.run();
        } catch (Exception e) {
        }

    }

}