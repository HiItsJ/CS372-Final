public class SpikeThread implements Runnable, CollisionCheck{

  MazeGame game;

  int x, y;
  static int lastID = 0;
  int id;

  Boolean returning = false;

  public SpikeThread(int x, int y, MazeGame g){
    this.x = x;
    this.y = y;
    game = g;
    id = lastID;
    lastID++;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public void setX(int x){
    this.x = x;
  }
  public void setY(int y){
    this.y = y;
  }
  public void run(){
    while(true){
      if (id == 0){
        if (!returning){
          if (y>248)
            returning = true;
          y++;
        }
        else {
          if (y<85)
            returning = false;
          y--;
        }
      }
      if (id == 1){
        if (!returning){
          if (y<50)
            returning = true;
          y--;
        }
        else {
          if (y>248)
            returning = false;
          y++;
        }
      }
      try{
        Thread.sleep(10);
      }
      catch(InterruptedException ex){}
      if (collision(game.h_X, game.h_Y)){
        game.end = true;
        game.endGame(game.end);
      }
      game.repaint();
    }
  }
  public Boolean collision(int hx, int hy){
    //Top left
    if (x<hx+11 && x+32>hx+11 && y<hy && y+32>hy){
      return true;
    }
    //Top right
    if (x<hx+20 && x+32>hx+20 && y<hy && y+32>hy){
      return true;
    }
    //Bottom left
    if (x<hx+11 && x+32>hx+11 && y<hy+32 && y+32>hy+32){
      return true;
    }
    //Bottom right
    if (x<hx+20 && x+32>hx+20 && y<hy+32 && y+32>hy+32){
      return true;
    }
    return false;
  }
}
