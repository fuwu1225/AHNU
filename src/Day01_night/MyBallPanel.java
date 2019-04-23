package Day01_night;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 小弹球画布类
 * 1.继承 JPanel
 * 2.实现Runnable
 * 3.重写 paint方法
 * 4.实现run方法
 * 5.run====>线程三部曲
 * 业务执行、线程睡眠、重绘方法
 *
 *
 *
 */
public class MyBallPanel extends JPanel implements Runnable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**第一部分:变量声明区域**/
    int x = 30;
    int y = 30;
    int f = 0;
    /**第二部分:构造方法区域*/

    /**第三部分:画笔方法区域*/
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 50, 50);
    }
    /**第四部分:业务处理区域*/
    @Override
    public void run() {
        while(true){
            // 1.业务执行
            if(f==0){x++;y++;}
            if(f==1){x++;y--;}
            if(f==2){x--;y--;}
            if(f==3){x--;y++;}
            if(x>=800&&f==0)	{f=3;}
            if(x>=800&&f==1)	{f=2;}
            if(x<=0&&f==3)		{f=0;}
            if(x<=0&&f==2)		{f=1;}
            if(y>=600&&f==0)	{f=1;}
            if(y>=600&&f==3)	{f=2;}
            if(y<=0&&f==2)		{f=3;}
            if(y<=0&&f==1)		{f=0;}
            // 2.线程睡眠
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3.重绘方法
            repaint();
        }
    }
}