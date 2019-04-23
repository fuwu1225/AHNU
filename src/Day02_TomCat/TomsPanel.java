package Day02_TomCat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author fhk
 * @date 2019/4/23-19:09
 */
public class TomsPanel extends JPanel implements MouseListener, Runnable {
    /*1*/
    /*1.1*/
    BufferedImage back;
    String[] images = new String[100];

    int index = 0;
    int count = -1;
    BufferedImage eat;
    BufferedImage drink;
    BufferedImage fart;//放屁
    BufferedImage pie;//吃金拱门
    BufferedImage scratch;//踩尾巴
    BufferedImage cymbal;//敲锣


    /*2*/
    public TomsPanel() {
        //背景初始化
        try {
            back = ImageIO.read(TomsPanel.class.getResource("Animations/Eat/eat_00.jpg"));
            eat = ImageIO.read(TomsPanel.class.getResource("Buttons/eat.png"));
            drink = ImageIO.read(TomsPanel.class.getResource("Buttons/drink.png"));
            fart = ImageIO.read(TomsPanel.class.getResource("Buttons/fart.png"));//
            pie = ImageIO.read(TomsPanel.class.getResource("Buttons/pie.png"));//吃
            scratch = ImageIO.read(TomsPanel.class.getResource("Buttons/scratch.png"));
            cymbal = ImageIO.read(TomsPanel.class.getResource("Buttons/cymbal.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*3*/
    public void paint(Graphics g) {
        super.paint(g);
        /*back:左上角
         *
         * */
        g.drawImage(back,0,0,512,768,null);
        g.drawImage(eat,50,350,60,60,null);
        g.drawImage(drink,50,450,60,60,null);
        g.drawImage(cymbal,50,550,60,60,null);
        g.drawImage(fart,400,350,60,60,null);
        g.drawImage(scratch,400,450,60,60,null);




    }

    /*4*/

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int mx = mouseEvent.getX();
        int my = mouseEvent.getY();
        if (mx > 50 && mx < 110 && my > 350 && my < 410) {
            count = 40;
            updateImage("eat");
        }
        if (mx > 50 && mx < 110 && my > 450 && my < 510) {
            count = 81;
            updateImage("drink");
        }


    }

    //鼠标修改image值
    public void updateImage(String name) {
        for (int i = 0; i < count; i++) {
            if (i < 10) {
                images[i] = "Animations/" + "/" + name + "_0" + i + ".jpg";
            } else {
                images[i] = "Animations/" + "/" + name + "_" + i + ".jpg";

            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void run() {
        while (true) {
            index++;
            if (count > index) {
                try {
                    back = ImageIO.read(TomsPanel.class.getResource(images[index]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                count = -1;
                index = 0;
            }

            try {
                back=ImageIO.read(TomsPanel.class.getResource(images[index]));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //重绘
            repaint();
        }
    }
}
