/**
 
 *
 *  @author  TODO Gavin Wong
 *  @version TODO 9/5/2018
 *  @author  Period: 5
 *  @author  Assignment: Easter
 *
 *  @author  Sources: TODO list collaborators
 */
import java.lang.reflect.*;
import java.util.Scanner;

// TODO: add comments

public class Easter
{
    private int y;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int k;
    private int r;
    private int m;
    private int n;
    private int p;

    public Easter( int year )
    {
        y = year;
    }

    public void calculate()
    {
        a = y % 19;
        System.out.println( "a = " + a );
        b = y / 100;
        System.out.println( "b = " + b );
        c = y % 100;
        System.out.println( "c = " + c);
        d = b / 4;
        System.out.println( "d = " + d);
        e = b % 4;
        System.out.println( "e = " + e);
        f = (b + 8) / 25;
        System.out.println( "f = " + f);
        g = (b - f + 1) / 3;
        System.out.println( "g = " + g);
        h = (19 * a + b - d - g + 15 ) % 30;
        System.out.println( "h = " + h);
        i = c / 4;
        System.out.println( "i = " + i);
        k = c % 4;
        System.out.println( "k = " + k);
        r = (32 + 2 * e + 2 * i - h - k) % 7;
        System.out.println( "r = " + r);
        m = (a + 11 * h + 22 * r) / 451;
        System.out.println( "m = " + m);
        n = (h + r - 7 * m + 114) / 31;
        System.out.println("n = " + n);
        p = (h + r - 7 * m + 114) % 31;
        System.out.println("p = " + p);
        
        System.out.println("Easter in 2003 falls on " + n + "/" + (p + 1));
        
        
        
        // TODO: complete method
    }

    /**
     * Intended only for debugging.
     * 
     * <p>A generic toString implementation that uses reflection to print
     * names and values of all fields <em>declared in this class</em>.
     * Note that superclass fields are left out of this implementation.</p>
     * 
     * @return a string representation of this Easter.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }
            separator = ", ";
        }
        return str + "]";
    }


    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the year (yyyy) --> " );
        int year = console.nextInt();

        Easter bunny = new Easter( year );
        bunny.calculate();
    }
}
