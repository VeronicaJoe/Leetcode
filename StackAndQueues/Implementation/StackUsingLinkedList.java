/* Structure of linked list Node
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}*/

class myStack {
    class Node 
    {
        int data;
        Node next;
        
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
        public Node(int data,Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    Node head = null;
    int size = 0;
    public myStack() {
        // Initialize your data members
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return head==null;
    }

    public void push(int x) {
        // Adds an element x at the rear of the stack.
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void pop() 
    {
        // Removes the front element of the stack.
        if(!isEmpty())
        head = head.next;
        size--;
    }

    public int peek() {
        // Returns the front element of the stack.
        // If stack is empty, return -1.
        if(isEmpty())
        return -1;
        
        return head.data;
    }

    public int size() {
        // Returns the current size of the stack.
        return size;
    }
}
