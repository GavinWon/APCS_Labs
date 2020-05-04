/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Gavin Wong
 * @version 10/11/18
 * 
 * @author Period - 5
 * @author Assignment - JMCh10 Lipogrammer
 * 
 * @author Sources - TODO list collaborators
 */
public class LipogramAnalyzer
{
    private String text;

    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private static String alphabet2 = "ABCDEFGHIJKLMNOPQRSTUVXYZ";


    /**
     * Constructor: Saves the text string
     * 
     * @param text
     *            String to analyze
     */
    public LipogramAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Returns the text string with all characters equal to letter replaced with
     * '#'.
     * 
     * @param letter
     *            character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark( char letter )
    {
        String temp = text;
        // iterating through each character in string
        for ( int index = 0; index < text.length(); index++ )
        {
            // checking whether a certain character matches with the letter
            if ( temp.charAt( index ) == letter )
            {
                temp = temp.substring( 0, index ) + 
                                "#" + temp.substring( index + 1 );
            }
        }

        return temp;
    }


    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once;
     * there are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter
     *            character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith( char letter )
    {
        String result = "";
        String firstWord = "";
        int concatAmt = 0;
        // iterating through each character in string
        for ( int index = 0; index < text.length(); index++ )
        {
            // checking whether a certain character matches with the letter
            if ( text.charAt( index ) == letter )
            {
                int wordStart = index;
                int wordEnd = index;
                while ( wordStart != 0 && 
                    ( alphabet.indexOf( text.charAt( wordStart ) ) >= 0
                    || alphabet2.indexOf( text.charAt( wordStart ) ) >= 0 ) )
                {
                    wordStart--;
                }
                while ( wordEnd < text.length()
                    && ( alphabet.indexOf( text.charAt( wordEnd ) ) >= 0
                        || alphabet2.indexOf( text.charAt( wordEnd ) ) >= 0 ) )
                {
                    wordEnd++;
                }
                if ( wordStart != 0)
                {
                    wordStart += 1;
                }
                
                String temp = text.substring(wordStart, wordEnd) + "\n";
                String temp2 = "\n" + text.substring( wordStart, wordEnd)
                    + "\n"; 
                
                if ( result.indexOf( temp2) < 0 && !firstWord.equals(temp))
                {
                    concatAmt++;
                    result = result.concat(
                        text.substring( wordStart, wordEnd ) );
                    result += "\n";
                    if (concatAmt == 1)
                    {
                        firstWord = result;
                    }
                }
            }
        }

        return result;
    }


    /**
     * 
     * TODO search the word with the character on index pos
     * @param pos the index of the character
     * @return the word that contains the character of index pos
     */
    public String extractWord( int pos )
    {
        int wordStart = pos;
        int wordEnd = pos;
        while ( wordStart != 0 && 
              ( alphabet.indexOf( text.charAt( wordStart ) ) >= 0
            || alphabet2.indexOf( text.charAt( wordStart ) ) >= 0 ) )
        {
            wordStart--;
        }
        while ( wordEnd != text.length() &&
              ( alphabet.indexOf( text.charAt( wordEnd ) ) >= 0
            || alphabet2.indexOf( text.charAt( wordEnd ) ) >= 0 ) )
        {
            wordEnd++;
        }
        if ( wordStart != 0 )
        {
            wordStart += 1;
        }
        return text.substring( wordStart, wordEnd );
    }
}
