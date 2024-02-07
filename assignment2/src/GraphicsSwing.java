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
        UtilityFunction.drawCurve(x + 141,y + 37 + 40,x + 137,y + 49 + 40,x + 149,y + 57 + 40,x + 146,y + 37 + 40,1);
        // right eye
        UtilityFunction.drawCurve(x + 171,y + 32 + 40,x + 176,y + 27 + 40,x + 180,y + 27 + 40,x + 188,y + 32 + 40,1);
        UtilityFunction.drawCurve(x + 173,y + 39 + 40,x + 178,y + 34 + 40,x + 184,y + 34 + 40,x + 189,y + 39 + 40,1);
        UtilityFunction.drawCurve(x + 177,y + 36 + 40,x + 177,y + 53 + 40,x + 184,y + 53 + 40,x + 184,y + 36 + 40,1);

        // mouse
        UtilityFunction.drawCurve(x + 149,y + 76 + 40,x + 156,y + 81 + 40,x + 161,y + 81 + 40,x + 174,y + 73 + 40,1);

        // nose 
        g2.drawLine(x + 158,y + 40,x + 158,y + 51);
        UtilityFunction.drawCurve(x + 158,y + 51 + 40,x + 154,y + 56 + 40,x + 154,y + 59 + 40,x + 159,y + 62 + 40,1);

        // neck
        g2.drawLine(x + 140,y + 88,x + 140,y + 107);
        g2.drawLine(x + 197,y + 69,x + 197,y + 100);

        //body part1
        g2.drawLine(x + 140,y + 107,x + 157,y + 125);
        g2.drawLine(x + 159,y + 126,x + 197,y + 100);

        UtilityFunction.drawCurve(x + 140,y + 102 + 40,x + 131,y + 117 + 40,x + 131,y + 133 + 40,x + 145,y + 189 + 40,1);
        UtilityFunction.drawCurve(x + 197,y + 94 + 40,x + 214,y + 97 + 40,x + 214,y + 112 + 40,x + 145,y + 189 + 40,1);
        g2.drawLine(x + 157,y + 125,x + 136,y + 143);
        g2.drawLine(x + 159,y + 126,x + 177,y + 151);

        // necktie
        g2.drawLine(x + 142,y + 138,x + 147,y + 154);
        g2.drawLine(x + 147,y + 154,x + 161,y + 156);
        g2.drawLine(x + 161,y + 156,x + 172,y + 145);

        g2.drawLine(x + 164,y + 132,x + 145,y + 142);
        g2.drawLine(x + 145,y + 145,x + 166,y + 135);
        g2.drawLine(x + 167,y + 138,x + 147,y + 149);
        g2.drawLine(x + 147,y + 152,x + 170,y + 141);

        g2.drawLine(x + 149,y + 154,x + 139,y + 165);
        g2.drawLine(x + 160,y + 156,x + 162,y + 168);

        g2.drawLine(x + 158,y + 156,x + 140,y + 167);
        g2.drawLine(x + 161,y + 160,x + 141,y + 170);
        g2.drawLine(x + 162,y + 164,x + 143,y + 177);
        g2.drawLine(x + 162,y + 168,x + 144,y + 179);

        //body part2
        g2.drawLine(x + 145,y + 189,x + 140,y + 202);
        g2.drawLine(x + 140,y + 202,x + 140,y + 223);
        g2.drawOval(x + 134,y + 190,6,6);

        // Unknonw
        UtilityFunction.drawCurve(x + 197,y + 90 + 40,x + 223,y + 90 + 40,x + 223,y + 115 + 40,x + 206,y + 138 + 40,1);
        UtilityFunction.drawCurve(x + 197,y + 86 + 40,x + 230,y + 90 + 40,x + 221,y + 117 + 40,x + 211,y + 137 + 40,1);
        UtilityFunction.drawCurve(x + 211,y + 137 + 40,x + 219,y + 150 + 40,x + 220,y + 163 + 40,x + 212,y + 197 + 40,1);
        UtilityFunction.drawCurve(x + 212,y + 197 + 40,x + 210,y + 211 + 40,x + 205,y + 215 + 40,x + 196,y + 217 + 40,1);
        UtilityFunction.drawCurve(x + 196,y + 217 + 40,x + 189,y + 223 + 40,x + 189,y + 206 + 40,x + 195,y + 214 + 40,1);
        UtilityFunction.drawCurve(x + 195,y + 214 + 40,x + 208,y + 208 + 40,x + 205,y + 204 + 40,x + 209,y + 196 + 40,1);
        UtilityFunction.drawCurve(x + 209,y + 196 + 40,x + 214,y + 156 + 40,x + 214,y + 148 + 40,x + 210,y + 143 + 40,1);
        UtilityFunction.drawCurve(x + 210,y + 143 + 40,x + 191,y + 156 + 40,x + 186,y + 176 + 40,x + 184,y + 203 + 40,1);
        g2.drawLine(x + 184,y + 203,x + 184,y + 220);
        UtilityFunction.drawCurve(x + 206,y + 138 + 40,x + 191,y + 153 + 40,x + 182,y + 178 + 40,x + 181,y + 218 + 40,1);
        UtilityFunction.drawCurve(x + 181,y + 218 + 40,x + 183,y + 227 + 40,x + 190,y + 227 + 40,x + 191,y + 221 + 40,1);
        UtilityFunction.drawCurve(x + 191,y + 221 + 40,x + 189,y + 217 + 40,x + 187,y + 217 + 40,x + 184,y + 220 + 40,1);

        UtilityFunction.drawCurve(x + 140,y + 97 + 40,x + 124,y + 104 + 40,x + 114,y + 110 + 40,x + 115,y + 169 + 40,1);
        UtilityFunction.drawCurve(x + 140,y + 94 + 40,x + 119,y + 98 + 40,x + 113,y + 113 + 40,x + 108,y + 169 + 40,1);
        g2.drawOval(x + 106,y + 168, 10, 10);
        g2.drawOval(x + 109,y + 171,4,4);

        //body part3
        g2.drawLine(x + 148,y + 187,x + 191,y + 164);
        g2.drawLine(x + 205,y + 96,x + 216,y + 100);
        UtilityFunction.drawCurve(x + 140,y + 101 + 40,x + 136,y + 102 + 40,x + 135,y + 104 + 40,x + 133,y + 108 + 40,1);
        g2.drawLine(x + 118,y + 142,x + 133,y + 108);
        g2.drawLine(x + 118,y + 142,x + 123,y + 142);
        g2.drawLine(x + 123,y + 142,x + 119,y + 154);
        g2.drawLine(x + 119,y + 154,x + 145,y + 189);
        UtilityFunction.drawCurve(x + 219,y + 103 + 40,x + 290,y + 172 + 40,x + 280,y + 200 + 40,x + 243,y + 285 + 40 ,1);
        UtilityFunction.drawCurve(x + 218,y + 195 + 40,x + 215,y + 221 + 40,x + 207,y + 230 + 40,x + 195,y + 236 + 40,1);
        UtilityFunction.drawCurve(x + 206,y + 248 + 40,x + 203,y + 234 + 40,x + 193,y + 231 + 40,x + 98,y + 223 + 40,1);
        UtilityFunction.drawCurve(x + 98,y + 223 + 40,x + 90,y + 225 + 40,x + 77,y + 236 + 40,x + 74,y + 249 + 40,1);
        UtilityFunction.drawCurve(x + 74,y + 249 + 40,x + 80,y + 278 + 40,x + 85,y + 283 + 40,x + 91,y + 281 + 40,1);
        UtilityFunction.drawCurve(x + 91,y + 281 + 40,x + 131,y + 288 + 40,x + 110,y + 282 + 40,x + 144,y + 300 + 40,1);
        g2.drawLine(x + 144,y + 300,x + 225,y + 300);
        g2.drawLine(x + 225,y + 300,x + 243,y + 285);
        g2.drawLine(x + 243,y + 285,x + 243,y + 300);
        UtilityFunction.drawCurve(x + 140,y + 101 + 40,x + 131,y + 103 + 40,x + 127,y + 112 + 40,x + 123,y + 113 + 40,1);
        UtilityFunction.drawCurve(x + 114,y + 118 + 40,x + 108,y + 123 + 40,x + 98,y + 128 + 40,x + 85,y + 129 + 40,1);
        UtilityFunction.drawCurve(x + 85,y + 129 + 40,x + 65,y + 133 + 40,x + 55,y + 150 + 40,x + 49,y + 181 + 40,1);
        UtilityFunction.drawCurve(x + 49,y + 181 + 40,x + 39,y + 208 + 40,x + 30,y + 215 + 40,x + 27,y + 235 + 40,1);
        g2.drawLine(x + 27,y + 236,x + 27,y + 268);
        UtilityFunction.drawCurve(x + 27,y + 268 + 40,x + 30,y + 283 + 40,x + 35,y + 285 + 40,x + 94,y + 293 + 40,1);
        g2.drawLine(x + 94,y + 293,x + 132,y + 293);
        g2.drawLine(x + 76,y + 139,x + 83,y + 199);
        g2.drawLine(x + 65,y + 161,x + 83,y + 199);
        g2.drawLine(x + 83,y + 199,x + 83,y + 231);
        UtilityFunction.drawCurve(x + 85,y + 231 + 40,x + 65,y + 238 + 40,x + 65,y + 244 + 40,x + 74,y + 249 + 40,1);
        UtilityFunction.drawCurve(x + 138,y + 242 + 40,x + 137,y + 258 + 40,x + 143,y + 271 + 40,x + 152,y + 279 + 40,1);
        UtilityFunction.drawCurve(x + 145,y + 254 + 40,x + 146,y + 259 + 40,x + 149,y + 263 + 40,x + 153,y + 264 + 40,1);
    }
}
