import java.util.Arrays;
import java.util.Scanner;

class Main {

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

    public static int medianOf3(Comparable [] a, int lo, int hi)
    {
        int middle = (lo + hi)/2;

        if(a[lo].compareTo(a[middle]) > 0)
            swap(a,lo,middle);

        if(a[lo].compareTo(a[hi]) > 0)
            swap(a,lo,hi);

        if(a[middle].compareTo(a[hi]) > 0)
            swap(a,middle,hi);

        swap(a,middle,hi - 1);

        return hi - 1;
    }

    public static void quickSort(Comparable [] a, int lo, int hi)
    {
        if(lo >= hi)
        return;

        int median = medianOf3(a,lo,hi); //lo + (hi - lo)/2
        swap(a,lo, median);

        int k = partition(a,lo,hi);
        quickSort(a,lo,k-1);
        quickSort(a,k+1,hi);
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


//        Comparable []a= {2,6,5,3,8,7,1,0,4};
//        quickSort(a,0,a.length-1);
    }
}
