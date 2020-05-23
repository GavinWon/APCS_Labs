import java.util.*;
import java.lang.reflect.*;
import java.text.DecimalFormat;


/**
 *  Represents a stock in the SafeTrade project
 *
 *  @author  Ashley Tsao
 *  @version Apr 1, 2019
 *  @author  Period: 5
 *  @author  Assignment: JMCh19_SafeTrade
 *
 *  @author  Sources: None
 */
public class Stock
{
    /**
     * holds MONEY
     */
    private static final DecimalFormat MONEY = new DecimalFormat( "0.00" );

    private String stockSymbol;

    private String companyName;

    private double loPrice;
    private double hiPrice; 
    private double lastPrice;

    private int volume;

    private PriorityQueue<TradeOrder> buyOrders;
    private PriorityQueue<TradeOrder> sellOrders;



    // TODO complete class
    /**
     * This constructor constructs a new stock with a given symbol, company
     * name, and starting price.
     * 
     * @param symbol
     *            - the stock symbol
     * @param name
     *            - full company name
     * @param price
     *            - opening price for this stock
     */
    public Stock(
        java.lang.String symbol,
        java.lang.String name,
        double price )
    {
        stockSymbol = symbol;
        companyName = name;
        volume = 0;
        loPrice = price;
        hiPrice = price;
        lastPrice = price;
        sellOrders = new PriorityQueue<TradeOrder>( 11,
            new PriceComparator() );
        buyOrders = new PriorityQueue<TradeOrder>( 11,
            new PriceComparator( false ) );
    }


        /**
     * Returns a quote string for this stock.
     * 
     * @return quote the quote for this stock
     */
    public java.lang.String getQuote()
    {
        String quote1 = companyName + " (" + stockSymbol + ")\n"
            + "Price: " + lastPrice + "  hi: " + hiPrice + "  lo: "
            + loPrice + "  vol: " + volume + "\n";
        String quoteAsk = "";
        String quoteBid = "";
        if ( !sellOrders.isEmpty() )
        {
            TradeOrder ask = sellOrders.peek();
            double askPrice = ask.getPrice();
            int askShares = ask.getShares();

            if ( ask.isMarket() )
            {
                quoteAsk = "Ask: market" + " size: " + askShares;
            }
            else
            {
                quoteAsk = "Ask: " + askPrice + " size: " + askShares;
            }

        }
        else
        {
            quoteAsk = "Ask: none ";
        }
        if ( !buyOrders.isEmpty() )
        {
            TradeOrder bid = buyOrders.peek();
            int buyShares = bid.getShares();
            double buyPrice = bid.getPrice();

            if ( bid.isMarket() )
            {
                quoteBid = " Bid: market" + " size: " + buyShares;
            }
            else
            {
                quoteBid = " Bid: " + buyPrice + " size: " + buyShares;
            }
        }
        else
        {
            quoteBid = " Bid: none";
        }

        quote1 += ( quoteAsk + quoteBid );
        return quote1;
    }


    /**
     * Places a trading order for this stock. Adds the order to the appropriate
     * priority queue depending on whether this is a buy or sell order. Notifies
     * the trader who placed the order that the order has been placed, by
     * sending a message to that trader.
     * 
     * @param order
     *            a trading order to be placed.
     */
    public void placeOrder( TradeOrder order )
    {
        if ( !order.getSymbol().equals( stockSymbol )
            || order.getShares() <= 0 )
        {
            order.getTrader()
                .mailbox()
                .add( order.getSymbol() + " not found" );
        }
        else
        {
            String orderPlaced = "New order: ";
            if ( order.isBuy() )
            {
                buyOrders.add( order );
                orderPlaced += " Buy ";
            }
            else
            {
                sellOrders.add( order );
                orderPlaced += " Sell ";
            }

            orderPlaced += stockSymbol + " (" + companyName + ")\n"
                + order.getShares() + " shares at ";

            if ( order.isMarket() )
            {
                orderPlaced += "market";
            }
            else
            {
                orderPlaced += "$" + order.getPrice();
            }

            Trader trade = order.getTrader();
            trade.mailbox().add( orderPlaced );
            executeOrders();
        }

    }


     /**
     * Executes as many pending orders as possible.
     */
    protected void executeOrders()
    {
        if ( buyOrders.isEmpty() || sellOrders.isEmpty() )
        {
            return;
        }
        TradeOrder buy = buyOrders.peek();
        TradeOrder sell = sellOrders.peek();
        Trader buyer = buy.getTrader();
        Trader seller = sell.getTrader();
        double price = 0;
        if ( buy.isLimit() && sell.isLimit()
            && buy.getPrice() >= sell.getPrice() )
        {
            price = sell.getPrice();
        }
        else if ( buy.isLimit() && sell.isMarket() )
        {
            price = buy.getPrice();
        }
        else if ( buy.isMarket() && sell.isMarket() )
        {
            price = lastPrice;
        }
        else
        {
            return;
        }
        int nShares = Math.min( buy.getShares(), sell.getShares() );
        buy.subtractShares( nShares );
        sell.subtractShares( nShares );
        if ( buy.getShares() == 0 )
        {
            buyOrders.remove( buy );
        }
        if ( sell.getShares() == 0 )
        {
            sellOrders.remove( sell );
        }
        if ( price < loPrice )
        {
            loPrice = price;
        }
        if ( price > hiPrice )
        {
            hiPrice = price;
        }
        volume += nShares;
        lastPrice = price;
        buyer.receiveMessage( "You bought: " + nShares + " " + stockSymbol
            + " at " + MONEY.format( price ) + " amt "
            + MONEY.format( nShares * price ) );
        seller.receiveMessage( "You sold: " + nShares + " " + stockSymbol
            + " at " + MONEY.format( price ) + " amt "
            + MONEY.format( nShares * price ) );
        if ( !buyOrders.isEmpty() && !sellOrders.isEmpty() )
        {
            executeOrders();
        }

    }


    //
    // The following are for test purposes only
    //
  
     /**
     * Returns stockSymbol
     * @return stockSymbol symbol of the stock
     */
    protected String getStockSymbol()
    {
        return stockSymbol;
    }

    /**
     * Return companyName
     * @return companyName name of company
     */
    protected String getCompanyName()
    {
        return companyName;
    }

    /**
     * Return getLoPrice
     * @return loPrice low price
     */
    protected double getLoPrice()
    {
        return loPrice;
    }

    /**
     * Return getHiPrice
     * @return hiPrice
     */
    protected double getHiPrice()
    {
        return hiPrice;
    }

    /**
     * 
     * Return lastPrice
     * @return lastPrice
     */
    protected double getLastPrice()
    {
        return lastPrice;
    }

    /**
     * 
     * the volume
     * @return volume
     */
    protected int getVolume()
    {
        return volume;
    }

    /**
     * 
     * the orders of what was bought
     * @return buyOrders
     */
    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }

    /**
     * 
     * the orders of what was sold
     * @return sellOrders
     */
    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
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
