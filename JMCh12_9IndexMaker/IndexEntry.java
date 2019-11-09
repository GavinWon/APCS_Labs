import java.util.ArrayList;


/**
 * 
 * TODO Contains a word and a ArrayList of integers for each line the word
 * appears
 *
 * @author Gavin Wong
 * @version Nov 9, 2018
 * @author Period: 5
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: TODO
 */
public class IndexEntry
{
    private String word;

    private ArrayList<Integer> numList;


    /**
     * Constructs an IndexEntry for a given word (converted to uppercase); sets
     * numsList to an empty ArrayList
     * 
     * @param word the word for the IndexEntry
     */
    public IndexEntry( String word )
    {
        numList = new ArrayList<Integer>();
        this.word = word.toUpperCase();
    }


    /**
     * 
     * TODO Returns the word of this IndexEntry object.
     * 
     * @return the word of this IndexEntry object.
     */
    public String getWord()
    {
        return word;
    }


    /**
     * 
     * TODO If num is not already in the list, adds num at the end of this
     * IndexEntry's list of numbers
     * 
     * @param num the line in which the word is on
     */
    public void add( int num )
    {
        if ( !numList.contains( num ) )
        {
            numList.add( num );
        }
    }


    /**
     * TODO Returns the string format of the IndexEntry
     * @return the string format
     */
    public String toString()
    {
        String output = word + " ";
        for ( int index = 0; index < numList.size(); index++ )
        {
            if ( index == 0 )
            {
                output += numList.get( index );
            }
            else
            {
                output += ", " + numList.get( index );
            }
        }
        return output;
    }
}
