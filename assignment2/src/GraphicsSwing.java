package assignment2.src;

import javax.swing.*;
import java.awt.*;
import src.UtilityFunction;
import java.awt.geom.AffineTransform;

public class GraphicsSwing extends JPanel implements Runnable{
    //double MineMove1 = 

    boolean status1 = false;
    boolean status2 = false;
    boolean status3 = false;
    @Override public void run(){
        long lastTime = System.currentTimeMillis();
        long startTime = lastTime;
        while(true){
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastTime;

            if (currentTime>=500+startTime) {
                status1 = true;
            }if (currentTime>=1000+startTime) {
                status2 = true;
            }if (currentTime>=1500+startTime) {
                status3 = true;
            }

            //Update

            //Display
            repaint();

            lastTime = currentTime;
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        UtilityFunction.setupUtilityFunction(g);
        drawBaby(g2,5,270);
        // drawMine(g2, 170,20);
        if (status1) {
            drawsmallcircle(g2, 170, 20);
        }if (status2) {
            drawmidcircle(g2, 170, 20);
        }if (status3) {
            drawlargecircle(g2, 170, 20);
        }
    }

    public void drawBaby(Graphics2D g2,int x,int y){
        //head
        g2.drawOval(x,y,171,167);

        //body
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

        //แก้ม
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

        //mouth
        UtilityFunction.drawCurve(x + 95, y + 124 + 40, x + 105, y + 126 + 40, x + 107, y + 122 + 40, x + 106, y + 119 + 40, 1);

        //หู
        UtilityFunction.drawCurve(x + 7,y + 116 + 40,x ,y + 122 + 40, x + 4,y + 130 + 40,x + 15,y + 131 + 40,1);
        UtilityFunction.drawCurve(x + 170,y + 78 + 40,x + 180,y + 80 + 40,x + 178,y + 90 + 40,x + 171,y + 94 + 40,1);
    }

    public void drawsmallcircle(Graphics2D g2,int x,int y){
        g2.drawOval(x-20,y + 240,20,10);
    }

    public void drawmidcircle(Graphics2D g2,int x,int y){
        g2.drawOval(x,y + 200,40,20);
    }

    public void drawlargecircle(Graphics2D g2,int x,int y){
        g2.drawOval(x,y,350,220);
    }
}
