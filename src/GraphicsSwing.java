package src;

import javax.swing.*;
import java.awt.*;

public class GraphicsSwing extends JPanel {
    public void paintComponent(Graphics g) {
        UtilityFunction.setGraphice(g);
        drawStructure();
        drawHouse();
        
        drawHouse2();
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
        UtilityFunction.drawSquare(1, 66,455,74,455,74,462,66,462);

        //บ้าน 4
        UtilityFunction.drawLine(82, 435, 102, 428, 1);
        UtilityFunction.drawLine(102, 428, 120, 435, 1);
        UtilityFunction.drawLine(120, 435, 120, 471, 1);
        UtilityFunction.drawLine(120, 445, 120, 471, 1);
        UtilityFunction.drawLine(91, 441, 105, 441, 1);
        UtilityFunction.drawLine(105, 441, 120, 448, 1);

        //บ้าน 5
        UtilityFunction.drawLine(120, 445, 141, 431, 1);
        UtilityFunction.drawLine(141, 431, 159, 431, 1);
        UtilityFunction.drawLine(159, 431, 159, 448, 1);
        UtilityFunction.drawLine(120, 450, 137, 450, 1);
        UtilityFunction.drawLine(137, 450, 137, 485, 1);

        //บ้าน 6
        UtilityFunction.drawLine(166, 459, 177, 446, 1);
        UtilityFunction.drawLine(177, 446, 213, 452, 1);
        UtilityFunction.drawLine(213, 452,193,472, 1);
        UtilityFunction.drawLine(193, 472, 166, 459, 1);

        //บ้าน 7
        UtilityFunction.drawLine(163, 489, 228, 454, 1);
        UtilityFunction.drawLine(228, 454, 270, 465, 1);
        UtilityFunction.drawLine( 270, 465,215,503, 1);
        UtilityFunction.drawLine(215, 503, 163, 489, 1);

        //บ้าน 8
        UtilityFunction.drawLine(236, 451, 253, 438, 1);
        UtilityFunction.drawLine(253, 438, 296, 442, 1); // ต้องรอเส้นโค้งก่อน

        UtilityFunction.drawSquare(1,285,455,293,455,293,464,285,464);


        //เรือ
        UtilityFunction.drawSquare(1, 447,356,447,364,447,364,450,366,450,366,487,366,487,366,491,355,491,355,487,353,487, 353,
        486, 355,486, 355 ,475, 355,475, 355 ,475, 351,475, 351 ,463, 351,463, 351 ,463, 355,463, 355 ,457, 355,457, 355 ,457, 351,457, 351,
        451, 351,451, 351 ,451, 355,451, 355 ,447, 356);
        
        
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
        UtilityFunction.drawLine(0, 575, 600, 575, 1);
    }

    private void drawHouse2(){
        UtilityFunction.drawSquare(1, 332,465,370,446,380,454,341,473);

        UtilityFunction.drawLine(352,473, 352, 509,1);
        UtilityFunction.drawSquare(1, 352,473,396,457,403,457,408,462,408,468,402,463,363,480);
        UtilityFunction.drawLine(364,480,364,509,1);
        UtilityFunction.drawLine(368,478,368,509,1);
        UtilityFunction.drawSquare(1, 370,479,373,479,373,487,370,487);
        UtilityFunction.drawSquare(1, 375,478,378,478,378,486,375,486);
        UtilityFunction.drawSquare(1, 380,477,383,477,383,484,380,484);
        UtilityFunction.drawSquare(1, 369,493,410,474,408,461,420,444,432,457,432,479,374,498); // fix (ยังไม่แก้)
        UtilityFunction.drawLine(432,478,454,478,1);
        UtilityFunction.drawLine(454,478,454,509,1);

        // window
        for(int i = 1;i <= 16;i+=6){
            UtilityFunction.drawSquare(1,386 + i,496,390 + i,496,390 + i,505,386 + i,505);
        }

    }
}
