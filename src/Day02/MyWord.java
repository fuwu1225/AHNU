package Day02;

import com.sun.source.tree.NewArrayTree;

import javax.swing.*;
import java.awt.*;

/**
 * @author fhk
 * @date 2019/4/23-9:31
 */
public class MyWord {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        MyWordPanel myWordPanel= new MyWordPanel();
        frame.add(myWordPanel);




        Thread thread=new Thread(myWordPanel);



        thread.start();
        /*键盘*/
        myWordPanel.addKeyListener(myWordPanel);



        frame.setSize(800,600);

        frame.setTitle("gouwanyier");

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        /*
        *
        *
        *
        * jiaodianshezhi1*/
        myWordPanel.setFocusable(true);

    }
}
