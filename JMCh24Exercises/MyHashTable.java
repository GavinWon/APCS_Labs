import java.util.*;

/**
 * Question 24-22
 *
 * @author Gavin Wong
 * @version 3/5/2019
 * @author Period: 5
 * @author Assignment: JMCh24Exercises
 *
 * @author Sources: TODO
 */
public class MyHashTable
{
    private ArrayList<LinkedList<String>> buckets;
    private int numItems;
    private double loadFactorLimit;

    public MyHashTable()
    {
        this( 16, 0.75 );
    }

    public MyHashTable( int capacity, double limit )
    {
        buckets = new ArrayList<LinkedList<String>>( capacity );
        for ( int count = 1; count <= capacity; count++ )
            buckets.add( new LinkedList<String>() );
        numItems = 0;
        loadFactorLimit = limit;
    }
    
    /**
     * Question 24-22
     * 
     * Fill in the blanks in the add method.
     * 
     * Adds the specified element to this set if it is not already present.
     * More formally, adds the specified element str to this table if this
     * tables does not contain the element. If this set already contains the
     * element, the call leaves the table unchanged.
     * 
     * @param str element to be added to this table
     * @return true if this table did not already contain the specified element
     */
    public boolean add( String str )
    {
        if ( ( numItems * 1.0 / buckets.size() >= loadFactorLimit))
        {
            resize( 2 * buckets.size());
        }
        System.out.println(numItems * 1.0 / buckets.size());

        int index = Math.abs( str.hashCode() % buckets.size() );
        
        if (buckets.get(index).contains(str))
            return false;
        buckets.get(index).add(str);
        numItems++;

        return true;
    }

    /**
     * Removes all of the elements from this set. The set will be empty
     * after this call returns.
     */
    public void clear()
    {
        buckets = new ArrayList<LinkedList<String>>( buckets.size() );
        for ( int count = 1; count <= buckets.size(); count++ )
            buckets.add( new LinkedList<String>() );
        numItems = 0;
    }

    /**
     * Returns true if this set contains the specified element. More formally,
     * returns true if and only if this set contains an element e such that
     * (o==null ? e==null : o.equals(e)).
     * 
     * @param obj  element whose presence in this set is to be tested
     * 
     * @return true if this set contains the specified element
     */
    public boolean contains( Object obj )
    {
        int i = obj.hashCode() % buckets.size();
        
        return buckets.get( i ).contains( obj );
    }

    /**
     * Removes the specified element from this set if it is present.
     * More formally, removes an element e such that
     * (o==null ? e==null : o.equals(e)), if this set contains such an element.
     * Returns true if this set contained the element (or equivalently,
     * if this set changed as a result of the call). (This set will not
     * contain the element once the call returns.)
     * 
     * @param str string to be removed from this set, if present
     * @return true if the set contained the specified element
     */
    public boolean remove( Object str )
    {
        if ( str instanceof String )
        {
            int index = str.hashCode() % buckets.size();
            return buckets.get( index ).remove( str );
        }
        return false;
    }

    public boolean isEmpty()
    {
        return numItems == 0;
    }

    public int size()
    {
        return numItems;
    }

    private void resize( int newSize )
    {
        ArrayList<LinkedList<String>> newBuckets =
            new ArrayList<LinkedList<String>>( newSize );

        for ( int count = 1; count <= newSize; count++ )
        {
            newBuckets.add( new LinkedList<String>() );
        }

        for ( LinkedList<String> bucket : buckets )
        {
            for ( String str : bucket )
            {
                int index = Math.abs(str.hashCode() % newBuckets.size());
                newBuckets.get( index ).add( str );
            }
        }

        buckets = newBuckets;
    }
    
    public String toString()
    {
        return buckets.toString();
    }

    // < Other methods not shown >

}
