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
        //บ้าน 1
        UtilityFunction.drawLine(0, 448, 33, 448, 1);
        UtilityFunction.drawLine(33, 448, 33, 509, 1);
        UtilityFunction.drawLine(33, 448, 51, 431, 1);
        UtilityFunction.drawLine(51, 431, 24, 431, 1);
        UtilityFunction.drawLine(51, 431, 51, 486, 1);
        UtilityFunction.drawLine(0, 448, 24, 431, 1);

        //บ้าน 2
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

        //บ้าน 3
        UtilityFunction.drawLine(51, 441, 55, 441, 1);
        UtilityFunction.drawLine(55, 441, 55, 482, 1);
        UtilityFunction.drawLine(55, 441, 75, 434, 1);
        UtilityFunction.drawLine(75, 434, 92, 441, 1);
        UtilityFunction.drawLine(92, 441, 92,469, 1);
        UtilityFunction.drawLine(55, 447, 75, 439, 1);
        UtilityFunction.drawLine(75, 439, 92, 448, 1);

        //บ้าน 4
        UtilityFunction.drawLine(82, 435, 102, 428, 1);
        UtilityFunction.drawLine(102, 428, 120, 445, 1);
        UtilityFunction.drawLine(120, 445, 120, 471, 1);

        //บ้าน 5
        UtilityFunction.drawLine(120, 445, 141, 431, 1);
        UtilityFunction.drawLine(141, 431, 159, 431, 1);
        UtilityFunction.drawLine(159, 431, 159, 448, 1);
        UtilityFunction.drawLine(120, 450, 137, 450, 1);
        UtilityFunction.drawLine(137, 450, 137, 485, 1);
        
        //ต้นไม้
        UtilityFunction.drawLine(154, 486, 154, 494, 1);
        UtilityFunction.drawLine(154, 494, 157, 494, 1);
        UtilityFunction.drawLine(157, 494, 157, 485, 1);
        UtilityFunction.drawLine(157, 485, 167, 485, 1);
        UtilityFunction.drawLine(167, 485, 168, 465, 1);
        UtilityFunction.drawLine(168, 465, 157, 446, 1);
        UtilityFunction.drawLine(157, 446, 144, 465, 1);
        UtilityFunction.drawLine(144, 465, 144, 479, 1);
        UtilityFunction.drawLine(144, 479, 147, 484, 1);
        UtilityFunction.drawLine(147, 484, 154, 484, 1);

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
