import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class BezierCircle extends JFrame {

    public BezierCircle() {
        super("Bezier Circle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 100;

        drawBezierCircle(g2d, centerX, centerY, radius);
    }

    private void drawBezierCircle(Graphics2D g2d, int centerX, int centerY, int radius) {
        Path2D path = new Path2D.Float();

        // Move to starting point
        path.moveTo(centerX + radius, centerY);

        // Set control points for the Bezier curve
        double controlX1 = centerX + radius;
        double controlY1 = centerY - radius * 0.55;
        double controlX2 = centerX - radius;
        double controlY2 = centerY - radius * 0.55;

        // Draw the Bezier curve
        path.curveTo(controlX1, controlY1, controlX2, controlY2, centerX - radius, centerY);
        path.curveTo(controlX2, centerY + radius * 0.55, controlX1, centerY + radius * 0.55, centerX + radius, centerY);

        // Close the path
        path.closePath();

        // Draw the path
        g2d.draw(path);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BezierCircle());
    }
}
