package Day03;

import Day03.LTZJPanel;

import javax.swing.JFrame;

/**
 *
 * @author lenovo
 *
 */
public class LTZJ {
    public static void main(String[] args) {
        // 1.创建窗口
        JFrame frame = new JFrame("雷霆战机");
        /** 添加画布类 */
        LTZJPanel panel = new LTZJPanel();
        frame.add(panel);
        frame.addMouseMotionListener(panel);// 鼠标监听
        /** 添加线程关联 */
        Thread t = new Thread(panel);
        t.start();

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
