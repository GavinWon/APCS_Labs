import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 * SafeTrade tests:
 *   TradeOrder
 *   PriceComparator
 *   Trader
 *   Brokerage
 *   StockExchange
 *   Stock
 *
 * @author Gavin Wong
 * @author Joyce Tung
 * @author Ashley Tsao
 * @version 4/2/2019
 * @author Assignment: JM Chapter 19 - SafeTrade
 * 
 * @author Sources: TODO sources
 *
 */
public class JUSafeTradeTest
{
    // --Test TradeOrder
    /**
     * TradeOrder tests:
     *   TradeOrderConstructor - constructs TradeOrder and then compare toString
     *   TradeOrderGetTrader - compares value returned to constructed value
     *   TradeOrderGetSymbol - compares value returned to constructed value
     *   TradeOrderIsBuy - compares value returned to constructed value
     *   TradeOrderIsSell - compares value returned to constructed value
     *   TradeOrderIsMarket - compares value returned to constructed value
     *   TradeOrderIsLimit - compares value returned to constructed value
     *   TradeOrderGetShares - compares value returned to constructed value
     *   TradeOrderGetPrice - compares value returned to constructed value
     *   TradeOrderSubtractShares - subtracts known value & compares result
     *     returned by getShares to expected value
     */
    private String symbol = "GGGL";
    private boolean buyOrder = true;
    private boolean marketOrder = true;
    private int numShares = 123;
    private int numToSubtract = 24;
    private double price = 123.45;

    @Test
    public void tradeOrderConstructor()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        String toStr = to.toString();

        assertTrue( "<< Invalid TradeOrder Constructor >>",
                    toStr.contains( "TradeOrder[Trader trader:null" )
                        && toStr.contains( "java.lang.String symbol:" + symbol )
                        && toStr.contains( "boolean buyOrder:" + buyOrder )
                        && toStr.contains( "boolean marketOrder:" + marketOrder )
                        && toStr.contains( "int numShares:" + numShares )
                        && toStr.contains( "double price:" + price ) );
    }
    
    @Test
    public void TradeOrderToString()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertNotNull( to.toString() );
    }

    @Test
    public void tradeOrderGetTrader()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertNull( "<< TradeOrder: " + to.getTrader() + " should be null >>",
                    to.getTrader() );
    }

    @Test
    public void tradeOrderGetSymbol()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertEquals( "<< TradeOrder: " + to.getTrader() + " should be "
            + symbol + " >>", symbol, to.getSymbol() );
    }

    @Test
    public void tradeOrderIsBuy()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );

        assertTrue( "<< TradeOrder: " + to.isBuy() + " should be " + buyOrder
            + " >>", to.isBuy() );
    }

    @Test
    public void tradeOrderIsSell()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertFalse( "<< TradeOrder: " + to.isSell() + " should be "
            + !buyOrder + " >>", to.isSell() );
    }

    @Test
    public void tradeOrderIsMarket()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertTrue( "<< TradeOrder: " + to.isMarket() + " should be "
            + marketOrder + " >>", to.isMarket() );
    }

    @Test
    public void tradeOrderIsLimit()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );

        assertFalse( "<< TradeOrder: " + to.isLimit() + " should be "
            + !marketOrder + ">>", to.isLimit() );
    }

    @Test
    public void tradeOrderGetShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertTrue( "<< TradeOrder: " + to.getShares() + " should be "
            + numShares + ">>", numShares == to.getShares()
            || ( numShares - numToSubtract ) == to.getShares() );
    }

    @Test
    public void tradeOrderGetPrice()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertEquals( "<< TradeOrder: " + to.getPrice() + " should be " + price
            + ">>", price, to.getPrice(), 0.0 );
    }

    @Test
    public void tradeOrderSubtractShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        to.subtractShares( numToSubtract );
        assertEquals( "<< TradeOrder: subtractShares(" + numToSubtract
            + ") should be " + ( numShares - numToSubtract ) + ">>", numShares
            - numToSubtract, to.getShares() );
    }
    
    // --Test TraderWindow Stub
    @Test
    public void traderWindowConstructor()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
    }

    @Test
    public void traderWindowShowMessage()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
        tw.showMessage( null );
    }

    //  --Test PriceComparator
    
    @Test
    public void priceComparatorConstructor1()
    {
        PriceComparator p = new PriceComparator();
        assertNotNull(p); //this works
    }
    
    @Test
    public void priceComparatorConstructor2()
    {
        PriceComparator p = new PriceComparator(false);
        assertNotNull(p); //this works
    }
    
    @Test
    public void compareTest()
    {
        PriceComparator p = new PriceComparator( false );
        PriceComparator p1 = new PriceComparator();
        Trader t = new Trader( new Brokerage( new StockExchange() ),
            "joe",
            "ave" );
        TradeOrder o1 = new TradeOrder( t, "CAE", true, true, 2, 3.01 );
        TradeOrder o2 = new TradeOrder( t, "CAE", true, true, 2, 3.01 );
        TradeOrder o7 = new TradeOrder( t, "CAE", true, false, 2, 3.01 );
        TradeOrder o8 = new TradeOrder( t, "CAE", true, false, 2, 4.03 );
        assertEquals( p.compare( o1, o2 ), 0 ); // 1st pair
        assertEquals( p.compare( o1, o7 ), -1 ); // 2nd pair
        assertEquals( p.compare( o7, o2 ), 1 ); // 3rd pair
        assertEquals( p.compare( o7, o8 ), -301 + 403 ); // 4th pair, descending
        assertEquals( p1.compare( o7, o8 ), -403 + 301 ); // 4th pair, ascending
    }
    
    
    // --Test Trader
    
    @Test
    public void traderConstructor()
    {
        Trader t = new Trader(new Brokerage(new StockExchange()), "joke", "abcd");
        assertNotNull(t);
    }
    
    @Test
    public void getNameTest()
    {
        Trader t = new Trader(new Brokerage(new StockExchange()), "joke", "abcd");
        assertEquals(t.getName(), "joke");
    }
    
    @Test
    public void getPasswordTest()
    {
        Trader t = new Trader(new Brokerage(new StockExchange()), "joke", "abcd");
        assertEquals(t.getPassword(), "abcd");
    }
    
    @Test
    public void compareToTest()
    {
        Trader t = new Trader(new Brokerage(new StockExchange()), "joke", "abcd");
        Trader t1 = new Trader(new Brokerage(new StockExchange()), "lily", "abcd");
        assertEquals(t.compareTo( t1 ), "joke".compareToIgnoreCase( "lily" ));
    }
    
    @Test
    public void equalsTest()
    {
        Trader t = new Trader(new Brokerage(new StockExchange()), "joke", "abcd");
        Trader t2 = new Trader(new Brokerage(new StockExchange()), "joke", "abcd");
        Trader t1 = new Trader(new Brokerage(new StockExchange()), "lily", "abcd");
        //???? how
        assertTrue(t.equals( t2 ) && !t1.equals( t ));
    }
    
    @Test
    public void openWindowTest()
    {
        Trader t = new Trader(new Brokerage(new StockExchange()), "joke", "abcd");
        t.openWindow();
        String s = t.toString();
        assertTrue( s.contains( "TraderWindow myWindow:TraderWindow" ) );
    }
    
    @Test
    public void hasMessagesTest()
    {
        Trader t = new Trader(new Brokerage(new StockExchange()), "joke", "abcd");
        assertTrue(!t.hasMessages());
        t.receiveMessage( "hi" );
        assertTrue(t.hasMessages());
    }
    
    @Test
    public void getQuoteTest()
    {
        StockExchange exchange = new StockExchange();
        Brokerage b = new Brokerage(exchange);
        Trader t = new Trader(b, "joke", "abcd");
        exchange.listStock( "GGGL", "Giggle.com", 10.00 );
        t.getQuote( "GGGL" );
        assertTrue(t.hasMessages()); //works because trader hasn't logged in
    }
    
    @Test
    public void placeOrderTest()
    {
        StockExchange exchange = new StockExchange();
        Brokerage b = new Brokerage(exchange);
        Trader t = new Trader(b, "joke", "abcd");
        exchange.listStock( "GGGL", "Giggle.com", 10.00 );
        t.placeOrder( new TradeOrder(t, "GGGL", true, true, 10, 10 ) );
        assertTrue(t.hasMessages());
    }
    
    @Test
    public void quitTest()
    {
        StockExchange exchange = new StockExchange();
        Brokerage b = new Brokerage(exchange);
        Trader t = new Trader(b, "joke", "abcd");
        b.addUser( "joke", "abcd" );
        b.login( "joke", "abcd" );
        t.quit();
        assertTrue(b.getLoggedTraders().size() == 0);
    }
    
    @Test
    public void recieveMessageTest()
    {
        StockExchange exchange = new StockExchange();
        Brokerage b = new Brokerage(exchange);
        Trader t = new Trader(b, "joke", "abcd");
        t.receiveMessage( "HI" );
        assertTrue(t.hasMessages());
    }
    
    @Test
    public void toStringTest()
    {
        Trader t = new Trader(new Brokerage(new StockExchange()), "joke", "abcd");
        assertNotNull(t.toString());
    }
    
    
     // --Test Brokerage
    
    @Test
    public void brokerageConstructor()
    {
        StockExchange st = new StockExchange();
        Brokerage b = new Brokerage(st);
        assertEquals(
                "Brokerage: Invalid Constructor",
                "Brokerage[java.util.Map traders:{}, java.util.Set loggedTraders:[], StockExchange exchange:StockExchange[java.util.Map listedStocks:{}]]",
                b.toString());
    }
    
    @Test
    public void brokerageAddUser()
    {
        StockExchange st = new StockExchange();
        Brokerage b = new Brokerage(st);
        assertTrue(b.addUser("Gav", "Password") == -1);
        assertTrue(b.addUser("Gavin", "SuperDuperWuperLongPassword") == -2);
        assertTrue(b.addUser("Gavin", "Password") == 0);
        assertTrue(b.addUser("Gavin", "Password") == -3);
        assertTrue(b.getTraders().size() == 1);
    }
    
    @Test
    public void brokerageGetQuote()
    {
        StockExchange st = new StockExchange();
        Brokerage b = new Brokerage(st);
        st.listStock("h", "hello", 0.76 );
        Trader t = new Trader(b, "Gavin", "Password");
        b.getQuote("h", t);
        assertTrue(t.mailbox().size() == 1);
        
    }
    
    @Test
    public void brokerageLogin()
    {
        StockExchange st = new StockExchange();
        Brokerage b = new Brokerage(st);
        assertTrue(b.login("Gavin" , "Password") == -1);
        b.addUser("Gavin" , "Password");
        assertTrue(b.login("Gavin" , "Pass") == -2);
        assertTrue(b.login("Gavin" , "Password") == 0);
        assertTrue(b.getLoggedTraders().size() == 1);
        assertTrue(b.login("Gavin" , "Password") == -3);
    }
    
    @Test
    public void brokerageLogout()
    {
        StockExchange st = new StockExchange();
        Brokerage b = new Brokerage(st);
        Trader t = new Trader (b, "Gavin", "Password");
        b.addUser("Gavin" , "Password");
        b.login("Gavin" , "Password");
        b.logout(t);
        assertFalse(b.getLoggedTraders().contains(t));
        
    }
    
    @Test
    public void brokeragePlaceOrder()
    {
        StockExchange st = new StockExchange();
        Brokerage b = new Brokerage(st);
        Trader trader = new Trader(b, "Gavin", "Password");
        TradeOrder order = new TradeOrder(trader, "stuff", true, true, 5, 10.0);
        Stock stock = new Stock("stuff","stuffy" , 5.0);
        st.getListedStocks().put("stuff", stock);

        b.placeOrder(order);

        assertTrue(trader.hasMessages());
    }
    
    @Test
    public void brokerageToString()
    {
        StockExchange st = new StockExchange();
        Brokerage b = new Brokerage(st);
        assertNotNull(b.toString());
    }
    
    // --Test StockExchange
    @Test
    public void stockExchangeConstructor()
    {
        StockExchange st = new StockExchange();

        assertEquals("StockExchange: Invalid Constructor",
                "StockExchange[java.util.Map listedStocks:{}]",
                st.toString());
    }
    
    @Test
    public void stockExchangeGetQuote()
    {
        StockExchange st = new StockExchange();
        st.listStock("h", "hello", 0.76 );
        assertNotNull(st.getQuote("h"));
        
    }
    
    @Test
    public void stockExchangeListStock()
    {
        StockExchange st = new StockExchange();
        Stock s = new Stock("h", "hello", 0.76);
        st.listStock( "h", "hello", 0.76 );
        Map<String, Stock> test = st.getListedStocks();
        assertTrue(test.containsKey("h"));
    }
    
    @Test
    public void stockExchangePlaceOrder()
    {
        StockExchange st = new StockExchange();
        Brokerage b = new Brokerage(st);
        Trader trader = new Trader(b, "Gavin", "Password");
        TradeOrder order = new TradeOrder(trader, "stuff", true, true, 5,
                10.0);
        Stock stock = new Stock("stuff", "stuffy", 5.0);
        st.getListedStocks().put("stuff", stock);

        st.placeOrder(order);

        assertTrue(trader.hasMessages());
    }
    
    @Test
    public void stckExchangeToString()
    {
        StockExchange st = new StockExchange();
        st.listStock("h", "hello", 0.76 );
        assertNotNull(st.toString());
    }
    
    
    // --Test Stock
    private String name = "Giggle.com";
       @Test
    public void stockConstructor()
    {
        PriorityQueue<TradeOrder> sellOrders = new PriorityQueue<TradeOrder>(
            11,
            new PriceComparator() );
        PriorityQueue<TradeOrder> buyOrders = new PriorityQueue<TradeOrder>(
            11,
            new PriceComparator( false ) );
        int vol = 0;
        Stock s = new Stock( symbol, name, price );

        String toStr = s.toString();

        assertTrue( "<< Invalid Stock Constructor >>",
            toStr.contains( "String stockSymbol:" + symbol )
                && toStr.contains( "String companyName:" + name )
                && toStr.contains( "double loPrice:" + price )
                && toStr.contains( "double hiPrice:" + price )
                && toStr.contains( "double lastPrice:" + price )
                && toStr.contains( "int volume:" + vol )
                && toStr.contains( "PriorityQueue buyOrders:" + buyOrders )
                && toStr.contains(
                    "PriorityQueue sellOrders:" + sellOrders ) );
    }

    @Test
    public void stockGetQuote()
    {
        Stock st = new Stock( symbol, "name", price );

        assertEquals( "MESSAGE",
            st.getQuote(),
            "name (" + symbol + ")\nPrice: " + price + " hi: " + price
                + " lo: " + price + " vol: 0\nAsk: none Bid: none" );
    }

  @Test
    public void stockExecuteOrder()
    {
        Stock s = new Stock( "GGGL", "Giggle", 2.0 );
        StockExchange e = new StockExchange();
        Brokerage b = new Brokerage( e );
        e.getListedStocks().put( "GGGL", s );
        Trader t1 = new Trader( b, "name1", "pass1" );
        Trader t2 = new Trader( b, "name2", "pass2" );

        TradeOrder order1 = new TradeOrder( t1, "GGGL", true, true, 1, 2.0 );
        TradeOrder order2 = new TradeOrder( t2, "GGGL", false, true, 1, 2.0 );

        t1.placeOrder( order1 );
        t2.placeOrder( order2 );

        s.executeOrders();
        String msg = t1.mailbox().peek();
        String msg2 = t2.mailbox().peek();

        assertEquals( msg.toString(), "New order:  Buy GGGL (Giggle)\n" + "1 shares at market" );
        assertEquals( msg2.toString(), "New order:  Sell GGGL (Giggle)\n" + "1 shares at market" );
    }
    @Test
    public void stockPlaceOrder()
    {
        StockExchange e = new StockExchange();
        Stock s = new Stock( symbol, "name", price );
        e.listStock( symbol, "name", price );
        Brokerage b = new Brokerage( e );
        Trader trader = new Trader( b, "name", "password" );
        TradeOrder test = new TradeOrder( trader, symbol, buyOrder, marketOrder, numShares, price );
        s.placeOrder( test );
        assertEquals( s.getBuyOrders().isEmpty(), false );
        assertTrue( trader.hasMessages() );
    }
    
    @Test
    public void stockToStringTest()
    {
        Stock s = new Stock( symbol, name, price );
        assertNotNull( s.toString() );
    }
    // TODO your tests here

    
    // Remove block comment below to run JUnit test in console
/*
    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( JUSafeTradeTest.class );
    }
    
    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "JUSafeTradeTest" );
    }
*/
}

