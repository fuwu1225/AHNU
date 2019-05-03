package Day03;

/**
 * @author fhk
 * @date 2019/4/26-16:35
 */


import javax.swing.JFrame;

// 雷霆战机

public class LTZJ {

    public static void main(String[] args) {
        // 1.创建窗口
        JFrame frame = new JFrame("雷霆战机");
        /**画布类**/
        GamePanel panel = new GamePanel();
        frame.add(panel);
        /**线程*/
        Thread t = new Thread(panel);
        t.start();
        /**鼠标监听*/
        frame.addMouseMotionListener(panel);

        // 2.设置尺寸
        frame.setSize(512, 768);
        // 3.设置居中显示
        frame.setLocationRelativeTo(null);
        // 4.设置关闭模式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 5.设置可见
        frame.setVisible(true);



    }
}
