import java.util.ArrayList;


/**
 * 
 * TODO Makes an Arraylist that holds IndexEntry
 *
 * @author Gavin Wong
 * @version Nov 9, 2018
 * @author Period: 5
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: TODO
 */

public class DocumentIndex extends ArrayList<IndexEntry>
{
    /**
     * Creates an empty DocumentIndex with the default initial capacity.
     */
    public DocumentIndex()
    {
        super();
    }


    /**
     * Created an empty DocumentIndex with a given initial capcity
     * 
     * @param initialCapacity the capacity of the DocumentIndex
     */
    public DocumentIndex( int initialCapacity )
    {
        super( initialCapacity );
    }


    /**
     * 
     * TODO If word is not yet in this DocumentIndex, creates a new IndexEntry
     * for a word, and inserts it into this list in alphabetical order; adds num
     * to this world's IndexEntry by calling its add(num) method.
     * 
     * @param word the word to check or add
     * @param num the line of the word
     */
    public void addWord( String word, int num )
    {
        word = word.toUpperCase();
        if ( this.size() == 0 )
        {
            IndexEntry newEntry = new IndexEntry( word );
            newEntry.add( num );
            this.add( 0, newEntry );
        }
        else
        {
            for ( int index = 0; index < this.size(); index++ )
            {
                IndexEntry temp = this.get( index );
                if ( temp.getWord().equals( word ) )
                {
                    temp.add( num );
                    return;
                }
            }
            IndexEntry newEntry = new IndexEntry( word );
            newEntry.add( num );
            this.add( foundOrInserted( word ), newEntry );
        }

    }


    // For each word in str, calls addWord(word, num).
    /**
     * 
     * TODO Find each word str, calls addWord(word, num).
     * 
     * @param str a string with all the words of a line
     * @param num the line in which the string is on
     */
    public void addAllWords( String str, int num )
    {
        String[] arrStrings = str.split( "\\W+" );
        for ( String temp : arrStrings )
        {
            if ( temp.length() >= 1 )
            {
                this.addWord( temp, num );
            }
        }

    }


    /**
     * 
     * TODO Tries to find an IndexEntry with a given word in this DocumentIndex.
     * If not found, inserts a new IndexEntry for a word at the appropriate
     * place (in lexicographical order). Returns the index of the found or
     * inserted IndexEntry
     * 
     * @param word The word to add
     * @return the index in which this word should be on
     */
    private int foundOrInserted( String word )
    {
        word = word.toUpperCase();
        for ( int index = 0; index < this.size(); index++ )
        {
            IndexEntry temp = this.get( index );
            if ( index == this.size() - 1 
                            && word.compareTo( temp.getWord() ) > 0 )
            {
                return this.size();
            }
            else if ( word.compareTo( temp.getWord() ) > 0
                && word.compareTo( this.get( index + 1 ).getWord() ) < 0 )
            {
                return index + 1;
            }
        }
        return 0;
    }
}
