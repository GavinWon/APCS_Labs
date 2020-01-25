import info.gridworld.actor.Bug;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author  Period - TODO Your Period
   @author  Assignment - GridWorld Part 2, Random bugs - CircleBug

   @author  Sources - TODO list collaborators
 */
import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class CircleBug extends Bug
{
    private int steps;
    private int sideLength;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public CircleBug( int length )
    {
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
}