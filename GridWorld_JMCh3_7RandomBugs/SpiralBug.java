import info.gridworld.actor.Bug;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Gavin Wong
   @version TODO 9/3/2018

   @author  Period - TODO 5
   @author  Assignment - GridWorld Part 2, Exercise 2 - SpiralBug

   @author  Sources - TODO list collaborators
 */
public class SpiralBug extends Bug
{
    private int steps;
    private int sideLength;

    /**
     * Constructs a Spiral bug that traces a square of a given side length
     * @param length the side length
     */
    public SpiralBug(int length)
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
            turn();
            steps = 0;
            sideLength++;
        }
    }
}