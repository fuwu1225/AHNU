package Day01_night;
import javax.swing.JFrame;

/**
 * 小弹球
 *
 *
 */
public class MyBall {
    public static void main(String[] args){
        // 1.创建窗口
        JFrame frame = new JFrame("小弹球");
        /**添加画布类*/
        MyBallPanel panel = new MyBallPanel();
        frame.add(panel);
        /**添加线程关联*/
        Thread t = new Thread(panel);
        t.start();

        // 2.设置窗口大小
        frame.setSize(800, 600);
        // 3.设置关闭模式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 4.设置居中显示
        frame.setLocationRelativeTo(null);
        // 5.设置可见
        frame.setVisible(true);



    }
}