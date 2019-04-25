package Day03;

import Day03.FlyObject;

import java.awt.image.BufferedImage;

public class LTZJHero extends FlyObject {
    /** 私有属性 */
    // 图片集
    private BufferedImage[] images;
    // 图片集转换值
    private int index;

    // 类的构造方法
    public LTZJHero() {
        /** 公共属性 */
        this.image = Day03.LTZJPanel.ws0;
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        this.x = 200;
        this.y = 500;
        this.index = 0;
        this.images = new BufferedImage[] { Day03.LTZJPanel.ws0, Day03.LTZJPanel.ws1, Day03.LTZJPanel.ws2, Day03.LTZJPanel.ws3, Day03.LTZJPanel.ws4,
                Day03.LTZJPanel.ws5, Day03.LTZJPanel.ws6, Day03.LTZJPanel.ws7, Day03.LTZJPanel.ws8, Day03.LTZJPanel.ws9 };
    }

    // 方法
    @Override
    public void step() {
        // 修改坐标值
        // 修改图片
        this.index++;
        int ix = this.index / 10 % this.images.length;// 每10帧更新一次图片
        this.image = this.images[ix];
    }

    @Override
    public boolean outOfBounds() {
        return false;
    }

    /** 鼠标控制英雄机 */
    public void moveTo(int mx, int my) {
        this.x = mx - this.width / 2;
        this.y = my - this.height / 2;
    }

}
