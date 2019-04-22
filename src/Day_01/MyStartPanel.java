package Day_01;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author fhk
 * @date 2019/4/22-10:56
 */
/*
 * 线程和进程
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * */
public class MyStartPanel extends JPanel implements Runnable {

    int[] xx = new int[100];//全局变量
    int[] yy = new int[100];//全局变量

    /*
     * 构造方法
     * 只执行一次
     * 在new mystattpanel调用
     * 不写系统会自动创建
     *
     * */
    public MyStartPanel() {
        for (int i = 0; i < 100; i++) {
            xx[i] = (int) (Math.random() * 800);
            yy[i] = (int) (Math.random() * 600);
        }//数组初始化

    }

    public void paint(Graphics g) {
        super.paint(g);//g画笔,继承

        this.setBackground(Color.BLACK);//当前该对象背景颜色


        //5：设置月亮
        g.setColor(Color.GRAY);
        g.fillOval(66, 66, 66, 100);//x,y,w,h,(x,y)左上角坐标，w宽，h

        g.setColor(Color.black);
        g.fillOval(44, 44, 66, 100);//x,y,w,h,(x,y)左上角坐标，w宽，h高


        Font ft = new Font("微软雅黑", Font.BOLD, 28);

        g.setFont(ft);


        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * 800);
            int y = (int) (Math.random() * 600);
            //五颜六色
            int R = (int) (Math.random() * 256);
            int G = (int) (Math.random() * 256);
            int B = (int) (Math.random() * 256);
            Color randColor = new Color(R, G, B);
            g.setColor(randColor);
            g.drawString("你滴寒王", xx[i], yy[i]);
            //g.drawString("*",1000-i,i);

        }



        /*for (int i = 0; i <500 ; i++) {
            g.drawString("龙鸣",i,i);
        }*/
    }

    public void run() {
        while (true) {
            //1业务执行
            /*流星雨*/
            for (int i = 0; i < 100; i++) {
                xx[i]++;
                //yy[i]++;
                if (xx[i] > 800)
                    xx[i] = 0;
                if (yy[i] > 600)
                    yy[i] = 0;
            }
            //2睡眠方法
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //3调用重绘方法
            repaint();//擦掉，重绘，一直循环
        }
    }
}
