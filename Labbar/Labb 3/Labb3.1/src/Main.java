import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int sizeST = 1000;
        int unique = 0;
        int words = 0;
        Scanner input = new Scanner(System.in);
        BinarySearchST<String,Integer> symbolTable = new BinarySearchST<>();

        System.out.println("Type text: ");

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

        System.out.println("Unique words: " + unique);
        System.out.println("Total words: " + words);
    }
}