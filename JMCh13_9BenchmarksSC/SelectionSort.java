public class SelectionSort extends StepCount
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using Selection Sort.
    public void sort( double[] a )
    {
        addSteps(1); // initialize n
        for ( int n = a.length; n > 1; n-- )
        {
            addSteps(1); // checks n
            // Find the index iMax of the largest element
            // among a[0], ..., a[n-1]:
            addSteps(1); // initializes iMax
            int iMax = 0;
            
            addSteps(1); // initialize i
            for ( int i = 1; i < n; i++ )
            {
                addSteps(1); // checks i
                
                addSteps(1); // if comparison
                if ( a[i] > a[iMax] )
                {
                    addSteps(1); // new assignment for iMax
                    iMax = i;
                }
                addSteps(1); // increment i
            }
            addSteps(3); // swap of list[iMax] & list[n - 1]
            // Swap a[iMax] with a[n-1]:
            swap (a, iMax, n-1);

            // Decrement n (accomplished by n-- in the for loop).
            addSteps(1); // decrement n
        }
    }
}
