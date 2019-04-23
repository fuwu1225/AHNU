package Day02_TomCat;

import javax.swing.*;

/**
 * @author fhk
 * @date 2019/4/23-19:07
 */
public class Toms {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        TomsPanel panel =new TomsPanel();
        frame.add(panel);
        Thread thread=new Thread(panel);
        thread.start();
        frame.addMouseListener(panel);

        frame.setSize(512,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
