class SeparateChainingLiteHashST<Key, Value> {

    private int n;       // number of key-value pairs
    private int m;       // hash table size
    private Node[] st;   // array of linked-list symbol tables

    // a helper linked list data type
    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    // create separate chaining hash table
    public SeparateChainingLiteHashST() {
        this(1000);
    }

    // create separate chaining hash table with m lists
    public SeparateChainingLiteHashST(int m) {
        this.m = m;
        st = new Node[m];
    }

    // hash value between 0 and m-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    // is the key in the symbol table?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return value associated with key, null if no such key
    public Value get(Key key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }

    // insert key-value pair into the table
    public void put(Key key, Value val) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        n++;
        st[i] = new Node(key, val, st[i]);
    }

    public void evenly(){
        int nodesAtIndex;
        for(int i = 0 ; i < m ; i++) {
            nodesAtIndex = 0;
            for (Node x = st[i]; x != null; x = x.next)
                nodesAtIndex++;

            System.out.println("Total nodes at index " + i + " are " + nodesAtIndex);
        }
    }

    public void average(){
        int nodesAtIndex;
        int sum = 0;
        for(int i = 0 ; i < m ; i++) {
            nodesAtIndex = 0;
            for (Node x = st[i]; x != null; x = x.next) {
                nodesAtIndex++;
            }

            sum = sum + nodesAtIndex;
        }

        int average = sum / m;
        System.out.println("Average amount of nodes at each index are: " + average);
    }
}

