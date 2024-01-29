package assignment2;

import javax.swing.*;
import src.GraphicsSwing;
import java.awt.*;

public class Main{
    public static void main(String[] args){
        JFrame f = new JFrame();
        GraphicsSwing gs = new GraphicsSwing();
        f.setSize(600, 600);
        f.setTitle("Assignment2");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.add(gs);
        Thread t = new Thread(gs);
        t.start();
    }
}