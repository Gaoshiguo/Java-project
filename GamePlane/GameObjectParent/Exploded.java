package GamePlane.GameObjectParent;
import javax.swing.*;
import java.awt.*;

public class Exploded  {

    public static void main(String[] args){
       JFrame frame=new JFrame();
       JOptionPane.showMessageDialog(frame,"ninde","chengji",JOptionPane.INFORMATION_MESSAGE);
//       initFrame(frame,400,300);
//       frame.setVisible(true);
//       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void initFrame(JFrame frame,int width,int height){
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        int x=40;
        int y=40;
        frame.setBounds((int)x/2,(int)y/2,width,height);
    }
}
