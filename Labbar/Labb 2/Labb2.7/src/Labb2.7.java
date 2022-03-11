import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void insertionSort(int [] a)
    {
        for(int k = 0 ; k < a.length ; k++)
            a[k] = a[k] * (-1);

        int swaps = 0;
        for(int i = 1 ; i < a.length ; i++)
        {
            int tmp = a[i];
            int j = i - 1;

            while(j >= 0 && a[j] > tmp)
            {
                a[j+1] = a[j];
                j--;
                swaps += 1;
            }
            a[j+1] = tmp;

        }

        for(int p = 0 ; p < a.length ; p++)
            a[p] = a[p] * (-1);

        System.out.println("Amount of swaps:" + swaps);
    }

    public static void numberOfInversions(int [] a)
    {
        int inversions = 1;

        for(int i = 1 ; i < a.length ; i++)
        {
            int tmp = a[i];
            int j = i;

            while(j > 0)
            {
                if(a[--j] < tmp) {
                    System.out.println("Inversion " + inversions + " is: [" + i + "," + a[i] + "]" + ",[" + j + "," + a[j] + "]");
                    inversions += 1;
                }
            }
        }
        System.out.println("Number of inversions are: " + (inversions-1) + "\n");
    }

    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter size of array");
        int arraySize = input1.nextInt();
        int [] array = new int[arraySize];

        System.out.println("Enter array elements");
        for(int i = 0 ; i < arraySize ; i++)
            array[i] = input1.nextInt();

        System.out.println("Unsorted array: " + Arrays.toString(array) + "\n");


        numberOfInversions(array);
        insertionSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}


