import javax.swing.*;

import src.GraphicsSwing;

public class Main{
    public static void main(String[] args){
        JFrame mainframe = new JFrame();
        mainframe.setSize(600,600);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setVisible(true);
        mainframe.add(new GraphicsSwing());
    }
}