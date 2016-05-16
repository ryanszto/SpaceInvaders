
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
    
    public Projectile(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double projectile = new Rectangle2D.Double(x,y,5,15);
        g2.draw(projectile);
        g2.setColor(Color.GREEN);
        g2.fill(projectile);
    }
}
