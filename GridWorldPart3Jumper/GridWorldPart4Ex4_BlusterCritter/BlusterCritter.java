import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

import java.awt.Color;


/**
 * TODO Write a one-sentence summary of your class here TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author TODO Gavin Wong
 * @version TODO 11/14/2018
 * @author Period: 5
 * @author Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 *
 * @author Sources: TODO I received help from ...
 */
public class BlusterCritter extends Critter
{
    private int courage;



    /**
     * Constructs a BlustterCritter
     * 
     * @param c the courage value of the critter
     */
    public BlusterCritter( int c )
    {
        courage = c;
    }


    /**
     * TODO Process all the actors two steps from it Postcondition: The state of
     * all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();

        int x = this.getLocation().getRow();
        int y = this.getLocation().getCol();
        for ( int xIndex = x - 2; xIndex <= x + 2; xIndex++ )
        {
            for ( int yIndex = y - 2; yIndex <= y + 2; yIndex++ )
            {
                if (xIndex != x || yIndex != y)
                {    
                    Location loc = new Location( xIndex, yIndex );
                    if ( gr.isValid( loc ) )
                    {
                        Actor neighbor = gr.get( loc );
                        if ( neighbor != null )
                        {
                            actors.add( neighbor );
                        }
                    }
                }
            }
        }
        return actors;
    }


    /**
     * TODO Write your method description here <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * 
     * @param actors the actors to be processed
     */
    public void processActors( ArrayList<Actor> actors )
    {
        int crittersCount = 0;
        for ( Actor act : actors )
        {
            if ( act instanceof Critter )
            {
                crittersCount += 1;
            }
        }
        if ( crittersCount >= courage )
        {
            darken();
        }
        else
        {
            lighten();
        }
    }


    /**
     * TODO makes the critter darken
     */
    private void darken()
    {
        Color c = this.getColor();
        int red = c.getRed() - 3;
        int green = c.getGreen() - 3;
        int blue = c.getBlue() - 3;
        
        if ( red < 0 )
        {
            red = 0;
        }
        if ( green < 0 )
        {
            green = 0;
        }
        if ( blue < 0 )
        {
            blue = 0;
        }
        
        setColor( new Color( red, green, blue ) );
    }


    /**
     * TODO makes the critter lightens
     */
    private void lighten()
    {
        Color c = this.getColor();
        
        int red = c.getRed() + 3;
        int green = c.getGreen() + 3;
        int blue = c.getBlue() + 3;

        if ( red > 255 )
        {
            red = 255;
        }
        if ( green > 255 )
        {
            green = 255;
        }
        if ( blue > 255 )
        {
            blue = 255;
        }
        setColor( new Color( red, green, blue ) );
    }
}
