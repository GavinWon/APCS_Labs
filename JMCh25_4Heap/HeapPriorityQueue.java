import java.util.*;

/**
   Implements a priority queue based on a min-heap.

   @author  Gavin Wong
   @version 3/8/2019

   @author Period - 5   
   @author Assignment - TODO Assignment Name

   @author Sources - TODO list collaborators
 */
public class HeapPriorityQueue
{
    private static final int DFLT_CAPACITY = 101;
    private Object[] items;
    private int numItems;
    private final Comparator<Object> comparator;

    public HeapPriorityQueue()
    {
        this(DFLT_CAPACITY, null);
    }

    public HeapPriorityQueue(Comparator<Object> c)
    {
        this(DFLT_CAPACITY, c);
    }

    public HeapPriorityQueue(int initialCapacity)
    {
        this(initialCapacity, null);
    }

    public HeapPriorityQueue(int initialCapacity, Comparator<Object> c)
    {
        items = new Object[initialCapacity + 1];
        comparator = c;
    }

    /**
     *  Returns true if this priority queue is empty;
     *  otherwise returns false.
     */
    public boolean isEmpty()
    {
        return numItems == 0;
    }

    /**
     *  Returns the highest priority element without removing
     *  it from this priority queue.
     */
    public Object peek()
    {
        if (numItems == 0)
        {
            throw new NoSuchElementException();
        }
        return items[1];
    }

    /**
     *  Adds obj to this priority queue; returns true.
     */
    public boolean add(Object obj)
    {
        numItems++;
        if (numItems >= items.length)  // items[0] is not used
            growCapacity();
        items[numItems] = obj;
        reheapUp();
        return true;
    }

    /**
     *  Removes and returns the highest priority item.
     */
    public Object remove()
    {
        if (numItems == 0)
        {
            throw new NoSuchElementException();
        }

        Object minObject = items[1];
        items[1] = items[numItems];
        numItems--;
        reheapDown();
        return minObject;
    }

    //**************************************************************************

    private boolean lessThan(Object obj1, Object obj2)
    {
        if (comparator != null)
            return comparator.compare(obj1, obj2) < 0;
        else
            return ((Comparable)obj1).compareTo(obj2) < 0;
    }

    public void reheapDown()
    {
        if (numItems <= 1)
        {
            return;
        }
        Object item = items[1];
        int itemPosition = 1;
        while (itemPosition * 2 <= numItems && itemPosition * 2 + 1 <= numItems) // Fix this, this might be wrong
        {        
            Object child = items[itemPosition * 2];
            Object child2 = items[itemPosition * 2 + 1];
            item = items[itemPosition];
            if (lessThan(child, child2))
            {
                items[itemPosition] = child;
                items[itemPosition * 2] = item;
                
                itemPosition = itemPosition * 2;
            }
            else
            {
                items[itemPosition] = child2;
                items[itemPosition * 2 + 1] = item;
                
                itemPosition = itemPosition * 2 + 1;
            }
            
            
        }
        if (itemPosition * 2 <= numItems && lessThan(items[itemPosition * 2], items[itemPosition]))
        {
            Object temp = items[itemPosition];
            items[itemPosition] = items[itemPosition * 2];
            items[itemPosition * 2] = temp;
            itemPosition *= 2;
        }
    }

    public void reheapUp()
    {
        if (numItems == 1)
            return;
        Object item;
        int itemPosition = numItems;
        while (itemPosition != 1)
        {
            Object parent = items[itemPosition / 2];
            item = items[itemPosition];
            if (lessThan(item, parent))
            {
                items[itemPosition / 2] = item;
                items[itemPosition] = parent;
                itemPosition /= 2;
            }
            else
            {
                return;
            }
            
        }
    }

    private void growCapacity()
    {
        Object[] tempItems = new Object[2 * items.length - 1];
        System.arraycopy(items, 0, tempItems, 0, items.length);
        items = tempItems;
    }

    /**
    returns the String containing all the elements in level order
    @return the String containing all the elements in level order
     */
    public String toString()
    {
        String output = "";
        for (int index = 1; index <= numItems; index++)
        {
            output += items[index];
            output += "\n";
        }
        return output; // Fix This!!!
    }
}

