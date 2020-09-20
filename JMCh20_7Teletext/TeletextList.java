// Implements the list of messages for teletext

import java.awt.Graphics;

/**
 * 
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Gavin Wong
 *  @version Jan 10, 2019
 *  @author  Period: 5
 *  @author  Assignment: JMCh20_7Teletext
 *
 *  @author  Sources: TODO
 */
public class TeletextList
{
    private ListNode2<String> heading;
    private ListNode2<String> topNode;

    /**
     * Creates a circular list of headlines. First creates a circular list
     * with one node, "Today's headlines:". Saves a reference to that node in
     * heading. Adds a node holding an empty string before heading and another
     * node holding an empty string after heading. Appends all the strings
     * from headlines to the list, after the blank line that follows heading,
     * preserving their order. Sets topNode equal to heading.
     * 
     * @param headlines  Strings to add to circular list
     */
    public TeletextList(String[] headlines)
    {
        heading = new ListNode2<String>("Today's headlines", null, null);
        ListNode2<String> blankT = new ListNode2<String>("", null, heading);
        ListNode2<String> blankB = new ListNode2<String>("", heading, null);
        heading.setPrevious(blankT);
        heading.setNext(blankB);
        blankT.setPrevious(blankB);
        blankB.setNext(blankT);
        ListNode2<String> previous = blankB;
        
        for (String temp : headlines)
        {
            ListNode2<String> newNode = addAfter(previous, temp);
            System.out.println(newNode.getValue());
            previous = newNode;
            
            
        }
        topNode = heading;
    }

    /**
     * Inserts a node with msg into the headlines list after the blank /line
     * that follows heading.
     * 
     * @param msg  String to add to headlines list
     */
    public void insert(String msg)
    {
        ListNode2<String> blank = heading.getNext();
        ListNode2<String> node = new ListNode2<String>(msg,
                        blank, blank.getNext());
        blank.setNext(node);
        blank.getNext().setPrevious(node);
    }

    /**
     * Deletes the node that follows topNode from the headlines list, unless
     * that node happens to be heading or the node before or after heading that
     * holds a blank line.
     */
    public void delete()
    {
        ListNode2<String> next = topNode.getNext();
        if (!next.getValue().equals("") &&
                        !next.getValue().equals(heading.getValue()))
        {
            topNode.setNext(next.getNext());
        }
    }

    /**
     * Scrolls up the headlines list, advancing topNode to the next node.
     */
    public void scrollUp()
    {
        topNode = topNode.getNext();
    }

    /**
     * 
     * TODO adds a new node with the msg before the node
     * @param node the node that will be in front of the new node with msg
     * @param msg the msg to be added in
     * @return the new node
     */
    private ListNode2<String> addBefore( ListNode2<String> node, String msg )
    {
        ListNode2<String> newNode = new ListNode2<String>(msg, 
                        node.getPrevious(), node);
        if (node.getPrevious() != null)
        {
            node.getPrevious().setNext(newNode);
        }
        node.setPrevious(newNode);
        return newNode;
    }

    /**
     * 
     * TODO adds a new node with the msg after the node
     * @param node the node that will be before the new node with msg
     * @param msg the msg to be added in
     * @return the new node
     */
    private ListNode2<String> addAfter(ListNode2<String> node, String msg)
    {
        ListNode2<String> newNode = new ListNode2<String>(msg, 
                        node, node.getNext());
        node.getNext().setPrevious(newNode);
        node.setNext(newNode);
        return newNode; //fix this
    }

    /**
     * 
     * TODO Removes a node
     * @param node the node that will be removed
     */
    private void remove(ListNode2<String> node)
    {
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
    }

    /**
     * 
     * Draws nLines headlines in g, starting with topNode at x, y and
     * incrementing y by lineHeight after each headline.
     * @param g the graphics
     * @param x the topNode x
     * @param y the topNode y
     * @param lineHeight the height of the line
     * @param nLines the amount of lines
     */
    public void draw( Graphics g, int x, int y, int lineHeight, int nLines )
    {
        ListNode2<String> node = topNode;
        for ( int k = 1; k <= nLines; k++ )
        {
            g.drawString( node.getValue(), x, y );
            y += lineHeight;
            node = node.getNext();
        }
    }

    /**
     * Returns a string representation of this TeletextList.
     * 
     * @return a string representation of this TeletextList.
     */
    public String toString()
    {
        String str = getClass().getName() + "[";
        String separator = "";

        for ( ListNode2<String> node = heading; node.getNext() != heading;
              node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}
