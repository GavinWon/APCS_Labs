import info.gridworld.actor.Bug;
import java.awt.Color;

/**
 * A subclass of Bug that adds the turnAround method and redefines Bug's act
 * method so that this bug makes a U-turn when it can't move

 * @author  TODO Your Name
 * @version TODO Date
 *
 * @author  Period - TODO Your Period
 * @author  Assignment - Random Bugs - UTurnBug
 *
 * @author  Sources - TODO list collaborators
 */
public class UTurnBug extends Bug
{
    public UTurnBug()
    {
        setColor( Color.YELLOW );
    }

    public UTurnBug( Color bugColor )
    {
        setColor( bugColor );
    }

    public void turnAround()
    {
        turn();
        turn();
        turn();
        turn(); // Or: setDirection(getDirection() + 180);
    }

    // Overrides Bug's act method
    public void act()
    {
        if ( canMove() )
            move();
        else
            turnAround();
    }
}
