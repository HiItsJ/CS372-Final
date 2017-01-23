import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MazeGame extends JComponent implements MouseMotionListener, MouseListener{

  static JFrame frame;

  Image img_Hero, img_WallV, img_WallH;

  public MazeGame(Image h, Image wv, Image wh){
    img_Hero = h;
    img_WallV = wv;
    imt_WallH = wh;
    addMouseListener(this);
    addMouseMotionListener(this);
  }
  public void mouseDragged(MouseEvent e){}
  public void mouseMoved(MouseEvent e){}
  public void mouseClicked(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mousePressed(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
  public static void main(String[] args){

    Toolkit toolkit = Toolkit.getDefaultToolkit();

    Image img_H = toolkit.getImage("/Users/Josiah/Desktop/CS/CS372-ALL/CS372-Final/Hero.png");
    Image img_WV = toolkit.getImage("/Users/Josiah/Desktop/CS/CS372-ALL/CS372-Final/Wall_Vertical.png");
    Image img_WH = toolkit.getImage("/Users/Josiah/Desktop/CS/CS372-ALL/CS372-Final/Wall_Horizontal.png");

    frame = new JFrame();
    frame.add(new MazeGame(img_H, img_WV, img_WH));
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
