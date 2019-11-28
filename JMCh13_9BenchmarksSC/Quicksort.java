public class Quicksort extends StepCount
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Quicksort algorithm.
    public void sort( double[] a )
    {
        addSteps(1); //function call
        recursiveSort( a, 0, a.length - 1 );
    }

    // Recursive helper method: sorts a[from], ..., a[to]
    private void recursiveSort( double[] a, int from, int to )
    {
        addSteps(1); // checks condition;
        if ( from >= to )
        {
            addSteps(1); //return back
            return;
        }
            
        // Choose pivot a[p]:
        addSteps(1); // variable initialization;
        int p = ( from + to ) / 2;
        // The choice of the pivot location may vary:
        // you can also use p = from or p = to or use
        // a fancier method, say, the median of the above three.

        // Partition:
        
        addSteps(3); // variables initialization and checks whether to enter
        int i = from;
        int j = to;
        while ( i <= j )
        {
            addSteps(1); // checks condition
            if ( a[i] <= a[p] )
            {
                addSteps(1); // increments i
                i++;
            }
            else if ( a[j] >= a[p] )
            {
                addSteps(2); // checks condition and decrements j
                j--;
            }
            else
            {
                addSteps(5); // swap and increments/decrements variables
                swap( a, i, j );
                i++;
                j--;
            }
        }

        // Finish partitioning:
        addSteps(1); //checks condition
        if ( p < j ) // place the pivot in its correct position
        {
            addSteps(4); // swap and new assignment
            swap( a, j, p );
            p = j;
        }
        else if ( p > i )
        {
            addSteps(5); // checks condition, swap, and new assignment
            swap( a, i, p );
            p = i;
        }

        // Sort recursively:
        addSteps(2); // two method calls
        recursiveSort( a, from, p - 1 );
        recursiveSort( a, p + 1, to );
    }
}
