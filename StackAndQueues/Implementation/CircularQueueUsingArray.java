class myQueue {
    // Dry-run this sequence with n = 3:
    // 1. enqueue(10)
    // 2. enqueue(20)
    // 3. enqueue(30)
    // 4. dequeue()
    // 5. enqueue(40)
    
    int[] arr;
    int front, rear;
    int size;
    // int size;
    public myQueue(int n) {
        // Define Data Structures
        arr = new int[n];
        front = -1;//pointing to 1st element
        rear = -1;
        size = n;
    }

    public boolean isEmpty() 
    {
        // Check if queue is empty
        return front==-1;
    }

    public boolean isFull() {
        // Check if queue is full
        return (rear+1)%size==front;
    }

    public void enqueue(int x) 
    {
        // Enqueue
        if(isFull())
        return;
        //First Element
        if(isEmpty())
        front = 0;
        rear = rear+1%size;
        arr[rear]=x;
    }

    public void dequeue() {
        // Dequeue
        if(isEmpty())
        return;
        
        if(front==rear)
        {
            //single element
            front = rear = -1;
        }
        else
        {
            front = (front+1)%size;
        }
    }

    public int getFront() {
        // Get front element
        if(isEmpty())
        return -1;
        return arr[front];
    }

    public int getRear() {
        // Get last element
        if(isEmpty())
        return -1;
        return arr[rear];
    }
}
