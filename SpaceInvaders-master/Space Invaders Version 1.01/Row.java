import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Row implements ActionListener
{
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    ArrayList<Enemy> displayEnemies;
    int w;
    boolean dir;

    public Row(int width, int y)
    {
        w = width;
        for(int i = 0; i < 6; i++)
        {
            enemies.add(new Enemy(100*i+100, y, 2));
        }

        displayEnemies = enemies;

        dir = true;

        enemies.get(0).setLeader();

    }

    public ArrayList<Enemy> getRow()
    {
        return displayEnemies;    
    }

    public void actionPerformed(ActionEvent e)
    {
        if((enemies.get(0).posX() <= 15 && !dir)||(enemies.get(enemies.size()-1).posX() >= w-65 && dir))
        {
            //move down
            for(int rI = 0; rI < displayEnemies.size();rI++)
            {
                displayEnemies.get(rI).moveDown();
            }
            dir = !dir;
        }
        else
        {
            //move
            for(int rI = 0; rI < displayEnemies.size();rI++)
            {
                displayEnemies.get(rI).move(dir);
            }
        }
    }
}
