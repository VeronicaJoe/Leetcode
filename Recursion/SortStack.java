class Solution {
    //Brute Force: Store in a list sort and add the elements back to stack in reverse order
    public void sortStack(Stack<Integer> st) {
        List<Integer> list = new ArrayList<>();
        while(!st.isEmpty())
        {
            list.add(st.pop());
        }
        Collections.sort(list);
        for(int num:list)
        {
            st.push(num);
        }
    }
    //Optimal Approach: 2 recursive calls
    //              --> 1st call to pop all and keep track of them
    //              --> 2nd call after popping all insert in correct pos
    public void sortStack1(Stack<Integer> st) {
        // code here
        sort(st);
    }
    private void sort(Stack<Integer> st)
    {
        if(st.isEmpty())
        {
            return;
        }
        int top = st.pop();
        sort(st);
        insertExactPos(st,top);
    }
    private void insertExactPos(Stack<Integer> st,int num)
    {
        if(st.isEmpty()||st.peek()<=num)
        {
            st.push(num);
            return;
        }
        int top = st.pop();
        insertExactPos(st,num);
        st.push(top);
    }
}
