import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a stock exchange. A <code>StockExchange</code> keeps a
 * <code>HashMap</code> of stocks, keyed by a stock symbol. It has methods to
 * list a new stock, request a quote for a given stock symbol, and to place a
 * specified trade order.
 *
 * @author gwong676
 * @version Apr 1, 2019
 * @author Period: 5
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: TODO
 */
public class StockExchange
{
    private Map<String, Stock> listedStocks;


    /**
     * Constructs a new stock exchange object. Initializes listed stocks to an
     * empty map (a HashMap).
     */
    public StockExchange()
    {
        listedStocks = new HashMap<String, Stock>();
    }


    /**
     * 
     * Returns the quote for a given stock
     * 
     * @param symbol
     *            - stock symbol
     * @return a text message that contains the quote
     */
    public String getQuote( String symbol )
    {
        Stock st = listedStocks.get( symbol );
        if ( st == null )
        {
            return symbol + " not found";
        }
        return st.getQuote();
    }


    /**
     * 
     * Adds a new stock with given parameters to the listed stocks.
     * 
     * @param symbol
     *            - stock symbol
     * @param name
     *            - company name
     * @param price
     *            - opening stock price
     */
    public void listStock( String symbol, String name, double price )
    {
        Stock st = new Stock( symbol, name, price );
        listedStocks.put( symbol, st );
    }


    /**
     * 
     * Places a trade order by calling stock.placeOrder for the stock specified
     * by the stock symbol in the trade order
     * 
     * @param order
     *            - a trading order to be placed with this stock exchange.
     */
    public void placeOrder( TradeOrder order )
    {
        String symbol = order.getSymbol();
        Stock st = listedStocks.get( symbol );
        if ( st == null )
        {
            return;
        }
        st.placeOrder( order );
    }


    /**
     * 
     * get the Listed Stocks
     * 
     * @return listedStocks
     */
    protected Map<String, Stock> getListedStocks()
    {
        return listedStocks;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this StockExchange.
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
}
