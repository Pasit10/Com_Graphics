package assignment2.src;

import javax.swing.*;
import java.awt.*;
import src.UtilityFunction;
import java.awt.geom.AffineTransform;

public class GraphicsSwing extends JPanel implements Runnable{
    boolean status1 = false;
    boolean status2 = false;
    boolean status3 = false;

    double babyX = 5,babyY = 270;

    double smallcircleX = 170, smallcircleY = 20;

    double midcircleX = 170, midcircleY = 20;

    double circleX = 170;
    double circleY = 20;
    double circleHeight = 220;
    double circleWidth = 350;

    @Override public void run(){
        long lastTime = System.currentTimeMillis();
        long startTime = lastTime;
        // while(true){
        //     long currentTime = System.currentTimeMillis();
        //     long elapsedTime = currentTime - lastTime;

        //     //Update
        //     if (currentTime>=500+startTime) {
        //         status1 = true;
        //     }if (currentTime>=1000+startTime) {
        //         status2 = true;
        //     }if (currentTime>=1500+startTime) {
        //         status3 = true;
        //     }
        //     // ขยายฝัน
        //     double speed = elapsedTime / 1000.0;
        //     if((circleX > -200 || circleY > -100) && status3){
        //         circleWidth += 300 * speed;
        //         circleHeight += 300 * speed;
        //         circleX -= 180 * speed;
        //         circleY -= 100 * speed;
        //         System.out.println(circleX + " " + circleY + " this circle");
        //     }
        //     //ขยับเด็ก
        //     if(status3 && midcircleY < getHeight()){
        //         babyY += 230 * speed;
        //         smallcircleY += 230 * speed;
        //         midcircleY += 230 * speed;
        //         System.out.println(babyY + " " + smallcircleY + " " + midcircleY);
        //     }
        //     //ความฝันที่อยากเป็น
        //     //Display
        //     repaint();

        //     lastTime = currentTime;
        // }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        //clear background
        // g2.setColor(Color.WHITE);
        // g2.fillRect(0,0,getWidth(),getHeight());

        UtilityFunction.setupUtilityFunction(g);
        // drawBaby(g2,(int)babyX,(int)babyY);
        // // drawMine(g2, 170,20);
        // if (status1) {
        //     drawsmallcircle(g2, (int)smallcircleX, (int)smallcircleY);
        // }if (status2) {
        //     drawmidcircle(g2, (int)midcircleX, (int)midcircleY);
        // }if (status3) {
        //     drawlargecircle(g2,(int) circleX, (int)circleY, (int)circleWidth, (int)circleHeight);
        // }

        drawDreamDoctor(g2, 10,100);
    }

    public void drawBaby(Graphics2D g2,int x,int y){
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

        //head
        g2.drawOval(x,y,171,167);

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

    public void drawlargecircle(Graphics2D g2,int x,int y,int width,int height){
        g2.drawOval(x,y,width,height);
    }

    public void drawDreamDoctor(Graphics2D g2,int x,int y){
        //head
        UtilityFunction.drawCurve(x + 119,y + 41 + 40,x + 106,y + 26 + 40,x + 108,y + 7 + 40,x + 124,y + 1 + 40,1);
        g2.drawLine(x + 119,y + 41,x + 125,y + 41);
        g2.drawLine(x + 125,y + 41,x + 133,y + 78);
        UtilityFunction.drawCurve(x + 120,y + 41 + 40,x + 116,y +45 + 40,x + 116,y + 51 + 40,x + 131,y + 65 + 40,1);
        UtilityFunction.drawCurve(x + 133,y + 78 + 40,x + 151,y + 110 + 40,x + 167,y + 107 + 40,x + 197,y + 69 + 40,1);
        g2.drawLine(x + 197,y + 69,x + 200,y + 38);
        UtilityFunction.drawCurve(x + 200,y + 38 + 40,x + 194,y + 35 + 40,x + 192,y + 28 + 40,x + 192,y + 21 + 40,1);
        UtilityFunction.drawCurve(x + 192,y + 21 + 40,x + 181,y + 14 + 40,x + 179,y + 7 + 40,x + 179,y + 1 + 40,1);
        UtilityFunction.drawCurve(x + 200,y + 38 + 40,x + 202,y + 33 + 40,x + 208,y + 33 + 40,x + 210,y + 38 + 40,1);
        g2.drawLine(x + 210,y + 38,x + 210,y + 50);
        UtilityFunction.drawCurve(x + 210,y + 50 + 40,x + 209,y + 60 + 40,x + 205,y + 65 + 40,x + 197,y + 66 + 40,1);
        UtilityFunction.drawCurve(x + 210,y + 44 + 40,x + 224,y + 27 + 40,x + 224,y + 20 + 40,x + 205,y + 1 + 40,1);
        UtilityFunction.drawCurve(x + 124,y + 1 + 40,x + 128,y - 20 + 40,x + 190,y - 20 + 40,x + 205,y + 1 + 40,1);
        g2.drawLine(x + 125,y + 41,x + 125,y + 34);
        g2.drawLine(x + 125,y + 34,x + 130,y + 29);
        g2.drawLine(x + 130,y + 29,x + 130,y + 20);
        g2.drawLine(x + 130,y + 20,x + 132,y + 18);
        g2.drawLine(x + 132,y + 18,x + 132,y + 11);
        UtilityFunction.drawCurve(x + 132,y + 11 + 40,x + 169,y + 11 + 40,x + 176,y + 7 + 40,x + 179,y + 1 + 40,1);

        // left eye
        UtilityFunction.drawCurve(x + 132,y + 33 + 40,x + 139,y + 28 + 40,x + 144,y + 28 + 40,x + 149,y + 32 + 40,1);
        UtilityFunction.drawCurve(x + 133,y + 41 + 40,x + 140,y + 35 + 40,x + 144,y + 35 + 40,x + 150,y + 39 + 40,1);
        UtilityFunction.drawCurve(x + 141,y + 37 + 40,x + 139,y + 49 + 40,x + 146,y + 57 + 40,x + 146,y + 37 + 40,1);
        // right eye
        UtilityFunction.drawCurve(x + 171,y + 32 + 40,x + 176,y + 27 + 40,x + 180,y + 27 + 40,x + 188,y + 32 + 40,1);
        UtilityFunction.drawCurve(x + 173,y + 39 + 40,x + 178,y + 34 + 40,x + 184,y + 34 + 40,x + 189,y + 39 + 40,1);
        UtilityFunction.drawCurve(x + 177,y + 36 + 40,x + 179,y + 53 + 40,x + 183,y + 53 + 40,x + 184,y + 36 + 40,1);

        // mouse
        UtilityFunction.drawCurve(x + 149,y + 76 + 40,x + 156,y + 81 + 40,x + 161,y + 81 + 40,x + 174,y + 73 + 40,1);

        // nose 
        g2.drawLine(x + 158,y + 40,x + 158,y + 51);
        UtilityFunction.drawCurve(x + 158,y + 51 + 40,x + 154,y + 56 + 40,x + 154,y + 59 + 40,x + 159,y + 62 + 40,1);
    }
}
