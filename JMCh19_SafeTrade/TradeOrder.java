import java.lang.reflect.*;


/**
 * * Represents a buy or sell order for trading a given number of shares of a
 * specified stock.
 *
 * @author Ashley Tsao
 * @version Apr 1, 2019
 * @author Period: 5
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: None
 */
public class TradeOrder
{
    private Trader trader;

    private String symbol;

    private boolean buyOrder;

    private boolean marketOrder;

    private int numShares;

    private double price;


    /**
     * Constructs a new TradeOrder for a given trader, stock symbol, a number of
     * shares, and other parameters
     * 
     * @param trader
     *            the trader
     * @param symbol
     *            the symbol
     * @param buyOrder
     *            the buyOrder
     * @param marketOrder
     *            the marketOrder
     * @param numShares
     *            the numShares
     * @param price
     *            the price
     */
    TradeOrder(
        Trader trader,
        java.lang.String symbol,
        boolean buyOrder,
        boolean marketOrder,
        int numShares,
        double price )
    {
        this.trader = trader;
        this.symbol = symbol;
        this.buyOrder = buyOrder;
        this.marketOrder = marketOrder;
        this.numShares = numShares;
        this.price = price;
    }


    /**
     * Returns the price per share for this trade order (used by a limit order).
     * 
     * @return price
     */
    public double getPrice()
    {
        return price;
    }


    /**
     * Returns the number of shares to be traded in this trade order.
     * 
     * @return numShares
     */
    public int getShares()
    {
        return numShares;
    }


    /**
     * Returns the stock symbol for this trade order.
     * 
     * @return symbol
     */
    public java.lang.String getSymbol()
    {
        return symbol;
    }


    /**
     * Returns the trader for this trade order.
     * 
     * @return trader
     */
    public Trader getTrader()
    {
        return trader;
    }


    /**
     * Returns true if this is a buy order; otherwise returns false.
     * 
     * @return buyOrder
     */
    public boolean isBuy()
    {
        return buyOrder;
    }


    /**
     * Returns true if this is a limit order; otherwise returns false.
     * 
     * @return true limit order false not limit order
     */
    public boolean isLimit()
    {
        return !marketOrder;
    }


    /**
     * Returns true if this is a market order; otherwise returns false.
     * 
     * @return true - market order false - not market order
     */
    public boolean isMarket()
    {
        return marketOrder;
    }


    /**
     * Returns true if this is a sell order; otherwise returns false.
     * 
     * @return true - sell order false - not sell order
     */
    public boolean isSell()
    {
        return !buyOrder;
    }


    /**
     * Subtracts a given number of shares from the total number of shares in
     * this trade order.
     * 
     * @param shares
     *            number of shares to subtract
     */
    public void subtractShares( int shares )
    {
        if ( shares > numShares )
        {
            throw new java.lang.IllegalArgumentException();
        }
        else
        {
            numShares -= shares;
        }
    }


    //
    // The following are for test purposes only
    //
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this TradeOrder.
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
