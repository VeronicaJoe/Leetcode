class myStack {
    Queue<Integer> q = new LinkedList<>();

    void push(int x) 
    {
        // Inserts an element x at the top of the stack
        //To manipulate queue to act like stack
        //on every push rotate the array(latest comes in the front)
        q.add(x);
        for(int i=0;i<q.size()-1;i++)
        {
            q.add(q.remove());//n-1 elements removed and added except the last added element
        }
    }

    void pop() {
        // Removes an element from the top of the stack
        if(q.size()==0)
        return;
        
        q.remove();
    }

    int top() {
        // Returns the top element of the stack
        // If stack is empty, return -1
        if(q.size()==0)
        return -1;
        
        return q.peek();
    }

    int size() {
        // Returns the current size of the stack
        return q.size();
    }
}
