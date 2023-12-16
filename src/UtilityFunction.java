package src;

import java.awt.*;

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
    public static void drawCurve(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int size,Color c) {
        for (double t = 0; t <= 1; t += 0.01) {
            int x = (int) (Math.pow(1 - t, 3) * x1 + 3 * Math.pow(1 - t, 2) * t * x2
                    + 3 * (1 - t) * t * t * x3 + Math.pow(t, 3) * x4);
    
            int y = (int) (Math.pow(1 - t, 3) * y1 + 3 * Math.pow(1 - t, 2) * t * y2
                    + 3 * (1 - t) * t * t * y3 + Math.pow(t, 3) * y4);
    
            int nextX = (int) (Math.pow(1 - (t + 0.01), 3) * x1 + 3 * Math.pow(1 - (t + 0.01), 2) * (t + 0.01) * x2
                    + 3 * (1 - (t + 0.01)) * (t + 0.01) * (t + 0.01) * x3 + Math.pow((t + 0.01), 3) * x4);
    
            int nextY = (int) (Math.pow(1 - (t + 0.01), 3) * y1 + 3 * Math.pow(1 - (t + 0.01), 2) * (t + 0.01) * y2
                    + 3 * (1 - (t + 0.01)) * (t + 0.01) * (t + 0.01) * y3 + Math.pow((t + 0.01), 3) * y4);
    
            drawLine(x,y,nextX, nextY,size,c);
        }
    }
    // default color (black) for drawSquare method
    public static void drawSquare(int x1,int y1,int x2,int y2,int size){
        drawSquare(x1, y1, x2, y2, size,Color.BLACK);
    }
    // drawSquare use drawLine Method implementation
    // Point1 (x1,y1) is upper left corner of the square
    // Point2 (x2,y2) is lower right corner of the square
    public static void drawSquare(int x1,int y1,int x2,int y2,int size,Color c){
        drawLine(x1, y1, x1, y2, size,c);
        drawLine(x2, y1, x2, y2, size,c);
        drawLine(x1, y1, x2, y1, size,c);
        drawLine(x1, y2, x2, y2, size,c);
    }
    
    private static void plot(int x,int y,Color c,int size){
        g.setColor(c);
        g.fillRect(x, y, size,size);
    }
}
