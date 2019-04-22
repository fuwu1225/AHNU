package Day_01_Test;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author fhk
 * @date 2019/4/22-16:12
 */
public class Ktlx  {
    public static void main(String[] args) {
        JFrame frame = new JFrame();//面板


        /*添加画布*/
        KtlxPanel panel = new KtlxPanel();
        frame.add(panel);


        /*添加线程*/
        Thread t = new Thread(panel);
        t.start();

        /*一些窗口属性设置*/
        frame.setBounds(100,100,340,240);
        frame.setTitle("test_01");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
