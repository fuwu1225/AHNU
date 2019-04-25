package Day03;

import Day03.LTZJBullet;
import Day03.LTZJHero;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//import org.omg.CORBA.PUBLIC_MEMBER;

public class LTZJPanel extends JPanel implements Runnable, MouseMotionListener {
    /**
     * 1.背景图片 1.1背景移动 1.2循环背景 2.英雄机 2.1父类FlyObject 2.2英雄机 2.3初始化英雄机类 2.4飞机移动
     * 3.1英雄机子弹 3.2存储多个子弹
     */
    private static final long serialVersionUID = 1L;
    /** 第一部分:变量声明区域 */
    // 1.1背景图片
    static BufferedImage back;
    int backY = 0;
    // 1.3英雄级图片集
    static BufferedImage ws0;
    static BufferedImage ws1;
    static BufferedImage ws2;
    static BufferedImage ws3;
    static BufferedImage ws4;
    static BufferedImage ws5;
    static BufferedImage ws6;
    static BufferedImage ws7;
    static BufferedImage ws8;
    static BufferedImage ws9;
    // 1.4英雄机
    LTZJHero hero = new LTZJHero();
    // 1.5子弹图片
    static BufferedImage bullets;
    // 1.6子弹数组
    LTZJBullet[] bs = {};
    /** 第二部分:静态代码块区域 */
    static {
        try {
            back = ImageIO.read(LTZJPanel.class.getResource("img/background.png"));
            ws0 = ImageIO.read(LTZJPanel.class.getResource("img/ws00.png"));
            ws1 = ImageIO.read(LTZJPanel.class.getResource("img/ws01.png"));
            ws2 = ImageIO.read(LTZJPanel.class.getResource("img/ws02.png"));
            ws3 = ImageIO.read(LTZJPanel.class.getResource("img/ws03.png"));
            ws4 = ImageIO.read(LTZJPanel.class.getResource("img/ws04.png"));
            ws5 = ImageIO.read(LTZJPanel.class.getResource("img/ws05.png"));
            ws6 = ImageIO.read(LTZJPanel.class.getResource("img/ws06.png"));
            ws7 = ImageIO.read(LTZJPanel.class.getResource("img/ws07.png"));
            ws8 = ImageIO.read(LTZJPanel.class.getResource("img/ws08.png"));
            ws9 = ImageIO.read(LTZJPanel.class.getResource("img/ws09.png"));
            bullets = ImageIO.read(LTZJPanel.class.getResource("img/bullets.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /** 第三部分:画笔方法区域 */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paintBack(g);
        paintHero(g);
        paintBullet(g);
    }

    // 3.1绘制背景图片
    public void paintBack(Graphics g) {
        if (backY > 768) {
            backY = 0;
        }
        backY++;
        g.drawImage(back, 0, backY, null);
        g.drawImage(back, 0, backY - 768, null);
    }

    // 3.2绘制英雄机
    public void paintHero(Graphics g) {
        g.drawImage(hero.image, hero.x, hero.y, hero.width, hero.height, null);
    }

    // 3.3绘制子弹
    public void paintBullet(Graphics g) {
        for (int i = 0; i < bs.length; i++) {
            LTZJBullet bt = bs[i];
            g.drawImage(bt.image, bt.x, bt.y, bt.width, bt.height, null);
        }
    }

    /** 第四部分:业务逻辑处理区域 */
    private void shootAction() {
        /** 英雄机子弹存储 */
        LTZJBullet bt = new LTZJBullet(hero.x, hero.y);
        // 数组扩容
        bs = Arrays.copyOf(bs, bs.length + 1);
        bs[bs.length - 1] = bt;
    }

    @Override
    public void run() {
        while (true) {
            // 4.1走一步
            stepAction();
            // 4.2射击
            shootAction();
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

    // 4.1走一步
    public void stepAction() {
        hero.step();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // 获取鼠标坐标值
        int mx = e.getX();
        int my = e.getY();
        // 设置英雄机移动
        hero.moveTo(mx, my);

    }
}
