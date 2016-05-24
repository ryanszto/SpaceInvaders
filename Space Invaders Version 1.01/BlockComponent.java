
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.geom.Rectangle2D.Double;
public class BlockComponent extends JComponent
{
    private double x;
    private double y;
    public BlockComponent(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double block = new Rectangle2D.Double(x,y,15,15);
        g2.draw(block);
        g2.setColor(Color.GREEN);
        g2.fill(block);
    }
    
    public double getPosX()
    {
        return x;
    }
    
    public double getPosY()
    {
        return y;
    }
}
