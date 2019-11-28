public class InsertionSort extends StepCount
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using Insertion Sort.
    public void sort( double[] a )
    {
        addSteps(1); // initialize n
        for ( int n = 1; n < a.length; n++ )
        {
            addSteps(1); // checks condition of n
            
            // Save the next element to be inserted:
            addSteps(1); // initialize atemp;
            double aTemp = a[n];

            // Going backward from a[n-1], shift elements to the
            // right until you find an element a[i] <= aTemp:
            addSteps(1); // initialize i
            int i = n;
            
            addSteps(2); // comparing expression to enter while loop
            while ( i > 0 && aTemp < a[i - 1] )
            {
                
                addSteps(2); //undergo changing the variables
                a[i] = a[i - 1];
                i--;
                addSteps(2); // checks whether you go into while loop again
            }

            // Insert the saved element after a[i]:
            addSteps(1); // change a[i]
            a[i] = aTemp;
            
            addSteps(1); // increments n
        }
    }
}

