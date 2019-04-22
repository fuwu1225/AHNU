package Day_01;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author fhk
 * @date 2019/4/22-10:04
 */
public class Mystart {
    public static void main(String[] args) {
        JFrame frame = new JFrame();//新建对象
        MyStartPanel panel=new MyStartPanel();//新建panel
        frame.add(panel);//在画板上添加画纸


        frame.setSize(800, 600);//尺寸
        frame.setVisible(true);//可见性
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭模式
        frame.setLocationRelativeTo(null);//窗口居中

        //ArrayList list = new ArrayList();

       /*
        int i=0;
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        while (!list.isEmpty()) {
            if(i++<=5)
            System.out.println(list);
        }*/
    }
}
