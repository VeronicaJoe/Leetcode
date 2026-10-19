// Node class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Queue class
class myQueue {
    Node front;
    Node rear;
    int size;
    public myQueue() {
        // Initialize your data members
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        // check if the queue is empty
        return front==null;
    }

    public void enqueue(int x) 
    {
        // Adds an element x at the rear of the queue.
        Node newNode = new Node(x);
        //First Node inserted
        if(isEmpty())
        {
            front = newNode;
            rear = newNode;
        }
        else
        {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void dequeue() {
        // Removes the front element of the queue
        if(isEmpty())
        return;
        //single node
        if(front.next==null)
        {
            front = null;
            rear = null;
        }
        else
        {
            front = front.next;
        }
        size--;
    }

    public int getFront() {
        // Returns the front element of the queue.
        // If queue is empty, return -1.
        if(isEmpty())
        return -1;
        
        return front.data;
    }

    public int size() 
    {
        // Returns the current size of the queue.
        return size;
    }
}
