package Day03;


import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class AirPlane extends FlyObject implements Enemy{
    private BufferedImage[] images;

    // 图片集转换值
    private int index;
    int ystep = 3;
    public AirPlane() {
        /** 公共属性 */

        this.image = GamePanel.flys0;
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        this.x =(int) (Math.random() * 450);
        this.y = -(int) (Math.random() * 768);
        this.images = new BufferedImage[] { GamePanel.flys0, GamePanel.flys1,
                GamePanel.flys2, GamePanel.flys3, GamePanel.flys4, GamePanel.flys5,

        };
        /** 私有属性 */
        this.index = 0;


    }

    @Override
    public void step() {
        // 修改坐标值
        this.y=this.y+ystep;
        // 修改图片
        this.index++;
        int ix = this.index / 6 % this.images.length;
        this.image = this.images[ix];

    }

    @Override
    public boolean outOfBounds() {
        if(this.x>512||this.x<0||this.y>768||this.y<0)
            return true;
        else return false;
    }
    public int getScore()
    {
        return 10;
    }

}
