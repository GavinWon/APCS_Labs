/**
 * represents a digit for a certain base
 * 
 * @author Gavin Wong
 * @version 4/5/2019
 * 
 * @author Period - 5
 * @author Assignment - Numbers
 * 
 * @author Sources - TODO list collaborators
 */
public class Digit
{
    private int base;

    private char value;

    /**
     * Makes a digit with default value and base 10
     */
    public Digit()
    {
        base = 10;
        value = '0';
    }

    /**
     * Makes a digit with the given base and value
     * @param value digit value
     * @param base digit base
     */
    public Digit( int value, int base )
    {
        this.base = base;
        this.value = Character.forDigit( value, base );
    }

    /**
     * 
     * Increments digit
     * @return true if overload, false if not
     */
    public boolean increment()
    {
        int temp = Character.getNumericValue( value );
        if ( temp + 1 == base )
        {
            temp = 0;
            value = '0';
            return true;
        }
        else
        {
            temp++;
            value = Character.forDigit( temp, base );
            return false;
        }

    }

    /**
     * @return String value of digit
     */
    public String toString()
    {
        String output = value + "";
        return output.toUpperCase();
    }
}
