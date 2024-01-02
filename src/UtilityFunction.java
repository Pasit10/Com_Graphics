package src;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public final class UtilityFunction {
    private static Graphics g;
    private static BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
    private static Graphics2D g2 = buffer.createGraphics();
    private static ArrayList<Integer> fireworkRGBColor = new ArrayList<>();
    // set Graphics in this class not null
    public static void setGraphice(Graphics graphics){
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600,600);
        g = graphics;
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
    // drawLine Use Bresenham Algorithm
    public static void drawLine(int x1,int y1,int x2,int y2,int size,Color c){
        y1 -= 40; y2 -= 40; // custom for java JFrame
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
        y1 -= 40; y2 -= 40; y3 -= 40;y4 -= 40;// custom for java JFrame
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
    // draw Cicle
    public static void drawCircle(int centerX,int centerY,int radius,int size){
        drawCircle(centerX, centerY, radius,size,Color.black);
    }
    // draw Cicle (use Chat-Gpt)
    public static void drawCircle(int centerX, int centerY, int radius,int size,Color c) {
        int x = radius;
        int y = 0;
        centerY-=30;
        int radiusError = 1 - x;

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
    // draw Cicle only 6 Octants
    public static void drawHalfCircle(int centerX, int centerY, int radius,int size,Color c) {
        int x = radius;
        int y = 0;
        centerY-=30;
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

    // FloodFill
    public static void Floodfill(int x,int y,Color target_color,Color replacement_color){
        y-= 40;
        ArrayList<node> q = new ArrayList<>();
        q.add(new node(x, y));
        buffer.setRGB(x, y, replacement_color.getRGB());
        while(!q.isEmpty()){
            node current = q.remove(0);
            if(current.y - 1 >= 0 && buffer.getRGB(current.x , current.y - 1) == target_color.getRGB()){
                buffer.setRGB(current.x, current.y - 1, replacement_color.getRGB());
                q.add(new node(current.x, current.y - 1));
            }
            if(current.y + 1 <= 600 && buffer.getRGB(current.x , current.y + 1) == target_color.getRGB()){
                buffer.setRGB(current.x, current.y + 1, replacement_color.getRGB());
                q.add(new node(current.x, current.y + 1));
            }
            if(current.x - 1 >= 0 && buffer.getRGB(current.x - 1, current.y) == target_color.getRGB()){
                buffer.setRGB(current.x - 1,current.y, replacement_color.getRGB());
                q.add(new node(current.x - 1, current.y));
            }
            if(current.x + 1 <= 600 && buffer.getRGB(current.x + 1, current.y) == target_color.getRGB()){
                buffer.setRGB(current.x + 1,current.y, replacement_color.getRGB());
                q.add(new node(current.x + 1, current.y));
            }
        }
        g.drawImage(buffer, 0,0,null);
    }
    // Floodfill use only unknow background color
    public static void FloodfillUpgrade(int x,int y,Color border_color,Color replacement_color){
        y-= 40;
        ArrayList<node> q = new ArrayList<>();
        q.add(new node(x, y));
        buffer.setRGB(x, y, replacement_color.getRGB());
        while(!q.isEmpty()){
            node current = q.remove(0);
            if(current.y - 1 >= 0 && buffer.getRGB(current.x , current.y - 1) != border_color.getRGB() && buffer.getRGB(current.x , current.y - 1) != replacement_color.getRGB()){
                buffer.setRGB(current.x, current.y - 1, replacement_color.getRGB());
                q.add(new node(current.x, current.y - 1));
            }
            if(current.y + 1 <= 600 && buffer.getRGB(current.x , current.y + 1) != border_color.getRGB() && buffer.getRGB(current.x , current.y + 1) != replacement_color.getRGB()){
                buffer.setRGB(current.x, current.y + 1, replacement_color.getRGB());
                q.add(new node(current.x, current.y + 1));
            }
            if(current.x - 1 >= 0 && buffer.getRGB(current.x - 1, current.y) != border_color.getRGB() && buffer.getRGB(current.x - 1 , current.y) != replacement_color.getRGB()){
                buffer.setRGB(current.x - 1,current.y, replacement_color.getRGB());
                q.add(new node(current.x - 1, current.y));
            }
            if(current.x + 1 <= 600 && buffer.getRGB(current.x + 1, current.y) != border_color.getRGB() && buffer.getRGB(current.x + 1 , current.y) != replacement_color.getRGB()){
                buffer.setRGB(current.x + 1,current.y, replacement_color.getRGB());
                q.add(new node(current.x + 1, current.y));
            }
        }
        g.drawImage(buffer, 0,0,null);
    }
    private static class node{
        int x,y;
        node(int x,int y){this.x = x;this.y = y;}
    }
    // floodfill แต่ไล่สีในแนวตั้ง
    public static void floodFillGradient(int xStart, int yStart, int xEnd, int yEnd,Color startColor, Color endColor, Color target) {
        Queue<Point> q = new LinkedList<>();

        float ratio = (float) (yStart - yStart) / (yEnd - yStart - 1);

        Color lineColor = interpolateColor(startColor, endColor, ratio);
        Color lineColor1 = interpolateColor(startColor, endColor, ratio);
        Color lineColor2 = interpolateColor(startColor, endColor, ratio);

        if (buffer.getRGB(xStart, yStart) != target.getRGB()) {
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
            if (p.y + 1 < 600 && (buffer.getRGB(p.x, p.y + 1) != target.getRGB()) &&  (!fireworkRGBColor.contains(buffer.getRGB(p.x, p.y + 1)))) {
                if (buffer.getRGB(p.x, p.y + 1) != lineColor2.getRGB()) {
                    //plot(p.x, p.y + 1,lineColor2, 1);
                    buffer.setRGB(p.x,p.y + 1,lineColor2.getRGB());
                    q.add(new Point(p.x, p.y + 1));
                }
            }
            // n
            if (p.y - 1 > 0 && (buffer.getRGB(p.x, p.y - 1) != target.getRGB()) && (!fireworkRGBColor.contains(buffer.getRGB(p.x, p.y - 1)))) {
                if (buffer.getRGB(p.x, p.y - 1) != lineColor1.getRGB()) {
                    //plot(p.x, p.y - 1,lineColor1, 1);
                    buffer.setRGB(p.x,p.y - 1,lineColor1.getRGB());
                    q.add(new Point(p.x, p.y - 1));
                }
            }
            // e
            if (p.x + 1 < 600 && (buffer.getRGB(p.x + 1, p.y) != target.getRGB()) && (!fireworkRGBColor.contains(buffer.getRGB(p.x + 1, p.y)))) {
                if (buffer.getRGB(p.x + 1, p.y) != lineColor.getRGB()) {
                    //plot(p.x + 1, p.y,lineColor,1);
                    buffer.setRGB(p.x + 1,p.y,lineColor.getRGB());
                    q.add(new Point(p.x + 1, p.y));
                }
            }
            // w
            if (p.x - 1 > 0 && (buffer.getRGB(p.x - 1, p.y) != target.getRGB()) && (!fireworkRGBColor.contains(buffer.getRGB(p.x - 1, p.y)))) {
                if (buffer.getRGB(p.x - 1, p.y) != lineColor.getRGB()) {
                    //plot(p.x - 1, p.y, lineColor,1);
                    buffer.setRGB(p.x - 1,p.y,lineColor.getRGB());
                    q.add(new Point(p.x - 1, p.y));
                }
            }
        }
        g.drawImage(buffer, 0,0,null);
    }
     // floodfill แต่ไล่สีในแนวนอน
    public static void floodFillGradienthorizontal(int xStart, int yStart, int xEnd, int yEnd, Color startColor, Color endColor, Color target) {
        Queue<Point> q = new LinkedList<>();

        float ratio = (float) (xStart - xStart) / (xEnd - xStart - 1);

        Color lineColor = interpolateColor(startColor, endColor, ratio);
        Color lineColor1 = interpolateColor(startColor, endColor, ratio);
        Color lineColor2 = interpolateColor(startColor, endColor, ratio);

        if (buffer.getRGB(xStart, yStart) != target.getRGB()) {
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
            if (p.y + 1 < 600 && (buffer.getRGB(p.x, p.y + 1) != target.getRGB())) {
                if (buffer.getRGB(p.x, p.y + 1) != lineColor.getRGB()) {
                    //plot(p.x, p.y + 1,lineColor2, 1);
                    buffer.setRGB(p.x,p.y + 1,lineColor.getRGB());
                    q.add(new Point(p.x, p.y + 1));
                }
            }
            // n
            if (p.y - 1 > 0 && (buffer.getRGB(p.x, p.y - 1) != target.getRGB())) {
                if (buffer.getRGB(p.x, p.y - 1) != lineColor.getRGB()) {
                    //plot(p.x, p.y - 1,lineColor1, 1);
                    buffer.setRGB(p.x,p.y - 1,lineColor.getRGB());
                    q.add(new Point(p.x, p.y - 1));
                }
            }
            // e
            if (p.x + 1 < 600 && (buffer.getRGB(p.x + 1, p.y) != target.getRGB())) {
                if (buffer.getRGB(p.x + 1, p.y) != lineColor2.getRGB()) {
                    //plot(p.x + 1, p.y,lineColor,1);
                    buffer.setRGB(p.x + 1,p.y,lineColor2.getRGB());
                    q.add(new Point(p.x + 1, p.y));
                }
            }
            // w
            if (p.x - 1 > 0 && (buffer.getRGB(p.x - 1, p.y) != target.getRGB())) {
                if (buffer.getRGB(p.x - 1, p.y) != lineColor1.getRGB()) {
                    //plot(p.x - 1, p.y, lineColor,1);
                    buffer.setRGB(p.x - 1,p.y,lineColor1.getRGB());
                    q.add(new Point(p.x - 1, p.y));
                }
            }
        }
        g.drawImage(buffer, 0,0,null);
    }


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
    private static void plot(int x,int y,Color c,int size){
        g2.setColor(c);
        g2.fillRect(x, y, size,size);
    }
}