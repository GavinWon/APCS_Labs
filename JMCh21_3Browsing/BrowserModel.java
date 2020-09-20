//import java.util.List;
import java.util.Stack;


/**
 * 
 * TODO It models a browser
 *
 * @author Gavin Wong
 * @version Jan 20, 2019
 * @author Period: 5
 * @author Assignment: JMCh21_3Browsing
 *
 * @author Sources: TODO
 */

public class BrowserModel
{
    private BrowserView view;

    private Stack<Integer> backStk;
    private Stack<Integer> forwardStk;

    private int topLine;


    /**
     * Initialize all fields.
     * 
     * @param view
     *            the view from BrowserView
     */
    public BrowserModel( BrowserView view )
    {
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();

        this.view = view;
        this.view.update( topLine );

    }


    /**
     * 
     * TODO Goes back to previous line
     */
    public void back()
    {
        forwardStk.push( topLine );

        if ( hasBack() )
        {
            topLine = backStk.pop();

        }
        view.update( topLine );
    }


    /**
     * 
     * TODO Goes to the forward line
     */
    public void forward()
    {
        backStk.push( topLine );

        if ( hasForward() )
        {

            topLine = forwardStk.pop();

        }
        view.update( topLine );
    }


    /**
     * 
     * TODO returns back to home line
     */
    public void home()
    {
        backStk.push( topLine );

        topLine = 0;
        view.update( topLine );

        forwardStk.removeAllElements();
    }


    /**
     * 
     * TODO Goes the the nth line
     * 
     * @param n
     *            the line that the program will go to
     */

    public void followLink( int n )
    {
        backStk.push( topLine );
        topLine = n;

        view.update( topLine );
        forwardStk.removeAllElements();
    }


    /**
     * 
     * TODO Checks whether you can go back
     * 
     * @return Can go back - true, can't go back - false
     */
    public boolean hasBack()
    {
        return !backStk.isEmpty();
    }


    /**
     * 
     * TODO Checks whether you can go forward
     * 
     * @return can go forward - true, can't go forward - false
     */
    public boolean hasForward()
    {
        return !forwardStk.isEmpty();
    }


    /**
     * 
     * TODO for Testing
     * @return backStk
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }

    /**
     * 
     * TODO for Testing
     * @return forwardStk
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }

    /**
     * 
     * TODO for Testing
     * @return topLine
     */
    public int getTopLine()
    {
        return topLine;
    }
}
