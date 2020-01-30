import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 *  This class runs a world that contains Rocks and BlusterCritters
 *  added at specific locations to test BlusterCritter behavior.
 * 
 *  @author George Peck
 *  @author BlusterRunner.java
 *  @version Nov 18, 2007
 *  @author Period: 1-7
 *  @author Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 *
 *  @author Sources: C. Horstmann
 */
public class BlusterRunner
{
    /**
     * Test for BlusterCritter class.
     * @param args command line arguments (not used)
     */
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        world.add( new Location( 7, 8 ), new Rock() );
        world.add( new Location( 3, 3 ), new Rock() );
        world.add( new Location( 2, 8 ), new Rock( Color.BLUE ) );
        world.add( new Location( 5, 5 ), new Rock( Color.PINK ) );
        world.add( new Location( 1, 5 ), new Rock( Color.RED ) );
        world.add( new Location( 7, 2 ), new Rock( Color.YELLOW ) );
        world.add( new Location( 4, 4 ), new BlusterCritter( 10 ) );
        world.add( new Location( 5, 8 ), new BlusterCritter( 1 ) );
        world.show();
    }
}