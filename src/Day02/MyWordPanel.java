package Day02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author fhk
 * @date 2019/4/23-9:32
 */

/**
 * &#x6253;&#x5b57;&#x6e38;&#x620f;
 * &#x4e0b;&#x843d;
 * &#x76d1;&#x542c;
 */
public class MyWordPanel extends JPanel implements Runnable, KeyListener {

    /*第一区域*/
    int[] xx = new int[10];
    int[] yy = new int[10];
    char[] words = new char[10];
    int score = 0;

    public MyWordPanel() {
        for (int i = 0; i < 10; i++) {
            xx[i] = (int) (Math.random() * 800);
            yy[i] = (int) (Math.random() * 600);
            words[i] = (char) ((Math.random() * 26 + 65));

        }
    }

    /*第二区域*/
    /*第三区域*/
    public void paint(Graphics g) {
        this.setBackground(Color.pink);
        super.paint(g);
        Font ft = new Font("微软雅黑", Font.BOLD, 33);
        g.setFont(ft);

        for (int i = 0; i < 10; i++) {
            g.drawString(words[i] + "", xx[i], yy[i]);
        }
        g.drawString("score:" + score, 33, 33);
    }

    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                yy[i]++;
                if (yy[i] > 600)
                    yy[i] = 0;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }


    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        //判断
        for (int i = 9; i >= 0; i--) {
            if (words[i] == key) {
                words[i] = (char) ((Math.random() * 26) + 65);
                xx[i] = (int) (Math.random() * 800);
                yy[i] = -(int) (Math.random() * 600);
                score += 10;
                break;
            }

        }
        System.out.println(key);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

