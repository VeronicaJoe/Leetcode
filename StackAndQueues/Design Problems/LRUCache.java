class Node
{
    int key,value;
    Node prev;
    Node next;

    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map;//<key,node>
    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;

        head.prev = null;
        tail.next = null;

        map = new HashMap<>();
    }
    
    public int get(int key) 
    {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            int val = node.value;
            remove(node);
            moveToFront(node);
            return val;
        }    
        return -1;
    }
    private void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void moveToFront(Node node)
    {
        //newnode = (3,4)
        //(0,0)->(1,2)
        //(0,0)<->(3,4)<->(1,2)
        Node actualHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = actualHead;
        if(actualHead!=null)
        {
            actualHead.prev = node;
        }
    }
    public void put(int key, int value) 
    {
        //Already present then just update
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            moveToFront(node);
        }    
        else
        {
            //new node to be created
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            if(map.size()>capacity)
            {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            moveToFront(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
