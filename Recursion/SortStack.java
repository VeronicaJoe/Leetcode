class Solution {
    public void sortStack1(Stack<Integer> st) {
        // code here
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
    public void sortStack(Stack<Integer> st)
    {
        if(st.isEmpty())
        {
            return;
        }
        int num = st.pop();
        sortStack(st);
        insert(st,num);
    }
    private void insert(Stack<Integer> st,int num)
    {
        if(st.isEmpty()||st.peek()<=num)
        {
            st.push(num);
            return;
        }
        int ele = st.pop();
        insert(st,num);
        st.push(ele);
    }
}
