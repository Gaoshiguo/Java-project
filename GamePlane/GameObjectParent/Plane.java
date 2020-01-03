package GamePlane.GameObjectParent;

import GameUtil.GameUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Plane extends GameObjectparent{
    boolean live=true;
    private boolean up,down,left,right;
    private int speed=6;
    public Plane(Image image,double x,double y) {
        this.image=image;
        this.x=x;
        this.y=y;
        this.width=image.getWidth(null);
        this.height=image.getHeight(null);
    }
    public void move(KeyEvent e){
       if(e.getKeyCode()==KeyEvent.VK_UP){
            up=true;
       }
       if(e.getKeyCode()==KeyEvent.VK_DOWN){
            down=true;
       }
       if(e.getKeyCode()==KeyEvent.VK_LEFT){
            left=true;
       }
       if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            right=true;
       }
    }
    public void stop(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_UP){
            up=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            left=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            right=false;
        }
    }

    public void drawself(Graphics g){
        if(live==true) {
            g.drawImage(image, (int) x, (int) y, null);
            if (up == true) {
                y = y - speed;
            }
            if (down == true) {
                y = y + speed;
            }
            if (left == true) {
                x = x - speed;
            }
            if (right == true) {
                x = x + speed;
            }
        }
        else{
            x=y=-50;

        }
    }

}
