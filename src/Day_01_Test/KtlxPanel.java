package Day_01_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Random;

/**
 * @author fhk
 * @date 2019/4/22-16:13
 */
public class KtlxPanel extends JPanel implements Runnable {
    // 画笔方法
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Ellipse2D.Float ellipse=new Ellipse2D.Float(-80,5,160,10);
        Random random=new Random();
        g2.translate(160,90);
        int R=random.nextInt(256);
        int G=random.nextInt(256);
        int B=random.nextInt(256);
        Color color=new Color(R,G,B);
        g2.setColor(color);
        g2.draw(ellipse);
        int i=0;
        while (i<100){
            R=random.nextInt(256);
            G=random.nextInt(256);
            B=random.nextInt(256);
            color=new Color(R,G,B);
            g2.setColor(color);
            g2.rotate(360);//旋转画布
            g2.draw(ellipse);
            i++;
        }

    }

    // 业务执行
    @Override
    public void run() {
        while (true) {
            // 1.业务执行

            // 2.睡眠方法
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3.重绘方法
            repaint();
        }
    }
}
