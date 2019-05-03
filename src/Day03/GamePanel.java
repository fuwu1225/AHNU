package Day03;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 1.画布类
 * 	1.1背景移动backY
 * 	1.2循环背景
 * 2英雄机
 * 	2.1父类 FLYObject飞行物类
 * 	2.2英雄类hero英雄机
 * 	2.3
 * 	2.4飞机翱翔
 * 	2.5飞机移动
 * 3.英雄机子弹
 * 	3.1Bullet子弹类
 * 	3.2存储多个子弹bt
 * 	3.3绘制子弹
 *	3.4子弹移动
 *	3.5设置子弹频率 shootIndex
 * 4.敌机
 * 	4.1敌机类Airplane
 * 		注意事项： 图片集images、 图片转换值index step方法：修改坐标、修改图片
 * 		x,y====>随机函数512-width y坐标 必须是负数
 * 	4.2GamePanel
 * 		数组 flys
 * 	4.3ShootAction
 * 		创建存储Airplane对象
 * 	4.4第三区域:绘制敌机
 * 		3.4方法paintFly(g);
 * 	4.5第四区域：
 * 			4.1stepAction 调用方法
 * 			yStep=2;
 * 5.爱心
 * 	5.1Love
 * 	注意：爱心走S型
 * 	5.2 GamePanel
 * 		flys数组中
 * 		修改FlyObject[]
 * 	5.3ShootAction
 * 	创建存储：频率来20%存储爱心百分之80存储敌机
 * 	5.4修改绘制敌机3.4方法
 * 	Airplane ap=flys[i];改成FlyObject ap=flys[i];
 *
 * 6.出界判断
 * 	6.1第四区域：4.3outofBounds
 * 	6.2调用所有对象outofBounds
 * 	6.3出界消失
 * 	if(bs[i].outOfBoundns()){
 * 		bs[i]=bs[bs.length-1];
 * 		bs=Arrays.copyOf(bs,bs.length()-1)
 * 	}
 *
 *
 * 7.碰撞判断
 * 		7.1第四区域：4.4方法hitAction
 *			 将每一颗英雄机子弹拿出来
 *			hit(bt,i):bt子弹对象 i该子弹下标
 *		7.2 4.4.1方法hit（Bullet bt,i）
 * 			每颗子弹与flys中每一个对象比较
 * 			FlyObject object=flys[i]
 * 			if(object.hitBy(bt））{
 * 				//出界处理
 * 			}
 *		7.3 FlyObject 下方
 *			hitBy(Bullet bt)
 *			{
 *			}
 *		9.英雄机属性设置
 *		9.1英雄机的双倍火力
 *		9.2 生命值
 *		9.3
 *  10BOSS机器
 *  		10.1Boss类
 *  			图片集 频率值 xStep ySTep
 *  		10.2 GanmePanel
 *  			Boss[]bss 存储所有的Boss机
 *  		10.3在shootAction中
 *  			shootindex%12==0；
 * 			Boss机加入BSS
 * 			10.4绘制paintBoss
 * 			10.5setAction
 * 	11 Boss机器子弹
 * 		11.1 BossBullet
 * 		11.2 注意事项：
 * 			shootAction -->boos 子弹添加
 * 			if（bss.length>0）
 * 				for(i<bss.length) 添加子弹
 * 		11.3 绘制boos机子弹
 * 		11.4 stepAction调用移动
 * 		11,6 hitAction取出所有的Boos子弹
 *
 *
 */
public class GamePanel extends JPanel implements Runnable, MouseMotionListener {
    /** 变量声明区域 */
    // 1.1背景图片
    static BufferedImage back;
    // 1.2背景移动
    int backY = 0;
    // 1.3英雄机图片集
    static BufferedImage ws00;
    static BufferedImage ws01;
    static BufferedImage ws02;
    static BufferedImage ws03;
    static BufferedImage ws04;
    static BufferedImage ws05;
    static BufferedImage ws06;
    static BufferedImage ws07;
    static BufferedImage ws08;
    static BufferedImage ws09;
    static BufferedImage bossbu;
    static BufferedImage bossbu0;
    static BufferedImage bossbu1;

    // 1.4英雄机
    Hero hero = new Hero();
    Boss boss=new Boss();
    // 1.5子弹图片
    static BufferedImage bullets;
    // 1.6子弹数组
    Bullet[] bs = {};
    Bossbullet [] bbss={};
    // 1.7射击频率值
    int shootIndex = 0;

    // 1.8敌机图片集
    static BufferedImage flys0;
    static BufferedImage flys1;
    static BufferedImage flys2;
    static BufferedImage flys3;
    static BufferedImage flys4;
    static BufferedImage flys5;
    // 1.9敌机
    FlyObject[] flys = {};
    // 1.10 移动速度ystep
    //static int ystep = 1;
    // 1.11敌机产生频率
    int airIndex = 0;
    //分数值
    int score=0;
    //1.11boss机图片
    static BufferedImage boss0;
    static BufferedImage boss1;
    // 1.12爱心图片集
    static BufferedImage qq00;
    static BufferedImage qq01;
    static BufferedImage qq02;
    static BufferedImage qq03;
    static BufferedImage qq04;
    static BufferedImage qq05;
    static BufferedImage qq06;
    static BufferedImage qq07;
    static BufferedImage qq08;
    Boss[]bss={};
//	static BufferedImage boss2;
//	static BufferedImage boss3;
//	static BufferedImage boss4;
    /** 静态代码区域 */
    static {
        try {
            back = ImageIO.read(GamePanel.class
                    .getResource("img/background.png"));
            ws00 = ImageIO.read(GamePanel.class.getResource("img/ws00.png"));
            ws01 = ImageIO.read(GamePanel.class.getResource("img/ws01.png"));
            ws02 = ImageIO.read(GamePanel.class.getResource("img/ws02.png"));
            ws03 = ImageIO.read(GamePanel.class.getResource("img/ws03.png"));
            ws04 = ImageIO.read(GamePanel.class.getResource("img/ws04.png"));
            ws05 = ImageIO.read(GamePanel.class.getResource("img/ws05.png"));
            ws06 = ImageIO.read(GamePanel.class.getResource("img/ws06.png"));
            ws07 = ImageIO.read(GamePanel.class.getResource("img/ws07.png"));
            ws08 = ImageIO.read(GamePanel.class.getResource("img/ws08.png"));
            ws09 = ImageIO.read(GamePanel.class.getResource("img/ws09.png"));
            flys0=ImageIO.read(GamePanel.class.getResource("img/flys0.png"));
            flys1=ImageIO.read(GamePanel.class.getResource("img/flys1.png"));
            flys2=ImageIO.read(GamePanel.class.getResource("img/flys2.png"));
            flys3=ImageIO.read(GamePanel.class.getResource("img/flys3.png"));
            flys4=ImageIO.read(GamePanel.class.getResource("img/flys4.png"));
            flys5=ImageIO.read(GamePanel.class.getResource("img/flys5.png"));
            qq00=ImageIO.read(GamePanel.class.getResource("img/qq00.png"));
            qq01=ImageIO.read(GamePanel.class.getResource("img/qq01.png"));
            qq02=ImageIO.read(GamePanel.class.getResource("img/qq02.png"));
            qq03=ImageIO.read(GamePanel.class.getResource("img/qq03.png"));
            qq04=ImageIO.read(GamePanel.class.getResource("img/qq04.png"));
            qq05=ImageIO.read(GamePanel.class.getResource("img/qq05.png"));
            qq06=ImageIO.read(GamePanel.class.getResource("img/qq06.png"));
            qq07=ImageIO.read(GamePanel.class.getResource("img/qq07.png"));
            qq08=ImageIO.read(GamePanel.class.getResource("img/qq08.png"));
            boss0=ImageIO.read(GamePanel.class.getResource("img/boss0.png"));
            boss1=ImageIO.read(GamePanel.class.getResource("img/boss1.png"));
            bossbu=ImageIO.read(GamePanel.class.getResource("img/bossbu.png"));
            bossbu0=ImageIO.read(GamePanel.class.getResource("img/bossbu0.png"));
            bossbu1=ImageIO.read(GamePanel.class.getResource("img/bossbu1.png"));
            bullets = ImageIO.read(GamePanel.class
                    .getResource("img/bullets.png"));
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    /** 画笔方法区域 */
    public void paint(Graphics g) {
        super.paint(g);
        // 3.1绘制背景图片
        paintBack(g);
        // 3.2绘制英雄机
        paintHero(g);
        // 3.3绘制子弹
        paintBullet(g);
        // 3.4绘制敌机
        paintFly(g);
        paintState(g);
        paintBoss(g);


    }

    // 3.1 绘制背景图片
    public void paintBack(Graphics g) {
        // 不写宽和高默认图片尺寸
        backY++;
        g.drawImage(back, 0, backY, null);
        g.drawImage(back, 0, -768 + backY, null);
        if (backY > 768) {
            backY = 0;
        }
    }

    // 3.2绘制英雄机
    public void paintHero(Graphics g) {
        g.drawImage(hero.image, hero.x, hero.y, hero.width, hero.height, null);
    }

    // 3.3绘制子弹
    public void paintBullet(Graphics g) {
        for (int i = 0; i < bs.length; i++) {
            Bullet bt = bs[i];
            g.drawImage(bt.image, bt.x, bt.y, bt.width, bt.height, null);
        }
    }
    // 3.4绘制敌机
    public void paintFly(Graphics g){
        for(int i=0;i<flys.length;i++){
            FlyObject ap=flys[i];
            g.drawImage(ap.image, ap.x, ap.y, ap.width, ap.height, null);
        }
    }
    //绘制boss机器
    public void paintBoss(Graphics g){
        g.drawImage(boss.image, boss.x, boss.y, boss.width, boss.height,null);
    }
    //3.5绘制状态
    public void paintState(Graphics g){
        g.setFont(new Font("微软雅黑",28,28));
        g.setColor(Color.red);
        g.drawString("分数"+score, 20, 50);
        g.drawString("生命"+hero.getLife(), 20, 100);
        String fire =hero.getDoubleFire()>0?"双倍":"单倍";
        g.drawString("火力"+fire ,20, 150);
    }


    /** 业务逻辑处理区域 */
    public void run() {
        while (true) {
            // 1.业务执行
            // 4.1走一步
            stepAction();


            // 4.2射击
            shootAction();
            //4.3出界
            for(int i=0;i<bs.length;i++){
                if(bs[i].outOfBounds()){
                    bs[i]=bs[bs.length-1];
                    bs=Arrays.copyOf(bs,bs.length-1);
                }
            }
            //4.4 击毁敌机
            for(int i=0;i<bs.length;i++)
            {
                hitAction(bs[i],i);
            }


            // 2.睡眠方法
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 3.重绘方法
            repaint();
        }

    }

    // 4.1走一步
    public void stepAction() {
        // 1.英雄机走一步
        hero.step();
        boss.step();
        // 2.子弹飞行
        for (int i = 0; i < bs.length; i++) {
            bs[i].step();

        }

        for(int i=0;i<flys.length;i++)
        {
            flys[i].step();
        }

    }

    // 4.2射击
    public void shootAction() {
        // 修改设计频率值
        shootIndex++;
        airIndex++;
        int random=(int)(Math.random()*100);
        /** 英雄机子弹存储 */

        if(shootIndex%10==0)
        {
//		Bullet bt = new Bullet(hero.x + hero.width / 2 - 5, hero.y);

            // 数组扩容
//		bs = Arrays.copyOf(bs, bs.length + 1);

//		bs[bs.length - 1] = bt;
        }
		/*if(airIndex%10==0)
		{
			Airplane ap = new Airplane();
			flys = Arrays.copyOf(flys, flys.length + 1);
			flys[flys.length - 1] = ap;
		}*/
        if(shootIndex%80==0)
        {
            Bullet[] bts =hero.shootBy();
            //数组扩容
            bs=Arrays.copyOf(bs, bs.length+bts.length);
            //添加
            //bts是源数组,0是从bts的第几个下标开始复制,bs是目标数组， bts.length是复制多长
            System.arraycopy(bts, 0, bs, bs.length-bts.length,bts.length);
        }
        if (airIndex % 120 == 0) {
            if(random>=80)
            {

                Love le = new Love();
                flys = Arrays.copyOf(flys, flys.length + 1);
                flys[flys.length - 1] = le;
            }
            else
            {
                AirPlane ap = new AirPlane();
                flys = Arrays.copyOf(flys, flys.length + 1);
                flys[flys.length - 1] = ap;

            }
            //boss机存储
            if(shootIndex%500==0)
            {
                bss=Arrays.copyOf(bss, bss.length-1);
                bss[bss.length-1]=new Boss();
            }
        }


    }
    //4.4击毁敌机
    public void hitAction(Bullet bt,int num)
    {
        int hitIndex=-1;
        for(int i=0;i<flys.length;i++)
        {

            if(flys[i].hitby(bt)){
                //出界处理
                hitIndex=i;

                break;

            }
        }

        if(hitIndex!=-1)
        {
            //判断是否是爱心
//			score+=10;
            FlyObject object= flys[hitIndex];
            if(object instanceof Award){
                //判断奖励类型
                int type =(((Award)object).getAwardType());
                if(type==Award.DOUBLEFIRE){
                    //双倍火力
                    hero.adddoubleFire();
                }
                else{
                    //生命
                    hero.addLife();
                }
            }
            if(object instanceof Enemy)
            {
                AirPlane pl=(AirPlane) object;
                score+=pl.getScore();

            }
            flys[hitIndex]=flys[flys.length-1];
            flys=Arrays.copyOf(flys,flys.length-1);
            bs[num]=bs[bs.length-1];
            bs=Arrays.copyOf(bs,bs.length-1);
        }

    }

    /** 鼠标监听事件 **/
    // 鼠标拖拽
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    // 鼠标移动
    public void mouseMoved(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        hero.moveTo(mx, my);

    }

}
