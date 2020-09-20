/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  Gavin Wong
   @version 3/12/2019

   @author  Period - 5
   @author  Assignment - HeapSort

   @author  Sources - TODO list collaborators
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    //   using the Mergesort algorithm
    /**
     * 
     * TODO sorts the array
     * @param a the array to be sorted
     */
    public static void sort(double[] a)
    {
        int length = a.length;
        for (int i = length/2; i >= 1; i--)
        {
            reheapDown(a, i, length); //a[i-1] root
        }
            
        while (length > 1)
        {
            //swap a[0] with a[n-1]:
            double temp = a[0];
            a[0] = a[length - 1];
            a[length - 1] = temp;
            
            length--;
            reheapDown(a, 1, length);
        }
    }

    // Should be private - made public for testing
    /**
     * 
     * TODO Helper method
     * @param a the array to sort
     * @param i the root
     * @param n the length
     */
    public static void reheapDown(double[] a, int i, int n)
    {
        int root = i - 1;
        int leftC = root * 2 + 1;
        int rightC = root * 2 + 2;
        
        if (leftC >= n)
        {
            return;
        }
        
        //Keep reheaping down until you can't
        while (leftC < n && rightC < n)
        {
            
            if(a[root] > a[leftC] && a[root] > a[rightC])
            {
                return;
            }
            else if (a[leftC] > a[rightC])
            {
                double temp = a[leftC];
                a[leftC] = a[root];
                a[root] = temp;
                
                root = leftC;
            }
            else
            {
                double temp = a[rightC];
                a[rightC] = a[root];
                a[root] = temp;
                
                root = rightC;
            }
            
            leftC = root * 2 + 1;
            rightC = root * 2 + 2;
            
        }
        if (leftC < n && a[leftC] > a[root])
        {
            double temp = a[leftC];
            a[leftC] = a[root];
            a[root] = temp;
            
            root = leftC;
        }
    }
        
}
