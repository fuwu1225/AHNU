package Day03;

import Day03.GamePanel;

import java.awt.image.BufferedImage;

/**
 * 英雄机
 * @author kunkka
 *
 */
public class Hero extends FlyObject {
    /**私有属性*/
    //图片集
    private BufferedImage[] images;

    //图片集转换值
    private int index;
    //双倍活力值
    private int doubleFire;
    private int life;
    //属性
    //类的构造方法
    public Hero()
    {
        /**公共属性*/
        this.image= GamePanel.ws00;
        this.width=this.image.getWidth();
        this.height=this.image.getHeight();
        this.x=200;
        this.y=500;
        this.doubleFire=1;
        this.life=10;
        /**私有属性*/
        this.index=0;
        this.images=new BufferedImage[]{
                GamePanel.ws00,
                GamePanel.ws01,
                GamePanel.ws02,
                GamePanel.ws03,
                GamePanel.ws04,
                GamePanel.ws05,
                GamePanel.ws06,
                GamePanel.ws07,
                GamePanel.ws08,
                GamePanel.ws09
        };

    }
    //方法
    @Override
    public void step() {
        //修改坐标值
        //修改图片
        this.index++;

        int ix=this.index/10%this.images.length;
        this.image=this.images[ix];



    }
    public Bullet[] shootBy()
    {//定义数组
        Bullet[]bts=null;
        int wt=this.width/4;
        if(this.doubleFire>0)
        {
            //修改火力值
            this.doubleFire--;
            bts=new Bullet[2];
            bts[0]=new Bullet(this.x+1*wt,this.y);
            bts[1]=new Bullet(this.x+3*wt,this.y);
        }
        else{ bts=new Bullet[1];
            bts[0]=new Bullet(this.x+2*wt,this.y);}
        return bts;
    }

    @Override
    public boolean outOfBounds() {

        return false;
    }
    /**鼠标控制英雄机*/
    public void moveTo(int mx, int my) {
        this.x=mx-this.width/2;
        this.y=my-this.height/2;


    }
    public void adddoubleFire()
    {
        this.doubleFire=40;
    }
    public void addLife()
    {
        this.life+=5;
    }
    public int getLife()
    {
        return this.life;
    }
    public int getDoubleFire()
    {
        return this.doubleFire;
    }


}
