import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws FileNotFoundException {
        int stSize = 200;
        BST<String, Integer> st = new BST<String, Integer>();

        File text = new File("C:\\Users\\Milad\\Documents\\KTH\\Algoritmer & Datastrukturer\\Labbar\\Labb 3\\Labb3.1\\outputfile1.txt");
        Scanner input = new Scanner(text);

        while (input.hasNext()) {
            String tmp = input.next().toLowerCase();

            if (st.contains(tmp))
                st.put(tmp, st.get(tmp) + 1);

            else
            {
                st.put(tmp, 1);
            }
        }

        Scanner scanner = new Scanner(System.in);


        System.out.println("Press 'a' to print first 200 words in alphabetic order \n" +
                           "Press 'r' to print first 200 words in reverse alphabetic order");

        switch (scanner.next()) {
            case "a":
                st.alphabetic();
                break;

            case "r":
                st.alphabeticReverse();
                break;

            default:
                System.out.println("Press 'a' to print first 200 words in alphabetic order '\n' " +
                        "Press 'r' to print first 200 words in reverse alphabetic order");
        }
    }
}
