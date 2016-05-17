import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.*;
import java.awt.BasicStroke;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.Timer;
public class SpaceShip extends JComponent 
{
    Ellipse2D ship; // declares a new Ellipse2D object ship
    int x; // declares a new integer x
    int y,dx, frW, frH, r, lives;
    BufferedImage ship1;
    int a;
    int b;

    public SpaceShip(int x, int y)
    {
        this.x = x/2-40; // initializes the instace field variable x a value of the parameter variable
        // x/2-20
        this.y = y-110;
        frW = x;
        frH = y;
        dx = 0;
        r = 40;
        lives = 3;
        ship = new Ellipse2D.Double(x,y,r,r); // construct a new Ellipse2D.Double object with explicit
        // parameters x,y,r,r and assigns it to the Ellipse2D object ship
        a = x;
        b = y;
        try
        {
            ship1 = ImageIO.read(new File("ship.png"));
        } 
        catch (IOException e) {}
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g; // constructs a new Graphics2D object g2 by casting the Graphics
        //         // g object passed in through the method header
        //         ship = new Ellipse2D.Double(x,y,r,r);
        //         g2.setColor(Color.GREEN); // invokes the mutator method setColor() with explicit parameter 
        //         // Color.BLACK on the Graphics2D object g2
        //         g2.fill(ship); // / invokes the mutator method fill() with explicit parameter ship on the
        //         // Graphics2D object g2
        g2.drawImage(ship1, x, y, Color.BLACK, Field.frame);
    }

    public void move()
    {
        x+=dx;
    }

    public void moddx(int k)
    {
        dx=k; // assigns dx a new value of dx + k
        move();
        repaint();
    }

    public int getXPos()
    {
        return x; // returns the instance field variable x of the SpaceShip Class
    }

    public Projectile fire()
    { 
        Projectile p = new Projectile(x+25, y);
        return p;
    }

}
