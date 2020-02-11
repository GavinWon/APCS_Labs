import java.awt.*;
import javax.swing.*;

/**
 * This program draws an ornament of nested triangles
 * 
 * @author TODO Gavin wong
 * @version TODO 9/19/2018  
 * 
 * @author Period - 5
 * @author Assignment - Ch04 Ex4-16 Ornament
 * 
 * @author Sources - TODO list collaborators
 */
public class Ornament extends JPanel
{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background
        drawTriangles( g, 100, 80, 64 );
    }

    /**
     * Draws an ornament made of triangles in Graphics g with the base midpoint
     * at (x, y) and base half-length r
     * @param g the Graphics
     * @param x the x value  of the midpoint
     * @param y the y value of the midpoint
     * @param r the half-base length 
     */
    public void drawTriangles( Graphics g, int x, int y, int r )
    {
        if (r == 4) {
            return;
        }
        
        g.drawLine(x - r, y, x + r, y);
        g.drawLine(x - r, y , x, y - r );
        g.drawLine(x, y - r, x + r, y);
        drawTriangles(g , x - (r / 2) , y, r / 2);
        drawTriangles(g , x + (r / 2), y, r / 2);
        
    }
    /**
     * 
     * TODO Make a Jframe and a ornament object
     * @param args string arguments
     */
    public static void main( String[] args )
    {
        JFrame w = new JFrame( "Triangles" );
        w.setBounds( 300, 300, 200, 120 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Ornament panel = new Ornament();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( false );
        w.setVisible( true );
    }
}
