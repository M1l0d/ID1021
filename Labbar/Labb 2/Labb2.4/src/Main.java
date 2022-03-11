import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void insertionSort(Comparable [] a)
    {
        for(int i = 1 ; i < a.length ; i++)
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
        if (hi <= lo) return;
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


    /***************************************************************************
     *  Index mergesort.
     ***************************************************************************/
    // stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]

    /**
     * Returns a permutation that gives the elements in the array in ascending order.
     * @param a the array
     * @return a permutation {@code p[]} such that {@code a[p[0]]}, {@code a[p[1]]},
     *    ..., {@code a[p[N-1]]} are in ascending order
     */


    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void swap(Comparable [] a, int i , int j) // Metod för att byta plats på två element
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static int partition(Comparable [] a, int lo, int hi)
    {
        Comparable pivot = a[hi];

        int i = lo - 1;

        for(int j = lo ; j <= hi - 1 ; j++)
        {
            if(a[j].compareTo(pivot) < 0)
            {
                i++;
                swap(a, i , j);
            }
        }
        swap(a, i +1, hi);
        return i + 1;
    }

    public static void quickSort(Comparable [] a, int lo, int hi)
    {
        if(lo < hi)
        {
            int k = partition(a,lo,hi);

            quickSort(a,lo,k - 1);
            quickSort(a,k + 1,hi);
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) throws FileNotFoundException {


        // Array with 10 elements
        File test10 = new File("C:\\Users\\Milad\\Documents\\KTH\\Algoritmer & Datastrukturer\\Labbar\\TXTFILES FOR LABB2\\10test.txt");
        Scanner scan10 = new Scanner(test10);

        int arraySize10 = scan10.nextInt();
        int [] array10 = new int[arraySize10];
        for(int i = 0 ;i < arraySize10 ; i++)
            array10[i] = scan10.nextInt();


        // Array with 100 elements
        File test100 = new File("C:\\Users\\Milad\\Documents\\KTH\\Algoritmer & Datastrukturer\\Labbar\\TXTFILES FOR LABB2\\100test.txt");
        Scanner scan100 = new Scanner(test100);

        int arraySize100 = scan100.nextInt();
        Comparable [] array100 = new Comparable[arraySize100];
        for(int i = 0 ;i < arraySize100 ; i++)
            array100[i] = scan100.nextInt();


        // Array with 1 thousand elements
        File test1k = new File("C:\\Users\\Milad\\Documents\\KTH\\Algoritmer & Datastrukturer\\Labbar\\TXTFILES FOR LABB2\\1000test.txt");
        Scanner scan1k = new Scanner(test1k);

        int arraySize1k = scan1k.nextInt();
        Comparable [] array1k = new Comparable[arraySize1k];
        for(int i = 0 ;i < arraySize1k ; i++)
            array1k[i] = scan1k.nextInt();


//        // Array with 10 thousand elements
//        File test10k = new File("C:\\Users\\Milad\\Documents\\KTH\\Algoritmer & Datastrukturer\\Labbar\\TXTFILES FOR LABB2\\test10lax.txt");
//        Scanner scan10k = new Scanner(test10k);
//
//        int arraySize10k = scan10k.nextInt();
//        Comparable [] array10k = new Comparable[arraySize10k];
//        for(int i = 0 ;i < arraySize10k ; i++)
//            array10k[i] = scan10k.nextInt();
//
//
//        // Array with 100 thousand elements
//        File test100k = new File("C:\\Users\\Milad\\Documents\\KTH\\Algoritmer & Datastrukturer\\Labbar\\TXTFILES FOR LABB2\\test100lax.txt");
//        Scanner scan100k = new Scanner(test100k);
//
//        int arraySize100k = scan100k.nextInt();
//        Comparable [] array100k = new Comparable[arraySize100k];
//        for(int i = 0 ;i < arraySize100k ; i++)
//            array100k[i] = scan100k.nextInt();
//
//
//        // Array with 500 thousand elements
//        File test500k = new File("C:\\Users\\Milad\\Documents\\KTH\\Algoritmer & Datastrukturer\\Labbar\\TXTFILES FOR LABB2\\test500lax.txt");
//        Scanner scan500k = new Scanner(test500k);
//
//        int arraySize500k = scan500k.nextInt();
//        Comparable [] array500k = new Comparable[arraySize500k];
//        for(int i = 0 ;i < arraySize500k ; i++)
//            array500k[i] = scan500k.nextInt();
//
//
//        // Array with 750 thousand elements
//        File test750k = new File("C:\\Users\\Milad\\Documents\\KTH\\Algoritmer & Datastrukturer\\Labbar\\TXTFILES FOR LABB2\\test750lax.txt");
//        Scanner scan750k = new Scanner(test750k);
//
//        int arraySize750k = scan750k.nextInt();
//        Comparable [] array750k = new Comparable[arraySize750k];
//        for(int i = 0 ;i < arraySize750k ; i++)
//            array750k[i] = scan750k.nextInt();
//
//
//        // Array with 1 million elements
//        File test1M = new File("C:\\Users\\Milad\\Documents\\KTH\\Algoritmer & Datastrukturer\\Labbar\\TXTFILES FOR LABB2\\testmill.txt");
//        Scanner scan1M = new Scanner(test1M);
//
//        int arraySize1M = scan1M.nextInt();
//        Comparable [] array1M = new Comparable[arraySize1M];
//        for(int i = 0 ;i < arraySize1M ; i++)
//            array1M[i] = scan1M.nextInt();




        // INSERTION SORT
        long insertionStart = System.currentTimeMillis();
        insertionSort(array1k);
        long insertionStop = System.currentTimeMillis();
        long insertionElapsed = insertionStop - insertionStart;
        System.out.println("Execution time for insertion sort: " + insertionElapsed + "ms");
        //System.out.println(Arrays.toString(array1k));



        // MERGE SORT
        long mergeStart = System.currentTimeMillis();
        mergeSort(array1k);
        long mergeStop = System.currentTimeMillis();
        long mergeElapsed = mergeStop - mergeStart;
        System.out.println("Execution time for merge sort: " + mergeElapsed + "ms");
        //System.out.println(Arrays.toString(array1k));



//        // QUICKSORT
//        long quickStart = System.currentTimeMillis();
//        quickSort(array500k,0, array500k.length - 1);
//        long quickStop = System.currentTimeMillis();
//        long quickElapsed = quickStop - quickStart;
//        System.out.println("Execution time for quicksort: " + quickElapsed + "ms");
//        //System.out.println(Arrays.toString(array1k));
    }
}
