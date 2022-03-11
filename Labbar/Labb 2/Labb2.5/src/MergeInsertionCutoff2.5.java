import java.util.Scanner;

class MergeInsertionCutoff {

    public static int cutoff;

    public static void insertionSort(Comparable [] a, int lo , int hi)
    {
        for(int i = lo + 1 ; i < hi + 1 ; i++)
        {
            Comparable tmp = a[i];
            int j = i - 1;

            while(j >= 0 && (a[j].compareTo(tmp) > 0))
            {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = tmp;
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo + cutoff)
        {
            insertionSort(a,lo,hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void mergeSort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }


    /***************************************************************************
     *  Helper sorting function.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


    public static void main(String[] args) {

        cutoff = 5;

        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter size of array");
        int arraySize = input1.nextInt();
        Comparable [] array = new Comparable[arraySize];

        System.out.println("Enter array elements");
        for(int i = 0 ; i < arraySize ; i++)
            array[i] = input1.nextInt();

        long mergeStart = System.currentTimeMillis();
        mergeSort(array);
        long mergeStop = System.currentTimeMillis();
        long mergeElapsed = mergeStop - mergeStart;
        System.out.println("Execution time for merge sort: " + mergeElapsed + "ms");
        //System.out.println(Arrays.toString(array));

    }
}
