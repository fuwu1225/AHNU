package Day02_TomCat;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 *
 *
 * @author lenovo
 *
 */
public class TomCatPanel extends JPanel implements Runnable, MouseListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /** 第一部分:变量声明区域 */
    BufferedImage back;// 声明背景图
    String[] eatList = new String[40];// 声明背景图片数组
    String[] angryList = new String[26];
    String[] cymbalList = new String[13];
    String[] drinkList = new String[81];
    String[] fartList = new String[28];
    String[] FLList = new String[30];
    String[] FRList = new String[30];
    String[] KnockoutList = new String[81];
    String[] pieList = new String[24];
    String[] scratchList = new String[56];
    String[] stomachList = new String[34];
    String[] name = eatList;
    int index = 0;// 声明动画频率值
    int count = -1;// 声明图片数量
    BufferedImage eat;// 吃鸟
    BufferedImage cymbal;
    BufferedImage drink;
    BufferedImage fart;
    BufferedImage pie;
    BufferedImage scratch;

    /** 第二部分:构造方法区域 */
    public TomCatPanel() {
        for (int i = 0; i < 40; i++) {// 初始化吃鸟动作
            if (i < 10)
                eatList[i] = "Animations/Eat/eat_0" + i + ".jpg";
            else
                eatList[i] = "Animations/Eat/eat_" + i + ".jpg";
        }
        for (int i = 0; i < 26; i++) {
            if (i < 10)
                angryList[i] = "Animations/Angry/angry_0" + i + ".jpg";
            else
                angryList[i] = "Animations/Angry/angry_" + i + ".jpg";
        }
        for (int i = 0; i < 13; i++) {
            if (i < 10)
                cymbalList[i] = "Animations/Cymbal/cymbal_0" + i + ".jpg";
            else
                cymbalList[i] = "Animations/Cymbal/cymbal_" + i + ".jpg";
        }
        for (int i = 0; i < 81; i++) {
            if (i < 10)
                drinkList[i] = "Animations/Drink/drink_0" + i + ".jpg";
            else
                drinkList[i] = "Animations/Drink/drink_" + i + ".jpg";
        }
        for (int i = 0; i < 28; i++) {
            if (i < 10)
                fartList[i] = "Animations/Fart/fart_0" + i + ".jpg";
            else
                fartList[i] = "Animations/Fart/fart_" + i + ".jpg";
        }
        for (int i = 0; i < 30; i++) {
            if (i < 10)
                FRList[i] = "Animations/FootRight/footRight_0" + i + ".jpg";
            else
                FRList[i] = "Animations/FootRight/footRight_" + i + ".jpg";
        }
        for (int i = 0; i < 30; i++) {
            if (i < 10)
                FLList[i] = "Animations/FootLeft/footLeft_0" + i + ".jpg";
            else
                FLList[i] = "Animations/FootLeft/footLeft_" + i + ".jpg";
        }
        for (int i = 0; i < 81; i++) {
            if (i < 10)
                KnockoutList[i] = "Animations/Knockout/knockout_0" + i + ".jpg";
            else
                KnockoutList[i] = "Animations/Knockout/knockout_" + i + ".jpg";
        }
        for (int i = 0; i < 24; i++) {
            if (i < 10)
                pieList[i] = "Animations/Pie/pie_0" + i + ".jpg";
            else
                pieList[i] = "Animations/Pie/pie_" + i + ".jpg";
        }
        for (int i = 0; i < 56; i++) {
            if (i < 10)
                scratchList[i] = "Animations/Scratch/scratch_0" + i + ".jpg";
            else
                scratchList[i] = "Animations/Scratch/scratch_" + i + ".jpg";
        }
        for (int i = 0; i < 34; i++) {
            if (i < 10)
                stomachList[i] = "Animations/Stomach/stomach_0" + i + ".jpg";
            else
                stomachList[i] = "Animations/Stomach/stomach_" + i + ".jpg";
        }
        try {
            back = ImageIO.read(TomCatPanel.class.getResource("Animations/Eat/eat_00.jpg"));
            eat = ImageIO.read(TomCatPanel.class.getResource("Buttons/eat.png"));
            cymbal = ImageIO.read(TomCatPanel.class.getResource("Buttons/cymbal.png"));
            drink = ImageIO.read(TomCatPanel.class.getResource("Buttons/drink.png"));
            fart = ImageIO.read(TomCatPanel.class.getResource("Buttons/fart.png"));
            pie = ImageIO.read(TomCatPanel.class.getResource("Buttons/pie.png"));
            scratch = ImageIO.read(TomCatPanel.class.getResource("Buttons/scratch.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** 第三部分:画笔方法区域 */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(back, 0, 0, 512, 768, null);// 显示图片
        g.drawImage(eat, 50, 300, 60, 60, null);
        g.drawImage(cymbal, 50, 400, 60, 60, null);
        g.drawImage(drink, 50, 500, 60, 60, null);
        g.drawRect(50, 500, 60, 60);
        g.drawImage(fart, 400, 300, 60, 60, null);
        g.drawImage(pie, 400, 400, 60, 60, null);
        g.drawImage(scratch, 400, 500, 60, 60, null);
        g.setColor(Color.pink);


        g.drawRect(350, 630, 60, 60);
        g.drawString("Angry", 350, 630);


        g.drawRect(260, 670, 60, 60);
        g.drawString("FootLeft", 260, 670);


        g.drawRect(170, 670, 60, 60);
        g.drawString("FootRight", 170, 670);


        g.drawRect(230, 130, 60, 60);
        g.drawString("Knockout", 230, 130);


        g.drawRect(230, 550, 60, 60);
        g.drawString("Stomach", 230, 550);
    }

    /** 第四部分:业务处理区域 */
    @Override
    public void run() {
        while (true) {
            // 1.业务执行
            index++;// 修改图片频率值
            if (index >= count) {// 控制动画效果
                // 结束动画
                index = 0;
                count = -1;
            } else {
                // 开始动画
                try {
                    back = ImageIO.read(TomCatPanel.class.getResource(name[index]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 根据频率修改图片内容
            // 2.线程睡眠
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3.重绘方法
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 获取鼠标的坐标值
        int mx = e.getX();
        int my = e.getY();
        // 判断鼠标坐标值是否相等
        if (mx > 50 && mx < 50 + 60 && my > 300 && my < 300 + 60) {
            System.out.println("单击");
            // 设置count值
            count = 40;
            name = eatList;
        }
        if (mx > 50 && mx < 50 + 60 && my > 400 && my < 400 + 60) {
            System.out.println("单击");
            // 设置count值
            count = 13;
            name = cymbalList;
        }
        if (mx > 50 && mx < 50 + 60 && my > 500 && my < 500 + 60) {
            System.out.println("单击");
            // 设置count值
            count = 81;
            name = drinkList;
        }
        if (mx > 400 && mx < 400 + 60 && my > 300 && my < 300 + 60) {
            System.out.println("单击");
            // 设置count值
            count = 28;
            name = fartList;
        }
        if (mx > 400 && mx < 400 + 60 && my > 400 && my < 400 + 60) {
            System.out.println("单击");
            // 设置count值
            count = 24;
            name = pieList;
        }
        if (mx > 400 && mx < 400 + 60 && my > 500 && my < 500 + 60) {
            System.out.println("单击");
            // 设置count值
            count = 56;
            name = scratchList;
        }
        if (mx > 350 && mx < 350 + 60 && my > 630 && my < 630 + 60) {
            System.out.println("单击");
            // 设置count值
            count = 26;
            name = angryList;
        }
        if (mx > 260 && mx < 260 + 60 && my > 670 && my < 670 + 60) {
            System.out.println("单击");
            // 设置count值
            count = 30;
            name = FLList;
        }
        if (mx > 170 && mx < 170 + 60 && my >670 && my < 670 + 60) {
            System.out.println("单击");
            // 设置count值
            count = 30;
            name = FRList;
        }
        if (mx > 230 && mx < 230 + 60 && my > 130 && my < 130 + 60) {
            System.out.println("单击");
            // 设置count值
            count = 81;
            name = KnockoutList;
        }if (mx > 230 && mx < 230 + 60 && my > 550 && my < 550 + 60) {
            System.out.println("单击");
            // 设置count值
            count = 34;
            name = stomachList;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
