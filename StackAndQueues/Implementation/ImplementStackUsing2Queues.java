class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) 
    {
        //Step 1: Add to q2
        q2.add(x);
        //Step 2: Move all elements from q1 -> q2
        while(!q1.isEmpty())
        {
            q2.add(q1.remove());
        }    
        //Step 3: Swap q1<->q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() 
    {
        //Remove from q1
        if(q1.isEmpty())
        return -1;
        return q1.remove();    
    }
    
    public int top() 
    {
        if(q1.isEmpty())
        return -1;
        return q1.peek();    
    }
    
    public boolean empty() 
    {
        return q1.isEmpty();    
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
