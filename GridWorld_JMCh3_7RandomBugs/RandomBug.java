import info.gridworld.actor.Bug;
import java.awt.Color;

/**
 * A subclass of Bug that adds the turnAround method and redefines Bug's act
 * method so that this bug makes a U-turn when it can't move

 * @author  TODO Gavin Wong
 * @version TODO 9/3/2018
 *
 * @author  Period - TODO 5
 * @author  Assignment - Random Bugs - UTurnBug
 *
 * @author  Sources - TODO list collaborators
 */
public class RandomBug extends Bug
{
    public RandomBug()
    {
        setColor( Color.YELLOW );
    }

    public RandomBug( Color bugColor )
    {
        setColor( bugColor );
    }

    public void turn(int angle)
    {
        setDirection(getDirection() + angle);  // Or: setDirection(getDirection() + 180);
    }

    // Overrides Bug's act method
    public void act()
    {	int angle;
        if ( canMove() ) {
            move();
            angle = 45 * (int)(Math.random() * 8);
        }
        else {
        	angle = 45 * (int)(Math.random() * 8);
            turn(angle);
        }
    }
}
