package assignment2;

import javax.swing.*;
import assignment2.src.GraphicsSwing;

public class Main{
    public static void main(String[] args){
        JFrame f = new JFrame();
        GraphicsSwing gs = new GraphicsSwing();
        f.setSize(1000, 1000);
        f.setTitle("Assignment2");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.add(gs);
        Thread t = new Thread(gs);
        t.start();
    }
}