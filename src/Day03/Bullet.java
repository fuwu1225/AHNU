package Day03;

import Day03.GamePanel;

public class Bullet extends day03.FlyObject {

    /**构造方法*/
    public Bullet(int heroX,int heroY){
        /**公共属性初始化**/
        this.image= GamePanel.bullets;
        this.width=this.image.getWidth();
        this.height=this.image.getHeight();
        this.x=heroX;
        this.y=heroY;
    }

    @Override
    public void step() {
        // TODO Auto-generated method stub
        this.y--;

    }

    @Override
    public boolean outOfBounds() {
        if(this.x>512||this.x<0||this.y>768||this.y<0)
            return true;
        else return false;
    }
}
