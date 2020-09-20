import java.util.TreeMap;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Gavin Wong
 * @version 2/7/2019
 * 
 * @author Period - 5
 * @author Assignment - MorseCode
 * 
 * @author Sources - TODO list collaborators
 */
public class MorseCode
{
    private static final char DOT = '.';

    private static final char DASH = '-';

    private static TreeMap<Character, String> codeMap;

    private static TreeNode<Character> decodeTree;


    public static void start()
    {
        codeMap = new TreeMap<Character, String>();

        // put a space in the root of the decoding tree
        decodeTree = new TreeNode<Character>( ' ', null, null ); // autoboxing

        addSymbol( 'A', ".-" );
        addSymbol( 'B', "-..." );
        addSymbol( 'C', "-.-." );
        addSymbol( 'D', "-.." );
        addSymbol( 'E', "." );
        addSymbol( 'F', "..-." );
        addSymbol( 'G', "--." );
        addSymbol( 'H', "...." );
        addSymbol( 'I', ".." );
        addSymbol( 'J', ".---" );
        addSymbol( 'K', "-.-" );
        addSymbol( 'L', ".-.." );
        addSymbol( 'M', "--" );
        addSymbol( 'N', "-." );
        addSymbol( 'O', "---" );
        addSymbol( 'P', ".--." );
        addSymbol( 'Q', "--.-" );
        addSymbol( 'R', ".-." );
        addSymbol( 'S', "..." );
        addSymbol( 'T', "-" );
        addSymbol( 'U', "..-" );
        addSymbol( 'V', "...-" );
        addSymbol( 'W', ".--" );
        addSymbol( 'X', "-..-" );
        addSymbol( 'Y', "-.--" );
        addSymbol( 'Z', "--.." );
        addSymbol( '0', "-----" );
        addSymbol( '1', ".----" );
        addSymbol( '2', "..---" );
        addSymbol( '3', "...--" );
        addSymbol( '4', "....-" );
        addSymbol( '5', "....." );
        addSymbol( '6', "-...." );
        addSymbol( '7', "--..." );
        addSymbol( '8', "---.." );
        addSymbol( '9', "----." );
        addSymbol( '.', ".-.-.-" );
        addSymbol( ',', "--..--" );
        addSymbol( '?', "..--.." );
        System.out.println( decodeTree.getLeft().getValue() );
        System.out.println( decodeTree.getRight().getValue() );
    }


    /**
     * Inserts a letter and its Morse code string into the encoding map and
     * calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol( char letter, String code )
    {
        codeMap.put( letter, code );
        treeInsert( letter, code );
    }


    /**
     * Inserts a letter and its Morse code string into the decoding tree. Each
     * dot-dash string corresponds to a path in the tree from the root to a
     * node: at a "dot" go left, at a "dash" go right. The node at the end of
     * the path holds the symbol for that code string.
     */
    private static void treeInsert( char letter, String code )
    {
        TreeNode<Character> current = decodeTree;
        TreeNode<Character> tempNode;

        for ( int index = 0; index < code.length(); index++ )
        {
            if ( code.charAt( index ) == DOT )
            {
                if ( current.getLeft() == null )
                {
                    tempNode = new TreeNode<Character>( '*', null, null );
                    current.setLeft( tempNode );
                }
                current = current.getLeft();
                System.out.println( "went left" + current.getValue() );
            }
            else
            {
                if ( current.getRight() == null )
                {
                    tempNode = new TreeNode<Character>( '*', null, null );
                    current.setRight( tempNode );
                }
                current = current.getRight();
                System.out.println( "went right" + current.getValue() );
            }
        }
        current.setValue( letter );
        System.out.println( current.getValue() );

        // TreeNode<Character> current = decodeTree;
        // TreeNode<Character> previous;
        // TreeNode<Character> tempNode = new TreeNode<Character>(' ', null,
        // null);
        // TreeNode<Character> newNode = new
        // TreeNode<Character>(letter,null,null);
        // for(int i = 0 ; i< code.length(); i++)
        // {
        // if (code.charAt(i) == '.')
        // {
        // previous = current;
        // current = current.getLeft();
        // if (current == null && i == code.length() - 1)
        // {
        // current = newNode;
        // previous.setLeft(current);
        // }
        // else if (current == null)
        // {
        // current = tempNode;
        // previous.setLeft(current);
        // }
        // else if (current != null && i == code.length() - 1)
        // {
        // current.setValue(letter);
        // previous.setLeft(current);
        // }
        // }
        // else
        // {
        // previous = current;
        // current = current.getRight();
        // if (current == null && i == code.length() - 1)
        // {
        // current = newNode;
        // previous.setRight(current);
        // }
        // else if(current == null)
        // {
        // current = tempNode;
        // previous.setRight(current);
        // }
        // else if (current != null && i == code.length() - 1)
        // {
        // current.setValue(letter);
        // previous.setRight(current);
        // }
        // }
        // }

    }


    /**
     * Converts text into a Morse code message. Adds a space after a dot-dash
     * sequence for each letter. Other spaces in the text are transferred
     * directly into the encoded message.
     *
     * @return the encoded message.
     */
    public static String encode( String text )
    {
        StringBuffer morse = new StringBuffer( 400 );

        char[] textArray = text.toUpperCase().toCharArray();

        for ( char c : textArray )
        {
            if ( codeMap.containsKey( c ) )
            {
                morse.append( codeMap.get( c ) + " " );
            }
            else
            {
                morse.append( " " );
            }
        }

        return morse.toString();
    }


    /**
     * Converts a Morse code message into a text string. Assumes that dot-dash
     * sequences for each letter are separated by one space. Additional spaces
     * are transferred directly into text.
     *
     * @return the plain text message.
     */
    public static String decode( String morse )
    {
        TreeNode<Character> current = decodeTree;
        StringBuffer text = new StringBuffer( 100 );

        for ( int index = 0; index < morse.length(); index++ )
        {
            Character c = morse.charAt( index );
            if ( c == DOT )
            {
                current = current.getLeft();
            }
            else if ( c == DASH )
            {
                current = current.getRight();
            }
            else
            {
                text.append( current.getValue() );
                current = decodeTree;
            }
        }
        text.append( current.getValue() );
        return text.toString();
    }
    // int startingI = 0;
    //
    // for ( int index = 0; index < morse.length(); index++ )
    // {
    // Character c = morse.charAt( index );
    // if ( c == ' ' )
    // {
    // String sub = morse.substring( startingI, index );
    // if ( startingI == index )
    // {
    // text.append( ' ' );
    // }
    // else
    // {
    // for ( int i = 0; i < sub.length(); i++ )
    // {
    // Character c2 = sub.charAt( i );
    // if ( c2 == DOT )
    // {
    // current = current.getLeft();
    // System.out.println( current.getValue() );
    // }
    // else
    // {
    // current = current.getRight();
    // System.out.println( current.getValue() );
    // }
    // }
    // }
    //
    // text.append( current.getValue() );
    // current = decodeTree;
    // System.out.println( current.getValue() + "+" );
    // startingI = index + 1;
    // }
    // }


    // --------------------------------------------------------------------
    // For test purposes only. Not to be used in completing the assignment

    public TreeMap<Character, String> getCodeMap()
    {
        return codeMap;
    }


    public TreeNode<Character> getDecodeTree()
    {
        return decodeTree;
    }
}
