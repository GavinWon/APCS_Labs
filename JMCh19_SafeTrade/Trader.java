import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a stock trader
 *
 * @author Joyce Tung
 * @version Apr 1, 2019
 * @author Period: 5
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: None
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;

    private String screenName;

    private String password;

    private TraderWindow myWindow;

    private Queue<String> mailbox;


    /**
     * Constructs a trader
     * 
     * @param brokerage
     *            Brokerage it belongs to
     * @param name
     *            java.lang.String name of trader
     * @param pswd
     *            java.lang.String password
     */
    public Trader(
        Brokerage brokerage,
        java.lang.String name,
        java.lang.String pswd )
    {
        this.brokerage = brokerage;
        screenName = name;
        password = pswd;
        // TODO: figure out whether the following line should be here!!!!
        mailbox = new LinkedList<String>();
    }


    /**
     * Returns trader name
     * 
     * @return java.lang.String name
     */
    public java.lang.String getName()
    {
        return screenName;
    }


    /**
     * Returns password
     * 
     * @return java.lang.String password
     */
    public java.lang.String getPassword()
    {
        return password;
    }


    /**
     * Compares a trader to this trader
     * 
     * @param other
     *            Trader trader to be compared to
     * @return int difference between two traders
     */
    public int compareTo( Trader other )
    {
        return screenName.compareToIgnoreCase( other.getName() );
    }


    /**
     * Returns true if a trader equals this trader, false otherwise
     * 
     * @param other
     *            Object to be compared to
     * @return boolean true if trader equals object
     */
    @Override
    public boolean equals( java.lang.Object other )
    {
        if ( !( other instanceof Trader ) )
        {
            // return false; // not sure if this is what's supposed to happen
            throw new ClassCastException();
        }
        return this.compareTo( (Trader)other ) == 0;
    }


    /**
     * Opens the Trader's window
     */
    public void openWindow()
    {
        myWindow = new TraderWindow( this );
        if ( this.hasMessages() )
        {
            while ( !mailbox.isEmpty() )
            {
                myWindow.showMessage( mailbox.remove() );
            }
        }
    }


    /**
     * Returns if the trader has messages
     * 
     * @return true if trader has messages, false otherwise
     */
    public boolean hasMessages()
    {
        return mailbox != null && !mailbox.isEmpty();
    }


    /**
     * adds a message to mailbox, displays message if myWindow isn't null
     * 
     * @param msg
     *            java.lang.String message to be added
     */
    public void receiveMessage( java.lang.String msg )
    {
        // TODO figure out if it works (find out after testing)
        mailbox.add( msg );
        if ( myWindow != null )
        {
            while ( !mailbox.isEmpty() )
            {
                myWindow.showMessage( mailbox.remove() );
            }
        }
    }


    /**
     * TODO Write your method description here.
     * 
     * @param symbol
     *            Trader gets q quote
     */
    public void getQuote( java.lang.String symbol )
    {
        brokerage.getQuote( symbol, this );
    }


    /**
     * TODO Write your method description here.
     * 
     * @param order
     *            TradeOrder puts Trader's order in brokerage
     */
    public void placeOrder( TradeOrder order )
    {
        brokerage.placeOrder( order );
    }


    /**
     * TODO Write your method description here.
     */
    public void quit()
    {
        brokerage.logout( this );
        myWindow = null;
    }


    //
    // The following are for test purposes only
    //
    /**
     * TODO Write your method description here.
     * 
     * @return Queue<String> Trader's mailbox
     */
    protected Queue<String> mailbox()
    {
        return mailbox;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
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
                if ( field.getType().getName().equals( "Brokerage" ) )
                {
                    str += separator + field.getType().getName() + " "
                        + field.getName();
                }
                else
                {
                    str += separator + field.getType().getName() + " "
                        + field.getName() + ":" + field.get( this );
                }
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
