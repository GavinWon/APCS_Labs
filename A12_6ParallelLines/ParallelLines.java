import java.awt.*;
import javax.swing.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Gavin wong
 * @version TODO 9/21/2018
 * 
 *          Period - TODO Your Period Assignment - A12.6 - ParallelLines
 * 
 *          Sources - TODO list collaborators
 */
public class ParallelLines extends JPanel
{
    int offSet;

    int size;

    
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background

        int width = getWidth();
        int height = getHeight();

        drawIllusion( g, width, height );
    }


    /**
     * TODO Write your method description here.
     * 
     * @param the graphics object
     * @param width the width of the window
     * @param height the height of the window
     */
    public void drawIllusion( Graphics g, int width, int height )
    {
        size = width / 14;

        for ( int row = 0; row < 8; row++ )
        {
            // calculating stuff
            switch ( row % 4 )
            {
                case 0:
                    offSet = 0;
                    break;
                case 1:
                    offSet = size / 4;
                    break;
                case 2:
                    offSet = size / 2;
                    break;
                case 3:
                    offSet = size / 4;
                    break;
            }

            int yStart = 20 + ( size * row );
            int xStart = 10;
            g.drawLine( xStart, yStart + size, width, yStart + size );

            for ( int col = 0; col < 7; col++ )
            {
                xStart = 10 + ( offSet + 2 * size * col );
                g.fillRect( xStart, yStart, size, size );
            }

        }
    }


    public static void main( String[] args )
    {
        JFrame w = new JFrame( "ParallelLines" );
        w.setBounds( 100, 100, 640, 480 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ParallelLines panel = new ParallelLines();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( true );
        w.setVisible( true );
    }
}
