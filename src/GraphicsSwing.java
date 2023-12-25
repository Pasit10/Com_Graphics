package src;

import javax.swing.*;
import java.awt.*;

public class GraphicsSwing extends JPanel {
    public void paintComponent(Graphics g) {
        UtilityFunction.setGraphice(g);
        Structure();
        House();
        House2();
        BackLine();
        Light();
        MoonAndCircle();
        Lake();
        Boat();
    }

    private void House(){
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
        UtilityFunction.drawLine(137, 450, 159, 431, 1);

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
        UtilityFunction.drawLine(236, 451, 280, 460, 1);
        UtilityFunction.drawCurve(281,460,283,454,290,447 ,296,443,1);

        //UtilityFunction.drawSquare(1,285,455,293,455,293,464,285,464); // ต้องแก้ square
        UtilityFunction.drawSquare(1, 286,457,291,450,291,458,286,464);
        
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

    private void MoonAndCircle(){
        UtilityFunction.drawCircle(286, 230, 43);
    }

    private void Light(){
        UtilityFunction.drawCircle(105, 446, 6);
        UtilityFunction.drawCircle(126, 418, 7);
        UtilityFunction.drawCircle(176, 428, 5);
        UtilityFunction.drawCircle(214, 430, 6);
        UtilityFunction.drawCircle(250, 484, 8);
        UtilityFunction.drawCircle(303, 440, 5);
        UtilityFunction.drawCircle(422, 422, 7);
        UtilityFunction.drawCircle(478, 423, 6);
        UtilityFunction.drawCircle(543, 433, 3);
        UtilityFunction.drawCircle(561, 445, 3);
    }

    private void Structure() {
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

    private void House2(){
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

        //tree component 
        UtilityFunction.drawLine(432,477,452,468,1);
        UtilityFunction.drawLine(452,468,452,458,1);
        UtilityFunction.drawCurve(452,458,455,447,462,438,475,439,1);
        UtilityFunction.drawCurve(475,439,474,442,475,447,480,447,1);
        UtilityFunction.drawCurve(453,455,448,452,447,445,454,441,1);
        UtilityFunction.drawLine(454,441,455,431,1);
        UtilityFunction.drawLine(456,430,463,431,1);
        UtilityFunction.drawLine(464,432,463,442,1);

        // tree 2
        UtilityFunction.drawLine(571,509,571,500,1);
        UtilityFunction.drawCurve(572,500,568,501,568,500,569,489,1);
        UtilityFunction.drawCurve(569,490,566,487,566,482,568,480,1);
        UtilityFunction.drawCurve(568,479,567,479,567,474,568,473,1);
        UtilityFunction.drawCurve(568,473,565,471,565,467,568,464,1);
        UtilityFunction.drawLine(568,466,567,456,1);
        UtilityFunction.drawLine(567,456,569,456,1);
        UtilityFunction.drawCurve(569,456,571,452,572,453,575,456,1);
        UtilityFunction.drawLine(575,456,575,462,1);
        UtilityFunction.drawLine(575,462,578,463,1);
        UtilityFunction.drawLine(578,463,580,476,1);
        UtilityFunction.drawLine(580,476,583,476,1);
        UtilityFunction.drawLine(583,476,584,465,1);
        UtilityFunction.drawLine(584,465,588,465,1);
        UtilityFunction.drawLine(588,465,593,474,1);
        UtilityFunction.drawLine(593,474,598,474,1);
        UtilityFunction.drawLine(598,474,598,502,1);
        UtilityFunction.drawLine(598,502,591,502,1);
        UtilityFunction.drawLine(591,502,591,509,1);
        UtilityFunction.drawLine(586,509,586,501,1);
        UtilityFunction.drawLine(587,501,576,501,1);
        UtilityFunction.drawLine(576,500,576,509,1);
    }

    private void BackLine(){
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
        UtilityFunction.drawLine(466 - setx,421,466 - setx,416,1);
        UtilityFunction.drawCurve(466 - setx,416,464 - setx,410,457 - setx,410,458 - setx,416,1);
        UtilityFunction.drawLine(458 - setx,416,449 - setx,416,1);
        UtilityFunction.drawCurve(449 - setx,416,447 - setx,417,445 - setx,419,446 - setx,425,1);
        UtilityFunction.drawLine(446 - setx,425,428 - setx,425,1);
        // tree 3
            UtilityFunction.drawSquare(1, 440 - setx, 425 ,440 - setx,418,441 - setx,418,440 - setx,406,436 - setx,405,434 - setx,416,435 - setx,418,437 - setx,418,437 - setx,425);

        UtilityFunction.drawLine(428 - setx,427,428 - setx,413,1);
        UtilityFunction.drawCurve(428 - setx,413,423 - setx,406,423 - setx,408,422 - setx,417, 1);
        UtilityFunction.drawLine(422 - setx,417,420 - setx,417,1);
        UtilityFunction.drawCurve(420 - setx, 417,418 - setx,402,410 - setx,405,413 - setx,417,1);
        UtilityFunction.drawLine(413 - setx,417,411 - setx,417,1);
        UtilityFunction.drawLine(411 - setx,417,411 - setx,426,1);
        UtilityFunction.drawLine(411 - setx,426,404 - setx,426,1);
        UtilityFunction.drawLine(405 - setx,428,405 - setx,413,1);
        UtilityFunction.drawLine(405 - setx,413,399 - setx,413,1);
        UtilityFunction.drawLine(399 - setx,413,399 - setx,421,1);
        UtilityFunction.drawLine(399 - setx,421,393 - setx,421,1);
        UtilityFunction.drawLine(393 - setx,421,393 - setx,414,1);
        UtilityFunction.drawCurve(393 - setx,414,388 - setx,415,391-setx,410,389 - setx,406,1);
        UtilityFunction.drawLine(389 - setx,406,380 - setx,406,1);
        UtilityFunction.drawLine(380 - setx,406,380 - setx,422,1);
        UtilityFunction.drawLine(380 - setx,422,381 - setx,426,1);
        UtilityFunction.drawLine(381 - setx,426,359 - setx,426,1);

        // tree 4
            UtilityFunction.drawLine(370 - setx,425,370 - setx,409,1);
            UtilityFunction.drawLine(370 - setx,409,376 - setx,402,1);
            UtilityFunction.drawCurve(370 - setx, 414, 370 - setx, 407,367 - setx,403, 364- setx,403,1);
            UtilityFunction.drawCurve(370 - setx, 421 ,369 - setx, 417,368 -  setx, 416, 366 - setx, 416, 1);
            UtilityFunction.drawLine(370 - setx,419,374 - setx,414,1);

        UtilityFunction.drawLine(359- setx,426,360 - setx,417,1);
        UtilityFunction.drawLine(360 - setx,417,344 -setx,414,1);
        UtilityFunction.drawLine(344 - setx,414,344 - setx,424,1);
        UtilityFunction.drawLine(344 - setx,424,333 - setx,424,1);
        UtilityFunction.drawLine(333 - setx,424,333 - setx,417,1);
        UtilityFunction.drawLine(333 - setx,417,329 - setx,415,1);
        UtilityFunction.drawLine(329-setx,415,313 - setx,415,1);
        UtilityFunction.drawLine(313  - setx,415,312 - setx,425,1);
        UtilityFunction.drawLine(312 - setx,425,308 - setx,425,1);
        UtilityFunction.drawLine(308 - setx,425,308 - setx,415,1);
        UtilityFunction.drawLine(308 - setx,415,296 - setx,415,1);
        UtilityFunction.drawCurve(296 - setx,415,296 - setx,429,277 - setx,429,277 - setx,416,1);
        UtilityFunction.drawLine(277 - setx ,416 ,268 - setx,413,1);
        UtilityFunction.drawLine(268 - setx ,413 ,258 - setx,413,1);
        UtilityFunction.drawLine(258 - setx ,413 ,245 - setx,417,1);
        UtilityFunction.drawLine(245 - setx ,417 ,245 - setx,425,1);
        UtilityFunction.drawLine(246 - setx,425,218 - setx,425,1);
        // tree
            UtilityFunction.drawLine(227 - setx,425,227 - setx,400,1);
            UtilityFunction.drawLine(227 - setx,410,219 - setx,401,1);
            UtilityFunction.drawLine(227 - setx,408,234 - setx,401,1);
            UtilityFunction.drawLine(227 - setx,418,218 - setx,411,1);
            UtilityFunction.drawLine(227 - setx,418,233 - setx,413,1);

        UtilityFunction.drawLine(218 - setx,425,219 - setx,421,1);
        UtilityFunction.drawLine(219 - setx,421,213 - setx,419,1);
        UtilityFunction.drawLine(213 - setx,419,213 -setx,424,1);
        UtilityFunction.drawLine(213 - setx,424,207 -setx,424,1);
        UtilityFunction.drawLine(207 - setx,424,207 - setx,412,1);
        UtilityFunction.drawLine(207 - setx,412,203 - setx,412,1);
        UtilityFunction.drawLine(203 - setx,412,203 - setx,404,1);
        UtilityFunction.drawLine(203 - setx,404,198 - setx,404,1);
        UtilityFunction.drawLine(198 - setx,404,197 - setx,414,1);
        UtilityFunction.drawLine(197 - setx,414,192 - setx,413,1);
        UtilityFunction.drawLine(192 - setx,413,191 - setx,405,1);
        UtilityFunction.drawLine(191 - setx,405, 188 - setx,405,1);

        //Man
        UtilityFunction.drawLine(188-setx, 405, 188-setx, 412, 1);
        UtilityFunction.drawLine(188-setx, 412, 185-setx, 412, 1);
        UtilityFunction.drawLine(185-setx, 412, 185-setx, 425, 1);
        UtilityFunction.drawLine(185-setx, 425, 182-setx, 425, 1);
        UtilityFunction.drawLine(182-setx, 425, 181-setx, 421, 1);
        UtilityFunction.drawLine(181-setx, 421, 174-setx, 421, 1);
        UtilityFunction.drawLine(175-setx, 421, 175-setx, 417, 1);
        UtilityFunction.drawLine(175-setx, 417, 182-setx, 417, 1);
        UtilityFunction.drawLine(182-setx, 417, 182-setx, 407, 1);
        UtilityFunction.drawLine(182-setx, 407, 176-setx, 404, 1);
        UtilityFunction.drawLine(176-setx, 404, 176-setx, 399, 1);
        UtilityFunction.drawLine(176-setx, 399, 170-setx, 397, 1);
        UtilityFunction.drawLine(170-setx, 397, 165-setx, 399, 1);
        UtilityFunction.drawLine(165-setx, 399, 165-setx, 408, 1);
        UtilityFunction.drawLine(165-setx, 408, 161-setx, 408, 1);
        UtilityFunction.drawLine(161-setx, 408, 161-setx, 418, 1);
        UtilityFunction.drawLine(161-setx, 418, 97-setx, 419, 1);
        //tree
            UtilityFunction.drawLine(98 - setx,414,98 - setx,411,1);
            UtilityFunction.drawCurve(98 - setx , 411,89 - setx,409,97 - setx,398,99 - setx,398,1);
            UtilityFunction.drawCurve(99 - setx,398 ,101 - setx,402,106 - setx,408,101 - setx,411,1);
            UtilityFunction.drawLine(101 - setx,411,101 - setx,419,1);

        UtilityFunction.drawLine(97-setx, 424, 97-setx, 414, 1);
        UtilityFunction.drawLine(97-setx, 414, 88-setx, 413, 1);
        UtilityFunction.drawLine(88-setx, 413, 87-setx, 424, 1);
        UtilityFunction.drawLine(87-setx, 424, 78-setx, 423, 1);
        UtilityFunction.drawLine(78-setx, 423, 78-setx, 411, 1);
        UtilityFunction.drawCurve(78-setx, 411, 70-setx, 404, 66-setx, 404, 61-setx, 411, 1);
        UtilityFunction.drawLine(61-setx, 411, 62-setx, 425, 1);
        UtilityFunction.drawLine(62-setx, 425, 58-setx, 425, 1);
        UtilityFunction.drawLine(58-setx, 425, 58-setx, 413, 1);
        UtilityFunction.drawLine(58-setx, 413, 49-setx, 411, 1);
        UtilityFunction.drawLine(49-setx, 411, 47-setx, 420, 1);
        UtilityFunction.drawLine(47-setx, 420, 27-setx, 418, 1);
        UtilityFunction.drawLine(27-setx, 418, 27-setx, 411, 1);
        UtilityFunction.drawLine(27-setx, 411, 26-setx, 409, 1);
        UtilityFunction.drawLine(26-setx, 409, 11-setx, 410, 1);
        UtilityFunction.drawLine(11-setx, 410, 12-setx, 398, 1);
        UtilityFunction.drawLine(12-setx, 398, 7-setx, 395, 1);
        UtilityFunction.drawLine(7-setx, 395, 1-setx, 395, 1);
        UtilityFunction.drawLine(1-setx, 395, 1-setx, 412, 1);
    }

    private void Lake(){
        UtilityFunction.drawCurve(337,347,351,363,337,397,316,411,1);
        UtilityFunction.drawLine(316,411,270,410,1);
        UtilityFunction.drawCurve(270,410,260,408,257,406,257,401,1);
        UtilityFunction.drawCurve(257,401,253,393,242,387,231,385,1);
        UtilityFunction.drawCurve(231,385,211,372,209,355,239,347,1);
    }

    private void Boat(){
        //เรือ
        UtilityFunction.drawSquare(1, 447,356,447,364,447,364,450,366,450,366,487,366,487,366,491,355,491,355,487,353,487, 353,
        486, 355,486, 355 ,475, 355,475, 355 ,475, 351,475, 351 ,463, 351,463, 351 ,463, 355,463, 355 ,457, 355,457, 355 ,457, 351,457, 351,
        451, 351,451, 351 ,451, 355,451, 355 ,447, 356);

        //smoke
        UtilityFunction.drawLine(457,346,464,346,1);
        UtilityFunction.drawCurve(464,346,464,342,465,341,469,341,1);
        UtilityFunction.drawLine(469,341,469,333,1);
        UtilityFunction.drawLine(469,333,466,330,1);
        UtilityFunction.drawLine(466,330,466,322,1);
        UtilityFunction.drawCurve(466,322,465,318,463,314,459,314,1);
        UtilityFunction.drawLine(459,314,445,314,1);
        UtilityFunction.drawCurve(445,314,435,319,434,309,445,309,1);
        UtilityFunction.drawCurve(445,309,449,307,449,304,443,303,1);
        UtilityFunction.drawLine(443,303,430,303,1);
        UtilityFunction.drawCurve(430,303,425,302,428,292,425,290,1);
        UtilityFunction.drawLine(425,290,393,290,1);
        UtilityFunction.drawCurve(393,290,389,294,389,301,399,303,1);
        UtilityFunction.drawCurve(399,303,394,308,395,310,408,311,1);
        UtilityFunction.drawCurve(408,311,409,319,416,322,429,323,1);
        UtilityFunction.drawCurve(429,323,431,332,442,331,444,337,1);
        UtilityFunction.drawLine(444,337,455,339,1);
        UtilityFunction.drawLine(455,339,457,341,1);
        UtilityFunction.drawLine(457,341,457,346,1);
    }
}
