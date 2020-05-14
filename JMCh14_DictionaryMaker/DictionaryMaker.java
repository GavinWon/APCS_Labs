import java.util.Scanner;
import java.io.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO the date

   @author Period - TODO Your Period
   @author Assignment - JM Ch14 - DictionaryMaker

   @author Sources - TODO list collaborators
 */
public class DictionaryMaker
{
    private static final int MINLENGTH = 3, MAXLENGTH = 5;
    public static Scanner fileIn;       //public for test purposes
    public static PrintWriter fileOut;  //public for test purposes

    public static void main(String[] args) throws IOException
    {
        Scanner kboard = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter input file name: ");
        String fileName = kboard.next();

        openInputFile(fileName);
        if (fileIn == null)
        {
            System.out.println("*** Can't open " + fileName + " ***");
            return;
        }

        createOutputFile("RamblecsDictionary.java");
        if (fileOut == null)
        {
            fileIn.close();
            System.out.println("*** Can't create RamblecsDictionary.java ***");
            return;
        }

        int count = copyWords();
        System.out.println("Done: " + count + " words.");

        fileIn.close();
        fileOut.close();
    }

    /**
     *  Opens a file fileName (in the current folder)
     *  and places a reference to it into fileIn
     */ 
    public static void openInputFile(String fileName)
    {
        File inputFile = new File (fileName);
        try
        {
            fileIn = new Scanner(inputFile);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + fileName + " ***");
            System.exit(1);
        }
        
    }

    /**
     *  Creates a new file fileName (in the current folder)
     *  and places a reference to it into fileOut
     */ 
    public static void createOutputFile(String fileName)
    {
        File outputFile = new File(fileName);
        try
        {
            fileOut = new PrintWriter(outputFile);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + fileName + " ***");
            System.exit(1);
        }
    }

    /**
     *  Reads all words from fileIn, selects the words that have
     *  from MINLENGTH to MAXLENGTH letters, converts them
     *  into upper case and writes the words into fileOut in
     *  Java syntax
     *  
     *  @return number of words processed
     */ 
    public static int copyWords()
    {
        int count = 0;
        fileOut.println("public class RamblecsDictionary");
        fileOut.println("{");
        fileOut.println("\tpublic String word[] = ");
        fileOut.println("\t{");
        while (fileIn.hasNextLine())
        {
            String tempWord = fileIn.nextLine();
            if (tempWord.length() >= MINLENGTH 
                            && tempWord.length() <= MAXLENGTH)
            {
                tempWord = tempWord.toUpperCase();
                fileOut.println("\t\t\"" + tempWord + "\",");
                count += 1;
            }
        }
        fileOut.println("\t};");
        fileOut.println("}");

        return count;  // fix this!!!
    }
}

