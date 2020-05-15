
/**
 * A price comparator for TradeOrder
 *
 * @author Joyce Tung
 * @version Apr 1, 2019
 * @author Period: 5
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: None
 */
public class PriceComparator implements java.util.Comparator<TradeOrder>
{
    private boolean ascending;


    /**
     * Constructs an ascending PriceComparator
     */
    public PriceComparator()
    {
        ascending = true;
    }


    /**
     * Constructs a PriceComparator
     * 
     * @param asc
     *            boolean ascending or descending
     */
    public PriceComparator( boolean asc )
    {
        ascending = asc;
    }


    /**
     * Compares two trade orders.
     * 
     * @param order1
     *            - the first order
     * @param order2
     *            - the second order
     * @return int 0 if both orders are market orders; -1 if order1 is market
     *         and order2 is limit; 1 if order1 is limit and order2 is market;
     *         the difference in prices, rounded to the nearest cent, if both
     *         order1 and order2 are limit orders. In the latter case, the
     *         difference returned is cents1 - cents2 or cents2 - cents1,
     *         depending on whether this is an ascending or descending
     *         comparator (ascending is true or false).
     */
    public int compare( TradeOrder order1, TradeOrder order2 )
    {
        if ( order1.isMarket() && order2.isMarket() )
        {
            return 0;
        }
        else if ( order1.isMarket() && order2.isLimit() )
        {
            return -1;
        }
        else if ( order1.isLimit() && order2.isMarket() )
        {
            return 1;
        }
        else // both orders are limits
        {
            // dollars *100 cents/dollar = cents
            int difference = (int)Math.round(
                100 * order1.getPrice() - 100 * order2.getPrice() );
            if ( !ascending )
            {
                difference *= -1;
            }
            // getPrice() in TradeOrder is in dollars
            return difference;
        }
    }
}
