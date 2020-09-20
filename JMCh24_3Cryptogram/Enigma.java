

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  Gavin Wong
   @version 2/15/2019

   @author Period - 5
   @author Assignment - JM 24.3 Lab: Cryptogram Solver

   @author Sources - TODO list collaborators
 */
public class Enigma
{
    private char[] lookupTable;

    /**
     * Initializes looking table
     * @param numLetters the length of looking table
     */
    public Enigma(int numLetters)
    {
        lookupTable = new char[numLetters];
    }
    
    /**
     * 
     * TODO changes certain index of lookingTable
     * @param index the index that needs to be changed
     * @param ch the value to change into
     */
    public void setSubstitution(int index, char ch)
    {
        lookupTable[index] = Character.toUpperCase(ch);
    }
    
    /**
     * 
     * TODO Decodes the message
     * @param text the text that needs to be decoded
     * @return the decoded text
     */
    public String decode(String text)
    {
        StringBuffer buffer = new StringBuffer(text.length());
        for (int index = 0; index < text.length(); index++)
        {
            char c = text.charAt(index);
            if (Character.isLetter(c))
            {
                if (Character.isUpperCase(c))
                {
                    buffer.append(lookupTable[c - 'A']);
                }
                else
                {
                    c = Character.toUpperCase(c);
                    buffer.append(Character.toLowerCase(lookupTable[c - 'A']));
                }
            }
            else
            {
                buffer.append(c);
            }
        }
        

        return buffer.toString();
    }
    
    
    /**
     * 
     * TODO send computer hints
     * @param text the text that needs to be analyzed 
     * @param lettersByFrequency a string with the most used letter on the right
     * and the least used on the left
     * @return the hint
     */
    public String getHints(String text, String lettersByFrequency)
    {
        String hints = "";
        
        int[] letters = countLetters( text );
        int number;
 
        for ( int k = 0; k < letters.length; k++ )
        {
            number = 0;
            for ( int i = 0; i < letters.length; i++ )
            {
                if ( letters[i] < letters[k] || 
                                letters[i] == letters[k] && i < k )
                {
                    number++;
                }
            }
            hints += lettersByFrequency.charAt(number);
        }
        
        return hints;

    }

    /**
     * 
     * TODO count the letters in the text
     * @param text the text that needs to be analyzed
     * @return a integer array with the number of each letter
     */
    private int[] countLetters(String text)
    {
        int[] counts = new int[lookupTable.length];
        text = text.toUpperCase();

        for (int index = 0; index < text.length(); index++)
        {
            char c = text.charAt(index);
            c = Character.toUpperCase(c);
            if (Character.isLetter(c))
            {
                counts[c - 'A']++;
            }
            
        }

        return counts;
    }

    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation
    /**
     * 
     * TODO returns lookupTable
     * @return lookupTable
     */
    public char[] getLookupTable()
    {
        return lookupTable;
    }

    /**
     * 
     * TODO return countLetters
     * @param text the text that will be inputed into countLetters
     * @return the int array of countLetters
     */
    public int[] getCountLetters(String text)
    {
        return countLetters(text);
    }

}