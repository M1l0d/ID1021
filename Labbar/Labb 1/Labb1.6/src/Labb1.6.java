import java.util.Iterator;
import java.util.Scanner;

class CircularDoubleOrderQueue implements Iterable
{
    Node front;
    Node end;
    int counter;

    public CircularDoubleOrderQueue()
    {
        this.front = null;
        this.end = null;
        this.counter = 0;
    }

    public Iterator iterator()
    {
        return new ListIterator();
    }

    public class ListIterator implements Iterator
    {
        Node current = front;

        public boolean hasNext()
        {
            if (current != null)
                return current != end;

            return false;
        }

        public Object next()
        {
            int currentInfo = current.info;
            current = current.next;
            return currentInfo;
        }


    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator iterator = iterator();

        if (iterator.hasNext()) {
            while (iterator.hasNext()) {
                sb.append(iterator.next() + "|");
            }
        }

        sb.append(iterator.next() + "]");
        return sb.toString();
    }

    public int queueSize(){
        return counter;
    }

    public void addToQueue(int info)
    {
        Node newNode = new Node(info);

        if (counter == 0)
        {
            front = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
            end = newNode;
        }
        else
        {
            end.next = newNode;
            newNode.previous = end;
            newNode.next = front;
            front.previous = newNode;
            end = newNode;
        }

        Node k = end;
        //k.info = end.info;

        while(k != front)
        {
            if(k.info < k.previous.info)
            {
                int y = k.info;
                k.info = k.previous.info;
                k.previous.info = y;
                k = k.previous;
            }
            else
                k = k.previous;
        }

        System.out.println("New element added to queue");
        System.out.println(toString());

        counter++;
    }

    public void remove()
    {
        counter--;

        if(counter == 0) {
            Node tmpNode = front;
            tmpNode.next = null;
            tmpNode.previous = null;
            front = end = null;
            System.out.println("Removed remaining element");
        }

        else if (counter < 0) {
            System.out.println("0 elements left to remove");
            if (counter < 0) {
                counter++;
            }
        }
        else
        {
            Node tmpNode = front;
            front = front.next;
            front.previous = end;
            tmpNode.next = null;
            tmpNode.previous = null;

            System.out.println("Deleted element");
            System.out.println(toString());
        }
    }

    public class Node
    {
        Node next;
        Node previous;
        int info;

        public Node(int info)
        {
            this.info = info;
            this.next = null;
            this.previous = null;
        }
    }

    public static void main(String[] args) {
        CircularDoubleOrderQueue queue = new CircularDoubleOrderQueue();

        System.out.println("Press 'h' for help");

        Scanner scan = new Scanner(System.in);
        String instruction = scan.nextLine();

        for(;!instruction.equals("e") ; instruction = scan.nextLine())
        {
            switch (instruction)
            {
                case "a":
                    System.out.println("Type value to be added:");
                    queue.addToQueue(scan. nextInt());
                    break;

                case "r":
                    queue.remove();
                    break;

                case "e":
                    return;

                case "h":
                    System.out.println("Press 'a' to add element and 'r' to remove element and 'e' to end");
                    break;

                default:
                    System.out.println("Press 'h' for help");
            }
        }
    }
}