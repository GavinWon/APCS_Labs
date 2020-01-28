import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *  Jumper tests:.
 *  test01 - jumper next to edge of grid - should turn
 *  test02 - jumper 2 from edge of grid - should turn
 *  test03 - Jumper 2 away from non-edible - turn
 *  test04 - Jumper 2 away from edible - jump to location, remove prev
 *  test05 - Jumper 2 away from empty location - jump
 *  test06 - Jumper one-arg constructor
 *  test07 - grid doesn't exist
 *
 *  @author  Gavin Wong, Joyce Tung
 *  @version 10/26/2018
 *
 *  @author  Period: 5
 *  @author  Assignment - GridWorld Part 3 Jumper
 *
 *  @author  Sources: None
 */
public class JUJumperTest
{
    /*
     * Variables used by the test methods.
     */
    private Grid<Actor> grid;
    private ActorWorld world;
    private Jumper jumper1;

    /**
     * Invoked before each test to instantiate the objects
     * used for every test.
     */
    @Before public void initialize()
    {
        grid = new BoundedGrid<Actor>(8, 8);
        world = new ActorWorld(grid);
        jumper1 = new Jumper();
    }

    /**
     * test01 - jumper next to edge of grid - should turn
     */
    @Test
    public void jumperNextToEdgeOfGridShouldTurn()
    {
        Location loc = new Location(0, 3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * test02 - jumper 2 from edge of grid - should turn.
     */
    @Test
    public void jumper2FromEdgeOfGridShouldTurn()
    {
        Location loc = new Location(1, 3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * test03 - Jumper 2 away from non-edible - turn
     */
    @Test
    public void jumper2FromNonEdibleShouldTurn()
    {
        Location loc = new Location(2, 3);
        world.add(loc, jumper1);
        Rock r = new Rock();
        Location loc1 = new Location(0, 3);
        world.add( loc1, r );
        jumper1.act();

        Location loc3 = new Location(6,7);
        Jumper jumper2 = new Jumper();
        world.add(loc3, jumper2);
        Location loc4 = new Location(4,7);
        Bug b = new Bug();
        world.add(loc4, b);
        jumper2.act();
        
        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
        assertTrue(r.getLocation() != null);
        assertTrue(testOccupied(loc3, jumper2, Location.NORTHEAST));
        assertTrue(b.getLocation() != null);
    }

    /**
     * test04 - Jumper 2 away from edible - jump to location, remove prev actor
     */
    @Test
    public void jumper2FromEdibleShouldMove()
    {
        Location loc = new Location(2, 3);
        world.add(loc, jumper1);
        Jumper r = new Jumper();
        Location loc1 = new Location(0, 3);
        world.add( loc1, r );
        jumper1.act();

        assertTrue(testOccupied(loc1, jumper1, Location.NORTH));
        assertTrue(testEmpty(loc));
        assertTrue(r.getLocation() == null);
    }

    /**
     * test05 - Jumper 2 away from empty location - jump
     */
    @Test
    public void jumper2FromEmpty()
    {
        Location loc = new Location(2, 3);
        Location loc2 = new Location(0,3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc2, jumper1, Location.NORTH));
        assertTrue(testEmpty(loc));
    }

    /**
     * test06 - Jumper one-arg constructor
     */
    @Test
    public void jumperConstructorWithOneArg()
    {
        Jumper jumper2 = new Jumper(Color.GREEN);
        Location loc = new Location(2,3);
        world.add(loc, jumper2);
        
        assertTrue(jumper2.getColor() == Color.GREEN);
        
    }

    /**
     * test07 - grid doesn't exist
     */
    @Test
    public void gridNotExist()
    {
        Grid<Actor> grid2 = null;
        ActorWorld world2 = new ActorWorld(grid2);
        Location loc = new Location(2,3);
        
        assertTrue(!(jumper1.canMove()));
        
//        Location loc = new Location(2, 3);
//        Location loc2 = new Location(1,3);
//        Location loc3 = new Location(0,3);
//        Flower f = new Flower();
//        world.add( loc, jumper1 );
//        world.add( loc2, f );
//        jumper1.act();
//        
//        assertTrue(testOccupied(loc2, f, Location.NORTH));
//        assertTrue(testOccupied(loc3, jumper1, Location.NORTH));
//        assertTrue(testEmpty(loc));
    }

    /**
     * Test helper method to test for empty location.
     *
     * @param loc null location if empty
     * @return true if all assertions pass
     */
    private boolean testEmpty(Location loc)
    {
        Actor empty = grid.get( loc );
        assertNull( "<<<<< " + loc + " should be empty. >>>>>", empty );

        return true;
    }

    /**
     * Test helper method to test that object is in a location, and has
     * a consistent loc, and direction dir.
     *
     * @param loc location that should be occupied
     * @param a   actor that should be in location loc
     * @param dir direction this actor should be facing
     * @return true if all assertions pass
     */
    private boolean testOccupied(Location loc, Actor a, int dir)
    {
        Actor found = grid.get( loc );
        assertSame( "<<<<< " + loc + " should contain the actor. >>>>>",
            a, found );
        assertEquals( "<<<<< Loc should be " + loc + " >>>>>",
            loc, found.getLocation() );
        assertEquals( "<<<<< Dir should be " + dir + " >>>>>",
            dir, found.getDirection() );

        return true;
    }
    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "JUJumperTest" );
    }
}