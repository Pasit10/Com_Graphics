package src;

import javax.swing.*;
import java.awt.*;

public class GraphicsSwing extends JPanel{
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        for(int i = 0;i < 300;i++){
            g.drawLine(i,0,i,600);
        }
    }
}
