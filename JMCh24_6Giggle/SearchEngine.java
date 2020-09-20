import java.util.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Gavin Wong
 * @version TODO 2/26/2019
 * 
 * @author Period - 5
 * @author Assignment - JM24.6 - Search Engine
 * 
 * @author Sources - TODO list collaborators
 */
public class SearchEngine
{
    // Instance variable(s)
    private String myURL; // holds the name for the "url" (file name)

    private Map<String, List<String>> myIndex; // holds the word index


    /**
     * Constructor makes a search engine
     * 
     * @param url the url
     */
    public SearchEngine( String url )
    {
        myURL = url;
        myIndex = new HashMap<String, List<String>>( 20000 );
    }


    /**
     * 
     * TODO gets the url
     * @return url
     */
    public String getURL()
    {
        return myURL;
    }

    /**
     * 
     * TODO adds the line to myIndex
     * @param line the line to add
     */
    public void add( String line )
    {
        Set<String> allWords = parseWords( line );
        for ( String temp : allWords )
        {
            List<String> wordList = myIndex.get( temp );
            if ( wordList == null )
            {
                LinkedList<String> newList = new LinkedList<String>();
                newList.add( line );
                myIndex.put( temp, newList );
            }
            else
            {
                wordList.add( line );
            }

        }
    }

    /**
     * 
     * TODO returns the hits
     * @param word the key
     * @return the value associated with the word
     */
    public List<String> getHits( String word )
    {
        if ( myIndex.containsKey( word ) )
        {
            return myIndex.get( word );
        }
        else
        {
            return null;
        }
    }

    /**
     * 
     * TODO Split the line into words
     * @param line the line to be split
     * @return the set of words
     */
    private Set<String> parseWords( String line )
    {
        Set<String> output = new TreeSet<String>();
        String[] temp = line.split( "\\W+" );
        for ( String value : temp )
        {
            value = value.toLowerCase();
            output.add( value );
        }
        return output;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    /**
     * 
     * TODO returns getIndex
     * @return getIndex
     */
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
