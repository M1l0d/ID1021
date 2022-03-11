import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        System.out.println("Enter string for recursive reverse");
        Scanner input1 = new Scanner(System.in);
        String a = input1.nextLine();
        String new_recursive = recursive_reverse(a);
        System.out.println(new_recursive);

        System.out.println("Enter string for iterative reverse");
        Scanner input2 = new Scanner(System.in);
        StringBuffer b = new StringBuffer();
        b.append(input2.nextLine());
        StringBuffer new_iterative = b;
        iterative_reverse(new_iterative);
        System.out.println(new_iterative);

    }
    public static String recursive_reverse(String s)
    {
        if(s.isEmpty())
        {
            return s;
        }

        return recursive_reverse(s.substring(1)) + s.charAt(0);
    }



    public static void iterative_reverse(StringBuffer s)
    {
        int n = s.length();
        Stack stack = new Stack(n);

        for(int i = 0 ; i < n ; i++)
        {
            stack.push(s.charAt(i));
        }

        for(int j = 0 ; j < n ; j++)
        {
            char c = stack.pop();
            s.setCharAt(j,c);
        }
    }
}

class Stack
{
    char[] c;
    int size;
    int top;

    Stack(int n) // Skapar en stack med storlek "n"
    {
        top = -1;
        size = n;
        c = new char[size];
    }

    boolean emptyStack() // Kollar om stacken är tom
    {
        return (top == -1);
    }

    boolean push(char p) // Pusha för att lägga till i stacken
    {
        if (top >= size)
            return false;

        else {
            c[++top] = p;
            return true;
        }
    }

    char pop() // Poppa för att ta bort från stacken
    {
        if(top == -1)
            return 0;

        else{
            char p = c[top--];
            return p;
        }
    }
}