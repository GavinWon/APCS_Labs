/**
 * Implements the game of Craps logic.
 *
 * @author Gavin wong
 * @version 9/17/2018
 * @author Period: 5
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: TODO collaborators
 */
public class CrapsGame
{
    private int point = 0;


    /**
     * TODO Calculates the result of the next dice roll in the Craps game. The
     * parameter total is the sum of dots on two dice. point is set to the saved
     * total, if the game continues, or 0, if the game has ended. Returns 1 if
     * player won, -1 if player lost, 0 if player continues rolling.
     * @return an and integer saying whether player wins or loses or continues 
     * playing
     * @param total the number that was just rolled
     */
    public int processRoll( int total )
    {
        int result = 0;
        if ( point == 0 )
        {
            if ( total == 7 || total == 11 )
            {
                result = 1;
            }
            else if (total == 2 || total == 3 || total == 12)
            {
                result = -1;
            }
            else
            {
                result = 0;
                point = total;
            }
        }
        else
        {
            if ( point == total )
            {
                result = 1;
                point = 0;
            }
            else if ( total == 7 )
            {
                result = -1;
                point = 0;
            }
            else
            {
                result = 0;
            }
        }
        return result;

    }


    /**
     * @return the saved point
     */
    public int getPoint()
    {
        return point;
    }
}