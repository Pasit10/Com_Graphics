package assignment2;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.*;

public class Assingment2_65050976_65050607 {
    public static void main(String[] args){
        JFrame f = new JFrame();
        GraphicsSwing gs = new GraphicsSwing();
        f.setSize(600, 600);
        f.setTitle("Assingment2_65050976_65050607");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.add(gs);
        Thread t = new Thread(gs);
        //t.start();
    }
}


class GraphicsSwing extends JPanel implements Runnable {
    BufferedImage buffer = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_ARGB);

    // แสดง text สิ่งที่คิด กับ สิ่งที่เป็น
    boolean statusSing = false;
    boolean statusTee = false;
    boolean statusKid = false;
    boolean statusPen = false;

    // mind
    boolean status1 = false;
    boolean status2 = false;
    boolean status3 = false;
    boolean statusEye = false;

    // แสดง event
    boolean startbaby = false;
    boolean startdoctor = false;
    boolean startwin = false;

    // แสดง I Want To Be A Doctor
    boolean statusI = false;
    boolean statusWant = false;
    boolean statusTo = false;
    boolean statusBe = false;
    boolean statusA = false;
    boolean statusDoctor = false;

    // Position Baby
    double babyX = 5, babyY = 270;

    // Mind Position
    double smallcircleX = 170, smallcircleY = 20;
    double midcircleX = 170, midcircleY = 20;

    // Large Mind Position
    double circleX = 170;
    double circleY = 20;
    double circleHeight = 220;
    double circleWidth = 350;

    // Position Cloud
    double cloudX1 = 0;
    double cloudX2 = 400;

    // Position Bird
    double birdX1 = 170;
    double birdX2 = 300;

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        long startTime = lastTime;
        while(true){
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastTime;

            // Update
            if (currentTime >= 500 + startTime && currentTime <= 2000 + startTime) {
                statusSing = true;
            }if (currentTime >= 1000 + startTime && currentTime <= 2000 + startTime) {
                statusTee = true;
            }if (currentTime >= 1500 + startTime && currentTime <= 2000 + startTime) {
                statusKid = true;
            }if (currentTime == 2000 + startTime) {
                statusSing = false;
                statusTee = false;
                statusKid = false;
                startbaby = true;
            }
            if (currentTime>=2500+startTime) {
                status1 = true;
            }if (currentTime>=3000+startTime) {
                status2 = true;
            }if (currentTime>=3500+startTime) {
                status3 = true;
            }if ((currentTime-startTime)%300 == 0 ) {
                statusEye = (statusEye) ? false : true;
            }
            // ขยายฝัน
            double speed = elapsedTime / 1000.0;
            if((circleX > -200 || circleY > -100) && status3){
                circleWidth += 300 * speed;
                circleHeight += 300 * speed;
                circleX -= 180 * speed;
                circleY -= 100 * speed;
            }
            //ขยับเด็ก
            if(status3 && midcircleY < getHeight()){
                babyY += 230 * speed;
                smallcircleY += 230 * speed;
                midcircleY += 230 * speed;
            }
            //หมอ
            if (currentTime >=6000+startTime && currentTime <= 9000 + startTime) {
                startdoctor = true;
                statusI = true;
            }if (currentTime >=6500+startTime && currentTime <= 9000 + startTime) {
                statusWant = true;
            }if (currentTime >=7000+startTime && currentTime <= 9000 + startTime) {
                statusTo = true;
            }if (currentTime >=7500+startTime && currentTime <= 9000 + startTime) {
                statusBe = true;
            }if (currentTime >=8000+startTime && currentTime <= 9000 + startTime) {
                statusA = true;
            }if (currentTime >=8500+startTime && currentTime <= 9000 + startTime) {
                statusDoctor = true;
            }
            // ความฝันที่อยากเป็น
            if (currentTime >=9000 + startTime && currentTime <= 10500 + startTime) {
                status3 = false;
                startdoctor = false;
                statusSing = true;
            }if (currentTime >=9500 + startTime && currentTime <= 10500 + startTime) {
                statusTee = true;
            }if (currentTime >=10000 + startTime && currentTime <= 10500 + startTime) {
                statusPen = true;
            }if(currentTime >= 10500 + startTime){
                statusSing = false;
                statusTee = false;
                statusPen = false;
                startwin = true;
            }
            // ความเป็นจริง
            if(startwin){
                cloudX1 += 20 * speed;
                cloudX2 += 20 * speed;
                if(cloudX1 >= 570){
                    cloudX1 = -20;
                }
                if(cloudX2 >= 570){
                    cloudX2 = -20;
                }
                birdX1 += 20 * speed;
                birdX2 += 20 * speed;
                if(birdX1 >= 600){
                    birdX1 = -20;
                }
                if(birdX2 >= 600){
                    birdX2 = -20;
                }
            }
            // Display
            repaint();
            lastTime = currentTime;
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = buffer.createGraphics();
        // clear background
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        // setup UtitlityFunction
        UtilityFunction.setupUtilityFunction(g2);   
        // // วาด baby
        // if (startbaby) {
             drawBaby(g2,(int)babyX,(int)babyY);
        // if (status1) {
        //     drawsmallcircle(g2, (int)smallcircleX, (int)smallcircleY);
        // }if (status2) {
        //     drawmidcircle(g2, (int)midcircleX, (int)midcircleY);
        // }if (status3) {
        //     drawlargecircle(g2,(int) circleX, (int)circleY, (int)circleWidth,(int)circleHeight);
        // }if(statusEye){
        //     drawOpenEyeBaby(g2,(int)babyX,(int)babyY);
        // }if (!statusEye) {
        //     drawCloseEyeBaby(g2,(int)babyX,(int)babyY);
        // }
        // // วาด Doctor
        // }if (startdoctor) {
        //     drawIWannaBeADoctor(g2, 10, 130);
        // }
        // // แสดง text สิ่งที่คิด กับ สิ่งที่เป็น
        // drawSingTeeKid(g2, 255,100);
        // drawSingTeePen(g2, 255, 100);

        // // วาดวิน
        // if(startwin){
        //     drawScaledWin(g2, 0, 265, 1.5, 1.5);
        //     drawScaledMotorcycle(g2, 220, 210, 1.3, 1.3);
        //     drawBackground(g2);
        // }
        g.drawImage(buffer, 0, 0, null);
    }

    public void drawSingTeeKid(Graphics2D g2, int x, int y) {
        Font font = new Font("Arial", Font.BOLD, 48); // Font name, style, size
        UtilityFunction.drawLine(0, 0, 1, 0, 1, Color.BLACK);
        // Set the font
        g2.setFont(font);
        if (statusSing) {
            g2.drawString("Sing", x, y);
        }
        if (statusTee) {
            g2.drawString("Tee", x, y + 200);
        }
        if (statusKid) {
            g2.drawString("Kid", x, y + 400);
        }
    }

    public void drawSingTeePen(Graphics2D g2, int x, int y) {
        Font font = new Font("Arial", Font.BOLD, 48); // Font name, style, size
        UtilityFunction.drawLine(0, 0, 1, 0, 1, Color.BLACK);
        // Set the font
        g2.setFont(font);
        if (statusSing) {
            g2.drawString("Sing", x, y);
        }
        if (statusTee) {
            g2.drawString("Tee", x, y + 200);
        }
        if (statusPen) {
            g2.drawString("Pen", x, y + 400);
        }

    }

    public void drawIWannaBeADoctor(Graphics2D g2, int x, int y) {
        Font font = new Font("Arial", Font.BOLD, 36); // Font name, style, size
        UtilityFunction.drawLine(0, 0, 1, 0, 1, Color.BLACK);
        // Set the font
        g2.setFont(font);
        if (statusI) {
            g2.drawString(" I", x, y);
        }
        if (statusWant) {
            g2.drawString(" Want", x, y + 50);
        }
        if (statusTo) {
            g2.drawString(" To", x, y + 100);
        }
        if (statusBe) {
            g2.drawString(" Be", x, y + 150);
        }
        if (statusA) {
            g2.drawString(" A", x, y + 200);
        }
        if (statusDoctor) {
            g2.drawString(" Doctor", x, y + 250);
        }
        drawScaledDreamDoctor(g2, 100, 100, 2, 2);
    }

    public void drawBaby(Graphics2D g2, int x, int y) {
        // body
        UtilityFunction.drawCurve(x + 30, y + 146, x + 43, y + 356, x + 277, y + 321, x + 164, y + 113, 1);
        UtilityFunction.drawLine(x + 34, y + 180, x + 54, y + 162);
        UtilityFunction.drawLine(x + 119, y + 161, x + 184, y + 158);
        UtilityFunction.drawLine(x + 61, y + 243, x + 160, y + 160);
        UtilityFunction.drawLine(x + 83, y + 225, x + 186, y + 250);
        UtilityFunction.drawLine(x + 132, y + 237, x + 95, y + 277);

        // head
        //g2.drawOval(x, y, 171, 167);
        UtilityFunction.drawmiddleElipse(x + 85,y + 83,85,83,1);
        // แก้ม
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

        // mouth
        UtilityFunction.drawCurve(x + 95, y + 124, x + 105, y + 126, x + 107, y + 122, x + 106, y + 119, 1);

        // หู
        UtilityFunction.drawCurve(x + 7, y + 116, x, y + 122, x + 4, y + 130, x + 15, y + 131, 1);
        UtilityFunction.drawCurve(x + 170, y + 78, x + 180, y + 80, x + 178, y + 90, x + 171, y + 94, 1);

        // ลงสีหน้า
        buffer = UtilityFunction.Floodfill(buffer, x + 30, y + 30, Color.WHITE, new Color(0xfddac6));

        // ลงสีผ้าอ้อม
        buffer = UtilityFunction.Floodfill(buffer, x + 35, y + 180, Color.WHITE, new Color(0x9ecfed));
        buffer = UtilityFunction.Floodfill(buffer, x + 160, y + 150, Color.WHITE, new Color(0x9ecfed));
        buffer = UtilityFunction.Floodfill(buffer, x + 100, y + 250, Color.WHITE, new Color(0x9ecfed));

        // ลงสีแก้ม
        buffer = UtilityFunction.Floodfill(buffer, x + 65, y + 125, Color.WHITE, new Color(0xf6a5b6));
        buffer = UtilityFunction.Floodfill(buffer, x + 135, y + 105, Color.WHITE, new Color(0xf6a5b6));

        // ลงสีหู
        buffer = UtilityFunction.Floodfill(buffer, x + 5, y + 120, Color.WHITE, new Color(0xfddac6));
        buffer = UtilityFunction.Floodfill(buffer, x + 173, y + 80, Color.WHITE, new Color(0xfddac6));
    }

    public void drawOpenEyeBaby(Graphics2D g2, int x, int y) {
        g2.drawOval(x + 60, y + 94, 20, 20);
        g2.drawOval(x + 70, y + 98, 6, 6);
        g2.drawOval(x + 110, y + 82, 20, 20);
        g2.drawOval(x + 120, y + 86, 6, 6);
        buffer = UtilityFunction.Floodfill(buffer, x + 65, y + 105, new Color(0xfddac6), new Color(0x3a3a3a));
        buffer = UtilityFunction.Floodfill(buffer, x + 125, y + 85, new Color(0xfddac6), new Color(0x3a3a3a));
    }

    public void drawCloseEyeBaby(Graphics2D g2, int x, int y) {
        UtilityFunction.drawCurve(x + 135, y + 80, x + 145, y + 84, x + 115, y + 94, x + 105, y + 90, 1);
        UtilityFunction.drawCurve(x + 85, y + 95, x + 95, y + 99, x + 65, y + 109, x + 55, y + 105, 1);
    }

    public void drawsmallcircle(Graphics2D g2, int x, int y) {
        g2.drawOval(x - 20, y + 240, 20, 10);
    }

    public void drawmidcircle(Graphics2D g2, int x, int y) {
        g2.drawOval(x, y + 200, 40, 20);
    }

    public void drawlargecircle(Graphics2D g2, int x, int y, int width, int height) {
        g2.drawOval(x, y, width, height);
    }

    public void drawDreamDoctor(Graphics2D g2, int x, int y) {
        // head
        UtilityFunction.drawCurve(x + 119, y + 41, x + 106, y + 26, x + 108, y + 7, x + 124, y + 1, 1);
        UtilityFunction.drawLine(x + 119, y + 41, x + 125, y + 41);
        UtilityFunction.drawLine(x + 125, y + 41, x + 133, y + 78);
        UtilityFunction.drawCurve(x + 120, y + 41, x + 116, y + 45, x + 116, y + 51, x + 131, y + 65, 1);
        UtilityFunction.drawCurve(x + 133, y + 78, x + 151, y + 110, x + 167, y + 107, x + 197, y + 69, 1);
        UtilityFunction.drawLine(x + 197, y + 69, x + 200, y + 38);
        UtilityFunction.drawCurve(x + 200, y + 38, x + 194, y + 35, x + 192, y + 28, x + 192, y + 21, 1);
        UtilityFunction.drawCurve(x + 192, y + 21, x + 181, y + 14, x + 179, y + 7, x + 179, y + 1, 1);
        UtilityFunction.drawCurve(x + 200, y + 38, x + 202, y + 33, x + 208, y + 33, x + 210, y + 38, 1);
        UtilityFunction.drawLine(x + 210, y + 38, x + 210, y + 50);
        UtilityFunction.drawCurve(x + 210, y + 50, x + 209, y + 60, x + 205, y + 65, x + 197, y + 66, 1);
        UtilityFunction.drawCurve(x + 210, y + 44, x + 224, y + 27, x + 224, y + 20, x + 205, y + 1, 1);
        UtilityFunction.drawCurve(x + 124, y + 1, x + 128, y - 20, x + 190, y - 20, x + 205, y + 1, 1);
        UtilityFunction.drawLine(x + 125, y + 41, x + 125, y + 34);
        UtilityFunction.drawLine(x + 125, y + 34, x + 130, y + 29);
        UtilityFunction.drawLine(x + 130, y + 29, x + 130, y + 20);
        UtilityFunction.drawLine(x + 130, y + 20, x + 132, y + 18);
        UtilityFunction.drawLine(x + 132, y + 18, x + 132, y + 11);
        UtilityFunction.drawCurve(x + 132, y + 11, x + 169, y + 11, x + 176, y + 7, x + 179, y + 1, 1);

        // left eye
        UtilityFunction.drawCurve(x + 132, y + 33, x + 139, y + 28, x + 144, y + 28, x + 149, y + 32, 1);
        UtilityFunction.drawCurve(x + 133, y + 41, x + 140, y + 35, x + 144, y + 35, x + 150, y + 39, 1);
        UtilityFunction.drawCurve(x + 141, y + 37, x + 137, y + 49, x + 149, y + 57, x + 146, y + 37, 1);
        // right eye
        UtilityFunction.drawCurve(x + 171, y + 32, x + 176, y + 27, x + 180, y + 27, x + 188, y + 32, 1);
        UtilityFunction.drawCurve(x + 173, y + 39, x + 178, y + 34, x + 184, y + 34, x + 189, y + 39, 1);
        UtilityFunction.drawCurve(x + 177, y + 36, x + 177, y + 53, x + 184, y + 53, x + 184, y + 36, 1);

        // mouse
        UtilityFunction.drawCurve(x + 149, y + 76, x + 156, y + 81, x + 161, y + 81, x + 174, y + 73, 1);

        // nose
        UtilityFunction.drawLine(x + 158, y + 40, x + 158, y + 51);
        UtilityFunction.drawCurve(x + 158, y + 51, x + 154, y + 56, x + 154, y + 59, x + 159, y + 62, 1);

        // neck
        UtilityFunction.drawLine(x + 140, y + 88, x + 140, y + 107);
        UtilityFunction.drawLine(x + 197, y + 69, x + 197, y + 102);

        // body part1
        UtilityFunction.drawLine(x + 140, y + 107, x + 158, y + 125);
        UtilityFunction.drawLine(x + 158, y + 125, x + 197, y + 100);

        UtilityFunction.drawCurve(x + 140, y + 102, x + 131, y + 117, x + 131, y + 133, x + 145, y + 189, 1);
        UtilityFunction.drawCurve(x + 197, y + 94, x + 214, y + 97, x + 214, y + 112, x + 145, y + 189, 1);
        UtilityFunction.drawLine(x + 157, y + 125, x + 134, y + 143);
        UtilityFunction.drawLine(x + 159, y + 126, x + 177, y + 151);

        // necktie
        UtilityFunction.drawLine(x + 142, y + 138, x + 147, y + 154);
        UtilityFunction.drawLine(x + 147, y + 154, x + 161, y + 156);
        UtilityFunction.drawLine(x + 161, y + 156, x + 174, y + 145);

        UtilityFunction.drawLine(x + 164, y + 132, x + 142, y + 142);
        UtilityFunction.drawLine(x + 145, y + 145, x + 166, y + 135);
        UtilityFunction.drawLine(x + 167, y + 138, x + 145, y + 149);
        UtilityFunction.drawLine(x + 147, y + 152, x + 170, y + 141);

        UtilityFunction.drawLine(x + 149, y + 154, x + 139, y + 165);
        UtilityFunction.drawLine(x + 160, y + 156, x + 162, y + 168);

        UtilityFunction.drawLine(x + 158, y + 156, x + 139, y + 167);
        UtilityFunction.drawLine(x + 161, y + 160, x + 140, y + 170);
        UtilityFunction.drawLine(x + 162, y + 164, x + 142, y + 177);
        UtilityFunction.drawLine(x + 162, y + 168, x + 142, y + 179);

        // body part2
        UtilityFunction.drawLine(x + 145, y + 189, x + 140, y + 202);
        UtilityFunction.drawLine(x + 140, y + 202, x + 140, y + 223);
        g2.drawOval(x + 134, y + 190, 6, 6);

        // Unknonw
        UtilityFunction.drawCurve(x + 197, y + 90, x + 223, y + 90, x + 223, y + 115, x + 206, y + 138, 1);
        UtilityFunction.drawCurve(x + 197, y + 86, x + 230, y + 90, x + 221, y + 117, x + 211, y + 137, 1);
        UtilityFunction.drawCurve(x + 211, y + 137, x + 219, y + 150, x + 220, y + 163, x + 212, y + 197, 1);
        UtilityFunction.drawCurve(x + 212, y + 197, x + 210, y + 211, x + 205, y + 215, x + 196, y + 217, 1);
        UtilityFunction.drawCurve(x + 196, y + 217, x + 189, y + 223, x + 189, y + 206, x + 195, y + 214, 1);
        UtilityFunction.drawCurve(x + 195, y + 214, x + 208, y + 208, x + 205, y + 204, x + 209, y + 196, 1);
        UtilityFunction.drawCurve(x + 209, y + 196, x + 214, y + 156, x + 214, y + 148, x + 210, y + 143, 1);
        UtilityFunction.drawCurve(x + 210, y + 143, x + 191, y + 156, x + 186, y + 176, x + 184, y + 203, 1);
        UtilityFunction.drawLine(x + 184, y + 203, x + 184, y + 220);
        UtilityFunction.drawCurve(x + 206, y + 138, x + 191, y + 153, x + 182, y + 178, x + 181, y + 218, 1);
        UtilityFunction.drawCurve(x + 181, y + 218, x + 183, y + 227, x + 190, y + 227, x + 191, y + 221, 1);
        UtilityFunction.drawCurve(x + 191, y + 221, x + 189, y + 217, x + 187, y + 217, x + 184, y + 220, 1);

        UtilityFunction.drawCurve(x + 140, y + 97, x + 124, y + 104, x + 114, y + 110, x + 115, y + 169, 1);
        UtilityFunction.drawCurve(x + 140, y + 94, x + 119, y + 98, x + 113, y + 113, x + 108, y + 169, 1);
        g2.drawOval(x + 106, y + 168, 10, 10);
        g2.drawOval(x + 109, y + 171, 4, 4);

        // body part3
        UtilityFunction.drawLine(x + 148, y + 187, x + 191, y + 164);
        UtilityFunction.drawLine(x + 205, y + 96, x + 216, y + 100);
        UtilityFunction.drawCurve(x + 140, y + 101, x + 136, y + 102, x + 135, y + 104, x + 133, y + 108, 1);
        UtilityFunction.drawLine(x + 118, y + 142, x + 133, y + 106);
        UtilityFunction.drawLine(x + 118, y + 142, x + 123, y + 142);
        UtilityFunction.drawLine(x + 123, y + 142, x + 119, y + 154);
        UtilityFunction.drawLine(x + 119, y + 154, x + 145, y + 189);
        UtilityFunction.drawCurve(x + 219, y + 103, x + 290, y + 172, x + 280, y + 200, x + 243, y + 285, 1);
        UtilityFunction.drawCurve(x + 218, y + 195, x + 215, y + 221, x + 207, y + 230, x + 195, y + 236, 1);
        UtilityFunction.drawCurve(x + 206, y + 248, x + 203, y + 234, x + 193, y + 231, x + 98, y + 223, 1);
        UtilityFunction.drawCurve(x + 98, y + 223, x + 90, y + 225, x + 77, y + 236, x + 74, y + 249, 1);
        UtilityFunction.drawCurve(x + 74, y + 249, x + 80, y + 278, x + 85, y + 283, x + 91, y + 281, 1);
        UtilityFunction.drawCurve(x + 91, y + 281, x + 131, y + 288, x + 110, y + 282, x + 144, y + 300, 1);
        UtilityFunction.drawLine(x + 144, y + 300, x + 225, y + 300);
        UtilityFunction.drawLine(x + 225, y + 300, x + 243, y + 283);
        // g2.drawLine(x + 243,y + 285,x + 243,y + 300);
        UtilityFunction.drawCurve(x + 140, y + 101, x + 131, y + 103, x + 127, y + 112, x + 123, y + 113, 1);
        UtilityFunction.drawCurve(x + 114, y + 118, x + 108, y + 123, x + 98, y + 128, x + 85, y + 129, 1);
        UtilityFunction.drawCurve(x + 85, y + 129, x + 65, y + 133, x + 55, y + 150, x + 49, y + 181, 1);
        UtilityFunction.drawCurve(x + 49, y + 181, x + 39, y + 208, x + 30, y + 215, x + 27, y + 235, 1);
        UtilityFunction.drawLine(x + 27, y + 235, x + 27, y + 268);
        UtilityFunction.drawCurve(x + 27, y + 268, x + 30, y + 283, x + 35, y + 285, x + 94, y + 293, 1);
        UtilityFunction.drawLine(x + 94, y + 293, x + 132, y + 293);
        UtilityFunction.drawLine(x + 76, y + 139, x + 83, y + 199);
        UtilityFunction.drawLine(x + 65, y + 161, x + 83, y + 199);
        UtilityFunction.drawLine(x + 83, y + 199, x + 83, y + 231);
        UtilityFunction.drawCurve(x + 85, y + 231, x + 65, y + 238, x + 65, y + 244, x + 74, y + 249, 1);
        UtilityFunction.drawCurve(x + 138, y + 242, x + 137, y + 258, x + 143, y + 271, x + 152, y + 279, 1);
        UtilityFunction.drawCurve(x + 145, y + 254, x + 146, y + 259, x + 149, y + 263, x + 153, y + 264, 1);

        // ผม
        buffer = UtilityFunction.Floodfill(buffer, x + 346, y + 179, Color.WHITE, new Color(0x4d2b22));
        // หน้า
        buffer = UtilityFunction.Floodfill(buffer, x + 409, y + 179, Color.WHITE, new Color(0xffd5c9));
        // ตา
        buffer = UtilityFunction.Floodfill(buffer, x + 390, y + 190, Color.WHITE, new Color(0x212826));
        buffer = UtilityFunction.Floodfill(buffer, x + 460, y + 190, Color.WHITE, new Color(0x212826));
        // หู
        buffer = UtilityFunction.Floodfill(buffer, x + 509, y + 195, Color.WHITE, new Color(0xffd5c9));
        buffer = UtilityFunction.Floodfill(buffer, x + 343, y + 200, Color.WHITE, new Color(0xffd5c9));
        // คอ
        buffer = UtilityFunction.Floodfill(buffer, x + 428, y + 340, Color.WHITE, new Color(0xffd5c9));
        // ปกคอ
        buffer = UtilityFunction.Floodfill(buffer, x + 464, y + 352, Color.WHITE, new Color(0x62b6fb));
        buffer = UtilityFunction.Floodfill(buffer, x + 387, y + 352, Color.WHITE, new Color(0x62b6fb));
        // เสื้อซับใน
        buffer = UtilityFunction.Floodfill(buffer, x + 384, y + 407, Color.WHITE, new Color(0x62b6fb));
        buffer = UtilityFunction.Floodfill(buffer, x + 433, y + 414, Color.WHITE, new Color(0x62b6fb));
        // เน็คไท
        buffer = UtilityFunction.Floodfill(buffer, x + 405, y + 371, Color.WHITE, new Color(0xa00e2e));
        buffer = UtilityFunction.Floodfill(buffer, x + 411, y + 386, Color.WHITE, new Color(0xa00e2e));
        buffer = UtilityFunction.Floodfill(buffer, x + 421, y + 404, Color.WHITE, new Color(0xa00e2e));
        buffer = UtilityFunction.Floodfill(buffer, x + 396, y + 421, Color.WHITE, new Color(0xa00e2e));
        buffer = UtilityFunction.Floodfill(buffer, x + 394, y + 442, Color.WHITE, new Color(0xa00e2e));
        buffer = UtilityFunction.Floodfill(buffer, x + 396, y + 460, Color.WHITE, new Color(0xa00e2e));

        // เสื้อ
        buffer = UtilityFunction.Floodfill(buffer, x + 285, y + 459, Color.WHITE, new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer, x + 466, y + 420, Color.WHITE, new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer, x + 357, y + 392, Color.WHITE, new Color(0xf3f3f3));

        // ที่ตรวจ
        buffer = UtilityFunction.Floodfill(buffer, x + 515, y + 384, Color.WHITE, new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer, x + 501, y + 279, Color.WHITE, new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer, x + 337, y + 331, Color.WHITE, new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer, x + 328, y + 445, Color.WHITE, new Color(0xf3f3f3));
        buffer = UtilityFunction.Floodfill(buffer, x + 466, y + 516, Color.WHITE, new Color(0xf3f3f3));

        UtilityFunction.plot(x + 143, y + 42, Color.WHITE, 1);
        UtilityFunction.plot(x + 180, y + 41, Color.WHITE, 1);
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

    public void drawWin(Graphics2D g2, int x, int y) {
        // head
        UtilityFunction.drawCurve(x + 65, y + 101, x + 43, y + 80, x + 43, y + 50, x + 65, y + 31, 1);
        UtilityFunction.drawLine(x + 72, y + 108, x + 72, y + 101);
        UtilityFunction.drawLine(x + 72, y + 101, x + 65, y + 101);
        UtilityFunction.drawCurve(x + 65, y + 31, x + 88, y + 16, x + 130, y + 16, x + 139, y + 60, 1);
        UtilityFunction.drawCurve(x + 111, y + 25, x + 122, y + 19, x + 133, y + 24, x + 126, y + 36, 1);
        UtilityFunction.drawCurve(x + 126, y + 36, x + 111, y + 52, x + 112, y + 63, x + 139, y + 60, 1);
        UtilityFunction.drawLine(x + 131, y + 60, x + 131, y + 91);
        UtilityFunction.drawCurve(x + 128, y + 27, x + 141, y + 39, x + 151, y + 55, x + 150, y + 74, 1);
        UtilityFunction.drawCurve(x + 150, y + 74, x + 138, y + 66, x + 137, y + 66, x + 131, y + 69, 1);
        UtilityFunction.drawCurve(x + 131, y + 74, x + 141, y + 79, x + 145, y + 79, x + 150, y + 74, 1);
        UtilityFunction.drawCurve(x + 131, y + 91, x + 131, y + 100, x + 128, y + 107, x + 118, y + 107, 1);
        UtilityFunction.drawLine(x + 118, y + 107, x + 118, y + 111);

        // body
        UtilityFunction.drawCurve(x + 65, y + 112, x + 87, y + 99, x + 100, y + 99, x + 125, y + 116, 1);
        UtilityFunction.drawLine(x + 65, y + 112, x + 72, y + 115);
        UtilityFunction.drawLine(x + 72, y + 115, x + 120, y + 115);
        UtilityFunction.drawCurve(x + 120, y + 115, x + 140, y + 117, x + 152, y + 121, x + 158, y + 125, 1);
        UtilityFunction.drawCurve(x + 158, y + 125, x + 182, y + 145, x + 187, y + 160, x + 190, y + 200, 1);
        UtilityFunction.drawCurve(x + 158, y + 125, x + 155, y + 146, x + 155, y + 180, x + 160, y + 200, 1);
        UtilityFunction.drawCurve(x + 68, y + 112, x + 22, y + 123, x + 20, y + 130, x + 12, y + 154, 1);
        UtilityFunction.drawCurve(x + 29, y + 127, x + 24, y + 153, x + 24, y + 173, x + 30, y + 200, 1);
        UtilityFunction.drawCurve(x + 28, y + 135, x + 65, y + 125, x + 119, y + 123, x + 158, y + 132, 1);
        UtilityFunction.drawCurve(x + 12, y + 154, x + 10, y + 183, x + 11, y + 195, x + 15, y + 200, 1);
        UtilityFunction.drawLine(x + 45, y + 200, x + 45, y + 157);
        UtilityFunction.drawLine(x + 45, y + 157, x + 136, y + 157);
        UtilityFunction.drawLine(x + 136, y + 157, x + 136, y + 200);
        UtilityFunction.drawLine(x + 15, y + 200, x + 190, y + 200);
        // ลงสีหมวก
        buffer = UtilityFunction.Floodfill(buffer, x + 121, y + 334, Color.WHITE, new Color(0xe5eef5));
        buffer = UtilityFunction.Floodfill(buffer, x + 194, y + 338, Color.WHITE, new Color(0x1d1723));
        buffer = UtilityFunction.Floodfill(buffer, x + 214, y + 338, Color.WHITE, new Color(0xaee8fa));
        buffer = UtilityFunction.Floodfill(buffer, x + 187, y + 304, Color.WHITE, new Color(0x7ab2c3));
        buffer = UtilityFunction.Floodfill(buffer, x + 211, y + 370, Color.WHITE, new Color(0x79b3c1));

        buffer = UtilityFunction.Floodfill(buffer, x + 142, y + 425, Color.WHITE, new Color(0x413f4d));
        buffer = UtilityFunction.Floodfill(buffer, x + 131, y + 444, Color.WHITE, new Color(0x88899b));
        buffer = UtilityFunction.Floodfill(buffer, x + 129, y + 479, Color.WHITE, new Color(0xf7631b));
        buffer = UtilityFunction.Floodfill(buffer, x + 152, y + 524, Color.WHITE, new Color(0xfff596));
        buffer = UtilityFunction.Floodfill(buffer, x + 31, y + 498, Color.WHITE, new Color(0x413f4d));
        buffer = UtilityFunction.Floodfill(buffer, x + 256, y + 510, Color.WHITE, new Color(0x413f4d));

    }

    public void drawBackground(Graphics2D g2) {
        UtilityFunction.drawLine(0, 100, 600, 100);
        UtilityFunction.drawLine(0, 170, 600, 170);
        UtilityFunction.drawLine(0, 480, 23, 480);
        UtilityFunction.drawLine(0, 530, 18, 530);
        UtilityFunction.drawLine(263, 480, 600, 480);
        UtilityFunction.drawLine(282, 530, 600, 530);

        //ท้องฟ้า
        drawCloud((int)cloudX1, 5);
        drawCloud((int)cloudX2, 5);
        //นก
        drawBird((int)birdX1, 5);
        drawBird((int)birdX2, 10);

        //motorcycle Shop Text
        Font font = new Font("Arial", Font.BOLD, 36);
        g2.setFont(font);
        g2.drawString("Motorcycle Shop",150,145);

        //สีท้องฟ้า
        UtilityFunction.floodFillGradient(buffer, 300, 0, 600, 104, new Color(0x0651c1), new Color(0xa9c3ff), Color.BLACK);
        
        //ภายในร้าน
        UtilityFunction.floodFillGradient(buffer, 0, 171, 600, 480, new Color(0xFFFF99), new Color(0xFFFFCC), Color.BLACK);
        
        //กรอบล่างของร้านที่เยอะ
        UtilityFunction.floodFillGradient(buffer, 314, 486, 600, 534, new Color(0xF6C8B6), new Color(0xF5E3CB), Color.BLACK);
        
        //กรอบล่างของร้านที่น้อย
        UtilityFunction.floodFillGradient(buffer, 0, 484, 0, 534, new Color(0xF6C8B6), new Color(0xF5E3CB), Color.BLACK);
        
        //พื้นถนน
        buffer = UtilityFunction.Floodfill(buffer, 7, 545, Color.WHITE, new Color(0xA9A9A9));
    }

    public void drawScaledWin(Graphics2D g2, int x, int y, double scaleX, double scaleY) {
        // กำหนดขนาดและตำแหน่งเริ่มต้น
        AffineTransform transform = new AffineTransform();
        transform.translate(x, y); // ย้ายไปที่ตำแหน่ง x, y
        transform.scale(scaleX, scaleY); // ขยายตามขนาด scaleX, scaleY

        // ใช้การเข้ารหัสที่กำหนดไว้
        g2.transform(transform);

        // เรียกใช้ฟังก์ชันเดิมที่วาด Doctor
        drawWin(g2, 0, 0); // วาดที่ตำแหน่ง (0, 0) เนื่องจากมีการเคลื่อนที่จากการย้ายและขยาย

        // เรียกใช้การตั้งค่าการเข้ารหัสเพื่อยกเลิกการเปลี่ยนแปลงขนาดและตำแหน่ง
        g2.setTransform(new AffineTransform());

    }

    public void drawCloud(int x, int y) {
        UtilityFunction.drawCurve(x + 43, y + 61, x + 26, y + 58, x + 26, y + 40, x + 55, y + 34, 1);
        UtilityFunction.drawCurve(x + 55, y + 34, x + 71, y + 19, x + 75, y + 19, x + 87, y + 30, 1);
        UtilityFunction.drawCurve(x + 87, y + 30, x + 104, y + 22, x + 109, y + 22, x + 127, y + 37, 1);
        UtilityFunction.drawCurve(x + 127, y + 37, x + 142, y + 36, x + 148, y + 48, x + 133, y + 60, 1);
        UtilityFunction.drawCurve(x + 133, y + 60, x + 119, y + 80, x + 105, y + 80, x + 91, y + 71, 1);
        UtilityFunction.drawCurve(x + 91, y + 71, x + 83, y + 81, x + 65, y + 79, x + 43, y + 61, 1);

        //สีก้อนเมฆ
        //UtilityFunction.drawLine(x + 43,y + 40,x + 44,y + 40);
        UtilityFunction.FloodfillUpgrade(buffer,x + 43,y + 40,Color.BLACK,new Color(0xCCFFFF));
    }

    public void drawBird(int x, int y) {
        UtilityFunction.drawCurve(x + 5, y + 25, x + 10, y + 12, x + 18, y + 12, x + 24, y + 26, 1);
        UtilityFunction.drawCurve(x + 24, y + 26, x + 32, y + 12, x + 39, y + 12, x + 45, y + 25, 1);
        UtilityFunction.drawLine(x + 24, y + 18, x + 24, y + 39);
        UtilityFunction.drawLine(x + 20, y + 39, x + 29, y + 39);
    }

    public void drawMotorcycle(Graphics2D g2, int x, int y) {
        UtilityFunction.drawPolyline(x + 106, y + 69, x + 103, y + 70, x + 92, y + 70, x + 91, y + 67);
        UtilityFunction.drawCurve(x + 91, y + 67, x + 86, y + 63, x + 86, y + 53, x + 91, y + 46, 1);
        UtilityFunction.drawCurve(x + 95, y + 46, x + 103, y + 52, x + 103, y + 63, x + 91, y + 67, 1);
        UtilityFunction.drawPolyline(x + 91, y + 46, x + 112, y + 46, x + 126, y + 60, x + 130, y + 60,
                x + 130, y + 59, x + 133, y + 59, x + 134, y + 62, x + 142, y + 62,
                x + 142, y + 67, x + 139, y + 67);
        UtilityFunction.drawCurve(x + 139, y + 67, x + 135, y + 63, x + 130, y + 63, x + 119, y + 70, 1);
        UtilityFunction.drawCurve(x + 106, y + 69, x + 93, y + 84, x + 83, y + 113, x + 70, y + 118, 1);
        UtilityFunction.drawPolyline(x + 70, y + 118, x + 70, y + 125, x + 73, y + 125, x + 73, y + 127, x + 70,
                y + 128, x + 58, y + 128);
        UtilityFunction.drawCurve(x + 58, y + 128, x + 36, y + 130, x + 36, y + 146, x + 48, y + 143, 1);
        UtilityFunction.drawPolyline(x + 119, y + 70, x + 119, y + 73, x + 124, y + 77, x + 124, y + 86);
        UtilityFunction.drawCurve(x + 124, y + 86, x + 110, y + 124, x + 110, y + 130, x + 122, y + 160, 1);
        UtilityFunction.drawCurve(x + 48, y + 143, x + 68, y + 146, x + 94, y + 152, x + 91, y + 164, 1);
        UtilityFunction.drawCurve(x + 91, y + 164, x + 91, y + 169, x + 95, y + 173, x + 106, y + 174, 1);
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
        UtilityFunction.drawPolyline(x + 82, y + 151, x + 60, y + 178, x + 63, y + 182, x + 85, y + 152);
        UtilityFunction.drawCircle(x + 62, y + 78, 10, 1);
        UtilityFunction.drawCircle(x + 61, y + 79, 27, 1);

        UtilityFunction.drawCurve(x + 262,y + 166,x + 280,y + 216,x + 207,y + 216,x + 212,y + 178,1);

        //ลงสีมอไซ
        buffer = UtilityFunction.Floodfill(buffer, x + 354, y + 342, Color.WHITE, new Color(0xd71417));

        //เบาะ
        buffer = UtilityFunction.Floodfill(buffer, x + 460, y + 342, Color.WHITE, new Color(0x70362d));

        //ไฟ
        buffer = UtilityFunction.Floodfill(buffer, x + 343, y + 281, Color.WHITE, new Color(0xE9F874));

        //ช่วงล่าง
        buffer = UtilityFunction.Floodfill(buffer, x + 459, y + 440, Color.WHITE, new Color(0x701418));
        buffer = UtilityFunction.Floodfill(buffer, x + 510, y + 436, Color.WHITE, new Color(0x666362));

        //โช๊ค
        buffer = UtilityFunction.Floodfill(buffer, x + 325, y + 412, Color.WHITE, new Color(0x3c3939));
        buffer = UtilityFunction.Floodfill(buffer, x + 315, y + 426, Color.WHITE, new Color(0x3c3939));
        buffer = UtilityFunction.Floodfill(buffer, x + 305, y + 439, Color.WHITE, new Color(0x3c3939));

        //ล้อ
        buffer = UtilityFunction.Floodfill(buffer, x + 275, y + 444, Color.WHITE, new Color(0x221714));
        buffer = UtilityFunction.Floodfill(buffer, x + 524, y + 454, Color.WHITE, new Color(0x221714));
        buffer = UtilityFunction.Floodfill(buffer, x + 295, y + 439, Color.WHITE, new Color(0xd0c5c9));
   }

    public void drawScaledMotorcycle(Graphics2D g2, int x, int y, double scaleX, double scaleY) {
        // กำหนดขนาดและตำแหน่งเริ่มต้น
        AffineTransform transform = new AffineTransform();
        transform.translate(x, y); // ย้ายไปที่ตำแหน่ง x, y
        transform.scale(scaleX, scaleY); // ขยายตามขนาด scaleX, scaleY

        // ใช้การเข้ารหัสที่กำหนดไว้
        g2.transform(transform);

        // เรียกใช้ฟังก์ชันเดิมที่วาด Doctor
        drawMotorcycle(g2, 0, 0); // วาดที่ตำแหน่ง (0, 0) เนื่องจากมีการเคลื่อนที่จากการย้ายและขยาย

        // เรียกใช้การตั้งค่าการเข้ารหัสเพื่อยกเลิกการเปลี่ยนแปลงขนาดและตำแหน่ง
        g2.setTransform(new AffineTransform());

    }
}

final class UtilityFunction {
    private static Graphics g;
    private static ArrayList<Integer> fireworkRGBColor = new ArrayList<>();
    // set Graphics in this class not null
    public static void setupUtilityFunction(Graphics2D graphics){
        g = graphics;
        g.fillRect(0, 0, 600,600);
    }
    // set FireWork Color use in FloodFill
    public static void setFireWorkRGBColor(Color[] allColors){
        for(Color color : allColors){
            fireworkRGBColor.add(color.getRGB());
        }
    }
    // default coler (black) for drawLine method
    public static void drawLine(int x1,int y1,int x2,int y2,int size){
        drawLine(x1, y1, x2, y2,size,Color.BLACK);
    }

    //
    public static void drawLine(int x1,int y1,int x2,int y2){
        drawLine(x1, y1, x2, y2,1,Color.BLACK);
    }

    // drawLine Use Bresenham Algorithm
    public static void drawLine(int x1,int y1,int x2,int y2,int size,Color c){
        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;
        if(dy > dx){
            double temp = dx;
            dx = dy;
            dy = temp;
            isSwap = true;
        }
        double D = 2 * dy - dx;
        int x = x1;
        int y = y1;
        for(int i = 1;i <= dx;i++){
            plot(x, y, c, size);
            if(D >= 0){
                if(isSwap) x += sx;
                else y += sy;

                D -= 2 * dx;
            }
            if(isSwap) y += sy;
            else x += sx;

            D += 2 * dy;
        }
    }

    // default color (black) for drawCurve method
    public static void drawCurve(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int size){
        drawCurve(x1, y1, x2, y2, x3, y3, x4, y4, size, Color.BLACK);
    }
    // drawCurve Use BezierCurve Algorithm
    public static void drawCurve(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,int size,Color c){
        for(double t = 0;t <= 1;t += 0.001){
            int x = (int)(Math.pow(1 - t,3)*x1 + 3*t*Math.pow(1 - t,2)*x2 + 3*t*t*(1 - t)*x3 + Math.pow(t, 3)*x4);
            int y = (int)(Math.pow(1 - t,3)*y1 + 3*t*Math.pow(1 - t,2)*y2 + 3*t*t*(1 - t)*y3 + Math.pow(t, 3)*y4);
            plot(x, y,c,size);
        }
    }
    // default color (black) for drawSquare method
    public static void drawSquare(int size,int ...xy){
        drawSquare(Color.BLACK,size,xy);
    }
    // drawSquare use drawLine Method implementation
    // xy Array of point {(x,y),(x1,y1),(x2,y2),...(xn,yn)}
    public static void drawSquare(Color c,int size,int ...xy){
        if(xy.length % 2 == 1) return; // x and y are not equal.
        for(int i = 0;i < xy.length - 3;i+=2){
            drawLine(xy[i], xy[i + 1], xy[i + 2], xy[i + 3], size, c);
        }
        drawLine(xy[xy.length - 2], xy[xy.length - 1],xy[0],xy[1], size, c);
    }
    // default color(black) and size = 1 for drawPolyline
    public static void drawPolyline(int ...xy){
        drawPolyline(Color.BLACK,1, xy);
    }
    // drawPolyline use drawLine Method implementation 
    public static void drawPolyline(Color c,int size,int ...xy){
        if(xy.length % 2 == 1) return; // x and y are not equal.
        for(int i = 0;i < xy.length - 3;i+=2){
            drawLine(xy[i], xy[i + 1], xy[i + 2], xy[i + 3], size, c);
        }
    }
    // draw Cicle use default colot (black)
    public static void drawCircle(int centerX,int centerY,int radius,int size){
        drawCircle(centerX, centerY, radius,size,Color.black);
    }
    // midpoint circle algorithm
    // draw Cicle (use Chat-Gpt version)
    public static void drawCircle(int centerX, int centerY, int radius,int size,Color c) {
        int x = radius;
        int y = 0;
        int radiusError = 1 - x;
        centerY += 100;
        while (x >= y) {
            plot(centerX + x, centerY - y,c,size);
            plot(centerX - x, centerY - y,c,size);
            plot(centerX + x, centerY + y,c,size);
            plot(centerX - x, centerY + y,c,size);
            plot(centerX + y, centerY - x,c,size);
            plot(centerX - y, centerY - x,c,size);
            plot(centerX + y, centerY + x,c,size);
            plot(centerX - y, centerY + x,c,size);

            y++;

            if (radiusError < 0) {
                radiusError += 2 * y + 1;
            } else {
                x--;
                radiusError += 2 * (y - x) + 1;
            }
        }
    }
    // draw Cicle only 6 Octants use in moon shadow
    public static void drawHalfCircle(int centerX, int centerY, int radius,int size,Color c) {
        int x = radius;
        int y = 0;
        int radiusError = 1 - x;

        while (x >= y) {
            plot(centerX + x, centerY - y,c,size);
            plot(centerX - x, centerY - y,c,size);
            plot(centerX + x, centerY + y,c,size);
            plot(centerX - x, centerY + y,c,size);
            plot(centerX + y, centerY + x,c,size);
            plot(centerX - y, centerY + x,c,size);

            y++;

            if (radiusError < 0) {
                radiusError += 2 * y + 1;
            } else {
                x--;
                radiusError += 2 * (y - x) + 1;
            }
        }
    }
    public static void drawmiddleElipse(int xc,int yc,int a,int b,int size){
        drawmiddleElipse(xc,yc,a,b,size,Color.black);
    }

    // midpoint ellipses algorithm
    public static void drawmiddleElipse(int xc,int yc,int a,int b,int size,Color c){
        int a2 = a*a , b2 = b*b;
        int twoA2 = 2*a2, twoB2 = 2 * b2;

        // REGION 1
        int x = 0;
        int y = b;
        int D = (int)Math.round(b2 - a2*b + a2/4);
        int Dx = 0, Dy = twoA2 * y;
        while(Dx <= Dy){
            plot(x + xc,y + yc,c,size);
            plot(x + xc,-y + yc,c,size);
            plot(-x + xc,-y +yc,c,size);
            plot(-x + xc,y + yc,c,size);
            x++;
            Dx += twoB2;
            D += Dx + b2;
            if(D >= 0){
                y--;
                Dy -= twoA2;
                D -= Dy;
            }
        }
        //REDION 2
        x = a;
        y = 0;
        D = (int)Math.round(a2 - b2*a + b2/4);
        Dx = twoB2*x;
        Dy = 0;
        while(Dx >= Dy){
            plot(x + xc,y + yc,c,size);
            plot(x + xc,-y + yc,c,size);
            plot(-x + xc,-y +yc,c,size);
            plot(-x + xc,y + yc,c,size);
            y++;
            Dy += twoA2;
            D += Dy + a2;
            if(D >= 0){
                x--;
                Dx -= twoB2;
                D -= Dx;
            }
        }
    }

    // FloodFill
    public static BufferedImage Floodfill(BufferedImage m,int x,int y,Color target_color,Color replacement_color){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        m.setRGB(x, y, replacement_color.getRGB());
        while(!q.isEmpty()){
            Point p = q.poll();
            // w
            if(p.y - 1 >= 0 && m.getRGB(p.x , p.y - 1) == target_color.getRGB()){
                m.setRGB(p.x, p.y - 1, replacement_color.getRGB());
                q.add(new Point(p.x, p.y - 1));
            }
            // e
            if(p.y + 1 <= 600 && m.getRGB(p.x , p.y + 1) == target_color.getRGB()){
                m.setRGB(p.x, p.y + 1, replacement_color.getRGB());
                q.add(new Point(p.x, p.y + 1));
            }
            // n
            if(p.x - 1 >= 0 && m.getRGB(p.x - 1, p.y) == target_color.getRGB()){
                m.setRGB(p.x - 1,p.y, replacement_color.getRGB());
                q.add(new Point(p.x - 1, p.y));
            }
            // s
            if(p.x + 1 <= 600 && m.getRGB(p.x + 1, p.y) == target_color.getRGB()){
                m.setRGB(p.x + 1,p.y, replacement_color.getRGB());
                q.add(new Point(p.x + 1, p.y));
            }
        }
        return m;
    }
    // Floodfill use only unknown background color
    // use border_color to exit loop
    public static BufferedImage FloodfillUpgrade(BufferedImage m,int x,int y,Color border_color,Color replacement_color){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        m.setRGB(x, y, replacement_color.getRGB());
        while(!q.isEmpty()){
            Point current = q.poll();
            // w
            if(current.y - 1 >= 0 && m.getRGB(current.x , current.y - 1) != border_color.getRGB() && m.getRGB(current.x , current.y - 1) != replacement_color.getRGB()){
                m.setRGB(current.x, current.y - 1, replacement_color.getRGB());
                q.add(new Point(current.x, current.y - 1));
            }
            // e
            if(current.y + 1 <= 600 && m.getRGB(current.x , current.y + 1) != border_color.getRGB() && m.getRGB(current.x , current.y + 1) != replacement_color.getRGB()){
                m.setRGB(current.x, current.y + 1, replacement_color.getRGB());
                q.add(new Point(current.x, current.y + 1));
            }
            // n
            if(current.x - 1 >= 0 && m.getRGB(current.x - 1, current.y) != border_color.getRGB() && m.getRGB(current.x - 1 , current.y) != replacement_color.getRGB()){
                m.setRGB(current.x - 1,current.y, replacement_color.getRGB());
                q.add(new Point(current.x - 1, current.y));
            }
            // s
            if(current.x + 1 <= 600 && m.getRGB(current.x + 1, current.y) != border_color.getRGB() && m.getRGB(current.x + 1 , current.y) != replacement_color.getRGB()){
                m.setRGB(current.x + 1,current.y, replacement_color.getRGB());
                q.add(new Point(current.x + 1, current.y));
            }
        }
        return m;
    }
    // floodfill แต่ไล่สีในแนวตั้ง
    public static BufferedImage floodFillGradient(BufferedImage m ,int xStart, int yStart, int xEnd, int yEnd,Color startColor, Color endColor, Color target) {
        Queue<Point> q = new LinkedList<>();

        float ratio = (float) (yStart - yStart) / (yEnd - yStart - 1);

        Color lineColor = interpolateColor(startColor, endColor, ratio);
        Color lineColor1 = interpolateColor(startColor, endColor, ratio);
        Color lineColor2 = interpolateColor(startColor, endColor, ratio);

        if (m.getRGB(xStart, yStart) != target.getRGB()) {
            plot(xStart, yStart,lineColor, 1);
            q.add(new Point(xStart, yStart));
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            ratio = (float) (p.y - yStart) / (yEnd - yStart - 1);
            lineColor = interpolateColor(startColor, endColor, ratio);

            // y-1
            ratio = (float) (p.y - yStart - 1) / (yEnd - yStart - 1);
            lineColor1 = interpolateColor(startColor, endColor, ratio);

            // y+1
            ratio = (float) (p.y - yStart + 1) / (yEnd - yStart - 1);
            lineColor2 = interpolateColor(startColor, endColor, ratio);

            // s
            if (p.y + 1 < 600 && (m.getRGB(p.x, p.y + 1) != target.getRGB()) &&  (!fireworkRGBColor.contains(m.getRGB(p.x, p.y + 1)))) {
                if (m.getRGB(p.x, p.y + 1) != lineColor2.getRGB()) {
                    //plot(p.x, p.y + 1,lineColor2, 1);
                    m.setRGB(p.x,p.y + 1,lineColor2.getRGB());
                    q.add(new Point(p.x, p.y + 1));
                }
            }
            // n
            if (p.y - 1 > 0 && (m.getRGB(p.x, p.y - 1) != target.getRGB()) && (!fireworkRGBColor.contains(m.getRGB(p.x, p.y - 1)))) {
                if (m.getRGB(p.x, p.y - 1) != lineColor1.getRGB()) {
                    //plot(p.x, p.y - 1,lineColor1, 1);
                    m.setRGB(p.x,p.y - 1,lineColor1.getRGB());
                    q.add(new Point(p.x, p.y - 1));
                }
            }
            // e
            if (p.x + 1 < 600 && (m.getRGB(p.x + 1, p.y) != target.getRGB()) && (!fireworkRGBColor.contains(m.getRGB(p.x + 1, p.y)))) {
                if (m.getRGB(p.x + 1, p.y) != lineColor.getRGB()) {
                    //plot(p.x + 1, p.y,lineColor,1);
                    m.setRGB(p.x + 1,p.y,lineColor.getRGB());
                    q.add(new Point(p.x + 1, p.y));
                }
            }
            // w
            if (p.x - 1 > 0 && (m.getRGB(p.x - 1, p.y) != target.getRGB()) && (!fireworkRGBColor.contains(m.getRGB(p.x - 1, p.y)))) {
                if (m.getRGB(p.x - 1, p.y) != lineColor.getRGB()) {
                    //plot(p.x - 1, p.y, lineColor,1);
                    m.setRGB(p.x - 1,p.y,lineColor.getRGB());
                    q.add(new Point(p.x - 1, p.y));
                }
            }
        }
        return m;
    }
     // floodfill แต่ไล่สีในแนวนอน
    public static BufferedImage floodFillGradienthorizontal(BufferedImage m,int xStart, int yStart, int xEnd, int yEnd, Color startColor, Color endColor, Color target) {
        Queue<Point> q = new LinkedList<>();

        float ratio = (float) (xStart - xStart) / (xEnd - xStart - 1);

        Color lineColor = interpolateColor(startColor, endColor, ratio);
        Color lineColor1 = interpolateColor(startColor, endColor, ratio);
        Color lineColor2 = interpolateColor(startColor, endColor, ratio);

        if (m.getRGB(xStart, yStart) != target.getRGB()) {
            plot(xStart, yStart,lineColor, 1);
            q.add(new Point(xStart, yStart));
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            ratio = (float) (p.x - xStart) / (xEnd - xStart - 1);
            lineColor = interpolateColor(startColor, endColor, ratio);

            // x-1
            ratio = (float) (p.x - xStart - 1) / (xEnd - xStart - 1);
            lineColor1 = interpolateColor(startColor, endColor, ratio);

            // x+1
            ratio = (float) (p.x - xStart + 1) / (xEnd - xStart - 1);
            lineColor2 = interpolateColor(startColor, endColor, ratio);

            // s
            if (p.y + 1 < 600 && (m.getRGB(p.x, p.y + 1) != target.getRGB())) {
                if (m.getRGB(p.x, p.y + 1) != lineColor.getRGB()) {
                    //plot(p.x, p.y + 1,lineColor2, 1);
                    m.setRGB(p.x,p.y + 1,lineColor.getRGB());
                    q.add(new Point(p.x, p.y + 1));
                }
            }
            // n
            if (p.y - 1 > 0 && (m.getRGB(p.x, p.y - 1) != target.getRGB())) {
                if (m.getRGB(p.x, p.y - 1) != lineColor.getRGB()) {
                    //plot(p.x, p.y - 1,lineColor1, 1);
                    m.setRGB(p.x,p.y - 1,lineColor.getRGB());
                    q.add(new Point(p.x, p.y - 1));
                }
            }
            // e
            if (p.x + 1 < 600 && (m.getRGB(p.x + 1, p.y) != target.getRGB())) {
                if (m.getRGB(p.x + 1, p.y) != lineColor2.getRGB()) {
                    //plot(p.x + 1, p.y,lineColor,1);
                    m.setRGB(p.x + 1,p.y,lineColor2.getRGB());
                    q.add(new Point(p.x + 1, p.y));
                }
            }
            // w
            if (p.x - 1 > 0 && (m.getRGB(p.x - 1, p.y) != target.getRGB())) {
                if (m.getRGB(p.x - 1, p.y) != lineColor1.getRGB()) {
                    //plot(p.x - 1, p.y, lineColor,1);
                    m.setRGB(p.x - 1,p.y,lineColor1.getRGB());
                    q.add(new Point(p.x - 1, p.y));
                }
            }
        }
        return m;
    }

    // เลือกสีที่จะอยู่ระหว่่าง startColor กับ endColors
    private static Color interpolateColor(Color startColor, Color endColor, float ratio) {
        int red = Math.max(0, Math.min(255, (int) (startColor.getRed() * (1 - ratio) +
                        endColor.getRed() * ratio)));
        int green = Math.max(0, Math.min(255, (int) (startColor.getGreen() * (1 - ratio) +
                        endColor.getGreen() * ratio)));
        int blue = Math.max(0, Math.min(255, (int) (startColor.getBlue() * (1 - ratio) +
                        endColor.getBlue() * ratio)));
        return new Color(red, green, blue);
    }

    // plot dot(vertex) at (x,y)
    public static void plot(int x,int y,Color c,int size){
        g.setColor(c);
        g.fillRect(x, y, size,size);
    }
}