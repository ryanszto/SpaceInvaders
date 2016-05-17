import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Field
{
    public static JFrame frame = new JFrame("WELCOME TO SPACE INVADERS");
    final int frWIDTH = 800; // declares a new final integer frWIDTH and assigns it a value of 1100
    final int frHEIGHT = 700;
    JLabel lives;
    ArrayList<BlockComponent> blockList;
    ArrayList<Projectile> projectileList;
    SpaceShip s;

    public Field()
    {
        frame.setSize(frWIDTH,frHEIGHT); // invokes the mutator method setSize() with explicit parameter
        // of the two final variables on the JFrame object fr
        frame.getContentPane().setBackground(Color.BLACK);
        //blocking terrain will be 2x3
        //enemies will take up one piece of grid

        lives = new JLabel("LIVES");// + number of lives

        blockList = new ArrayList<BlockComponent>();
        projectileList = new ArrayList<Projectile>();

        s = new SpaceShip(frWIDTH, frHEIGHT); // constructs a new SpaceShip object 
        // with explicit parameter of the two final variables and assigns it to the newly declared object 
        // reference s
    }

    public void beginGame()
    {
        for(int x = 0; x<6; x++)
        {
            for (int z = 50; z<=620; z+=190)
            {
                for(int y = 0; y<2; y++)
                {
                    blockList.add(new BlockComponent(z+(x*15),500+(y*15)));
                }
            }
        }

        for(int i = 0; i<48; i++)
        {
            frame.add(blockList.get(i));
            frame.setVisible(true);
        }

        ArrayList<Row> rows = new ArrayList<Row>();

        for(int y = 0; y < 3; y++)
        {
            rows.add(new Row(frWIDTH,50*y+100));
        }

        for(int loc = 0; loc < rows.size();loc++)
        {
            ArrayList<Enemy> enemies = rows.get(loc).getRow();
            for(int pos = 0; pos < enemies.size();pos++)
            {
                frame.add(enemies.get(pos));
                frame.setVisible(true);
            }
        }

        //         class BlockListener implements ActionListener//inner class 
        //         {
        //             public void actionPerformed(ActionEvent e)
        //             {
        //                 if()
        //                 {
        //
        //                 }
        //             }
        //         }
        //         blockList.addActionListener(new BlockListener());//invokes the addActionListener method to add the action listener   

        Timer r1 = new Timer(1000, rows.get(0));
        Timer r2 = new Timer(1000, rows.get(1));
        Timer r3 = new Timer(1000, rows.get(2));
        r1.start();
        r2.start();
        r3.start();

        class SpeedListener implements KeyListener // creating a new Inner Class that uses the 
        // KeyListener Interface
        {
            public void keyPressed(KeyEvent e)
            {
                switch(e.getKeyCode()) // switch statement based on the value returned by the accessor
                // method getKeyCode invoked upon KeyEvent e
                {
                    case KeyEvent.VK_LEFT: s.moddx(-5); break; // if the left arrow key is pressed
                    // invoke the mutator method moddx() with explicit parameter -1 on the
                    // Ball Component object b
                    case KeyEvent.VK_RIGHT: s.moddx(5); break;
                    //case KeyEvent.VK_UP: s.fire(); break;
                    case KeyEvent.VK_UP:
                    {
                        Projectile p = s.fire();
                        projectileList.add(p);
                        //frame.add(p); 
                        //frame.setVisible(true); 
                        break;
                    }
                }
            }

            public void keyReleased(KeyEvent e) {}

            public void keyTyped(KeyEvent e) {}
        }
        

        frame.addKeyListener(new SpeedListener()); // invokes the mutator method addKeyListener() with
        // explicit parameter of a newly constructed SpeedListener object on the JFrame object fr
        frame.add(s);
        frame.setVisible(true);

        lives.setForeground(Color.RED);
        lives.setVerticalAlignment(SwingConstants.BOTTOM);

        frame.add(lives);
        frame.setVisible(true);
    }  
}

