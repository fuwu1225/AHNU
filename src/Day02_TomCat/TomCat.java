package Day02_TomCat;

import Day02_TomCat.TomCatPanel;

import javax.swing.JFrame;

/**
 *
 *
 *
 *
 */
public class TomCat {
    public static void main(String[] args) {
        // 1.创建窗口
        JFrame frame = new JFrame("TomCat");
        /** 添加画布类 */
        TomCatPanel panel = new TomCatPanel();
        frame.add(panel);
        /** 添加线程关联 */
        Thread t = new Thread(panel);
        t.start();
        /** 添加鼠标监听事件 */
        frame.addMouseListener(panel);
        // 2.设置窗口大小
        frame.setSize(512, 768);
        // 3.设置关闭模式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 4.设置居中显示
        frame.setLocationRelativeTo(null);
        // 5.设置可见
        frame.setVisible(true);

    }
}
