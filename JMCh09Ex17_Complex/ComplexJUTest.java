import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 *  Test for the complex number class.
 *  
 *  testConstructor1Param - test the 1 parameter constructor
 *  testConstructor2Param - test the 2 parameter constructor
 *  testAddRealAndComplexNum - addition of a complex number 
 *     with a real number
 *  testAdd2ComplexNums - addition of two complex numbers
 *  testMultiply2ComplexNums - multiplication of two complex numbers
 *  testMultiplyRealAndComplexNum - multiplication of a complex number
 *     with a real number
 *  testAbsoluteValue - absolute value of a complex number
 *
 *  @author  TODO Your Name
 *  @version TODO Date
 *  @author  Period: TODO Your Period
 *  @author  Assignment: JMCh09Ex17_Complex 
 *
 *  @author  Sources: TODO List collaborators
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    private Complex comp1;
    private Complex comp2;
    
    @Before
    public void setUp()
    {
        comp1 = new Complex(3);
        comp2 = new Complex(1,2);
    }
    
    @Test
    public void testConstructor1Param()
    {
        assertEquals("3.0 + 0.0i", comp1.toString());
    }

    @Test
    public void testConstructor2Param()
    {
        assertEquals("1.0 + 2.0i", comp2.toString());
    }

    @Test
    public void testAddRealAndComplexNum()
    {
        assertEquals("5.0 + 2.0i", comp2.add(4).toString());
    }
    
    @Test
    public void testAdd2ComplexNums()
    {
        Complex temp = new Complex (2,6);
        assertEquals("5.0 + 6.0i", comp1.add(temp).toString());
    }

    @Test
    public void testMultiply2ComplexNums()
    {
        Complex temp = new Complex (3,4);
        assertEquals("9.0 + 12.0i", comp1.multiply(temp).toString());
    }

    @Test
    public void testMultiplyRealAndComplexNum()
    {
        double temp = 10.0;
        assertEquals("10.0 + 20.0i", comp2.multiply(temp).toString());
        
    }

    @Test
    public void testAbsoluteValue()
    {
        Complex temp = new Complex (3,4);
        assertEquals(5.0, temp.abs());
    }
    
    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }

    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
