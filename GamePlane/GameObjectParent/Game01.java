package GamePlane.GameObjectParent;

import GameUtil.GameUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

import static java.lang.Thread.sleep;

public class Game01 extends JFrame{
    Image plane=GameUtil.getImage("images/plane.png");
    Image bgimage=GameUtil.getImage("images/bg.jpg");
    Image explod= GameUtil.getImage("images/bao.png");
    Plane plane1=new Plane(plane,150,150);
    Bullet bullet=new Bullet();
    Bullet[] bullets=new Bullet[15];
    Date starttime=new Date();
    Date endtime;
    int period;


    public static void initFrame(JDialog dialog,int width,int height){
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension d=toolkit.getScreenSize();
        int x=(int)d.getWidth();
        int y=(int)d.getHeight();
        dialog.setBounds((x-width)/2,(y-width)/2,x,y);

    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(bgimage,0,0,null);
        plane1.drawself(g);
        bullet.drawself(g);
        for(int i=0;i<=bullets.length;i++){
            bullets[i].drawself(g);
            boolean interaction=bullets[i].getRec().intersects(plane1.getRec());
            if(interaction){
                plane1.live=false;
                endtime=new Date();
                period=(int)(((endtime.getTime()-starttime.getTime()))/1000);
                g.drawImage(explod,(int)plane1.x,(int)plane1.y,null);
            }

            if (plane1.live == false) {
                g.setColor(Color.white);
                g.drawString("您一共坚持" + period + "秒", 150, 150);
            }
        }






    }

    class paintThread extends Thread{
        @Override
        public void run() {
            while(true){
                repaint();
                try {
                    Thread.sleep(40);
                }
                catch  (InterruptedException e) {
                    e.printStackTrace();
                }
                addKeyListener(new KeyMonitor());
            }
        }
    }
    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            plane1.move(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane1.stop(e);
        }
    }
    public void showscore(){
        this.setTitle("您的成绩是：");
        this.setVisible(true);
        this.setLocation(250,250);
        this.setSize(250,250);
    }



    public void launchframe(){
           this.setTitle("小飞机程序");
           this.setVisible(true);
           this.setLocation(250,250);
           this.setSize(Constant.FRAME_WIDTH,Constant.FRAME_HEIGHT);
           this.addWindowListener(new WindowAdapter() {
               @Override
               public void windowClosing(WindowEvent e) {
                   System.exit(0);
               }
           });
           new paintThread().start();
           addKeyListener(new KeyMonitor());
           for(int i=0;i<=bullets.length;i++){
               bullets[i]=new Bullet();
           }
       }
       public  static void main(String[] args){
           Game01 f=new Game01();
           f.launchframe();

       }


}
