import java.util.Iterator;

/**
    Implements a singly-linked list.
    
    @author  Gavin Wong
    @version 12/14/2018
    
    @author  Period - TODO Your Period
    @author  Assignment - TODO Assignment Name
    
    @author  Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;
    private int nodeCount;

    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }

    /**
        Constructor: creates a list that contains all elements from the
        array values, in the same order
        @param values  array containing all elements for this list
     */
    public SinglyLinkedList(E[] values)
    {
        ListNode<E> tail = null;
        for (E value : values) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>(value, null);
            if (head == null)
                head = node;
            else
                tail.setNext(node);
            tail = node;    // update tail
        }

        nodeCount = values.length;
    }

    /**
        Return true if this list is empty; otherwise returns false.
        @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        if (nodeCount == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

    /**
        Returns the number of elements in this list.
        @return  number of elements in this list.
     */
    public int size()
    {
        return nodeCount;
    }

    /**
        Returns true if this list contains an Object equal to obj; otherwise returns false.
        @return true if this list contains an Object equal to obj
     */
    public boolean contains(Object obj)
    {
        for (ListNode<E> node = head; node != null; node = node.getNext())
        {
            if (obj.equals(node.getValue()))
            {
                return true;
            }
        }
        return false;  // fix this
    }

    /**
        Returns the index of the first Object equal to obj; if not found,
        returns -1.

        @param obj  Object to find
        @return  the index of the first Object in equal to obj; if not found,
                  returns -1.
     */
    public int indexOf(Object obj)
    {
        int count = 0;
        for (ListNode<E> node = head; node != null; node = node.getNext())
        {
            if (obj.equals(node.getValue()))
            {
                return count;
            }
            count++;
        }

        return -1;
    }

    /**
        Adds obj to this collection.  Returns true if successful;
        otherwise returns false.
        
        @param obj  element to add to this collection
        @return  true if successful; otherwise returns false.
     */
    public boolean add(E obj)
    {
        ListNode<E> node = new ListNode<E>(obj, null);
        if (head == null)
        {
            head = node;
            nodeCount++;
            return true;
        }
        else
        {
            for (ListNode<E> node1 = head; node1 != null; node1 = node1.getNext())
            {
                if (node1.getNext() == null)
                {
                    node1.setNext(node);
                    nodeCount++;
                    return true;
                }
            }
        }
        return false;
    }

    /**
        Removes the first element that is equal to obj, if any.
        Returns true if successful; otherwise returns false.

        @param obj  element to remove
        @return  true if successful; otherwise returns false.
     */
    public boolean remove(E obj)
    {
        for (ListNode<E> node = head; node != null; node = node.getNext())
        {
            if(node.getNext().getValue().equals(obj))
            {
                node.setNext(node.getNext().getNext());
                nodeCount--;
                return true;
            }
        }
        return false;  // fix this
    }

    /**
        Returns the i-th element.

        @param i  element to get from the list
        @return element at index i
        @throws IndexOutOfBoundsException 
     */
    public E get(int i)
    {
        int count = 0;
        for (ListNode<E> node = head; node != null; node = node.getNext())
        {
            if (i == count)
            {
                return (E)node.getValue();
            }
            else
            {
                count++;
            }
        }
        throw new IndexOutOfBoundsException();
    }
        
  

    /**
        Replaces the i-th element with obj and returns the old value.
        
        @param i index of element to replace
        @param obj replacement element of element at index i
        @return old value previously located at index i
        @throws IndexOutOfBoundsException 
     */
    public E set(int i, E obj)
    {
        if (i >= nodeCount || i < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else 
        {
            int x = 0;
            for(ListNode<E> node = head; node != null; node = node.getNext())
            {
                if (i == x)
                {
                    return node.getValue();
                }
                else 
                {
                    x++;
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /**
        Inserts obj to become the i-th element. Increments the size
        of the list by one.
        
        @param i  insertion point in list for obj
        @param obj element to insert into list
        @throws IndexOutOfBoundsException 
     */
    public void add(int i, E obj)
    {
        if (i == 0 && nodeCount == 0)
        {
            head = new ListNode<E>(obj,null);
            nodeCount += 1;
        }
        else if (i == 0 && nodeCount >= 1)
        {
            ListNode<E> temp = head;
            head = new ListNode<E>(obj,temp);
            nodeCount += 1;
        }
        else if (i > nodeCount || i < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            int x = 0;
            for(ListNode<E> node = head; node != null; node = node.getNext())
            {
                if (x == i - 1)
                {
                    ListNode<E> temp = new ListNode<E>(obj,node.getNext());
                    node.setNext(temp);
                    nodeCount++;
                    return;
                }
                else
                {
                    x++;
                }
            }
        }
        
    }

    /**
        Removes the i-th element and returns its value.
        Decrements the size of the list by one.

        @param i index of element to remove
        @return element removed from this list
     */
    public E remove(int i)
    {   
        int x = 0;
        E value = null;
        if (nodeCount <= 0 || i < 0 || i >= this.size())
        {
            throw new IndexOutOfBoundsException();
        }
        else if (i == 0 && nodeCount == 1)
        {
            value = head.getValue();
            head = null;
            nodeCount = 0;
            return value;
        }
        else if (i == 0 && nodeCount >= 2)
        {
            value = head.getValue();
            head = head.getNext();
            nodeCount--;
            return value;
        }
        
        for (ListNode<E> node = head; node != null; node = node.getNext())
        {
            if (x == i - 1)
            {
                value = node.getNext().getValue();
                node.setNext(node.getNext().getNext());
                nodeCount--;
                return value;
            }
            else
            {
                x++;
            }
            
        }
        return value;  // fix this
    }

    /**
        Returns a string representation of this list.
        @return  a string representation of this list.
     */
    public String toString()
    {
        String str = "[";
        String sep = "";
        Iterator<E> iter = this.iterator();
        while (iter.hasNext())
        {
            str = str.concat(sep + iter.next());
            sep = ", ";
        }
        return (str +"]");
    }

    /**
        Returns an iterator for this collection.
        @return  an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>(head);
    }
}

