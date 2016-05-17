import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Color;
import java.awt.Rectangle;

public class Enemy extends JComponent
{
    private int x;
    private int y; 
    private boolean leader;
    private int type;

    public Enemy(int locX, int locY, int ty)
    {
        x = locX;
        y = locY;
        leader = false;
        type = ty;
    }

    //draw
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.selectType(type), x, y, Color.BLACK, Field.frame);
    }

    public BufferedImage selectType(int i)
    {
        BufferedImage img = null;//Declare and initialize BufferedImage variable
        switch(i)
        {
            case 1:
            {
                try {
                    img = ImageIO.read(new File("sp enemies.png"));//Attempt to read and retrieve image from the specified file
                } catch (IOException e) { //catch an IOException if thrown       
                }
                break;
            }
            case 2:
            {
                try {
                    img = ImageIO.read(new File("sp enemies2.png"));//Attempt to read and retrieve image from the specified file
                } catch (IOException e) { //catch an IOException if thrown       
                }
                break;
            }
            case 3:
            {
                try {
                    img = ImageIO.read(new File("sp enemies3.png"));//Attempt to read and retrieve image from the specified file
                } catch (IOException e) { //catch an IOException if thrown       
                }
                break;
            }
            case 4:
            {
                try {
                    img = ImageIO.read(new File("sp enemies4.png"));//Attempt to read and retrieve image from the specified file
                } catch (IOException e) { //catch an IOException if thrown       
                }
                break;
            }
        }
        return img;
    }

    public void setLeader()
    {
        leader = true;    
    }

    public void move(boolean right)
    {
        if(right)
        {
            x+=10;
        }
        else
        {
            x-=10;
        }
        repaint();
    }

    public void moveDown()
    {
        y+=100;
        repaint();
    }

    public int posX()
    {
        return x;    
    }

    //move and shoot
    public void motions()
    {

    } 
}
