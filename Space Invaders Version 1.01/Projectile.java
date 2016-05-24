
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.geom.Rectangle2D.Double;

public class Projectile extends JComponent 
{
    private double x;
    private double y;
    boolean val;
    
    public Projectile(int x, int y)
    {
        this.x = x;
        this.y = y;
        val = true;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double projectile = new Rectangle2D.Double(x,y,6,15);
        g2.draw(projectile);
        g2.setColor(Color.GREEN);
        g2.fill(projectile);
    }
    
    public double getPosY()
    {
        return y;
    }
    
    public double getPosX()
    {
        return x;
    }

    public void moveUp()
    {
        y=y-10;
        repaint();
    }
    
    public boolean outofBounds()
    {
        return false;
    }   
}
