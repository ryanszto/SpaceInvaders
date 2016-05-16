import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Row implements ActionListener
{
  ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  
  int width;
  boolean dir;
  
  public Row(int frWidth, int yPos)
  {
    width = frWidth;
    for(int i = 0; i < 6; i++)
    {
      enemies.add(new Enemy(100*i+100, yPos, 2));
    }
    
    dir = true;
    
    enemies.get(0).setLeader();
  }
  
  public ArrayList<Enemy> getRow()
  {
    return enemies;    
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if((enemies.get(0).posX() <= 15 && !dir)||(enemies.get(enemies.size()-1).posX() >= width-65 && dir))
    {
      //move down
      for(int rI = 0; rI < enemies.size();rI++)
      {
        enemies.get(rI).moveDown();
      }
      dir = !dir;
    }
    else
    {
      //move
      for(int rI = 0; rI < enemies.size();rI++)
      {
        enemies.get(rI).move(dir);
      }
    }
  }
}
