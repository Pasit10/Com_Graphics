package src;

import javax.swing.*;
import java.awt.*;

public class GraphicsSwing extends JPanel {
    public void paintComponent(Graphics g) {
        UtilityFunction.setGraphice(g);
        drawStructure();
        drawHouse();

        drawHouse2();
        drawBackLine();
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

    private void drawHouse2(){
        UtilityFunction.drawSquare(1, 332,465,370,446,380,454,341,473);
        // หลังแรก
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
        
        //หลังสอง
        UtilityFunction.drawLine(462,509,462,475,1);
        UtilityFunction.drawLine(462,475,490,457,1);
        UtilityFunction.drawLine(480,463,480,441,1);
        UtilityFunction.drawSquare(1, 480,441,517,441,521,433,488,433);
        UtilityFunction.drawSquare(1, 492,449,500,449,500,458,492,458);
        UtilityFunction.drawSquare(1, 473,474,481,474,481,483,473,483);
        UtilityFunction.drawSquare(1,491,465,532,443,562,460,529,487);
        UtilityFunction.drawLine(517,441,517,451,1);
        UtilityFunction.drawSquare(1, 518,441,543,430,548,435,522,445);
        UtilityFunction.drawSquare(1, 537,487,542,487,542,502,537,502);
        UtilityFunction.drawSquare(1, 543,483,548,483,548,498,543,498);
        UtilityFunction.drawSquare(1,548,480,553,480,553,496,548,496);

        UtilityFunction.drawSquare(1, 562,438,585,439,579,455,553,449);
    }

    private void drawBackLine(){
        int setx = 18;
        UtilityFunction.drawCurve(600 - setx,425,589 - setx,435,588 - setx,425,588 - setx,411,1);
        // tree 1
            UtilityFunction.drawLine(596 -setx,427,596 -setx,413,1);
            UtilityFunction.drawLine(596 - setx,413,592 -setx,401,1);
            UtilityFunction.drawCurve(596 - setx,419 ,597 - setx,414 ,598 -setx,414,600 -setx ,415,1);
            UtilityFunction.drawCurve(594 - setx,412,596 - setx,405,598 - setx,402,600 - setx,404,1);
            UtilityFunction.drawCurve(596 - setx,419,592 - setx,421,594 - setx,419,593 - setx,415,1);
        //
        UtilityFunction.drawLine(588 - setx,411,585-setx,403,1);
        UtilityFunction.drawLine(585-setx,403,582-setx,403,1);
        UtilityFunction.drawLine(582-setx,403,581-setx,410,1);
        UtilityFunction.drawLine(581-setx,410,578 - setx,410,1);
        UtilityFunction.drawCurve(578-setx,410,574 - setx,408,577 - setx,407,575 - setx,403,1);
        UtilityFunction.drawLine(575 - setx,403,571 - setx,403,1);
        UtilityFunction.drawCurve(571-setx,403,572 - setx,408,569 - setx,417 ,570 - setx,421,1);
        UtilityFunction.drawCurve(570 - setx, 421,566-setx , 423, 564 - setx, 423, 563 - setx, 420, 1);
        UtilityFunction.drawLine(563 - setx,420,540 - setx,420,1);

        // tree 2
            UtilityFunction.drawSquare(1, 561 -setx,420,561 - setx,416,563 - setx,416,563 - setx,401,556 - setx,401,555 -setx,402,555-setx,416,558 -setx,416,558 - setx,420);
        //

        UtilityFunction.drawLine(540 - setx,420 , 540 - setx ,414,1);
        UtilityFunction.drawLine(540 - setx ,414,516 - setx,413,1);
        UtilityFunction.drawLine(516- setx,413,516 - setx,420,1);
        UtilityFunction.drawLine(516 - setx,420,500 - setx,420,1);
        UtilityFunction.drawCurve(500 - setx,420 ,496 - setx, 409,480 - setx,410,477 - setx,415,1);
        UtilityFunction.drawLine(477 - setx,415,477 - setx,422,1);
        UtilityFunction.drawLine(477 - setx,422,466 - setx,421,1);
    }
}
