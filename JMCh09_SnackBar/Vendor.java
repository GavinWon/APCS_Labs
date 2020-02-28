import java.lang.reflect.*;


/**
 * This class implements a vendor that sells one kind of item. A vendor carries
 * out sales transactions.
 * 
 * @author TODO Gavin Wong
 * @version TODO 10/4/2018
 * 
 * @author Period -
 * @author Assignment - Java Methods Ch09 - SnackBar
 * 
 * @author Sources - TODO list collaborators
 */
public class Vendor
{
    private int price;

    private int stockAmount;

    private int depositAmount;

    private int change;

    private static double totalSales = 0;


    /**
     * Makes a Vendor Object
     * 
     * @param priceAmount
     *            - the price of the object
     * @param stock
     *            - the amount of stock we have
     */
    public Vendor( int priceAmount, int stock )
    {
        price = priceAmount;
        stockAmount = stock;
    }


    /**
     * 
     * TODO set the stockAmount to a number
     * 
     * @param itemsStock
     *            the number we are setting stockAmount to
     */
    public void setStock( int itemsStock )
    {
        stockAmount = itemsStock;
    }


    /**
     * 
     * TODO gets stockAmount
     * 
     * @return the stock amount
     */
    public int getStock()
    {
        return stockAmount;
    }


    /**
     * 
     * TODO addMoney to the deposit amount
     * 
     * @param cents
     *            - the amount of money (in cents) to add
     */
    public void addMoney( int cents )
    {
        if ( stockAmount != 0 )
        {
            depositAmount += cents;
        }

    }


    /**
     * 
     * TODO get the deposit amount
     * 
     * @return the depositAmount
     */
    public int getDeposit()
    {
        return depositAmount;
    }


    /**
     * 
     * TODO we made sale if stock amount isn't zero and deposit amount is equal
     * to or more than price.
     * 
     * @return true if we made sale, false if not
     */
    public boolean makeSale()
    {
        if ( stockAmount > 0 && depositAmount >= price )
        {
            stockAmount--;
            depositAmount -= price;
            totalSales += price * 0.01;
            change = depositAmount;
            depositAmount = 0;
            return true;
        }
        else
        {
            change = depositAmount;
            depositAmount = 0;
            return false;
        }
    }


    /**
     * 
     * TODO gets the change from the last sale/transaction and sets change back
     * to zero
     * 
     * @return the change
     */
    public int getChange()
    {
        int temp = change;
        change = 0;
        return temp;

    }


    /**
     * 
     * TODO gets the total Sales and resets it back to zero
     * 
     * @return the total Sales
     */
    public static double getTotalSales()
    {
        double temp = totalSales;
        totalSales = 0;
        return temp;
    }


    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Vendor.
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
                str += separator + field.getName() + ":" + field.get( this );
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
