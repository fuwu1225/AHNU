package Day01_night;

import java.awt.*;

import javax.swing.JPanel;

/**
 * 小弹球画布类
 * 1.继承 JPanel
 * 2.实现Runnable
 * 3.重写 paint方法
 * 4.实现run方法
 * 5.run====>线程三部曲
 * 业务执行、线程睡眠、重绘方法
 */
public class MyBallPanel extends JPanel implements Runnable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 第一部分:变量声明区域
     **/
    int x = 30;
    int y = 30;
    int f = 0;
    int r, gg, b;
    int score = 0;
    //数组
    int[] xx = new int[5];
    int[] yy = new int[5];
    int[] ff = new int[5];
    Color[] colors = new Color[5];
    int speed = 5;

    /**
     * 第二部分:构造方法区域
     */
    public MyBallPanel() {
        for (int i = 0; i < 5; i++) {
            xx[i] = (int) (Math.random() * 700);
            yy[i] = (int) (Math.random() * 500);
            ff[i] = (int) (Math.random() * 4);
            colors[i] = updateColor();
        }
    }

    /**
     * 第三部分:画笔方法区域
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < 5; i++) {
            g.setColor(colors[i]);
            g.fillOval(xx[i], yy[i], 33, 33);
            //r = (int) (Math.random() * 255);
            // gg = (int) (Math.random() * 255);
            // b = (int) (Math.random() * 255);
            //colors[i]=new Color(r,gg,b);
            g.drawString("分数：" + score, 100, 100);

        }

    }


    /**
     * 第四部分:业务处理区域
     */
    @Override
    public void run() {
        while (true) {
            // 1.业务执行
            for (int i = 0; i < 5; i++) {
                if (ff[i] == 0) {
                    xx[i]++;
                    yy[i]++;
                }
                if (ff[i] == 1) {
                    xx[i]++;
                    yy[i]--;
                }
                if (ff[i] == 2) {
                    xx[i]--;
                    yy[i]--;
                }
                if (ff[i] == 3) {
                    xx[i]--;
                    yy[i]++;
                }
                if (xx[i] >= 800 && ff[i] == 0) {
                    colors[i] = updateColor();

                    //colors[i] = new Color(r, gg, b);
                    ff[i] = 3;
                    score += 50;

                }
                if (xx[i] >= 800 && ff[i] == 1) {
                    score += 50;


                    colors[i] = updateColor();

                    //colors[i] = new Color(r, gg, b);
                    ff[i] = 2;
                    score += 50;

                }
                if (xx[i] <= 0 && ff[i] == 3) {
                    colors[i] = updateColor();

                    //colors[i] = new Color(r, gg, b);
                    ff[i] = 0;
                    score += 50;

                }
                if (xx[i] <= 0 && ff[i] == 2) {
                    colors[i] = updateColor();

                    //colors[i] = new Color(r, gg, b);
                    ff[i] = 1;
                    score += 50;

                }
                if (yy[i] >= 600 && ff[i] == 0) {
                    colors[i] = updateColor();

                    //colors[i] = new Color(r, gg, b);
                    ff[i] = 1;
                    score += 50;

                }
                if (yy[i] >= 600 && ff[i] == 3) {
                    colors[i] = updateColor();

                    //colors[i] = new Color(r, gg, b);
                    ff[i] = 2;
                    score += 50;

                }
                if (yy[i] <= 0 && ff[i] == 2) {
                    colors[i] = updateColor();

                    //colors[i] = new Color(r, gg, b);
                    ff[i] = 3;
                    score += 50;

                }
                if (yy[i] <= 0 && ff[i] == 1) {
                    colors[i] = updateColor();
                    ff[i] = 0;
                    score += 50;
                }
            }
            //判断速度
            if (score > 500 && score <= 1000)
                speed = 3;
            else if (score > 1000 && score < 2000)
                speed = 2;
            else speed = 1;

            // 2.线程睡眠
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3.重绘方法
            repaint();
        }
    }

    /*修改颜色*/
    public Color updateColor() {
        int R = (int) (Math.random() * 255);
        int G = (int) (Math.random() * 255);
        int B = (int) (Math.random() * 255);
        return new Color(R, G, B);
    }
}