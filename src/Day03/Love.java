package Day03;



import java.awt.image.BufferedImage;

public class Love extends FlyObject implements Award{
    private BufferedImage[] images;

    // 图片集转换值
    private int index;
    int ystep = 2;
    int flag=0;
    int awardType=(int)(Math.random()*2);
    public Love() {
        /** 公共属性 */

        this.image = GamePanel.qq00;
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        this.x =(int) (Math.random() * (512-this.image.getWidth()*1/2));
        this.y = -(int) (Math.random() * 768);
        this.images = new BufferedImage[] { GamePanel.qq00, GamePanel.qq01,
                GamePanel.qq02, GamePanel.qq03, GamePanel.qq04, GamePanel.qq05,
                GamePanel.qq06,GamePanel.qq07,GamePanel.qq08
        };
        /** 私有属性 */
        this.index = 0;


    }
    @Override
    public void step() {
        // 修改坐标值
        if(flag==0)
        {
            this.x+=this.ystep;
            this.y+=this.ystep;
        }
        if(flag==1)
        {
            this.x-=this.ystep;
            this.y+=this.ystep;

        }
        if(this.x>(512-this.image.getWidth()))
        {
            flag=1;
        }
        if(this.x<0)
        {
            flag=0;
        }


        // 修改图片
        this.index++;
        int ix = this.index / 9 % this.images.length;
        this.image = this.images[ix];
    }

    @Override
    public boolean outOfBounds() {
        if(this.x>512||this.x<0||this.y>768||this.y<0)
            return true;
        else return false;
    }
    public int getAwardType() {

        return this.awardType;
    }

}
