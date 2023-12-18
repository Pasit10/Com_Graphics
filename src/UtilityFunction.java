package src;

import java.awt.*;
import java.util.ArrayList;

public final class UtilityFunction {
    private static Graphics g;
    // set Graphics in this class not null
    public static void setGraphice(Graphics graphics){
        g = graphics;
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
    // FloodFill
    public static void FloodFill(int x,int y,Color targetColor,Color replacement_colour){
        ArrayList<node> q = new ArrayList<>();

    }
    class node{
        int x,y;
        node(int x,int y){this.x = x;this.y = y;}
    }
    // plot dot(vertex) at (x,y)
    private static void plot(int x,int y,Color c,int size){
        g.setColor(c);
        g.fillRect(x, y, size,size);
    }



    // ----------------------- test space (prototype) ------------------------------------//
    public static void drawCircleUsingBezierCurve() {
        int radius = 100; // Adjust the radius as needed
        int centerX = 200; // Adjust the center X-coordinate
        int centerY = 200; // Adjust the center Y-coordinate
    
        // Calculate control points based on the circle equation
        int x1 = centerX + radius;
        int y1 = centerY;
    
        int x2 = (int)(centerX + radius * Math.cos(Math.PI / 4));
        int y2 = (int)(centerY + radius * Math.sin(Math.PI / 4));
    
        int x3 = (int)(centerX + radius * Math.cos(2 * Math.PI / 4));
        int y3 = (int)(centerY + radius * Math.sin(2 * Math.PI / 4));
    
        int x4 = centerX;
        int y4 = centerY + radius;
    
        // Call the BezierCurve method with the new control points
        BezierCurve(x1, y1, x2, y2, x3, y3, x4, y4);
    }
    
    public static void BezierCurve(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        for (double t = 0; t <= 1; t += 0.001) {
            int x = (int) (Math.pow(1 - t, 3) * x1 + 3 * t * Math.pow(1 - t, 2) * x2
                    + 3 * t * t * (1 - t) * x3 + Math.pow(t, 3) * x4);
            int y = (int) (Math.pow(1 - t, 3) * y1 + 3 * t * Math.pow(1 - t, 2) * y2
                    + 3 * t * t * (1 - t) * y3 + Math.pow(t, 3) * y4);
            plot(x, y,Color.black,1);
        }
    }

    public static void drawCircle(int centerX, int centerY, int radius) {
        int x = radius;
        int y = 0;
        int radiusError = 1 - x;
    
        while (x >= y) {
            plot(centerX + x, centerY - y,Color.black,1);
            plot(centerX - x, centerY - y,Color.black,1);
            plot(centerX + x, centerY + y,Color.black,1);
            plot(centerX - x, centerY + y,Color.black,1);
            plot(centerX + y, centerY - x,Color.black,1);
            plot(centerX - y, centerY - x,Color.black,1);
            plot(centerX + y, centerY + x,Color.black,1);
            plot(centerX - y, centerY + x,Color.black,1);
    
            y++;
    
            if (radiusError < 0) {
                radiusError += 2 * y + 1;
            } else {
                x--;
                radiusError += 2 * (y - x) + 1;
            }
        }
    }
}
