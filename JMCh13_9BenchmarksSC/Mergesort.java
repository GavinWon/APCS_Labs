public class Mergesort extends StepCount
{
    private double[] temp;

    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Mergesort algorithm.
    public void sort( double[] a )
    {
        addSteps(1); // initialize n
        int n = a.length;
        
        addSteps(2); // initialize temp and function call
        temp = new double[n];
        
        recursiveSort( a, 0, n - 1 );
    }

    // Recursive helper method: sorts a[from], ..., a[to]
    private void recursiveSort( double[] a, int from, int to )
    {
        addSteps(2); // find values of expression and if comparison
        if ( to - from < 2 ) // Base case: 1 or 2 elements
        {
            addSteps(2); // two comparisons
            if ( to > from && a[to] < a[from] )
            {
                addSteps(3); //initialization and assigments 
                double aTemp = a[to]; // swap a[to] and a[from]
                a[to] = a[from];
                a[from] = aTemp;
            }
        }
        else // Recursive case
        {
            addSteps(4); // initialize middle and funciton call
            int middle = ( from + to ) / 2;
            recursiveSort( a, from, middle );
            recursiveSort( a, middle + 1, to );
            merge( a, from, middle, to );
        }
    }

    // Merges a[from] ... a[middle] and a[middle+1] ... a[to]
    // into one sorted array a[from] ... a[to]
    private void merge( double[] a, int from, int middle, int to )
    {
        addSteps(3); // initialize 3 variables
        int i = from, j = middle + 1, k = from;

        // While both arrays have elements left unprocessed:
        addSteps(2); // 2 comparisons to check whether or not to enter loop
        while ( i <= middle && j <= to )
        {
            addSteps(1); //if comparison
            if ( a[i] < a[j] )
            {
                addSteps(2); //new assignments
                temp[k] = a[i]; // Or simply temp[k] = a[i++];
                i++;
            }
            else
            {
                addSteps(2); // new Assignments
                temp[k] = a[j];
                j++;
            }
            addSteps(1); //increment k
            k++;
            
            addSteps(2); // checks whether it can re-enter loop
        }

        // Copy the tail of the first half, if any, into temp:
        addSteps(1); // checks whether it can enter loop
        while ( i <= middle )
        {
            addSteps(3); // variable assignments
            temp[k] = a[i]; // Or simply temp[k++] = a[i++]
            i++;
            k++;
            addSteps(1); // checks whether it re-enters loop
        }

        // Copy the tail of the second half, if any, into temp:
        addSteps(1); // checks whether it can enter loop
        while ( j <= to )
        {
            addSteps(3); //new assignments
            temp[k] = a[j]; // Or simply temp[k++] = a[j++]
            j++;
            k++;
            addSteps(1); // checks whether it can re-enter loop
        }

        // Copy temp back into a
        addSteps(1); // initialize k
        for ( k = from; k <= to; k++ )
        {
            addSteps(2); // checks condition and new assignment
            a[k] = temp[k];
            addSteps(1); // increments k
        }
    }
}
