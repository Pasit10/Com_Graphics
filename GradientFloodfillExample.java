import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GradientFloodfillExample extends JFrame {

    public GradientFloodfillExample() {
        super("Gradient Floodfill Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // สร้าง JPanel ที่มีการไล่เฉดสี
        GradientPanel gradientPanel = new GradientPanel();
        getContentPane().add(gradientPanel);

        // ใช้เมธอด floodfill เพื่อทำการเติมสีที่ตำแหน่ง (50, 50)
        Color targetColor = new Color(0, 0, 255);  // สีน้ำเงิน (Blue)
        Color replacementColor = new Color(255, 0, 0);  // สีแดง (Red)
        BufferedImage resultImage = floodfill(gradientPanel.getImage(), 50, 50, targetColor, replacementColor);
        gradientPanel.setImage(resultImage);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private BufferedImage floodfill(BufferedImage image, int x, int y, Color targetColor, Color replacementColor) {
        // (เมธอด floodfill จากตัวอย่างก่อนหน้า)
        // Create a copy of the original image to avoid modifying the original
        BufferedImage resultImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        resultImage.getGraphics().drawImage(image, 0, 0, null);

        // Get the target color of the pixel at coordinates (x, y)
        int targetRGB = targetColor.getRGB();

        // Get the replacement color in RGB format
        int replacementRGB = replacementColor.getRGB();

        // Check if the target color is the same as the replacement color
        if (targetRGB == replacementRGB) {
            return resultImage;
        }

        // Perform flood fill using a recursive approach
        floodfillHelper(resultImage, x, y, targetRGB, replacementRGB);

        return resultImage;
    }

    private static void floodfillHelper(BufferedImage image, int x, int y, int targetColor, int replacementColor) {
        // Check if the current pixel is within the image boundaries
        if (x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight()) {
            // Check if the color of the current pixel matches the target color
            if (image.getRGB(x, y) == targetColor) {
                // Replace the color of the current pixel with the replacement color
                image.setRGB(x, y, replacementColor);

                // Recursively perform flood fill on neighboring pixels
                floodfillHelper(image, x + 1, y, targetColor, replacementColor);
                floodfillHelper(image, x - 1, y, targetColor, replacementColor);
                floodfillHelper(image, x, y + 1, targetColor, replacementColor);
                floodfillHelper(image, x, y - 1, targetColor, replacementColor);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GradientFloodfillExample());
    }
}

class GradientPanel extends JPanel {
    private BufferedImage image;

    public GradientPanel() {
        // ไม่สร้าง BufferedImage ที่นี้
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // สร้าง BufferedImage ที่นี้เมื่อ JPanel ถูกวาด
        if (image == null || image.getWidth() != getWidth() || image.getHeight() != getHeight()) {
            image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            drawGradient(g2d);
            g2d.dispose();
        }

        // วาด BufferedImage
        g.drawImage(image, 0, 0, null);
    }

    private void drawGradient(Graphics2D g2d) {
        // สร้างไล่เฉดสี
        Color color1 = Color.BLUE;
        Color color2 = Color.GREEN;
        GradientPaint gradientPaint = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);

        // กำหนดกราฟิกส์ 2 มิติ
        g2d.setPaint(gradientPaint);

        // สร้างสี่เหลี่ยมผืนผ้าที่มีพื้นที่เต็ม JPanel
        Rectangle rect = new Rectangle(0, 0, getWidth(), getHeight());
        g2d.fill(rect);
    }
}
