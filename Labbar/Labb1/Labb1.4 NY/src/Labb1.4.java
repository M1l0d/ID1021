import java.util.Iterator;
import java.util.Scanner;

class CircularSingularQueue<Item> implements Iterable<Item>
{
    Node front;
    Node end;
    int counter;

    public CircularSingularQueue()
    {
        this.front = null;
        this.end = null;
        this.counter = 0;
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item>
    {
        Node current = front;

        public boolean hasNext()
        {
            if (current != null)
                return current != end;

            return false;
        }

        public Item next()
        {
            Item currentInfo = current.info;
            current = current.next;
            return currentInfo;
        }


    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Item> iterator = iterator();

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

    public void addToEnd(Item info)
    {
        Node newNode = new Node(info);

        if (counter == 0)
        {
            front = newNode;
            newNode.next = newNode;
            end = newNode;
        }
        else
        {
            end.next = newNode;
            newNode.next = front;
            end = newNode;
        }
        System.out.println("New element added to queue");
        System.out.println(toString());

        counter++;
    }

    public void addToBeginning(Item info)
    {
        Node newNode = new Node(info);

        if (counter == 0)
        {
            front = newNode;
            newNode.next = newNode;
            end = newNode;
        }
        else
        {
            newNode.next = front;
            front = newNode;
            end.next = newNode;
        }
        System.out.println("New element added to queue");
        System.out.println(toString());

        counter++;
    }

    public void removeFirst()
    {
        counter--;

        if(counter == 0) {
            Node tmpNode = front;
            tmpNode.next = null;
            front = end = null;
            System.out.println("Removed remaining element");
        }

        else if (counter < 0) {
            System.out.println("0 elements left to remove");
                counter++;
        }
        else
        {
            Node tmpNode = front;
            front = front.next;
            end.next = front;
            tmpNode.next = null;

            System.out.println("Deleted first element");
            System.out.println(toString());
        }
    }

    public void removeLast()
    {
        counter--;

        if(counter == 0) {
            Node tmpNode = front;
            tmpNode.next = null;
            front = end = null;
            System.out.println("Removed remaining element");
        }

        else if (counter < 0) {
            System.out.println("0 elements left to remove");
            counter++;
        }
        else
        {
            Node tmpNode = front;
            while(tmpNode.next != end)
            {
                tmpNode = tmpNode.next;
            }

            tmpNode.next = front;
            end.next = null;
            end = tmpNode;

            System.out.println("Removed last element");
            System.out.println(toString());
        }
    }

    public class Node
    {
        Node next;
        Item info;

        public Node(Item info)
        {
            this.info = info;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        CircularSingularQueue<Integer> queue = new CircularSingularQueue<>();

        System.out.println("Press 'h' for help");

        Scanner scan = new Scanner(System.in);
        String instruction = scan.nextLine();

        for(; !instruction.equals("e") ; instruction = scan.nextLine())
        {
            switch (instruction)
            {
                case "a":
                    System.out.println("Type value to be added to end:");
                    queue.addToEnd(scan.nextInt());
                    break;

                case "b":
                    System.out.println("Type value to be added to beginning:");
                    queue.addToBeginning(scan.nextInt());
                    break;

                case "f":
                    queue.removeFirst();
                    break;

                case "l":
                    queue.removeLast();
                    break;

                case "e":
                    return;

                case "h":
                    System.out.println("Press 'a' to add element to end \n Press 'f' to remove first element \n " +
                            "Press 'l' to remove last element \n Press 'e' to end");
                    break;

                default:
                    System.out.println("Press 'h' for help");
            }
        }
    }
}