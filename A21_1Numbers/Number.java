import java.util.*;


/**
 * Represents a number
 * 
 * @author Gavin Wong
 * @version 4/5/2019
 * 
 * @author Period - 5
 * @author Assignment - Numbers
 * 
 * @author Sources - TODO list collaborators
 */
public class Number
{
    private int base;

    private LinkedList<Digit> digits;

   /**
    * Makes a default number with a default digit
    */
    public Number()
    {
        base = 10;
        digits = new LinkedList<Digit>();
        Digit d = new Digit( 0, 10 );
        digits.add( d );
    }

    /**
     * Makes a number with given value and base
     * @param value the number value
     * @param base the number vase
     */
    public Number( int value, int base )
    {
        this.base = base;
        digits = new LinkedList<Digit>();
        while ( value > 0 )
        {
            int digit = value % base;
            Digit d = new Digit( digit, base );
            digits.addFirst( d );
            value /= base;
        }
    }

    /**
     * 
     * Increments the number
     */
    public void increment()
    {
        for ( int index = digits.size() - 1; index >= 0; index-- )
        {
            Digit d = digits.get( index );
            boolean overload = d.increment();
            if ( !overload )
            {
                break;
            }
            if ( index == 0 && overload )
            {
                Digit value = new Digit( 1, base );
                digits.addFirst( value );
            }
        }
    }

    /**
     * @return the String value of the number
     */
    public String toString()
    {
        String output = "";
        for ( Digit d : digits )
        {
            output += d.toString();
        }
        return output;
    }
}
