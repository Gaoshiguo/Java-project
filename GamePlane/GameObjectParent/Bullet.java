package GamePlane.GameObjectParent;

import java.awt.*;

public class Bullet extends GameObjectparent {
    double direction;
    public Bullet(){
         x=50;
         y=250;
         width=10;
         height=10;
         speed=3;

         direction=Math.random()*Math.PI*2;

   }

   public void drawself(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillOval((int)x,(int)y,height,width);
        x+=speed*Math.cos(direction);
        y+=speed*Math.sin(direction);
        if(x<width||x>Constant.FRAME_WIDTH-width){
            direction=Math.PI-direction;
        }
       if(y<30||y>Constant.FRAME_HEIGHT-height){
           direction=-direction;
       }
        g.setColor(c);
   }


}
