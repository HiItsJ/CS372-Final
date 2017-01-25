import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MazeGame extends JComponent implements MouseMotionListener, MouseListener{

  static JFrame frame = new JFrame();

  int h_X = 20, h_Y = 20;
  Boolean movable = false;
  Boolean end = false;

  static SpikeThread[] st;
  static ArrayList<MazeWallV> walls_V = new ArrayList<MazeWallV>();
  static ArrayList<MazeWallH> walls_H = new ArrayList<MazeWallH>();

  Image img_Hero, img_WallV, img_WallH, img_Spike, img_Flag;

  public MazeGame(Image h, Image wv, Image wh, Image s, Image f){
    img_Hero = h;
    img_WallV = wv;
    img_WallH = wh;
    img_Spike = s;
    img_Flag = f;
    addMouseListener(this);
    addMouseMotionListener(this);
  }
  public void mouseDragged(MouseEvent e){}
  public void mouseMoved(MouseEvent e){
    if (h_X>95 && h_X<127 && h_Y+30>170 && h_Y+30<202){
      end = false;
      endGame(end);
    }
    for (MazeWallV o: walls_V){
      if (o.collision(h_X, h_Y)){
        end = true;
        endGame(end);
      }
    }
    for (MazeWallH o: walls_H){
      if (o.collision(h_X, h_Y)){
        end = true;
        endGame(end);
      }
    }
    if (movable){
      h_X = e.getX()-16;
      h_Y = e.getY()-16;
    }
    repaint();
  }
  public void mouseClicked(MouseEvent e){
    if (!movable){
      if (e.getX() > h_X && e.getX() < h_X+32 && e.getY() > h_Y && e.getY() < h_Y+32){
        movable = true;
      }
    }
    else {
      movable = false;
    }
  }
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){
    movable = false;
  }
  public void mousePressed(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
  public void endGame(Boolean b){
    if (b){
      JOptionPane.showMessageDialog(frame, "GAME OVER");
      h_X = 20;
      h_Y = 20;
      end = false;
      movable = false;
    }
    else {
      JOptionPane.showMessageDialog(frame, "YOU WIN");
      System.exit(0);
    }
  }
  public void paint(Graphics g){
    Graphics2D g2 = (Graphics2D)g;
    g2.drawImage(img_Hero, h_X, h_Y, this);

    for (MazeWallV o: walls_V){
      g2.drawImage(o.img, o.x, o.y, this);
    }
    for (MazeWallH o: walls_H){
      g2.drawImage(o.img, o.x, o.y, this);
    }
    for (SpikeThread s: st){
      g2.drawImage(img_Spike, s.getX(), s.getY(), this);
    }
    g2.drawImage(img_Flag, 95, 170, this);
  }
  public static void main(String[] args){

    Toolkit toolkit = Toolkit.getDefaultToolkit();

    //Dimensions noted are dimensions of the actual drawings and not the whole image frame;
    //All image frames: Width=32 Height=32
    //Hero Dimensions: Width=9 Height=23
    //Vertical Wall Dimensions: Width=11 Height=21
    //Horizontal Wall Dimensions: Width=21 Height=11
    //Spike Dimensions: Width=32 Height=32
    Image img_H = toolkit.getImage("/Users/Josiah/Desktop/CS/CS372-ALL/CS372-Final/Hero.png");
    Image img_WV = toolkit.getImage("/Users/Josiah/Desktop/CS/CS372-ALL/CS372-Final/Wall_Vertical.png");
    Image img_WH = toolkit.getImage("/Users/Josiah/Desktop/CS/CS372-ALL/CS372-Final/Wall_Horizontal.png");
    Image img_S = toolkit.getImage("/Users/Josiah/Desktop/CS/CS372-ALL/CS372-Final/Spike.png");
    Image img_F = toolkit.getImage("/Users/Josiah/Desktop/CS/CS372-ALL/CS372-Final/Flag.png");

    MazeWallV wallV;
    MazeWallH wallH;
    wallV = new MazeWallV(60, -2, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(60, 19, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(71, 40, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(71, 61, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(20, 82, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(20, 103, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(20, 124, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(20, 145, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(20, 219, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(71, 82, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(71, 103, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(71, 124, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(71, 145, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(71, 166, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(71, 187, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(123, 208, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(123, 218, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(123, 188, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(123, 167, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(123, 146, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(123, 125, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(123, 104, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(123, 84, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(123, 63, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(123, 42, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(174, 255, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(174, 234, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(174, 213, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(174, 192, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(174, 130, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(174, 109, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(174, 105, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(174, 84, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(174, 63, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(174, 42, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(230, 32, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(230, 35, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(230, 56, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(230, 77, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(230, 98, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(230, 119, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(230, 140, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(230, 161, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(230, 182, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(230, 203, img_WV);
    walls_V.add(wallV);
    wallV = new MazeWallV(230, 224, img_WV);
    walls_V.add(wallV);

    wallH = new MazeWallH(-2, 63, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(19, 63, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(91, 200, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(112, 200, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(70, 200, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(49, 200, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(29, 200, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(132, 23, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(153, 23, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(173, 23, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(194, 23, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(205, 23, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(226, 23, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(194, 132, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(205, 132, img_WH);
    walls_H.add(wallH);
    wallH = new MazeWallH(226, 132, img_WH);
    walls_H.add(wallH);

    MazeGame game = new MazeGame(img_H, img_WV, img_WH, img_S, img_F);

    st = new SpikeThread[2];
    st[0] = new SpikeThread(0, 85, game);
    st[1] = new SpikeThread(150, 248, game);
    for (int i = 0; i<st.length; i++){
      Thread t = new Thread(st[i]);
      t.start();
    }

    frame.add(game);
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);

    JOptionPane.showMessageDialog(frame, "Click the hero to move him. Click again to stop moving him.\nAvoid the walls and the spikes!\nReach the flag to win!");

  }
}
