/**
 *  This is a class that tests the Book class.
 *
 *  @author  TODO Gavin Wong
 *  @version TODO 8/29/2018	
 *  @author  Period: 5
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: TODO list collaborators
 */
public class BookTest
{
    /**
     * The main method in this class checks the Book operations for
     * consistency.
     * @param args is not used.
     */
    public static void main( String[] args )
    {
        /* TODO *** TO BE IMPLEMENTED *** */
    	Book childbook = new Book (3);
    	System.out.println(childbook.getNumPages());
		System.out.println(childbook.getCurrentPage());

    	for (int index = 0; index < 3 ; index++) {
    		childbook.nextPage();
    		System.out.println(childbook.getCurrentPage());
    	}
    	
    }
}
