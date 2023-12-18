import javax.swing.*;
import java.awt.*;

import src.*;

public class BezierCircle extends JFrame {

    public BezierCircle() {
        setTitle("Bezier Circle");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 100;
        UtilityFunction.setGraphice(g);
        drawBezierCircle(g, centerX, centerY, radius);
    }

    private void drawBezierCircle(Graphics g, int centerX, int centerY, int radius) {
        double c = 0.551915024494; // Magic constant for cubic Bezier approximation

        int controlX = (int) (radius * c);
        int controlY = (int) (radius * c);

        int[] xPoints = {
            centerX + radius, centerX + controlX, centerX,
            centerX - controlX, centerX - radius, centerX - controlX,
            centerX, centerX + controlX, centerX + radius
        };

        int[] yPoints = {
            centerY, centerY - controlY, centerY - radius,
            centerY - radius, centerY - radius, centerY - controlY,
            centerY, centerY + controlY, centerY + radius
        };

        for (int i = 0; i < xPoints.length - 1; i += 3) {
            UtilityFunction.drawCurve(xPoints[i], yPoints[i], xPoints[i + 1], yPoints[i + 1],xPoints[i + 2], yPoints[i + 2], xPoints[i + 3], yPoints[i + 3], 2);
        }
    }

    // UtilityFunction class methods go here

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BezierCircle example = new BezierCircle();
            example.setVisible(true);
        });
    }
}
