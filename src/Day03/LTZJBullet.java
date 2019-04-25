package Day03;

public class LTZJBullet extends Day03.FlyObject {

    public LTZJBullet(int heroX, int heroY) {
        this.image = Day03.LTZJPanel.bullets;
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        this.x = heroX;
        this.y = heroY;
    }

    @Override
    public void step() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean outOfBounds() {
        // TODO Auto-generated method stub
        return false;
    }
}
