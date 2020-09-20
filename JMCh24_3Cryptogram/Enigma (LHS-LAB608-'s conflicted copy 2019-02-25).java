import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

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

    public Enigma(int numLetters)
    {
        lookupTable = new char[numLetters];
        for (int index = 0; index < lookupTable.length; index++)
        {
            lookupTable[index] = '-';
        }
    }

    public void setSubstitution(int index, char ch)
    {
        lookupTable[index] = ch;
    }

    public String decode(String text)
    {
        StringBuffer buffer = new StringBuffer(text.length());
        for (int index = 0; index < text.length(); index++)
        {
            Character c = text.charAt(index);
            Character temp = Character.toLowerCase(c);
            int i = Character.getNumericValue(temp) - Character.getNumericValue('A');
            lookupTable[i];
        }
        

        return buffer.toString();
    }

    public String getHints(String text, String lettersByFrequency)
    {
        int [] letterCount = countLetters(text);
        String hints = "";

        for (int index = 0; index < letterCount.length; index++)
        {
            int nextMin = letterCount[index];
            hints += Integer.toString(nextMin);
        }

        return hints;
    }

    private int[] countLetters(String text)
    {
        int[] counts = new int[lookupTable.length];
        text = text.toUpperCase();

        for (int index = 0; index < text.length(); index++)
        {
            Character c = text.charAt(index);
            int i = Character.getNumericValue(c) - Character.getNumericValue('A');
            counts[i]++;
        }

        return counts;
    }

    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation

    public char[] getLookupTable()
    {
        return lookupTable;
    }

    public int[] getCountLetters(String text)
    {
        return countLetters(text);
    }

}