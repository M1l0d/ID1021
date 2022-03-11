import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File text = new File("C:\\Users\\Milad\\Documents\\KTH\\Algoritmer & Datastrukturer\\Labbar\\Labb 3\\Labb3.1\\outputfile1.txt");
        Scanner input = new Scanner(text);
        SeparateChainingLiteHashST<String,Integer> sch = new SeparateChainingLiteHashST<>();

        int words = 0;
        int unique = 0;

        while (input.hasNext()) {
            String tmp = input.next();
            words++;

            if (sch.contains(tmp))
                sch.put(tmp, sch.get(tmp) + 1);

            else
            {
                sch.put(tmp, 1);
                unique++;
            }
        }

        System.out.println("Total Words: " + words);
        System.out.println("Unique Words: " + unique);

        System.out.println("Search for word: ");
        input = new Scanner(System.in);

        String searchedWord = input.next();

        System.out.println("Amount of times the word appeared: " + sch.get(searchedWord));
    }

}
