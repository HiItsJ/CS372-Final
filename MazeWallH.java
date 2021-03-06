import java.awt.Image;

public class MazeWallH implements CollisionCheck{
  int x, y;
  Image img;
  public MazeWallH(int x, int y, Image i){
    this.x = x;
    this.y = y;
    img = i;
  }
  public Boolean collision(int hx, int hy){
    //Top left
    if (x<hx+11 && x+22>hx+11 && y<hy && y+18>hy){
      return true;
    }
    //Top right
    if (x+10<hx+20 && x+32>hx+20 && y<hy && y+18>hy){
      return true;
    }
    //Bottom left
    if (x<hx+11 && x+22>hx+11 && y+15<hy+32 && y+32>hy+32){
      return true;
    }
    //Bottom right
    if (x+10<hx+20 && x+32>hx+20 && y+15<hy+32 && y+32>hy+32){
      return true;
    }
    return false;
  }
}
