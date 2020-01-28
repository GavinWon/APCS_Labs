import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;

/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Gavin Wong, Joyce Tung
 *  @version 10/26/2018	
 *  @author  Period: 5
 *  @author  Assignment: GridWorld_Part3_Jumper
 *
 *  @author  Sources: None
 */
public class JumperRunner
{
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
      	Jumper a = new Jumper ();
      	world.add(new Location(7,8), a);
      	world.show();
    }
}