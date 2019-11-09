/**
 *  Tests Numbers and Digits
 *
 *  @author  gwong676
 *  @version Apr 7, 2019
 *  @author  Period: TODO
 *  @author  Assignment: A21_1Numbers
 *
 *  @author  Sources: TODO
 */
public class TestNumber
{
    /**
     * 
     * main method to run
     * @param args stuff
     */
    public static void main( String[] args )
    {
        int[] base = { 2, 8, 10, 16 };

        for ( int b = 0; b < base.length; b++ )
        {
            Number n = new Number( 0, base[b] );
            System.out.println( "\nbase=" + base[b] );
            for ( int i = 0; i < 256; i++ )
            {
                System.out.println( n );
                n.increment();
            }
        }
    }
}
