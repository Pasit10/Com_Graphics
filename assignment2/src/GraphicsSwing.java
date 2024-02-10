package assignment2.src;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class GraphicsSwing extends JPanel implements Runnable{
    BufferedImage buffer = new BufferedImage(2000,2000,BufferedImage.TYPE_INT_ARGB);

    boolean statusSing = false;
    boolean statusTee = false;
    boolean statusKid = false;
    boolean statusPen = false;

    boolean status1 = false;
    boolean status2 = false;
    boolean status3 = false;
    boolean statusEye = false;

    boolean startbaby = false;
    boolean startdoctor = false;

    boolean statusI = false;
    boolean statusWant = false;
    boolean statusTo = false;
    boolean statusBe = false;
    boolean statusA = false;
    boolean statusDoctor = false;

    double babyX = 5,babyY = 270;

    double smallcircleX = 170, smallcircleY = 20;

    double midcircleX = 170, midcircleY = 20;

    double circleX = 170;
    double circleY = 20;
    double circleHeight = 220;
    double circleWidth = 350;

    @Override public void run(){
        // long lastTime = System.currentTimeMillis();
        // long startTime = lastTime;
        // while(true){
        //     long currentTime = System.currentTimeMillis();
        //     long elapsedTime = currentTime - lastTime;

        //     // //Update
        //     if (currentTime >= 500 + startTime && currentTime <= 2000 + startTime) {
        //         statusSing = true;
        //     }if (currentTime >= 1000 + startTime && currentTime <= 2000 + startTime) {
        //         statusTee = true;
        //     }if (currentTime >= 1500 + startTime && currentTime <= 2000 + startTime) {
        //         statusKid = true;
        //     }if (currentTime == 2000 + startTime) {
        //         statusSing = false;
        //         statusTee = false;
        //         statusKid = false;
        //         startbaby = true;
        //     }
        //     if (currentTime>=2500+startTime) {
        //         status1 = true;
        //     }if (currentTime>=3000+startTime) {
        //         status2 = true;
        //     }if (currentTime>=3500+startTime) {
        //         status3 = true;
        //     }if ((currentTime-startTime)%300 == 0 ) {
        //         statusEye = (statusEye) ? false : true;
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
        //     //หมอ
        //     if (currentTime >=6000+startTime && currentTime <= 9000 + startTime) {
        //         startdoctor = true; 
        //         statusI = true;
        //     }if (currentTime >=6500+startTime && currentTime <= 9000 + startTime) {
        //         statusWant = true;
        //     }if (currentTime >=7000+startTime && currentTime <= 9000 + startTime) {
        //         statusTo = true;
        //     }if (currentTime >=7500+startTime && currentTime <= 9000 + startTime) {
        //         statusBe = true;
        //     }if (currentTime >=8000+startTime && currentTime <= 9000 + startTime) {
        //         statusA = true;
        //     }if (currentTime >=8500+startTime && currentTime <= 9000 + startTime) {
        //         statusDoctor = true;
        //     }
        //     // ความฝันที่อยากเป็น
        //     if (currentTime >=9000+startTime) {
        //         status3 = false;
        //         startdoctor = false;
        //         statusSing = true;
        //     }if (currentTime >=9500+startTime) {
        //         statusTee = true;
        //     }if (currentTime >=10000+startTime) {
        //         statusPen = true;
        //     }
        //     // Display
        //     repaint();

        //     lastTime = currentTime;
        // }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = buffer.createGraphics();
        //clear background
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,getWidth(),getHeight());

        UtilityFunction.setupUtilityFunction(g2);
        // if (startbaby) {
        //     drawBaby(g2,(int)babyX,(int)babyY);
        //     if (status1) {
        //         drawsmallcircle(g2, (int)smallcircleX, (int)smallcircleY);
        //     }if (status2) {
        //         drawmidcircle(g2, (int)midcircleX, (int)midcircleY);
        //     }if (status3) {
        //         drawlargecircle(g2,(int) circleX, (int)circleY, (int)circleWidth, (int)circleHeight);
        //     }if(statusEye){
        //         drawOpenEyeBaby(g2,(int)babyX,(int)babyY);
        //     }if (!statusEye) {
        //         drawCloseEyeBaby(g2,(int)babyX,(int)babyY);
        //     }
        // }if (startdoctor) {
        //     drawIWannaBeADoctor(g2, 10, 130);
        // }
        // drawSingTeeKid(g2, 255,100);
        // drawSingTeePen(g2, 255, 100);
    
        // drawWin(g2,100,100);

        // drawCloud(g2, 100,100);
        // drawBird(g2, 300,300);
        drawMotorcycle(g2, 100,100);
        g.drawImage(buffer, 0,0,null);
    }

    public void drawSingTeeKid(Graphics2D g2,int x,int y){
        Font font = new Font("Arial", Font.BOLD, 48); // Font name, style, size
        UtilityFunction.drawLine(0,0,1,0,1,Color.BLACK);
        // Set the font
        g2.setFont(font);
        if(statusSing){
            g2.drawString("Sing", x, y);
        }
        if(statusTee){
            g2.drawString("Tee", x, y + 200);
        }
        if(statusKid){
            g2.drawString("Kid", x, y + 400);
        }

    }

    public void drawSingTeePen(Graphics2D g2,int x,int y){
        Font font = new Font("Arial", Font.BOLD, 48); // Font name, style, size
        UtilityFunction.drawLine(0,0,1,0,1,Color.BLACK);
        // Set the font
        g2.setFont(font);
        if(statusSing){
            g2.drawString("Sing", x, y);
        }
        if(statusTee){
            g2.drawString("Tee", x, y + 200);
        }
        if(statusPen){
            g2.drawString("Pen", x, y + 400);
        }

    }

    public void drawIWannaBeADoctor(Graphics2D g2,int x,int y){
        Font font = new Font("Arial", Font.BOLD, 36); // Font name, style, size
        UtilityFunction.drawLine(0,0,1,0,1,Color.BLACK);
        // Set the font
        g2.setFont(font);
        if(statusI) {
            g2.drawString(" I", x, y);
        }if(statusWant){
            g2.drawString(" Want", x, y+50);
        }if (statusTo) { 
            g2.drawString(" To", x, y+100);
        }if (statusBe) {
            g2.drawString(" Be", x, y+150);
        }if (statusA) {
            g2.drawString(" A", x, y+200);
        }if (statusDoctor) {
            g2.drawString(" Doctor", x, y+250);
        }
        drawScaledDreamDoctor(g2, 100, 100, 2, 2);
    }

    public void drawBaby(Graphics2D g2,int x,int y){
        //body
        UtilityFunction.drawCurve(x + 30,y + 146,x + 43,y + 356,x + 277,y + 321,x + 164,y + 113,1);
        UtilityFunction.drawLine(x + 34,y + 180,x + 54,y + 162);
        UtilityFunction.drawLine(x + 119,y + 161,x + 184,y + 158);
        UtilityFunction.drawLine(x + 61,y + 243,x + 160,y + 160);
        UtilityFunction.drawLine(x + 83,y + 225,x + 186,y + 250);
        UtilityFunction.drawLine(x + 132,y + 237,x + 95,y + 277);

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
        UtilityFunction.drawCurve(x + 95, y + 124, x + 105, y + 126, x + 107, y + 122, x + 106, y + 119, 1);

        //หู
        UtilityFunction.drawCurve(x + 7,y + 116,x ,y + 122, x + 4,y + 130,x + 15,y + 131,1);
        UtilityFunction.drawCurve(x + 170,y + 78,x + 180,y + 80,x + 178,y + 90,x + 171,y + 94,1);

        //ลงสีหน้า
        buffer = UtilityFunction.Floodfill(buffer ,x + 30,y + 30,Color.WHITE,new Color(0xfddac6));

        //ลงสีผ้าอ้อม
        buffer = UtilityFunction.Floodfill(buffer ,x + 35,y + 180,Color.WHITE,new Color(0x9ecfed));
        buffer = UtilityFunction.Floodfill(buffer ,x + 160,y + 150,Color.WHITE,new Color(0x9ecfed));
        buffer = UtilityFunction.Floodfill(buffer ,x + 100,y + 250,Color.WHITE,new Color(0x9ecfed));

        //ลงสีแก้ม
        buffer = UtilityFunction.Floodfill(buffer ,x + 65,y + 125,Color.WHITE,new Color(0xf6a5b6));
        buffer = UtilityFunction.Floodfill(buffer ,x + 135,y + 105,Color.WHITE,new Color(0xf6a5b6));

        //ลงสีหู
        buffer = UtilityFunction.Floodfill(buffer ,x + 5,y + 120,Color.WHITE,new Color(0xfddac6));
        buffer = UtilityFunction.Floodfill(buffer ,x + 173,y + 80,Color.WHITE,new Color(0xfddac6));
    }
    
    public void drawOpenEyeBaby(Graphics2D g2,int x,int y){
        g2.drawOval(x + 60,y + 94,20,20);
        g2.drawOval(x + 70,y + 98,6,6);
        g2.drawOval(x + 110,y + 82,20,20);
        g2.drawOval(x + 120,y + 86,6,6);
        buffer = UtilityFunction.Floodfill(buffer ,x + 65,y + 105,new Color(0xfddac6),new Color(0x3a3a3a));
        buffer = UtilityFunction.Floodfill(buffer ,x + 125,y + 85,new Color(0xfddac6),new Color(0x3a3a3a));
    }

    public void drawCloseEyeBaby(Graphics2D g2,int x,int y){
        UtilityFunction.drawCurve(x + 135, y + 80, x + 145, y + 84, x + 115, y + 94, x + 105, y + 90, 1);
        UtilityFunction.drawCurve(x + 85, y + 95, x + 95, y + 99, x + 65, y + 109, x + 55, y + 105, 1);
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
        UtilityFunction.drawCurve(x + 119,y + 41,x + 106,y + 26,x + 108,y + 7,x + 124,y + 1,1);
        UtilityFunction.drawLine(x + 119,y + 41,x + 125,y + 41);
        UtilityFunction.drawLine(x + 125,y + 41,x + 133,y + 78);
        UtilityFunction.drawCurve(x + 120,y + 41,x + 116,y +45,x + 116,y + 51,x + 131,y + 65,1);
        UtilityFunction.drawCurve(x + 133,y + 78,x + 151,y + 110,x + 167,y + 107,x + 197,y + 69,1);
        UtilityFunction.drawLine(x + 197,y + 69,x + 200,y + 38);
        UtilityFunction.drawCurve(x + 200,y + 38,x + 194,y + 35,x + 192,y + 28,x + 192,y + 21,1);
        UtilityFunction.drawCurve(x + 192,y + 21,x + 181,y + 14,x + 179,y + 7,x + 179,y + 1,1);
        UtilityFunction.drawCurve(x + 200,y + 38,x + 202,y + 33,x + 208,y + 33,x + 210,y + 38,1);
        UtilityFunction.drawLine(x + 210,y + 38,x + 210,y + 50);
        UtilityFunction.drawCurve(x + 210,y + 50,x + 209,y + 60,x + 205,y + 65,x + 197,y + 66,1);
        UtilityFunction.drawCurve(x + 210,y + 44,x + 224,y + 27,x + 224,y + 20,x + 205,y + 1,1);
        UtilityFunction.drawCurve(x + 124,y + 1,x + 128,y - 20,x + 190,y - 20,x + 205,y + 1,1);
        UtilityFunction.drawLine(x + 125,y + 41,x + 125,y + 34);
        UtilityFunction.drawLine(x + 125,y + 34,x + 130,y + 29);
        UtilityFunction.drawLine(x + 130,y + 29,x + 130,y + 20);
        UtilityFunction.drawLine(x + 130,y + 20,x + 132,y + 18);
        UtilityFunction.drawLine(x + 132,y + 18,x + 132,y + 11);
        UtilityFunction.drawCurve(x + 132,y + 11,x + 169,y + 11,x + 176,y + 7,x + 179,y + 1,1);

        // left eye
        UtilityFunction.drawCurve(x + 132,y + 33,x + 139,y + 28,x + 144,y + 28,x + 149,y + 32,1);
        UtilityFunction.drawCurve(x + 133,y + 41,x + 140,y + 35,x + 144,y + 35,x + 150,y + 39,1);
        UtilityFunction.drawCurve(x + 141,y + 37,x + 137,y + 49,x + 149,y + 57,x + 146,y + 37,1);
        // right eye
        UtilityFunction.drawCurve(x + 171,y + 32,x + 176,y + 27,x + 180,y + 27,x + 188,y + 32,1);
        UtilityFunction.drawCurve(x + 173,y + 39,x + 178,y + 34,x + 184,y + 34,x + 189,y + 39,1);
        UtilityFunction.drawCurve(x + 177,y + 36,x + 177,y + 53,x + 184,y + 53,x + 184,y + 36,1);

        // mouse
        UtilityFunction.drawCurve(x + 149,y + 76,x + 156,y + 81,x + 161,y + 81,x + 174,y + 73,1);

        // nose 
        UtilityFunction.drawLine(x + 158,y + 40,x + 158,y + 51);
        UtilityFunction.drawCurve(x + 158,y + 51,x + 154,y + 56,x + 154,y + 59,x + 159,y + 62,1);

        // neck
        UtilityFunction.drawLine(x + 140,y + 88,x + 140,y + 107);
        UtilityFunction.drawLine(x + 197,y + 69,x + 197,y + 102);

        //body part1
        UtilityFunction.drawLine(x + 140,y + 107,x + 158,y + 125);
        UtilityFunction.drawLine(x + 158,y + 125,x + 197,y + 100);

        UtilityFunction.drawCurve(x + 140,y + 102,x + 131,y + 117,x + 131,y + 133,x + 145,y + 189,1);
        UtilityFunction.drawCurve(x + 197,y + 94,x + 214,y + 97,x + 214,y + 112,x + 145,y + 189,1);
        UtilityFunction.drawLine(x + 157,y + 125,x + 134,y + 143);
        UtilityFunction.drawLine(x + 159,y + 126,x + 177,y + 151);

        // necktie
        UtilityFunction.drawLine(x + 142,y + 138,x + 147,y + 154);
        UtilityFunction.drawLine(x + 147,y + 154,x + 161,y + 156);
        UtilityFunction.drawLine(x + 161,y + 156,x + 174,y + 145);

        UtilityFunction.drawLine(x + 164,y + 132,x + 142,y + 142);
        UtilityFunction.drawLine(x + 145,y + 145,x + 166,y + 135);
        UtilityFunction.drawLine(x + 167,y + 138,x + 145,y + 149);
        UtilityFunction.drawLine(x + 147,y + 152,x + 170,y + 141);

        UtilityFunction.drawLine(x + 149,y + 154,x + 139,y + 165);
        UtilityFunction.drawLine(x + 160,y + 156,x + 162,y + 168);

        UtilityFunction.drawLine(x + 158,y + 156,x + 139,y + 167);
        UtilityFunction.drawLine(x + 161,y + 160,x + 140,y + 170);
        UtilityFunction.drawLine(x + 162,y + 164,x + 142,y + 177);
        UtilityFunction.drawLine(x + 162,y + 168,x + 142,y + 179);

        //body part2
        UtilityFunction.drawLine(x + 145,y + 189,x + 140,y + 202);
        UtilityFunction.drawLine(x + 140,y + 202,x + 140,y + 223);
        g2.drawOval(x + 134,y + 190,6,6);

        // Unknonw
        UtilityFunction.drawCurve(x + 197,y + 90,x + 223,y + 90,x + 223,y + 115,x + 206,y + 138,1);
        UtilityFunction.drawCurve(x + 197,y + 86,x + 230,y + 90,x + 221,y + 117,x + 211,y + 137,1);
        UtilityFunction.drawCurve(x + 211,y + 137,x + 219,y + 150,x + 220,y + 163,x + 212,y + 197,1);
        UtilityFunction.drawCurve(x + 212,y + 197,x + 210,y + 211,x + 205,y + 215,x + 196,y + 217,1);
        UtilityFunction.drawCurve(x + 196,y + 217,x + 189,y + 223,x + 189,y + 206,x + 195,y + 214,1);
        UtilityFunction.drawCurve(x + 195,y + 214,x + 208,y + 208,x + 205,y + 204,x + 209,y + 196,1);
        UtilityFunction.drawCurve(x + 209,y + 196,x + 214,y + 156,x + 214,y + 148,x + 210,y + 143,1);
        UtilityFunction.drawCurve(x + 210,y + 143,x + 191,y + 156,x + 186,y + 176,x + 184,y + 203,1);
        UtilityFunction.drawLine(x + 184,y + 203,x + 184,y + 220);
        UtilityFunction.drawCurve(x + 206,y + 138,x + 191,y + 153,x + 182,y + 178,x + 181,y + 218,1);
        UtilityFunction.drawCurve(x + 181,y + 218,x + 183,y + 227,x + 190,y + 227,x + 191,y + 221,1);
        UtilityFunction.drawCurve(x + 191,y + 221,x + 189,y + 217,x + 187,y + 217,x + 184,y + 220,1);

        UtilityFunction.drawCurve(x + 140,y + 97,x + 124,y + 104,x + 114,y + 110,x + 115,y + 169,1);
        UtilityFunction.drawCurve(x + 140,y + 94,x + 119,y + 98,x + 113,y + 113,x + 108,y + 169,1);
        g2.drawOval(x + 106,y + 168, 10, 10);
        g2.drawOval(x + 109,y + 171,4,4);

        //body part3
        UtilityFunction.drawLine(x + 148,y + 187,x + 191,y + 164);
        UtilityFunction.drawLine(x + 205,y + 96,x + 216,y + 100);
        UtilityFunction.drawCurve(x + 140,y + 101,x + 136,y + 102,x + 135,y + 104,x + 133,y + 108,1);
        UtilityFunction.drawLine(x + 118,y + 142,x + 133,y + 106);
        UtilityFunction.drawLine(x + 118,y + 142,x + 123,y + 142);
        UtilityFunction.drawLine(x + 123,y + 142,x + 119,y + 154);
        UtilityFunction.drawLine(x + 119,y + 154,x + 145,y + 189);
        UtilityFunction.drawCurve(x + 219,y + 103,x + 290,y + 172,x + 280,y + 200,x + 243,y + 285,1);
        UtilityFunction.drawCurve(x + 218,y + 195,x + 215,y + 221,x + 207,y + 230,x + 195,y + 236,1);
        UtilityFunction.drawCurve(x + 206,y + 248,x + 203,y + 234,x + 193,y + 231,x + 98,y + 223,1);
        UtilityFunction.drawCurve(x + 98,y + 223,x + 90,y + 225,x + 77,y + 236,x + 74,y + 249,1);
        UtilityFunction.drawCurve(x + 74,y + 249,x + 80,y + 278,x + 85,y + 283,x + 91,y + 281,1);
        UtilityFunction.drawCurve(x + 91,y + 281,x + 131,y + 288,x + 110,y + 282,x + 144,y + 300,1);
        UtilityFunction.drawLine(x + 144,y + 300,x + 225,y + 300);
        UtilityFunction.drawLine(x + 225,y + 300,x + 243,y + 283);
        // g2.drawLine(x + 243,y + 285,x + 243,y + 300);
        UtilityFunction.drawCurve(x + 140,y + 101,x + 131,y + 103,x + 127,y + 112,x + 123,y + 113,1);
        UtilityFunction.drawCurve(x + 114,y + 118,x + 108,y + 123,x + 98,y + 128,x + 85,y + 129,1);
        UtilityFunction.drawCurve(x + 85,y + 129,x + 65,y + 133,x + 55,y + 150,x + 49,y + 181,1);
        UtilityFunction.drawCurve(x + 49,y + 181,x + 39,y + 208,x + 30,y + 215,x + 27,y + 235,1);
        UtilityFunction.drawLine(x + 27,y + 235,x + 27,y + 268);
        UtilityFunction.drawCurve(x + 27,y + 268,x + 30,y + 283,x + 35,y + 285,x + 94,y + 293,1);
        UtilityFunction.drawLine(x + 94,y + 293,x + 132,y + 293);
        UtilityFunction.drawLine(x + 76,y + 139,x + 83,y + 199);
        UtilityFunction.drawLine(x + 65,y + 161,x + 83,y + 199);
        UtilityFunction.drawLine(x + 83,y + 199,x + 83,y + 231);
        UtilityFunction.drawCurve(x + 85,y + 231,x + 65,y + 238,x + 65,y + 244,x + 74,y + 249,1);
        UtilityFunction.drawCurve(x + 138,y + 242,x + 137,y + 258,x + 143,y + 271,x + 152,y + 279,1);
        UtilityFunction.drawCurve(x + 145,y + 254,x + 146,y + 259,x + 149,y + 263,x + 153,y + 264,1);

        
        //ผม
        buffer = UtilityFunction.Floodfill(buffer ,x + 346,y +179,Color.WHITE,new Color(0x4d2b22));
        //หน้า
        buffer = UtilityFunction.Floodfill(buffer ,x + 409,y +179,Color.WHITE,new Color(0xffd5c9));
        //ตา
        buffer = UtilityFunction.Floodfill(buffer ,x + 390,y +190,Color.WHITE,new Color(0x212826));
        buffer = UtilityFunction.Floodfill(buffer ,x + 460,y +190,Color.WHITE,new Color(0x212826));
        //หู
        buffer = UtilityFunction.Floodfill(buffer ,x + 509,y +195,Color.WHITE,new Color(0xffd5c9));
        buffer = UtilityFunction.Floodfill(buffer ,x + 343,y +200,Color.WHITE,new Color(0xffd5c9));
        //คอ
        buffer = UtilityFunction.Floodfill(buffer ,x + 428,y +340,Color.WHITE,new Color(0xffd5c9));
        //ปกคอ
        buffer = UtilityFunction.Floodfill(buffer ,x + 464,y +352,Color.WHITE,new Color(0x62b6fb));
        buffer = UtilityFunction.Floodfill(buffer ,x + 387,y +352,Color.WHITE,new Color(0x62b6fb));
        //เสื้อซับใน
        buffer = UtilityFunction.Floodfill(buffer ,x + 384,y +407,Color.WHITE,new Color(0x62b6fb));
        buffer = UtilityFunction.Floodfill(buffer ,x + 433,y +414,Color.WHITE,new Color(0x62b6fb));
        //เน็คไท
        buffer = UtilityFunction.Floodfill(buffer ,x + 405,y +371,Color.WHITE,new Color(0xa00e2e));
        buffer = UtilityFunction.Floodfill(buffer ,x + 411,y +386,Color.WHITE,new Color(0xa00e2e));
        buffer = UtilityFunction.Floodfill(buffer ,x + 421,y +404,Color.WHITE,new Color(0xa00e2e));
        buffer = UtilityFunction.Floodfill(buffer ,x + 396,y +421,Color.WHITE,new Color(0xa00e2e));
        buffer = UtilityFunction.Floodfill(buffer ,x + 394,y +442,Color.WHITE,new Color(0xa00e2e));
        buffer = UtilityFunction.Floodfill(buffer ,x + 396,y +460,Color.WHITE,new Color(0xa00e2e));
        
        //เสื้อ
        buffer = UtilityFunction.Floodfill(buffer ,x + 285,y +459,Color.WHITE,new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer ,x + 466,y +420,Color.WHITE,new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer ,x + 357,y +392,Color.WHITE,new Color(0xf3f3f3));
        
        //ที่ตรวจ
        buffer = UtilityFunction.Floodfill(buffer ,x + 515,y +384,Color.WHITE,new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer ,x + 501,y +279,Color.WHITE,new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer ,x + 337,y +331,Color.WHITE,new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer ,x + 328,y +445,Color.WHITE,new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer ,x + 466,y +516,Color.WHITE,new Color(0xf3f3f3));
        
        UtilityFunction.plot(x+143, y+42, Color.WHITE, 1);
        UtilityFunction.plot(x+180, y+41, Color.WHITE, 1);
    }
    
    public void drawScaledDreamDoctor(Graphics2D g2, int x, int y, double scaleX, double scaleY) {
        // กำหนดขนาดและตำแหน่งเริ่มต้น
        AffineTransform transform = new AffineTransform();
        transform.translate(x, y); // ย้ายไปที่ตำแหน่ง x, y
        transform.scale(scaleX, scaleY); // ขยายตามขนาด scaleX, scaleY
        
        // ใช้การเข้ารหัสที่กำหนดไว้
        g2.transform(transform);
        
        // เรียกใช้ฟังก์ชันเดิมที่วาด Doctor
        drawDreamDoctor(g2, 0, 0); // วาดที่ตำแหน่ง (0, 0) เนื่องจากมีการเคลื่อนที่จากการย้ายและขยาย
        
        // เรียกใช้การตั้งค่าการเข้ารหัสเพื่อยกเลิกการเปลี่ยนแปลงขนาดและตำแหน่ง
        g2.setTransform(new AffineTransform());
        
    }
    
    public void drawWin(Graphics2D g2,int x,int y){
        //head
        UtilityFunction.drawCurve(x + 65,y + 101,x + 43,y + 80,x + 43,y + 50,x + 65,y + 31,1);
        UtilityFunction.drawLine(x + 72,y + 108,x + 72,y + 101);
        UtilityFunction.drawLine(x + 72,y + 101,x + 65,y + 101);
        UtilityFunction.drawCurve(x + 65,y + 31,x + 88,y + 16,x + 130,y + 16,x + 139,y + 60,1);
        UtilityFunction.drawCurve(x + 111,y + 25,x + 122,y + 19,x + 133,y + 24,x + 126,y + 36,1);
        UtilityFunction.drawCurve(x + 126,y + 36,x + 111,y + 52,x + 112,y + 63,x + 139,y + 60,1);
        UtilityFunction.drawLine(x + 131,y + 60,x + 131,y + 91);
        UtilityFunction.drawCurve(x + 128,y + 27,x + 141,y + 39 ,x + 151,y + 55,x + 150,y + 74,1);
        UtilityFunction.drawCurve(x + 150,y + 74,x + 138,y + 66 ,x + 137,y + 66,x + 131,y + 69,1);
        UtilityFunction.drawCurve(x + 131,y + 74,x + 141,y + 79 ,x + 145,y + 79,x + 150,y + 74,1);
        UtilityFunction.drawCurve(x + 131,y + 91,x + 131,y + 100,x + 128,y + 107,x + 118,y + 107,1);
        UtilityFunction.drawLine(x + 118,y + 107,x + 118,y + 111);

        //body
        UtilityFunction.drawCurve(x + 65,y + 112,x + 87,y + 99,x + 100,y + 99,x + 125,y + 116,1);
        UtilityFunction.drawLine(x + 65,y + 112,x + 72,y + 115);
        UtilityFunction.drawLine(x + 72,y + 115,x + 120,y + 115);
        UtilityFunction.drawCurve(x + 120,y + 115,x + 140,y + 117,x + 152,y + 121,x + 158,y + 125,1);
        UtilityFunction.drawCurve(x + 158,y + 125,x + 182,y + 145,x + 187,y + 160,x + 190,y + 200,1);
        UtilityFunction.drawCurve(x + 158,y + 125,x + 155,y + 146,x + 155,y + 180,x + 160,y + 200,1);
        UtilityFunction.drawCurve(x + 68,y + 112  ,x + 22,y + 123,x + 20,y + 130,x + 12,y + 154,1);
        UtilityFunction.drawCurve(x + 29,y + 127  ,x + 24,y + 153,x + 24,y + 173,x + 30,y + 200,1);
        UtilityFunction.drawCurve(x + 28,y + 135  ,x + 65,y + 125,x + 119,y + 123,x + 158,y + 132,1);
        UtilityFunction.drawCurve(x + 12,y + 154  ,x + 10,y + 183,x + 11,y + 195,x + 15,y + 200,1);
        UtilityFunction.drawLine(x + 45,y + 200,x + 45,y + 157);
        UtilityFunction.drawLine(x + 45,y + 157,x + 136,y + 157);
        UtilityFunction.drawLine(x + 136,y + 157,x + 136,y + 200);
        UtilityFunction.drawLine(x + 15,y + 200,x + 190,y + 200);
    }

    public void drawCloud(Graphics2D g2,int x,int y){
        UtilityFunction.drawCurve(x + 43,y + 61,x + 26,y + 58,x + 26,y + 40,x + 55,y + 34,1);
        UtilityFunction.drawCurve(x + 55,y + 34,x + 71,y + 19,x + 75,y + 19,x + 87,y + 30,1);
        UtilityFunction.drawCurve(x + 87,y + 30,x + 104,y + 22,x + 109,y + 22,x + 127,y + 37,1);
        UtilityFunction.drawCurve(x + 127,y + 37,x + 142,y + 36,x + 148,y + 48,x + 133,y + 60,1);
        UtilityFunction.drawCurve(x + 133,y + 60,x + 119,y + 80,x + 105,y + 80,x + 91,y + 71,1);
        UtilityFunction.drawCurve(x + 91,y + 71,x + 83,y + 81,x + 65,y + 79,x + 43,y + 61,1);
    }

    public void drawBird(Graphics2D g2,int x,int y){
        UtilityFunction.drawCurve(x + 5,y + 25,x + 10,y + 12,x + 18,y + 12,x + 24,y + 26,1);
        UtilityFunction.drawCurve(x + 24,y + 26,x + 32,y + 12,x + 39,y + 12,x + 45,y + 25,1);
        UtilityFunction.drawLine(x + 24,y + 18,x + 24,y + 39);
        UtilityFunction.drawLine(x + 20,y + 39,x + 29,y + 39);
    }

    public void drawMotorcycle(Graphics2D g2,int x,int y){
        UtilityFunction.drawPolyline(x + 106,y + 69,x + 103,y + 70,x + 92,y + 70,x + 91,y + 67);
        UtilityFunction.drawCurve(x + 91,y + 67,x + 86,y+ 63,x + 86,y + 53,x + 91,y + 46,1);
        UtilityFunction.drawCurve(x + 95,y + 46,x + 103,y + 52,x + 103,y + 63,x + 91,y + 67,1);
        UtilityFunction.drawPolyline(x + 91,y + 46,x + 112,y + 46,x + 126,y + 60,x + 130,y + 60,
                                    x + 130,y + 59,x + 133,y + 59,x + 134,y + 62,x + 142,y + 62,
                                    x + 142,y + 67,x + 139,y + 67);
        UtilityFunction.drawCurve(x + 139,y + 67,x + 135,y + 63,x + 130,y + 63,x + 119,y + 70,1);
        UtilityFunction.drawCurve(x + 106,y + 69,x + 93,y + 84,x + 83,y +113,x + 70,y + 118,1);
        UtilityFunction.drawPolyline(x + 70,y + 118,x + 70,y + 125,x + 73,y + 125,x + 73,y + 127,x + 70,y+ 128,x + 58,y + 128);
        UtilityFunction.drawCurve(x + 58,y + 128,x + 36,y + 130,x + 36,y + 146,x + 48,y + 143,1);
        UtilityFunction.drawPolyline(x + 119,y + 70,x + 119,y + 73,x + 124,y + 77,x + 124,y + 86);
        UtilityFunction.drawCurve(x + 124,y + 86,x + 110,y + 124,x + 110,y + 130,x + 122,y + 160,1);
        UtilityFunction.drawCurve(x + 48,y + 143,x + 68,y + 146,x + 94,y + 152,x + 91,y + 164,1);
        UtilityFunction.drawCurve(x + 91,y + 164,x + 91,y + 169,x + 95,y + 173,x + 106,y + 174,1);
        UtilityFunction.drawLine(x + 120,y + 155,x + 156,y + 155);
        UtilityFunction.drawLine(x + 106,y + 174,x + 162,y + 174);
        UtilityFunction.drawCurve(x + 162,y + 174,x + 161,y + 180,x + 164,y + 181,x + 211,y + 185,1);
        UtilityFunction.drawPolyline(x + 112,y + 174,x + 127,y + 170,x + 201,y + 170);
        UtilityFunction.drawCurve(x + 201,y + 169,x + 206,y + 180,x + 215,y + 180,x + 230,y + 176,1);
        UtilityFunction.drawLine(x + 230,y + 176,x + 244,y + 176);
        UtilityFunction.drawPolyline(x + 201,y + 169,x + 229,y + 170,x + 236,y + 166);
        UtilityFunction.drawLine(x + 215,y + 166,x + 263,y + 166);
        UtilityFunction.drawCurve(x + 244,y + 176,x + 251,y + 176,x + 253,y + 170,x + 248,y + 166,1);
        UtilityFunction.drawCurve(x + 156,y + 155,x + 169,y + 144,x + 148,y + 121,x + 165,y + 110,1);
        UtilityFunction.drawLine(x + 165,y + 110,x + 241,y + 110);
        UtilityFunction.drawCurve(x + 167,y + 110,x + 158,y + 103,x + 158,y + 96,x + 170,y + 91,1);
        UtilityFunction.drawPolyline(x + 170,y + 91,x + 241,y + 91,x + 247,y + 92,x + 247,y + 99,x + 241,y + 111);
        UtilityFunction.drawCurve(x + 241,y + 110,x + 241,y + 115,x + 244,y + 119,x + 268,y + 125,1);
        UtilityFunction.drawCurve(x + 268,y + 125,x + 276,y + 134,x + 279,y + 145,x + 280,y + 161,1);
        UtilityFunction.drawCurve(x + 279,y + 161,x + 277,y + 167,x + 274,y + 166,x + 263,y + 166,1);

        // wheel
        UtilityFunction.drawPolyline(x + 82,y + 151,x + 60,y + 178,x + 63,y + 182,x + 85,y + 152);
        UtilityFunction.drawCircle(x + 62,y + 78, 10,1);
        UtilityFunction.drawCircle(x + 61,y + 79, 27,1);

        UtilityFunction.drawCurve(x + 262,y + 166,x + 280,y + 216,x + 207,y + 216,x + 212,y + 178,1);
   }
}
