package assignment2.src;

import javax.swing.*;
import java.awt.*;
import src.UtilityFunction;
import java.awt.geom.AffineTransform;

public class GraphicsSwing extends JPanel implements Runnable{
    @Override public void run(){
        while(true){

        }
    }

    public void paintComponent(Graphics g) {
        UtilityFunction.setupUtilityFunction(g);
        drawBaby(g,0,0);
    }

    public void drawBaby(Graphics g,int x,int y){
        Graphics2D g2 = (Graphics2D)g;
        g2.drawOval(x,y,171,167);

        UtilityFunction.drawCurve(x + 30,y + 146 + 40,x + 43,y + 356 + 40,x + 277,y + 321 + 40,x + 164,y + 113 + 40,1);

        g2.drawLine(x + 34,y + 180,x + 54,y + 162);
        g2.drawLine(x + 119,y + 161,x + 184,y + 158);
        g2.drawLine(x + 61,y + 243,x + 160,y + 160);
        g2.drawLine(x + 83,y + 225,x + 186,y + 250);
        g2.drawLine(x + 132,y + 237,x + 95,y + 277);
        g2.drawOval(x + 60,y + 94,20,20);
        g2.drawOval(x + 70,y + 98,4,4);
        g2.drawOval(x + 110,y + 82,20,20);
        g2.drawOval(x + 120,y + 86,4,4);

        // Rotate ovals by -20 degrees
        AffineTransform originalTransform = g2.getTransform(); // Save the original transform

        double rotationAngle = Math.toRadians(-15); // Convert degrees to radians
        AffineTransform rotationTransform = AffineTransform.getRotateInstance(rotationAngle, x, y);
        g2.setTransform(rotationTransform);
        // Draw rotated ovals
        g2.drawOval(x + 24, y + 135, 13, 6);
        g2.drawOval(x + 94, y + 136, 13, 6);

        // Restore the original transform
        g2.setTransform(originalTransform);

        UtilityFunction.drawCurve(x + 95, y + 124 + 40, x + 105, y + 126 + 40, x + 107, y + 122 + 40, x + 106, y + 119 + 40, 1);
    }
}
