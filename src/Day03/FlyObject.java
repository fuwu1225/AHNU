package Day03;



import java.awt.image.BufferedImage;

/**
 * 飞行物类
 * 图片 image
 * 坐标值 x，y
 * 宽高 w,h
 *
 * 共同方法
 * step()
 * outofBounds()
 *
 * 抽象类
 * 抽象类和父类 和接口之间的区别
 * 继承：继承是单继承 只有一个 不需要重写  亲爹
 * 接口：多接口 必须实现重写  干爹
 * 抽象类：单继承 抽象方法则必须重写，抽象类中不一定有抽象方法但抽象方法一定在抽象类中
 *
 *
 *
 */
public abstract class FlyObject{
    /**属性*/
    public BufferedImage image;
    public int x,y,width,height;

    public abstract void step();
    public abstract boolean outOfBounds();
    public boolean hitby(Bullet bt){
        if(bt.x>this.x&&bt.x<this.x+this.width&&bt.y>this.y&&bt.y<this.y+this.height)
        {
            return true;
        }
        else return false;
    }


}
