import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int sizeST = 5;
        int unique = 0;
        int words = 0;
        Scanner input = new Scanner(System.in);
        BST<String,Integer> symbolTable = new BST<>();

        System.out.println("Type text: ");

        long startTime = System.currentTimeMillis();

        while(words < sizeST)
        {
            String tmp = input.next();
            words++;

            if(symbolTable.contains(tmp))
                symbolTable.put(tmp,symbolTable.get(tmp) + 1);

            else
            {
                symbolTable.put(tmp,1);
                unique++;
            }
        }

        long stopTime = System.currentTimeMillis();

        long totalTime = stopTime - startTime;

        System.out.println("Unique words: " + unique);
        System.out.println("Total words: " + words);
        System.out.println("Execution Time: " + totalTime + "ms");
    }
}