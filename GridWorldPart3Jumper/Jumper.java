import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.awt.Color;

//complete
/**
 * A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 * turn. A jumper can remove another jumper by jumping on them.
 * 
 * @author Joyce Tung, Gavin Wong
 * @version 10/26/18
 * @author Period: 5
 * @author Assignment: GridWorld_Part3_Jumper
 * 
 * @author Sources: None
 */
public class Jumper extends Bug implements Edible
{

    /**
     * Constructs a jumper with red color
     */
    public Jumper()
    {
        setColor( Color.RED );
    }

    /**
     * constructs a jumper with the specified color
     * @param bugColor the color the jumper will be
     */
    public Jumper( Color bugColor )
    {
        setColor( bugColor );
    }

    
    /**
     *  Makes the jumper move
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if ( gr == null )
        {
            return;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation( getDirection() )
            .getAdjacentLocation( getDirection() );
        if ( gr.isValid( next ) )
        {
            Actor neighbor = gr.get( next );
            if (neighbor != null)
            {
                neighbor.removeSelfFromGrid();
            }
            moveTo( next );
        }
        //else
        //{
        //    removeSelfFromGrid();
        //}
    }

    /**
     * Tests whether the Jumper can move at all.
     * @return true if Jumper can move, false if it can't
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if ( gr == null )
        {
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation( getDirection() )
            .getAdjacentLocation( getDirection() );
        if ( !gr.isValid( next ) )
        {
            return false;
        }
        Actor neighbor = gr.get( next );
        return ( neighbor == null ) || ( neighbor instanceof Edible );
    }
}