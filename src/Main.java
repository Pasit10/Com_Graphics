package src;
import javax.swing.*;

public class Main{
    public static void main(String[] args){
        JFrame mainframe = new JFrame();
        mainframe.add(new GraphicsSwing());
        mainframe.setSize(600,600);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setVisible(true);
    }
}