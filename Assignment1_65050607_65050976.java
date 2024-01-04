/*
 * Assignment 1
 * นายพสิษฐ์ มาลารัตน์ 65050607
 * นายอนุกูล ดวงจำปา ุ65050976
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Assignment1_65050976_65050607{
    public static void main(String[] args){
        JFrame mainframe = new JFrame();
        mainframe.add(new GraphicsSwing());
        mainframe.setSize(600,600);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setVisible(true);
    }
}

class GraphicsSwing extends JPanel {
    public void paintComponent(Graphics g) {
        UtilityFunction.setupUtilityFunction(g);

        Firework(100,240);
        Firework(500,220);

        Star();
        Structure();
        House();
        BackLine();
        Light();
        Moon();
        Lake();
        Boat();
    }

    private void Firework(int x,int y){
        Color midcircle = new Color(233,227,195);
        Color colorfirework1 = new Color(0xb1c97a);
        Color colorfirework2 = new Color(0xb48d59);
        Color colorfirework3 = new Color(0xf1d09b);
        Color colorfirework4 = new Color(0xff8c00);
        Color[] useColor = {colorfirework1,colorfirework2,colorfirework3,colorfirework4,midcircle};
        UtilityFunction.setFireWorkRGBColor(useColor);

        UtilityFunction.drawCircle(x - 1, y - 10, 2,2,midcircle);
        // use random by getRandomIndexUseColor
        UtilityFunction.drawCurve(x + 5,y - 2,x + 10,y - 5,x + 20,y - 7,x + 38,y - 8,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x + 5,y - 3,x + 15,y - 15,x + 30,y - 17,x + 37,y - 18,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x + 3,y - 4,x + 10,y - 18,x + 25,y - 27,x + 30,y - 28,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x + 2, y - 5,x + 6,y - 30,x + 15,y - 34,x + 20,y - 37,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawLine(x,y-6,x,y - 42,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x - 2, y - 5,x - 6,y - 30,x - 15,y - 34,x - 20,y - 37,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x - 3,y - 5,x - 10,y - 18,x - 25,y - 27,x - 30,y - 28,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x - 5,y - 3,x - 15,y - 15,x - 30,y - 17,x - 37,y - 18,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x - 5,y - 2,x - 10,y - 5,x - 20,y - 7,x - 38,y - 8,1,getRandomColorinUseColor(useColor));

        UtilityFunction.drawCurve(x + 7,y + 1,x + 10,y + 2,x + 30,y + 4,x + 40,y + 15,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x - 7,y + 1,x - 10,y + 2,x - 30,y + 4,x - 40,y + 15,1,getRandomColorinUseColor(useColor));

        UtilityFunction.drawCurve(x + 6,y - 1,x + 10,y - 3,x + 40,y - 3,x + 39,y + 2,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x - 7,y - 1,x - 10,y - 3,x - 40,y - 3,x - 39,y + 2,1,getRandomColorinUseColor(useColor));

        UtilityFunction.drawCurve(x + 6,y + 4,x + 10,y + 4,x + 25,y + 6,x + 34,y + 32,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x + 5,y + 5,x + 10,y + 6,x + 20,y + 12,x + 25,y + 39,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x + 4,y + 6,x + 8,y + 12,x + 11,y + 20,x + 12,y + 41,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawLine(x,y+6,x,y + 42,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x - 6,y + 4,x - 10,y + 4,x - 25,y + 6,x - 34,y + 32,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x - 5,y + 5,x - 10,y + 6,x - 20,y + 12,x - 25,y + 39,1,getRandomColorinUseColor(useColor));
        UtilityFunction.drawCurve(x - 4,y + 6,x - 8,y + 12,x - 11,y + 20,x - 12,y + 41,1,getRandomColorinUseColor(useColor));
    }

    private void Star(){
        Color colorStar1 = new Color(0xe2e3f4);
        Color[] color = {colorStar1};
        UtilityFunction.setFireWorkRGBColor(color);
        int randomX = 0;
        int randomY = 0;
        for(int i = 0; i<35; i++){
            randomX = (int)(Math.random()*600);
            randomY = ((int)(Math.random()*205)%(15))+149;
            UtilityFunction.drawCircle(randomX, randomY, 1, 1,colorStar1);
        }
    }

    private Color getRandomColorinUseColor(Color[] useColors){
        return useColors[(int)((Math.random() * 30) % useColors.length-1)];
    }

    private void House() {
        // บ้าน 1
        UtilityFunction.drawLine(0, 448, 33, 448, 1);
        UtilityFunction.drawLine(33, 448, 33, 509, 1);
        UtilityFunction.drawLine(33, 448, 51, 431, 1);
        UtilityFunction.drawLine(51, 431, 51, 486, 1);
        UtilityFunction.drawLine(0, 448, 24, 431, 1);
        UtilityFunction.drawLine(24, 431, 51, 431,1);

        // บ้าน 2
        UtilityFunction.drawLine(33, 508, 66, 469, 1);
        UtilityFunction.drawLine(66, 469, 117, 469, 1);
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

        // บ้าน 3
        UtilityFunction.drawLine(51, 441, 55, 441, 1);
        UtilityFunction.drawLine(55, 441, 55, 482, 1);
        UtilityFunction.drawLine(55, 441, 75, 434, 1);
        UtilityFunction.drawLine(75, 434, 92, 441, 1);
        UtilityFunction.drawLine(92, 441, 92, 469, 1);
        UtilityFunction.drawLine(55, 447, 75, 439, 1);
        UtilityFunction.drawLine(75, 439, 92, 448, 1);
        UtilityFunction.drawSquare(1, 66, 455, 74, 455, 74, 462, 66, 462);

        // บ้าน 4
        UtilityFunction.drawLine(82, 435, 102, 428, 1);
        UtilityFunction.drawLine(102, 428, 120, 435, 1);
        UtilityFunction.drawLine(120, 435, 120, 471, 1);
        UtilityFunction.drawLine(120, 445, 120, 471, 1);
        UtilityFunction.drawLine(91, 441, 105, 441, 1);
        UtilityFunction.drawLine(105, 441, 120, 448, 1);

        // บ้าน 5
        UtilityFunction.drawLine(120, 445, 141, 431, 1);
        UtilityFunction.drawLine(141, 431, 159, 431, 1);
        UtilityFunction.drawLine(159, 431, 159, 448, 1);
        UtilityFunction.drawLine(120, 450, 137, 450, 1);
        UtilityFunction.drawLine(137, 450, 137, 485, 1);
        UtilityFunction.drawLine(137, 450, 159, 431, 1);

        // บ้าน 6
        UtilityFunction.drawLine(166, 459, 177, 446, 1);
        UtilityFunction.drawLine(177, 446, 213, 452, 1);
        UtilityFunction.drawLine(213, 452, 193, 472, 1);
        UtilityFunction.drawLine(193, 472, 166, 459, 1);

        // บ้าน 7
        UtilityFunction.drawLine(163, 489, 228, 454, 1);
        UtilityFunction.drawLine(228, 454, 270, 465, 1);
        UtilityFunction.drawLine(270, 465, 215, 503, 1);
        UtilityFunction.drawLine(215, 503, 163, 489, 1);

        // บ้าน 8
        UtilityFunction.drawLine(236, 451, 253, 438, 1);
        UtilityFunction.drawLine(253, 438, 296, 442, 1);
        UtilityFunction.drawLine(236, 451, 280, 460, 1);
        UtilityFunction.drawCurve(280, 460, 283, 454, 290, 447, 296, 443, 1);

        // square
        UtilityFunction.drawSquare(1, 286, 457, 291, 450, 291, 458, 286, 464);

        // ต้นไม้ 1
        UtilityFunction.drawLine(154, 484, 154, 494, 1);
        UtilityFunction.drawLine(154, 494, 157, 494, 1);
        UtilityFunction.drawLine(157, 494, 157, 485, 1);
        UtilityFunction.drawLine(157, 485, 167, 485, 1);
        UtilityFunction.drawLine(167, 485, 168, 465, 1);
        UtilityFunction.drawLine(168, 465, 157, 446, 1);
        UtilityFunction.drawLine(157, 446, 144, 465, 1);
        UtilityFunction.drawLine(144, 465, 144, 479, 1);
        UtilityFunction.drawLine(144, 479, 147, 484, 1);
        UtilityFunction.drawLine(147, 484, 154, 484, 1);

        UtilityFunction.drawSquare(1, 332, 465, 370, 446, 380, 454, 341, 473);
        // บ้าน 9
        UtilityFunction.drawLine(352, 473, 352, 509, 1);
        UtilityFunction.drawSquare(1, 352, 473, 396, 457, 403, 457, 408, 462, 408, 468, 402, 463, 363, 480);
        UtilityFunction.drawLine(364, 480, 364, 509, 1);
        UtilityFunction.drawLine(368, 478, 368, 509, 1);
        UtilityFunction.drawSquare(1, 370, 479, 373, 479, 373, 487, 370, 487);
        UtilityFunction.drawSquare(1, 375, 478, 378, 478, 378, 486, 375, 486);
        UtilityFunction.drawSquare(1, 380, 477, 383, 477, 383, 484, 380, 484);
        UtilityFunction.drawSquare(1, 369, 493, 410, 474, 408, 461, 420, 444, 432, 457, 432, 479, 374, 498); // fix
                                                                                                             // (ยังไม่แก้)
        UtilityFunction.drawLine(432, 478, 454, 478, 1);
        UtilityFunction.drawLine(454, 478, 454, 509, 1);

        // หน้าต่าง ในบ้าน
        for (int i = 1; i <= 16; i += 6) {
            UtilityFunction.drawSquare(1, 386 + i, 496, 390 + i, 496, 390 + i, 505, 386 + i, 505);
        }

        // บ้าน 10
        UtilityFunction.drawLine(462, 509, 462, 475, 1);
        UtilityFunction.drawLine(462, 475, 490, 457, 1);
        UtilityFunction.drawLine(480, 463, 480, 441, 1);
        UtilityFunction.drawSquare(1, 480, 441, 517, 441, 521, 433, 488, 433);
        UtilityFunction.drawSquare(1, 492, 449, 500, 449, 500, 458, 492, 458);
        UtilityFunction.drawSquare(1, 473, 474, 481, 474, 481, 483, 473, 483);
        UtilityFunction.drawSquare(1, 491, 465, 532, 443, 562, 460, 529, 487);
        UtilityFunction.drawLine(517, 441, 517, 451, 1);
        UtilityFunction.drawSquare(1, 518, 441, 543, 430, 548, 435, 522, 445);
        UtilityFunction.drawSquare(1, 537, 487, 542, 487, 542, 502, 537, 502);
        UtilityFunction.drawSquare(1, 543, 483, 548, 483, 548, 498, 543, 498);
        UtilityFunction.drawSquare(1, 548, 480, 553, 480, 553, 496, 548, 496);

        UtilityFunction.drawSquare(1, 562, 438, 585, 439, 579, 455, 553, 449);

        // ต้นไม้ 2
        UtilityFunction.drawLine(432, 477, 452, 468, 1);
        UtilityFunction.drawLine(452, 468, 452, 458, 1);
        UtilityFunction.drawCurve(452, 458, 455, 447, 462, 438, 475, 439, 1);
        UtilityFunction.drawCurve(475, 439, 474, 442, 475, 447, 480, 447, 1);
        UtilityFunction.drawCurve(453, 455, 448, 452, 447, 445, 454, 441, 1);
        UtilityFunction.drawLine(454, 441, 455, 431, 1);
        UtilityFunction.drawLine(456, 430, 463, 431, 1);
        UtilityFunction.drawLine(464, 432, 463, 442, 1);

        // ต้นไม้ 3
        UtilityFunction.drawLine(571, 509, 571, 500, 1);
        UtilityFunction.drawCurve(572, 500, 568, 501, 568, 500, 569, 489, 1);
        UtilityFunction.drawCurve(569, 490, 566, 487, 566, 482, 568, 480, 1);
        UtilityFunction.drawCurve(568, 479, 567, 479, 567, 474, 568, 473, 1);
        UtilityFunction.drawCurve(568, 473, 565, 471, 565, 467, 568, 464, 1);
        UtilityFunction.drawLine(568, 466, 567, 456, 1);
        UtilityFunction.drawLine(567, 456, 569, 456, 1);
        UtilityFunction.drawCurve(569, 456, 571, 452, 572, 453, 575, 456, 1);
        UtilityFunction.drawLine(575, 456, 575, 462, 1);
        UtilityFunction.drawLine(575, 462, 578, 463, 1);
        UtilityFunction.drawLine(578, 463, 580, 476, 1);
        UtilityFunction.drawLine(580, 476, 583, 476, 1);
        UtilityFunction.drawLine(583, 476, 584, 465, 1);
        UtilityFunction.drawLine(584, 465, 588, 465, 1);
        UtilityFunction.drawLine(588, 465, 593, 474, 1);
        UtilityFunction.drawLine(593, 474, 598, 474, 1);
        UtilityFunction.drawLine(598, 474, 598, 502, 1);
        UtilityFunction.drawLine(598, 502, 591, 502, 1);
        UtilityFunction.drawLine(591, 502, 591, 509, 1);
        UtilityFunction.drawLine(586, 509, 586, 501, 1);
        UtilityFunction.drawLine(587, 501, 576, 501, 1);
        UtilityFunction.drawLine(576, 500, 576, 509, 1);

        //Color
        Color c1 = new Color(95,126,171);
        UtilityFunction.Floodfill(33,439, Color.WHITE, c1);
        UtilityFunction.Floodfill(143,440, Color.WHITE, c1);
        Color c2 = new Color(35,53,89);
        UtilityFunction.Floodfill(103,473, Color.WHITE, c2);
        UtilityFunction.Floodfill(79,440, Color.WHITE, c2);
        UtilityFunction.Floodfill(98,438, Color.WHITE, c2);
        UtilityFunction.Floodfill(190,458, Color.WHITE, c2);
        UtilityFunction.Floodfill(268,449, Color.WHITE, c2);
        UtilityFunction.Floodfill(215,473, Color.WHITE, c2);

        UtilityFunction.Floodfill(350,460, Color.WHITE, c2);
        UtilityFunction.Floodfill(389,465, Color.WHITE, c2);
        UtilityFunction.Floodfill(423,470, Color.WHITE, c2);
        UtilityFunction.Floodfill(473,451, Color.WHITE, c2);
        UtilityFunction.Floodfill(505,437, Color.WHITE, c2);
        UtilityFunction.Floodfill(518,458, Color.WHITE, c2);
        UtilityFunction.Floodfill(539,436, Color.WHITE, c2);
        UtilityFunction.Floodfill(575,447, Color.WHITE, c2);


    }

    private void Moon() {
        UtilityFunction.drawCircle(286, 230, 43,1);
        UtilityFunction.floodFillGradient(283, 237, 286, 315, new Color(0xf8cabd), new Color(0xf9c7b9), Color.BLACK);
        //UtilityFunction.Floodfill(286, 230, Color.WHITE, Color.GRAY);
    }

    private void Light() {
        UtilityFunction.drawCircle(105, 446, 6,1);
        UtilityFunction.drawCircle(126, 418, 7,1);
        UtilityFunction.drawCircle(176, 428, 5,1);
        UtilityFunction.drawCircle(214, 430, 6,1);
        UtilityFunction.drawCircle(250, 484, 8,1);
        UtilityFunction.drawCircle(303, 440, 5,1);
        UtilityFunction.drawCircle(422, 422, 7,1);
        UtilityFunction.drawCircle(478, 423, 6,1);
        UtilityFunction.drawCircle(543, 433, 3,1);
        UtilityFunction.drawCircle(561, 445, 3,1);
        int y = 5;
        //Color light = new Color(181,192,193);
        Color light = new Color(233,227,195);
        //Color light = Color.WHITE;
        UtilityFunction.FloodfillUpgrade(105, 446 + y, Color.BLACK,light);
        UtilityFunction.FloodfillUpgrade(126, 418 + y, Color.BLACK,light);
        UtilityFunction.FloodfillUpgrade(176, 428 + 6, Color.BLACK,light);
        UtilityFunction.FloodfillUpgrade(214, 430 + y, Color.BLACK,light);
        UtilityFunction.FloodfillUpgrade(250, 484 + y, Color.BLACK,light);
        UtilityFunction.FloodfillUpgrade(303, 440 + y + 1, Color.BLACK,light);
        UtilityFunction.FloodfillUpgrade(422, 422 + y, Color.BLACK,light);
        UtilityFunction.FloodfillUpgrade(478, 423 + y, Color.BLACK,light);
        UtilityFunction.FloodfillUpgrade(543, 433 + y + 3, Color.BLACK,light);
        UtilityFunction.FloodfillUpgrade(561, 445 + y + 3, Color.BLACK,light);
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

        int y = 40;
        UtilityFunction.floodFillGradient(0, 0, 600, 97, new Color(0x102131), new Color(0x0b1c2c), Color.BLACK);
        UtilityFunction.floodFillGradient(0,99-y, 600, 139-y, new Color(0x182f41), new Color(0x0c2d47), Color.BLACK);
        UtilityFunction.floodFillGradient(0,140-y, 600, 147-y, new Color(0x294d6d), new Color(0x244e74), Color.BLACK);
        UtilityFunction.floodFillGradient(0,510-y, 600, 517-y, new Color(0x294d6d), new Color(0x244e74), Color.BLACK);
        UtilityFunction.floodFillGradient(0,520-y, 600, 560-y, new Color(0x182f41), new Color(0x0c2d47), Color.BLACK);
        UtilityFunction.floodFillGradient(0,562-y, 600, 575-y, new Color(0x091723), new Color(0x06131c), Color.BLACK);
        UtilityFunction.floodFillGradient(123,562-y, 600, 575-y, new Color(0x091723), new Color(0x06131c), Color.BLACK);
        UtilityFunction.floodFillGradient(316,562-y, 600, 575-y, new Color(0x091723), new Color(0x06131c), Color.BLACK);
        UtilityFunction.floodFillGradient(500,562-y, 600, 575-y, new Color(0x091723), new Color(0x06131c), Color.BLACK);
        Color start = new Color(15,25,38);
        Color end = new Color(82,70,61);
        UtilityFunction.floodFillGradienthorizontal(0,580 - y,600,580 - y,start,end,Color.BLACK);
    }

    private void BackLine() {
        int setx = 18;
        UtilityFunction.drawLine(600 - setx,425,600,425,1);
        UtilityFunction.drawCurve(600 - setx, 425, 589 - setx, 435, 588 - setx, 425, 588 - setx, 411, 1);
        // tree 1
        UtilityFunction.drawLine(596 - setx, 427, 596 - setx, 413, 1);
        UtilityFunction.drawLine(596 - setx, 413, 592 - setx, 401, 1);
        UtilityFunction.drawCurve(596 - setx, 419, 597 - setx, 414, 598 - setx, 414, 600 - setx, 415, 1);
        UtilityFunction.drawCurve(594 - setx, 412, 596 - setx, 405, 598 - setx, 402, 600 - setx, 404, 1);
        UtilityFunction.drawCurve(596 - setx, 419, 592 - setx, 421, 594 - setx, 419, 593 - setx, 415, 1);
        UtilityFunction.drawLine(588 - setx, 411, 585 - setx, 403, 1);
        UtilityFunction.drawLine(585 - setx, 403, 582 - setx, 403, 1);
        UtilityFunction.drawLine(582 - setx, 403, 581 - setx, 410, 1);
        UtilityFunction.drawLine(581 - setx, 410, 578 - setx, 410, 1);
        UtilityFunction.drawCurve(578 - setx, 410, 574 - setx, 408, 577 - setx, 407, 575 - setx, 403, 1);
        UtilityFunction.drawLine(575 - setx, 403, 571 - setx, 403, 1);
        UtilityFunction.drawCurve(571 - setx, 403, 572 - setx, 408, 569 - setx, 417, 570 - setx, 421, 1);
        UtilityFunction.drawCurve(570 - setx, 421, 566 - setx, 423, 564 - setx, 423, 563 - setx, 420, 1);
        UtilityFunction.drawLine(563 - setx, 420, 540 - setx, 420, 1);

        // tree 2
        UtilityFunction.drawSquare(1, 561 - setx, 420, 561 - setx, 416, 563 - setx, 416, 563 - setx, 401, 556 - setx,
                401, 555 - setx, 402, 555 - setx, 416, 558 - setx, 416, 558 - setx, 420);

        UtilityFunction.drawLine(540 - setx, 420, 540 - setx, 414, 1);
        UtilityFunction.drawLine(540 - setx, 414, 516 - setx, 413, 1);
        UtilityFunction.drawLine(516 - setx, 413, 516 - setx, 420, 1);
        UtilityFunction.drawLine(516 - setx, 420, 500 - setx, 420, 1);
        UtilityFunction.drawCurve(500 - setx, 420, 496 - setx, 409, 480 - setx, 410, 477 - setx, 415, 1);
        UtilityFunction.drawLine(477 - setx, 415, 477 - setx, 422, 1);
        UtilityFunction.drawLine(477 - setx, 422, 466 - setx, 421, 1);
        UtilityFunction.drawLine(466 - setx, 421, 466 - setx, 416, 1);
        UtilityFunction.drawCurve(466 - setx, 416, 464 - setx, 410, 457 - setx, 410, 458 - setx, 416, 1);
        UtilityFunction.drawLine(458 - setx, 416, 449 - setx, 416, 1);
        UtilityFunction.drawCurve(449 - setx, 416, 447 - setx, 417, 445 - setx, 419, 446 - setx, 425, 1);
        UtilityFunction.drawLine(446 - setx, 425, 428 - setx, 425, 1);

        // tree 3
        UtilityFunction.drawSquare(1, 440 - setx, 425, 440 - setx, 418, 441 - setx, 418, 440 - setx, 406, 436 - setx,
                405, 434 - setx, 416, 435 - setx, 418, 437 - setx, 418, 437 - setx, 425);

        UtilityFunction.drawLine(428 - setx, 427, 428 - setx, 413, 1);
        UtilityFunction.drawCurve(428 - setx, 413, 423 - setx, 406, 423 - setx, 408, 422 - setx, 417, 1);
        UtilityFunction.drawLine(422 - setx, 417, 420 - setx, 417, 1);
        UtilityFunction.drawCurve(420 - setx, 417, 418 - setx, 402, 410 - setx, 405, 413 - setx, 417, 1);
        UtilityFunction.drawLine(413 - setx, 417, 411 - setx, 417, 1);
        UtilityFunction.drawLine(411 - setx, 417, 411 - setx, 426, 1);
        UtilityFunction.drawLine(411 - setx, 426, 404 - setx, 426, 1);
        UtilityFunction.drawLine(405 - setx, 428, 405 - setx, 413, 1);
        UtilityFunction.drawLine(405 - setx, 413, 399 - setx, 413, 1);
        UtilityFunction.drawLine(399 - setx, 413, 399 - setx, 421, 1);
        UtilityFunction.drawLine(399 - setx, 421, 393 - setx, 421, 1);
        UtilityFunction.drawLine(393 - setx, 421, 393 - setx, 414, 1);
        UtilityFunction.drawCurve(393 - setx, 414, 388 - setx, 415, 391 - setx, 410, 389 - setx, 406, 1);
        UtilityFunction.drawLine(389 - setx, 406, 380 - setx, 406, 1);
        UtilityFunction.drawLine(380 - setx, 406, 380 - setx, 422, 1);
        UtilityFunction.drawLine(380 - setx, 422, 381 - setx, 426, 1);
        UtilityFunction.drawLine(381 - setx, 426, 359 - setx, 426, 1);

        // tree 4
        UtilityFunction.drawLine(370 - setx, 425, 370 - setx, 409, 1);
        UtilityFunction.drawLine(370 - setx, 409, 376 - setx, 402, 1);
        UtilityFunction.drawCurve(370 - setx, 414, 370 - setx, 407, 367 - setx, 403, 364 - setx, 403, 1);
        UtilityFunction.drawCurve(370 - setx, 421, 369 - setx, 417, 368 - setx, 416, 366 - setx, 416, 1);
        UtilityFunction.drawLine(370 - setx, 419, 374 - setx, 414, 1);

        UtilityFunction.drawLine(359 - setx, 426, 360 - setx, 417, 1);
        UtilityFunction.drawLine(360 - setx, 417, 344 - setx, 414, 1);
        UtilityFunction.drawLine(344 - setx, 414, 344 - setx, 424, 1);
        UtilityFunction.drawLine(344 - setx, 424, 333 - setx, 424, 1);
        UtilityFunction.drawLine(333 - setx, 424, 333 - setx, 417, 1);
        UtilityFunction.drawLine(333 - setx, 417, 329 - setx, 415, 1);
        UtilityFunction.drawLine(329 - setx, 415, 313 - setx, 415, 1);
        UtilityFunction.drawLine(313 - setx, 415, 312 - setx, 425, 1);
        UtilityFunction.drawLine(312 - setx, 425, 308 - setx, 425, 1);
        UtilityFunction.drawLine(308 - setx, 425, 308 - setx, 415, 1);
        UtilityFunction.drawLine(308 - setx, 415, 296 - setx, 415, 1);
        UtilityFunction.drawCurve(296 - setx, 415, 296 - setx, 429, 277 - setx, 429, 277 - setx, 416, 1);
        UtilityFunction.drawLine(277 - setx, 416, 268 - setx, 413, 1);
        UtilityFunction.drawLine(268 - setx, 413, 258 - setx, 413, 1);
        UtilityFunction.drawLine(258 - setx, 413, 245 - setx, 417, 1);
        UtilityFunction.drawLine(245 - setx, 417, 245 - setx, 425, 1);
        UtilityFunction.drawLine(246 - setx, 425, 218 - setx, 425, 1);
        // tree
        UtilityFunction.drawLine(227 - setx, 425, 227 - setx, 400, 1);
        UtilityFunction.drawLine(227 - setx, 410, 219 - setx, 401, 1);
        UtilityFunction.drawLine(227 - setx, 408, 234 - setx, 401, 1);
        UtilityFunction.drawLine(227 - setx, 418, 218 - setx, 411, 1);
        UtilityFunction.drawLine(227 - setx, 418, 233 - setx, 413, 1);

        UtilityFunction.drawLine(218 - setx, 425, 219 - setx, 421, 1);
        UtilityFunction.drawLine(219 - setx, 421, 213 - setx, 419, 1);
        UtilityFunction.drawLine(213 - setx, 419, 213 - setx, 424, 1);
        UtilityFunction.drawLine(213 - setx, 424, 207 - setx, 424, 1);
        UtilityFunction.drawLine(207 - setx, 424, 207 - setx, 412, 1);
        UtilityFunction.drawLine(207 - setx, 412, 203 - setx, 412, 1);
        UtilityFunction.drawLine(203 - setx, 412, 203 - setx, 404, 1);
        UtilityFunction.drawLine(203 - setx, 404, 198 - setx, 404, 1);
        UtilityFunction.drawLine(198 - setx, 404, 197 - setx, 414, 1);
        UtilityFunction.drawLine(197 - setx, 414, 192 - setx, 413, 1);
        UtilityFunction.drawLine(192 - setx, 413, 191 - setx, 405, 1);
        UtilityFunction.drawLine(191 - setx, 405, 188 - setx, 405, 1);

        // Man
        UtilityFunction.drawLine(188 - setx, 405, 188 - setx, 412, 1);
        UtilityFunction.drawLine(188 - setx, 412, 185 - setx, 412, 1);
        UtilityFunction.drawLine(185 - setx, 412, 185 - setx, 425, 1);
        UtilityFunction.drawLine(185 - setx, 425, 182 - setx, 425, 1);
        UtilityFunction.drawLine(182 - setx, 425, 181 - setx, 421, 1);
        UtilityFunction.drawLine(181 - setx, 421, 174 - setx, 421, 1);
        UtilityFunction.drawLine(175 - setx, 421, 175 - setx, 417, 1);
        UtilityFunction.drawLine(175 - setx, 417, 182 - setx, 417, 1);
        UtilityFunction.drawLine(182 - setx, 417, 182 - setx, 407, 1);
        UtilityFunction.drawLine(182 - setx, 407, 176 - setx, 404, 1);
        UtilityFunction.drawLine(176 - setx, 404, 176 - setx, 399, 1);
        UtilityFunction.drawLine(176 - setx, 399, 170 - setx, 397, 1);
        UtilityFunction.drawLine(170 - setx, 397, 165 - setx, 399, 1);
        UtilityFunction.drawLine(165 - setx, 399, 165 - setx, 408, 1);
        UtilityFunction.drawLine(165 - setx, 408, 161 - setx, 408, 1);
        UtilityFunction.drawLine(161 - setx, 408, 161 - setx, 418, 1);
        UtilityFunction.drawLine(161 - setx, 418, 97 - setx, 419, 1);
        // tree
        UtilityFunction.drawLine(98 - setx, 414, 98 - setx, 411, 1);
        UtilityFunction.drawCurve(98 - setx, 411, 89 - setx, 409, 97 - setx, 398, 99 - setx, 398, 1);
        UtilityFunction.drawCurve(99 - setx, 398, 101 - setx, 402, 106 - setx, 408, 101 - setx, 411, 1);
        UtilityFunction.drawLine(101 - setx, 411, 101 - setx, 419, 1);

        UtilityFunction.drawLine(97 - setx, 424, 97 - setx, 414, 1);
        UtilityFunction.drawLine(97 - setx, 414, 88 - setx, 413, 1);
        UtilityFunction.drawLine(88 - setx, 413, 87 - setx, 424, 1);
        UtilityFunction.drawLine(87 - setx, 424, 78 - setx, 423, 1);
        UtilityFunction.drawLine(78 - setx, 423, 78 - setx, 411, 1);
        UtilityFunction.drawCurve(78 - setx, 411, 70 - setx, 404, 66 - setx, 404, 61 - setx, 411, 1);
        UtilityFunction.drawLine(61 - setx, 411, 62 - setx, 425, 1);
        UtilityFunction.drawLine(62 - setx, 425, 58 - setx, 425, 1);
        UtilityFunction.drawLine(58 - setx, 425, 58 - setx, 413, 1);
        UtilityFunction.drawLine(58 - setx, 413, 49 - setx, 411, 1);
        UtilityFunction.drawLine(49 - setx, 411, 47 - setx, 420, 1);
        UtilityFunction.drawLine(47 - setx, 420, 27 - setx, 418, 1);
        UtilityFunction.drawLine(27 - setx, 418, 27 - setx, 411, 1);
        UtilityFunction.drawLine(27 - setx, 411, 26 - setx, 409, 1);
        UtilityFunction.drawLine(26 - setx, 409, 11 - setx, 410, 1);
        UtilityFunction.drawLine(11 - setx, 410, 12 - setx, 398, 1);
        UtilityFunction.drawLine(12 - setx, 398, 7 - setx, 395, 1);
        UtilityFunction.drawLine(7 - setx, 395, 1 - setx, 395, 1);
        UtilityFunction.drawLine(1 - setx, 395, 1 - setx, 412, 1);

        Color background = new Color(32,41,59);
        UtilityFunction.Floodfill(326,440, Color.WHITE, background);
        UtilityFunction.Floodfill(180,471,Color.WHITE,background);
        UtilityFunction.Floodfill(99-setx, 407, Color.WHITE, background);
        UtilityFunction.Floodfill(438-setx, 414, Color.WHITE, background);
        UtilityFunction.Floodfill(559-setx, 411, Color.WHITE, background);
        UtilityFunction.Floodfill(41, 465, Color.WHITE, background);
        UtilityFunction.Floodfill(15, 482, Color.WHITE, new Color(0x1d3851));
        UtilityFunction.Floodfill(129, 461, Color.WHITE, new Color(0x1d3851));
        UtilityFunction.Floodfill(82, 457, Color.WHITE, background);
        UtilityFunction.Floodfill(53, 460, Color.WHITE, background);
        UtilityFunction.Floodfill(101, 462, Color.WHITE, background);
        UtilityFunction.Floodfill(156, 471, Color.WHITE, new Color(0x1d3851));
        UtilityFunction.Floodfill(360, 492, Color.WHITE, background);
        UtilityFunction.Floodfill(366, 491, Color.WHITE, background);
        UtilityFunction.Floodfill(392, 476, Color.WHITE, background);
        UtilityFunction.Floodfill(426, 498, Color.WHITE, background);
        UtilityFunction.Floodfill(520, 446, Color.WHITE, background);
        UtilityFunction.Floodfill(573, 484, Color.WHITE, new Color(0x1d3851));
        UtilityFunction.Floodfill(581, 504, Color.WHITE, background);



        //Sky
        UtilityFunction.floodFillGradient(0, 149, 65, 346, new Color(0x0c3759), new Color(0x164674), Color.BLACK);
        //Ocean
        UtilityFunction.floodFillGradient(0, 348, 65, 426, new Color(0x37699a), new Color(0x50759a), Color.BLACK);
    }

    private void Lake() {
        UtilityFunction.drawHalfCircle(286, 363, 37,1,Color.BLACK);
        UtilityFunction.floodFillGradient(268, 348, 307, 410, new Color(0xf8c8bc), new Color(0x879fbb), Color.BLACK);

    }

    private void Boat() {
        // boat
        UtilityFunction.drawSquare(1, 447, 356, 447, 364, 447, 364, 450, 366, 450, 366,
                                                487, 366, 487, 366, 491, 355,491, 355, 487, 353,
                                                487, 353,486, 355, 486, 355, 475, 355, 475, 355,
                                                475, 351, 475, 351, 463, 351, 463, 351, 463, 355,
                                                463, 355, 457,355, 457, 355, 457, 351, 457, 351,451,
                                                351, 451, 351, 451, 355, 451, 355, 447, 356);

        UtilityFunction.FloodfillUpgrade(467, 358, Color.BLACK, new Color(0x011f43));

        // smoke
        UtilityFunction.drawLine(457, 346, 464, 346, 1);
        UtilityFunction.drawCurve(464, 346, 464, 342, 465, 341, 469, 341, 1);
        UtilityFunction.drawLine(469, 341, 469, 333, 1);
        UtilityFunction.drawLine(469, 333, 466, 330, 1);
        UtilityFunction.drawLine(466, 330, 466, 322, 1);
        UtilityFunction.drawCurve(466, 322, 465, 318, 463, 314, 459, 314, 1);
        UtilityFunction.drawLine(459, 314, 445, 314, 1);
        UtilityFunction.drawCurve(445, 314, 435, 319, 434, 309, 445, 309, 1);
        UtilityFunction.drawCurve(445, 309, 449, 307, 449, 304, 443, 303, 1);
        UtilityFunction.drawLine(443, 303, 430, 303, 1);
        UtilityFunction.drawCurve(430, 303, 425, 302, 428, 292, 425, 290, 1);
        UtilityFunction.drawLine(425, 290, 393, 290, 1);
        UtilityFunction.drawCurve(393, 290, 389, 294, 389, 301, 399, 303, 1);
        UtilityFunction.drawCurve(399, 303, 394, 308, 395, 310, 408, 311, 1);
        UtilityFunction.drawCurve(408, 311, 409, 319, 416, 322, 429, 323, 1);
        UtilityFunction.drawCurve(429, 323, 431, 332, 442, 331, 444, 337, 1);
        UtilityFunction.drawLine(444, 337, 455, 339, 1);
        UtilityFunction.drawLine(455, 339, 457, 341, 1);
        UtilityFunction.drawLine(457, 341, 457, 346, 1);

        UtilityFunction.floodFillGradient(407, 293, 462, 345, new Color(0x5380ad), new Color(0xabc2d3),Color.BLACK);
        UtilityFunction.floodFillGradient(407, 291-40, 462, 345-40, new Color(0x5380ad), new Color(0xabc2d3),Color.BLACK);
    }
}


final class UtilityFunction {
    private static Graphics g;
    private static BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
    private static Graphics2D g2 = buffer.createGraphics();
    private static ArrayList<Integer> fireworkRGBColor = new ArrayList<>();
    // set Graphics in this class not null
    public static void setupUtilityFunction(Graphics graphics){
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600,600);
        g = graphics;
    }
    // set FireWork Color use in FloodFill
    public static void setFireWorkRGBColor(Color[] allColors){
        for(Color color : allColors){
            fireworkRGBColor.add(color.getRGB());
        }
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
    public static void drawCurve(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,int size,Color c){
        y1 -= 40; y2 -= 40; y3 -= 40;y4 -= 40;// custom for java JFrame
        for(double t = 0;t <= 1;t += 0.001){
            int x = (int)(Math.pow(1 - t,3)*x1 + 3*t*Math.pow(1 - t,2)*x2 + 3*t*t*(1 - t)*x3 + Math.pow(t, 3)*x4);
            int y = (int)(Math.pow(1 - t,3)*y1 + 3*t*Math.pow(1 - t,2)*y2 + 3*t*t*(1 - t)*y3 + Math.pow(t, 3)*y4);
            plot(x, y,c,size);
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
    // draw Cicle use default colot (black)
    public static void drawCircle(int centerX,int centerY,int radius,int size){
        drawCircle(centerX, centerY, radius,size,Color.black);
    }
    // draw Cicle (use Chat-Gpt version)
    public static void drawCircle(int centerX, int centerY, int radius,int size,Color c) {
        int x = radius;
        int y = 0;
        centerY-=30;
        int radiusError = 1 - x;

        while (x >= y) {
            plot(centerX + x, centerY - y,c,size);
            plot(centerX - x, centerY - y,c,size);
            plot(centerX + x, centerY + y,c,size);
            plot(centerX - x, centerY + y,c,size);
            plot(centerX + y, centerY - x,c,size);
            plot(centerX - y, centerY - x,c,size);
            plot(centerX + y, centerY + x,c,size);
            plot(centerX - y, centerY + x,c,size);

            y++;

            if (radiusError < 0) {
                radiusError += 2 * y + 1;
            } else {
                x--;
                radiusError += 2 * (y - x) + 1;
            }
        }
    }
    // draw Cicle only 6 Octants use in moon shadow
    public static void drawHalfCircle(int centerX, int centerY, int radius,int size,Color c) {
        int x = radius;
        int y = 0;
        centerY-=30;
        int radiusError = 1 - x;

        while (x >= y) {
            plot(centerX + x, centerY - y,c,size);
            plot(centerX - x, centerY - y,c,size);
            plot(centerX + x, centerY + y,c,size);
            plot(centerX - x, centerY + y,c,size);
            plot(centerX + y, centerY + x,c,size);
            plot(centerX - y, centerY + x,c,size);

            y++;

            if (radiusError < 0) {
                radiusError += 2 * y + 1;
            } else {
                x--;
                radiusError += 2 * (y - x) + 1;
            }
        }
    }

    // FloodFill
    public static void Floodfill(int x,int y,Color target_color,Color replacement_color){
        y-= 40;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        buffer.setRGB(x, y, replacement_color.getRGB());
        while(!q.isEmpty()){
            Point p = q.poll();
            // w
            if(p.y - 1 >= 0 && buffer.getRGB(p.x , p.y - 1) == target_color.getRGB()){
                buffer.setRGB(p.x, p.y - 1, replacement_color.getRGB());
                q.add(new Point(p.x, p.y - 1));
            }
            // e
            if(p.y + 1 <= 600 && buffer.getRGB(p.x , p.y + 1) == target_color.getRGB()){
                buffer.setRGB(p.x, p.y + 1, replacement_color.getRGB());
                q.add(new Point(p.x, p.y + 1));
            }
            // n
            if(p.x - 1 >= 0 && buffer.getRGB(p.x - 1, p.y) == target_color.getRGB()){
                buffer.setRGB(p.x - 1,p.y, replacement_color.getRGB());
                q.add(new Point(p.x - 1, p.y));
            }
            // s
            if(p.x + 1 <= 600 && buffer.getRGB(p.x + 1, p.y) == target_color.getRGB()){
                buffer.setRGB(p.x + 1,p.y, replacement_color.getRGB());
                q.add(new Point(p.x + 1, p.y));
            }
        }
        g.drawImage(buffer, 0,0,null);
    }
    // Floodfill use only unknown background color
    // use border_color to exit loop
    public static void FloodfillUpgrade(int x,int y,Color border_color,Color replacement_color){
        y-= 40;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        buffer.setRGB(x, y, replacement_color.getRGB());
        while(!q.isEmpty()){
            Point current = q.poll();
            // w
            if(current.y - 1 >= 0 && buffer.getRGB(current.x , current.y - 1) != border_color.getRGB() && buffer.getRGB(current.x , current.y - 1) != replacement_color.getRGB()){
                buffer.setRGB(current.x, current.y - 1, replacement_color.getRGB());
                q.add(new Point(current.x, current.y - 1));
            }
            // e
            if(current.y + 1 <= 600 && buffer.getRGB(current.x , current.y + 1) != border_color.getRGB() && buffer.getRGB(current.x , current.y + 1) != replacement_color.getRGB()){
                buffer.setRGB(current.x, current.y + 1, replacement_color.getRGB());
                q.add(new Point(current.x, current.y + 1));
            }
            // n
            if(current.x - 1 >= 0 && buffer.getRGB(current.x - 1, current.y) != border_color.getRGB() && buffer.getRGB(current.x - 1 , current.y) != replacement_color.getRGB()){
                buffer.setRGB(current.x - 1,current.y, replacement_color.getRGB());
                q.add(new Point(current.x - 1, current.y));
            }
            // s
            if(current.x + 1 <= 600 && buffer.getRGB(current.x + 1, current.y) != border_color.getRGB() && buffer.getRGB(current.x + 1 , current.y) != replacement_color.getRGB()){
                buffer.setRGB(current.x + 1,current.y, replacement_color.getRGB());
                q.add(new Point(current.x + 1, current.y));
            }
        }
        g.drawImage(buffer, 0,0,null);
    }
    // floodfill แต่ไล่สีในแนวตั้ง
    public static void floodFillGradient(int xStart, int yStart, int xEnd, int yEnd,Color startColor, Color endColor, Color target) {
        Queue<Point> q = new LinkedList<>();

        float ratio = (float) (yStart - yStart) / (yEnd - yStart - 1);

        Color lineColor = interpolateColor(startColor, endColor, ratio);
        Color lineColor1 = interpolateColor(startColor, endColor, ratio);
        Color lineColor2 = interpolateColor(startColor, endColor, ratio);

        if (buffer.getRGB(xStart, yStart) != target.getRGB()) {
            plot(xStart, yStart,lineColor, 1);
            q.add(new Point(xStart, yStart));
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            ratio = (float) (p.y - yStart) / (yEnd - yStart - 1);
            lineColor = interpolateColor(startColor, endColor, ratio);

            // y-1
            ratio = (float) (p.y - yStart - 1) / (yEnd - yStart - 1);
            lineColor1 = interpolateColor(startColor, endColor, ratio);

            // y+1
            ratio = (float) (p.y - yStart + 1) / (yEnd - yStart - 1);
            lineColor2 = interpolateColor(startColor, endColor, ratio);

            // s
            if (p.y + 1 < 600 && (buffer.getRGB(p.x, p.y + 1) != target.getRGB()) &&  (!fireworkRGBColor.contains(buffer.getRGB(p.x, p.y + 1)))) {
                if (buffer.getRGB(p.x, p.y + 1) != lineColor2.getRGB()) {
                    //plot(p.x, p.y + 1,lineColor2, 1);
                    buffer.setRGB(p.x,p.y + 1,lineColor2.getRGB());
                    q.add(new Point(p.x, p.y + 1));
                }
            }
            // n
            if (p.y - 1 > 0 && (buffer.getRGB(p.x, p.y - 1) != target.getRGB()) && (!fireworkRGBColor.contains(buffer.getRGB(p.x, p.y - 1)))) {
                if (buffer.getRGB(p.x, p.y - 1) != lineColor1.getRGB()) {
                    //plot(p.x, p.y - 1,lineColor1, 1);
                    buffer.setRGB(p.x,p.y - 1,lineColor1.getRGB());
                    q.add(new Point(p.x, p.y - 1));
                }
            }
            // e
            if (p.x + 1 < 600 && (buffer.getRGB(p.x + 1, p.y) != target.getRGB()) && (!fireworkRGBColor.contains(buffer.getRGB(p.x + 1, p.y)))) {
                if (buffer.getRGB(p.x + 1, p.y) != lineColor.getRGB()) {
                    //plot(p.x + 1, p.y,lineColor,1);
                    buffer.setRGB(p.x + 1,p.y,lineColor.getRGB());
                    q.add(new Point(p.x + 1, p.y));
                }
            }
            // w
            if (p.x - 1 > 0 && (buffer.getRGB(p.x - 1, p.y) != target.getRGB()) && (!fireworkRGBColor.contains(buffer.getRGB(p.x - 1, p.y)))) {
                if (buffer.getRGB(p.x - 1, p.y) != lineColor.getRGB()) {
                    //plot(p.x - 1, p.y, lineColor,1);
                    buffer.setRGB(p.x - 1,p.y,lineColor.getRGB());
                    q.add(new Point(p.x - 1, p.y));
                }
            }
        }
        g.drawImage(buffer, 0,0,null);
    }
     // floodfill แต่ไล่สีในแนวนอน
    public static void floodFillGradienthorizontal(int xStart, int yStart, int xEnd, int yEnd, Color startColor, Color endColor, Color target) {
        Queue<Point> q = new LinkedList<>();

        float ratio = (float) (xStart - xStart) / (xEnd - xStart - 1);

        Color lineColor = interpolateColor(startColor, endColor, ratio);
        Color lineColor1 = interpolateColor(startColor, endColor, ratio);
        Color lineColor2 = interpolateColor(startColor, endColor, ratio);

        if (buffer.getRGB(xStart, yStart) != target.getRGB()) {
            plot(xStart, yStart,lineColor, 1);
            q.add(new Point(xStart, yStart));
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            ratio = (float) (p.x - xStart) / (xEnd - xStart - 1);
            lineColor = interpolateColor(startColor, endColor, ratio);

            // x-1
            ratio = (float) (p.x - xStart - 1) / (xEnd - xStart - 1);
            lineColor1 = interpolateColor(startColor, endColor, ratio);

            // x+1
            ratio = (float) (p.x - xStart + 1) / (xEnd - xStart - 1);
            lineColor2 = interpolateColor(startColor, endColor, ratio);

            // s
            if (p.y + 1 < 600 && (buffer.getRGB(p.x, p.y + 1) != target.getRGB())) {
                if (buffer.getRGB(p.x, p.y + 1) != lineColor.getRGB()) {
                    //plot(p.x, p.y + 1,lineColor2, 1);
                    buffer.setRGB(p.x,p.y + 1,lineColor.getRGB());
                    q.add(new Point(p.x, p.y + 1));
                }
            }
            // n
            if (p.y - 1 > 0 && (buffer.getRGB(p.x, p.y - 1) != target.getRGB())) {
                if (buffer.getRGB(p.x, p.y - 1) != lineColor.getRGB()) {
                    //plot(p.x, p.y - 1,lineColor1, 1);
                    buffer.setRGB(p.x,p.y - 1,lineColor.getRGB());
                    q.add(new Point(p.x, p.y - 1));
                }
            }
            // e
            if (p.x + 1 < 600 && (buffer.getRGB(p.x + 1, p.y) != target.getRGB())) {
                if (buffer.getRGB(p.x + 1, p.y) != lineColor2.getRGB()) {
                    //plot(p.x + 1, p.y,lineColor,1);
                    buffer.setRGB(p.x + 1,p.y,lineColor2.getRGB());
                    q.add(new Point(p.x + 1, p.y));
                }
            }
            // w
            if (p.x - 1 > 0 && (buffer.getRGB(p.x - 1, p.y) != target.getRGB())) {
                if (buffer.getRGB(p.x - 1, p.y) != lineColor1.getRGB()) {
                    //plot(p.x - 1, p.y, lineColor,1);
                    buffer.setRGB(p.x - 1,p.y,lineColor1.getRGB());
                    q.add(new Point(p.x - 1, p.y));
                }
            }
        }
        g.drawImage(buffer, 0,0,null);
    }


    private static Color interpolateColor(Color startColor, Color endColor, float ratio) {
        int red = Math.max(0, Math.min(255, (int) (startColor.getRed() * (1 - ratio) +
                        endColor.getRed() * ratio)));
        int green = Math.max(0, Math.min(255, (int) (startColor.getGreen() * (1 - ratio) +
                        endColor.getGreen() * ratio)));
        int blue = Math.max(0, Math.min(255, (int) (startColor.getBlue() * (1 - ratio) +
                        endColor.getBlue() * ratio)));
        return new Color(red, green, blue);
    }

    private static class Point{
        int x,y;
        Point(int x,int y){this.x = x;this.y = y;}
    }

    // plot dot(vertex) at (x,y)
    private static void plot(int x,int y,Color c,int size){
        g2.setColor(c);
        g2.fillRect(x, y, size,size);
    }
}