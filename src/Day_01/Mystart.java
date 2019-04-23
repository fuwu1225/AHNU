package Day_01;

import javax.swing.*;

/**
 * @author fhk
 * @date 2019/4/22-10:04
 */
public class Mystart {
    public static void main(String[] args) {
        JFrame frame = new JFrame();//新建对象
        /*画布类*/
        MyStartPanel panel = new MyStartPanel();//新建panel
        frame.add(panel);//在画板上添加画纸

        /*线程关联*/
        Thread thread = new Thread(panel);//线程启动
        thread.start();


        //相关属性设置
        frame.setSize(800, 600);//尺寸
        frame.setVisible(true);//可见性
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭模式
        frame.setLocationRelativeTo(null);//窗口居中
        //ArrayList list = new ArrayList();

    }
}
