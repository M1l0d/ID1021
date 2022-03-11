import java.util.Iterator;
import java.util.Scanner;

class SingularQueue<Item> implements Iterable<Item>
{
    Node front;
    Node end;
    int counter;

    public SingularQueue()
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
                return current.next != null;

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

    public boolean isEmpty(){
        return front == null;
    }

    public void addToQueue(Item info)
    {
        Node newNode = new Node(info);

        if (counter == 0)
        {
            front = newNode;
            end = newNode;

        }
        else
        {
            end.next = newNode;
            end = newNode;
        }

//        System.out.println("New element added to queue");
//        System.out.println(toString());

        counter++;
    }

    public Item remove()
    {
        counter--;

        if(counter == 0) {
            Node tmpNode = front;
            tmpNode.next = null;
            front = end = null;
            //System.out.println("Removed remaining element");
            return tmpNode.info;
        }

        else
        {
            if (counter < 0) {
                System.out.println("0 elements left to remove");
                if (counter < 0) {
                    counter++;
                }
            }

            Node tmpNode = front;
            front = front.next;
            tmpNode.next = null;

            return tmpNode.info;

//            System.out.println("Deleted element");
//            System.out.println(toString());
        }
    }

    public void removeIndex(int x)
    {
        if(x <= 0)
            throw new IllegalArgumentException("Enter an index equal to or higher than 1");

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

        else if(x == queueSize() + 1) {
            counter++;
            remove();
        }

        else {
            int indexCounter = queueSize();
            Node prevTarget = front;
            Node target;
            Node nextTarget;
            //System.out.println(queueSize());

            while (indexCounter != (x)) {
                prevTarget = prevTarget.next;
                indexCounter--;
            }

            //System.out.println(prevTarget.info);

            target = prevTarget.next;
            nextTarget = target.next;
            target.next = null;
            prevTarget.next = nextTarget;

//            System.out.println("Removed element at index " + x);
//            System.out.println(toString());

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
        SingularQueue<Integer> queue = new SingularQueue<Integer>();

        System.out.println("Press 'h' for help");

        Scanner scan = new Scanner(System.in);
        String instruction = scan.nextLine();

        for(; !instruction.equals("e") ; instruction = scan.nextLine())
        {
            switch(instruction)
            {
                case "a":
                    System.out.println("Type value to be added");
                    queue.addToQueue(scan.nextInt());
                    break;

                case "i":
                    System.out.println("Type the index to be removed");
                    queue.removeIndex(scan.nextInt());
                    break;

                case "e":
                    return;

                case "s":
                    System.out.println("Size of queue is " + queue.queueSize());
                    break;

                case "h":
                    System.out.println("Press 'a' to add element \n Press 'i' to remove element from an index \n Press 'e' to end \n Press 's' to see size of queue");
                    break;

                default:
                    System.out.println("Press 'h' for help");
            }
        }
    }
}

