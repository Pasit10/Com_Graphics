package src;

import javax.swing.*;
import java.awt.*;

public class GraphicsSwing extends JPanel{
    public void paintComponent(Graphics g){
        UtilityFunction.setGraphice(g);
    }
}
