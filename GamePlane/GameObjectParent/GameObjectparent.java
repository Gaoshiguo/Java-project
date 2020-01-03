package GamePlane.GameObjectParent;

import java.awt.*;

public class GameObjectparent {
     Image image;
     int speed;
     int height,width;
     public double x,y;

    public void drawself(Graphics g){
        g.drawImage(image,(int)x,(int)y,null);
    }

    public GameObjectparent(Image image, int speed, int height, int width, double x, double y) {
        this.image = image;
        this.speed = speed;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public GameObjectparent(Image image, int height, int width, double x, double y) {
        this.image = image;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }
    public Rectangle getRec(){
        return new Rectangle((int)x,(int)y,width,height);
    }
    public GameObjectparent(){}

}
