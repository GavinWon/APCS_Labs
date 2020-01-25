import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author  Period - TODO Your Period
   @author  Assignment - GridWorld Part 2, Random Bugs - CircleBugRunner

   @author  Sources - TODO list collaborators
 */
public class CircleBugRunner
{
    public static void main( String[] args )
    {
    	ActorWorld world = new ActorWorld();
        CircleBug alice = new CircleBug( 6 );
        alice.setColor( Color.ORANGE );
        CircleBug bob = new CircleBug( 3 );
        world.add( new Location( 7, 8 ), alice );
        world.add( new Location( 5, 5 ), bob );
        world.show();
    }	
}