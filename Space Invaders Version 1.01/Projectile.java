
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.geom.Rectangle2D.Double;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Projectile extends JComponent implements ActionListener
{
    private double x;
    private double y;
    Timer t;
    boolean val;
    
    public Projectile(int x, int y)
    {
        this.x = x;
        this.y = y;
        t = new Timer(10, this);
        t.start();
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

    public void actionPerformed(ActionEvent e)
    {
        if(!val)
        {
          
        }
        this.moveUp();
        repaint();
    }    

    public void moveUp()
    {
        if(y>-15)
        {
            y=y-20;
        }
        else
        {
            outofBounds();
        }
    }
    
    public boolean outofBounds()
    {
        return false;
    }   
}
