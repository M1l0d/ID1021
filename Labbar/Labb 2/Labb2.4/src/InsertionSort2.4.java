import java.util.Arrays;
import java.util.Scanner;

class InsertionSort {

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

    public static void main(String[] args) {

        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter size of array");
        int arraySize = input1.nextInt();
        Comparable [] array = new Comparable[arraySize];

        System.out.println("Enter array elements");
        for(int i = 0 ; i < arraySize ; i++)
            array[i] = input1.nextInt();

        long insertionStart = System.currentTimeMillis();
        insertionSort(array);
        long insertionStop = System.currentTimeMillis();
        long insertionElapsed = insertionStop - insertionStart;
        System.out.println("Execution time for insertion sort: " + insertionElapsed + "ms");
        //System.out.println(Arrays.toString(array));
    }
}

// java InsertionSort < test100lax.txt
