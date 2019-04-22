package Day_01;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author fhk
 * @date 2019/4/22-10:56
 */
public class MyStartPanel extends JPanel {
    public void paint(Graphics g){
        super.paint(g);//g画笔,继承

        this.setBackground(Color.BLACK);//当前该对象背景颜色

        Font ft =new Font("微软雅黑",Font.BOLD,28);

        g.setFont(ft);


        for (int i = 0; i < 100; i++) {
            int x= (int)(Math.random()*800);
            int y= (int)(Math.random()*600);
            //五颜六色
            int R=(int)(Math.random()*256);
            int G=(int)(Math.random()*256);
            int B=(int)(Math.random()*256);
            Color randColor=new Color(R,G,B);
            g.setColor(randColor);
            g.drawString(".",x,y);
            //g.drawString("*",1000-i,i);

        }



        /*for (int i = 0; i <500 ; i++) {
            g.drawString("龙鸣",i,i);
        }*/
    }
}
