/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 *
 * @author Gavin Wong
 * @version 10/8/18
 * @author Period: 5
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: TODO List collaborators
 */
public class Complex
{
    private double a;

    private double b;


    /**
     * 
     * @param realCo
     *            the coefficient of the real value
     * @param imaCo
     *            the coefficient of the imaginary value
     */
    public Complex( double realCo, double imaCo )
    {
        a = realCo;
        b = imaCo;
    }


    /**
     * @param intCo
     *            the coefficient of the real value
     */
    public Complex( double intCo )
    {
        a = intCo;
        b = 0.0;
    }


    /**
     * 
     * TODO calculates the absolute value of the complex number
     * 
     * @return the absolute value of complex number
     */
    public double abs()
    {
        return Math.sqrt( ( this.a * this.a ) + ( this.b * this.b ) );
    }


    /**
     * 
     * TODO add Complex numbers together
     * 
     * @param other
     *            The complex number that is being added
     * @return the sum of the two complex numbers
     */
    public Complex add( Complex other )
    {
        return new Complex( this.a + other.a, this.b + other.b );
    }


    /**
     * 
     * TODO add complex and double together
     * 
     * @param addedValue
     *            the value of the double that is being added
     * @return the sum of the complex and double
     */
    public Complex add( double addedValue )
    {
        return new Complex( this.a + addedValue, this.b );
    }


    /**
     * 
     * TODO multiply two complex numbers togther
     * 
     * @param other
     *            the complex number that is being multiplied
     * @return the product of the two complex numbers
     */
    public Complex multiply( Complex other )
    {
        double realCo = ( this.a * other.a ) - ( this.b * other.b );
        double imaCo = ( this.a * other.b ) + ( this.b * other.a );
        return new Complex( realCo, imaCo );
    }


    /**
     * 
     * TODO multiply a complex number to a double
     * 
     * @param multValue
     *            the double value that is being multiplied
     * @return the product of the complex and double
     */

    public Complex multiply( double multValue )
    {
        return new Complex( this.a * multValue, this.b * multValue );
    }


    /**
     * Prints the complex number
     * @return the complex number in terms of a String
     */
    public String toString()
    {
        return a + " + " + b + "i";
    }
}
