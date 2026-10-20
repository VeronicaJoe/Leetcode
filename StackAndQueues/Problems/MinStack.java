//Brute Force: Use for loop and track the min 
class MinStack {
    Stack<Integer> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {
        st.push(value);
    }

    public void pop() {
        //remove from st1 and st2
        if (st.isEmpty())
            return;
        st.pop();
    }

    public int top() {
        if (st.isEmpty())
            return -1;
        return st.peek();
    }

    public int getMin() {
        if (st.isEmpty())
            return -1;
        int min = Integer.MAX_VALUE;
        for(int x:st)
        {
            min = Math.min(min,x);
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//Optimal: Using 2 Stacks
class MinStack1 {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MinStack1() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int value) {
        st1.push(value);
        if (st2.isEmpty() || st1.peek() <= st2.peek()) {
            st2.push(value);
        }
    }

    public void pop() {
        //remove from st1 and st2
        if (st1.isEmpty())
            return;
        int val = st1.pop();
        if (!st2.isEmpty() && st2.peek() == val)
            st2.pop();
    }

    public int top() {
        if (st1.isEmpty())
            return -1;
        return st1.peek();
    }

    public int getMin() {
        if (st2.isEmpty())
            return -1;
        return st2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
