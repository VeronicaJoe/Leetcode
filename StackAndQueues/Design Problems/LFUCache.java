//DS used:
//          1)keyMap<key,Node> - get() - O(1)
//          2)freqMap<freq,DLL> - put() - O(1)
class LFUCache {
    class Node
    {
        int key,value,freq;
        Node prev,next;
        public Node(int key,int value)
        {
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }
    //LRU
    class DoublyList
    {
        Node head,tail;
        public DoublyList()
        {
            head = new Node(0,0);  
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;     
        }

        //remove
        public void remove(Node node)
        {
            //1<->2<->3
            //remove 2
            Node prevNode = node.prev;
            Node nextNode = node.next;
            if(prevNode!=null)
            prevNode.next = nextNode;
            if(nextNode!=null)
            nextNode.prev = prevNode;
        }

        //removeLast - LRU
        public Node removeLast()
        {
            //(head)0<->2<->3<->4<->0(tail)
            if(isEmpty())
            return null;
            Node lastNode = tail.prev;
            Node newLast = lastNode.prev;
            lastNode.next = null;
            lastNode.prev = null;

            if(newLast!=null)
            newLast.next = tail;
            tail.prev = newLast;

            return lastNode;
        }
        //addToFront - get / put
        public void addToFront(Node node)
        {
            //remove node
            remove(node);
            //add to front
            Node oldHead = head.next;
            head.next = node;
            node.prev = head;
            node.next = oldHead;
            if(oldHead!=null)
            oldHead.prev = node;
        }
        public boolean isEmpty()
        {
            return head.next == tail;
        }
    }
    int capacity,minFreq;
    Map<Integer,Node> keyMap;
    Map<Integer,DoublyList> freqMap;
    public LFUCache(int capacity) 
    {
        this.capacity = capacity;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.minFreq = 1;
    }
    //helper - remove + addToFront
    public void update(Node node)
    {
        //Remove node from last - freqMap
        int freq = node.freq;
        DoublyList oldList = freqMap.get(freq);
        oldList.remove(node);
        if(freq==minFreq&&oldList.isEmpty())
        minFreq++;

        //add to front
        node.freq++;
        DoublyList newList = freqMap.getOrDefault(node.freq,new DoublyList());
        newList.addToFront(node);
        freqMap.put(node.freq,newList);
    }
    public int get(int key) 
    {
        //empty
        if(capacity==0)
        return -1;

        if(!keyMap.containsKey(key))
        return -1;

        Node node = keyMap.get(key);
        //remove + add to front
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) 
    {
        //already present
        if(keyMap.containsKey(key))
        {
            Node node = keyMap.get(key);
            node.value = value;
            update(node);
        }
        //not present    
        else
        {
            //Edge Case: Capacity full check
            if(capacity==keyMap.size())
            {
                //remove lfu, if multiple remove lru
                //get the removed node
                DoublyList freqList = freqMap.get(minFreq);
                Node removedNode = freqList.removeLast();
                //get the freq
                int freq = removedNode.freq;
                //if DLL is empty - remove from keyMap and FreqMap
                if(freqList.isEmpty())
                {
                    freqMap.remove(freq);
                }
                keyMap.remove(removedNode.key);
            }
            Node newNode = new Node(key,value);
            minFreq = 1;
            DoublyList newList = freqMap.getOrDefault(1,new DoublyList());
            newList.addToFront(newNode);
            freqMap.put(1,newList);
            keyMap.put(key,newNode);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
