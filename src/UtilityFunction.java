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
    // plot dot(vertex) at (x,y)
    private static void plot(int x,int y,Color c,int size){
        g.setColor(c);
        g.fillRect(x, y, size,size);
    }







    // ----------------------- test space (prototype) ------------------------------------//
    public static void drawBezierCircle(Graphics2D g, double centerX, double centerY, double radius) {
        double controlPointOffset = radius * 4 * (Math.sqrt(2) - 1) / 3;

        // Define control points for each quarter
        // Point2D p1 = new Point2D.Double(centerX, centerY + radius);
        // Point2D c11 = new Point2D.Double(centerX + controlPointOffset, centerY);
        // Point2D c12 = new Point2D.Double(centerX, centerY - controlPointOffset);
        // Point2D p2 = new Point2D.Double(centerX - radius, centerY);

        // Point2D p3 = new Point2D.Double(centerX - radius, centerY - radius);
        // Point2D c31 = new Point2D.Double(centerX - controlPointOffset, centerY);
        // Point2D c32 = new Point2D.Double(centerX, centerY + controlPointOffset);
        // Point2D p4 = new Point2D.Double(centerX, centerY + radius);

        // Draw each quarter as a Bezier curve
        // g.moveTo(p1.getX(), p1.getY());
        // g.curveTo(c11.getX(), c11.getY(), c12.getX(), c12.getY(), p2.getX(), p2.getY());
        // g.curveTo(c31.getX(), c31.getY(), c32.getX(), c32.getY(), p3.getX(), p3.getY());
        // g.curveTo(c32.getX(), c32.getY(), c31.getX(), c31.getY(), p4.getX(), p4.getY());
        // g.curveTo(c12.getX(), c12.getY(), c11.getX(), c11.getY(), p1.getX(), p1.getY());
        // g.closePath();

        double x1 = centerX;
        double y1 = centerY + radius;
        double x2 = centerX + controlPointOffset;
        double y2 = centerY;
        double x3 = centerX;
        double y3 = centerY - controlPointOffset;
        double x4 = centerX - radius;
        double y4 = centerY;
        drawCurve((int)x1,(int)y1,(int)x2,(int)y2,(int)x3,(int)y3,(int)x4,(int)y4, 1);

        // ยากชิบหายเลย
    }
}
