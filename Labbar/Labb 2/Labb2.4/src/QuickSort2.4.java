import java.util.Arrays;
import java.util.Scanner;

class QuickSort {

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
        swap(a, i + 1, hi);
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

    public static void main(String[] args) {

        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter size of array");
        int arraySize = input1.nextInt();
        Comparable [] array = new Comparable[arraySize];

        System.out.println("Enter array elements");
        for(int i = 0 ; i < arraySize ; i++)
            array[i] = input1.nextInt();

        long quickStart = System.currentTimeMillis();
        quickSort(array,0, array.length - 1);
        long quickStop = System.currentTimeMillis();
        long quickElapsed = quickStop - quickStart;
        System.out.println("Execution time for quicksort: " + quickElapsed + "ms");
        System.out.println(Arrays.toString(array));
    }
}
