import java.util.*;

public class TestList
{
    /**
       Test the LinkedListWithTail class
       @param args  command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        String[] str = {"apple", "banana", "newt", "aardvark"};

        LinkedListWithTail<String> sList = new LinkedListWithTail<String>();
        LinkedListWithTail<String> otherList = new LinkedListWithTail<String>();
        LinkedListWithTail<String> otherList2 = new LinkedListWithTail<String>();
        LinkedListWithTail<String> otherList3 = new LinkedListWithTail<String>();
        

        sList.add("apple");
        
        sList.add("banana");
        sList.add("newt");
        sList.add("aardvark");
        
        otherList.add( sList.remove() );
        otherList.add( sList.remove() );
        //both are empty
        otherList3.append(otherList2);
        otherList2.append(sList);
        sList.append(otherList3);
        //
        
//        while (!sList.isEmpty())
//        {
//            System.out.print(sList.remove() + " ");
//        }
//        System.out.println();
    }
}

/*
apple
banana
newt
newt aardvark apple banana 
 */