package src;

import javax.swing.*;
import java.awt.*;

public class GraphicsSwing extends JPanel {
    public void paintComponent(Graphics g) {
        UtilityFunction.setGraphice(g);
        drawStructure();
        drawHouse();
    }


    private void drawHouse(){
        UtilityFunction.drawLine(0, 448, 33, 448, 1);
        UtilityFunction.drawLine(33, 448, 33, 509, 1);
        UtilityFunction.drawLine(33, 448, 51, 431, 1);
        UtilityFunction.drawLine(51, 431, 24, 431, 1);
        UtilityFunction.drawLine(51, 431, 51, 485, 1);
        UtilityFunction.drawLine(0, 448, 24, 431, 1);

        UtilityFunction.drawLine(33, 508, 66, 469, 1);
        UtilityFunction.drawLine(66, 469, 117, 469, 1);
        UtilityFunction.drawLine(0, 448, 24, 431, 1);
        UtilityFunction.drawLine(117, 469, 147, 491, 1);
        UtilityFunction.drawLine(147, 491, 83, 491, 1);
        UtilityFunction.drawLine(83, 491, 68, 476, 1);
        UtilityFunction.drawLine(68, 476, 57, 488, 1);
        UtilityFunction.drawLine(49, 488, 58, 488, 1);

        UtilityFunction.drawLine(108, 495, 114, 495, 1);
        UtilityFunction.drawLine(114, 503, 114, 495, 1);
        UtilityFunction.drawLine(114, 503, 114, 495, 1);
        UtilityFunction.drawLine(114, 503, 108, 503, 1);
        UtilityFunction.drawLine(108, 495, 108, 503, 1);

    }


    private void drawStructure() {
        UtilityFunction.drawLine(0, 98, 600, 98, 1);
        UtilityFunction.drawLine(0, 139, 600, 139, 1);
        UtilityFunction.drawLine(0, 148, 600, 148, 1);
        UtilityFunction.drawLine(0, 347, 600, 347, 1);
        UtilityFunction.drawLine(0, 509, 600, 509, 1);
        UtilityFunction.drawLine(0, 519, 600, 519, 1);
        UtilityFunction.drawLine(0, 561, 600, 561, 1);
        UtilityFunction.drawLine(260, 562, 281, 600, 1);
        UtilityFunction.drawLine(65, 562, 78, 600, 1);
        UtilityFunction.drawLine(441, 562, 470, 600, 1);
    }
}
