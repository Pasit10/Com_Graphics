

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Firework extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int FIREWORK_SIZE = 5;
    private static final int PARTICLE_SIZE = 2;
    private static final int PARTICLE_COUNT = 50;
    private static final int DELAY = 10;

    private final ArrayList<Particle> particles;
    private final Timer timer;

    public Firework() {
        particles = new ArrayList<>();
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                repaint();
            }
        });
        timer.start();
    }

    private void update() {
        for (Particle particle : particles) {
            particle.move();
        }

        particles.removeIf(particle -> particle.getAlpha() <= 0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Particle particle : particles) {
            g2d.setColor(particle.getColor());
            int size = particle.getSize();
            g2d.fillOval((int) particle.getX(), (int) particle.getY(), size, size);
        }
    }

    private class Particle {
        private double x;
        private double y;
        private double speed;
        private double angle;
        private int size;
        private Color color;
        private double alpha;

        public Particle(double x, double y, double speed, double angle, int size, Color color) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.angle = angle;
            this.size = size;
            this.color = color;
            this.alpha = 1.0;
        }

        public void move() {
            x += speed * Math.cos(angle);
            y -= speed * Math.sin(angle);
            speed -= 0.1;
            alpha -= 0.01;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public int getSize() {
            return size;
        }

        public Color getColor() {
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            int alphaValue = (int) (alpha * 255);
            return new Color(red, green, blue, alphaValue);
        }

        public double getAlpha() {
            return alpha;
        }
    }

    public void launchFirework(int x, int y) {
        Random random = new Random();

        for (int i = 0; i < PARTICLE_COUNT; i++) {
            double speed = random.nextDouble() * 5 + 1;
            double angle = random.nextDouble() * 2 * Math.PI;
            int size = PARTICLE_SIZE;
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            Particle particle = new Particle(x, y, speed, angle, size, color);
            particles.add(particle);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fireworks");
        Firework fireworks = new Firework();
        frame.add(fireworks);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireworks.launchFirework(evt.getX(), evt.getY());
            }
        });
        frame.setVisible(true);
    }
}

