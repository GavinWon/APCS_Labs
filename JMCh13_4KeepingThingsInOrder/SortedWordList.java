/**
 * Implements a sorted list of words
 * 
 * @author Gavin Wong
 * @version 11/29/2018
 * 
 * @author Period - 5
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 * 
 * @author Sources - TODO list collaborators
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    /**
     * Creates a default ArrayList containing String Elements
     */
    public SortedWordList()
    {
        super();
    }

    /**
     * Creates a default ArrayList containing String Elements with capacity
     * @param capacity the capacity of the Arraylist
     */
    public SortedWordList( int capacity )
    {
        super( capacity );
    }

    /**
     * 
     * TODO checks whether the list contains String word
     * @param word the word to be checked
     * @return true if the list contains the word, false otherwise
     */
    public boolean contains( String word )
    {
        int left = 0;
        int right = this.size() - 1;
        int middle;
        while ( left <= right )
        {
            middle = ( left + right ) / 2;
            int diff = word.compareToIgnoreCase( this.get( middle ) );
            if ( diff > 0 )
            {
                left = middle + 1;
            }
            else if ( diff < 0 )
            {
                right = middle - 1;
            }
            else
            {
                return true;
            }

        }
        return false;
    }

    /**
     * 
     * TODO finds the index of the given word
     * @param word the word that needs to be found
     * @return the integer of the word index in the list, or -1 if
     * it cannot be found
     */
    public int indexOf( String word )
    {

        int left = 0;
        int right = this.size() - 1;
        int middle;
        while ( left <= right )
        {
            middle = ( left + right ) / 2;
            int diff = word.compareToIgnoreCase( this.get( middle ) );
            if ( diff > 0 )
            {
                left = middle + 1;
            }
            else if ( diff < 0 )
            {
                right = middle - 1;
            }
            else
            {
                return middle;
            }

        }
        return -1;
    }

    /**
     * TODO sets the string at index to be word
     * @param index the index where it should be set
     * @param word the word that should be set in
     * @return the String that is being set, or throws exception if word
     * doesn't belong at index
     */
    public String set( int index, String word )
    {
        if (index == 0 && this.get(index + 1).compareToIgnoreCase(word) > 0)
        {
            return super.set( 0, word );
        }
        else if ( index == this.size() - 1 && 
                        this.get( index ).compareToIgnoreCase( word ) < 0 )
        {
            return super.set( this.size() - 1, word );
        }
        else if ( this.get( index - 1 ).compareToIgnoreCase( word ) < 0
            && this.get( index + 1 ).compareToIgnoreCase( word ) > 0 )
        {
            return super.set( index, word );
        }
        else
        {
            throw new IllegalArgumentException("word =" 
                            + word + " i =" + index);
        }
    }

    /**
     * TODO adds the word at index
     * @param index the index where the word should be added
     * @param word the word that is going to be added
     */
    public void add( int index, String word )
    {
        if ( index == 0 && this.get( index ).compareToIgnoreCase( word ) > 0 )
        {
            super.add( 0, word );
        }
        else if ( index == this.size() &&
                        this.get( index - 1 ).compareToIgnoreCase( word ) < 0 )
        {
            super.add( word );
        }
        else if ( this.get( index - 1 ).compareToIgnoreCase( word ) < 0
            && this.get( index ).compareToIgnoreCase( word ) > 0 )
        {
            super.add( index, word );
        }
        else
        {
            throw new IllegalArgumentException( "word =" +
                            word + " i =" + index );
        }
    }

    /**
     * TODO adds the word into the list at the correct index
     * @param word to be added
     * @return true if the word was succesfully added, false if the word is
     * already in the list
     */
    public boolean add( String word )
    {
        if (this.contains( word ))
        {
            return false;
        }
        if ( this.size() == 0 )
        {
            super.add( word );
            return true;
        }
        int left = 0;
        int right = this.size() - 1;
        int middle;
        while ( left <= right )
        {
            middle = ( left + right ) / 2;
            int diff = word.compareTo( this.get( middle ) );
            if ( diff > 0 )
            {
                left = middle + 1;
                if ( left > right )
                {
                    super.add( left, word );
                }
            }
            else if ( diff < 0 )
            {
                right = middle - 1;
                if ( right < left )
                {
                    super.add( right + 1, word );
                }
            }

        }
        return true;
    }

    /**
     * 
     * TODO merges two list together
     * @param addWords the other list to be merged
     */
    public void merge( SortedWordList addWords )
    {
        for ( int index = 0; index < addWords.size(); index++ )
        {
            this.add( addWords.get( index ) );
        }
    }
}
