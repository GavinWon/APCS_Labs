/**
 * Simulates a six-sided die.
 *
 * @author TODO Gavin Wong
 * @version TODO 9/17/2018
 * @author Period: 5
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: TODO collaborators
 */
public class Die
{
    private int numDots;


    /**
     * Sets numDots to a random integer from 1 to 6
     */
    public void roll()
    {
        numDots = (int)( Math.random() * 6 ) + 1;
    }


    /**
     * Returns the value of the most recent roll.
     * 
     * @return numDots
     */
    public int getNumDots()
    {
        return numDots;
    }
    
    /**
     * 
     * TODO test out the die class
     * @param args stuff
     */
    public static void main(String[] args)
    {
        Die die = new Die();
        die.roll();
        System.out.println(die.getNumDots());
        die.roll();
        System.out.println(die.getNumDots());
    } 
}
