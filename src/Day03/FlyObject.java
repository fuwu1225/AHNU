package Day03;

import java.awt.image.BufferedImage;

/**
 * 父类 坐标xy，宽高wh 继承：单继承，不需要重写 接口：多接口，必须实现 抽象类：单继承，抽象方法则必须重写
 * 抽象类中不一定有抽象方法，抽象方法一定在抽象类中
 *
 */
public abstract class FlyObject {// 抽象类
    public BufferedImage image;
    public int x, y, width, height;

    /** 抽象方法 */
    public abstract void step();

    public abstract boolean outOfBounds();

}