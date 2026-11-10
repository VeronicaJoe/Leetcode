class Solution {
    //Brute Force: Using Extra Space
    public static void reverseStack1(Stack<Integer> st) {
        // code here
        //Step 1: recursion runs till my stack goes empty
        //Step 2: pop and add to a helper stack
        //Step 3: When base condition has attained then pop and add back to the st
        List<Integer> list = new ArrayList<>();
        helper(st,list);
    }
    private static void helper(Stack<Integer> st,List<Integer> list)
    {
        if(st.isEmpty())
        {
            for(int num:list)
            {
                st.push(num);
            }
            return;
        }
        list.add(st.pop());
        helper(st,list);
    }
    //Optimal Approach: Without using extra space
    public static void reverseStack(Stack<Integer> st) 
    {
        reverse(st);
    }
    private static void reverse(Stack<Integer> st)
    {
        if(st.isEmpty())
        return;
        
        int top = st.pop();
        reverse(st);
        insertAtBottom(st,top);
    }
    private static void insertAtBottom(Stack<Integer> st,int num)
    {
        if(st.isEmpty())
        {
            st.push(num);
            return;
        }
        int top = st.pop();
        insertAtBottom(st,num);
        st.push(top);
    }
}

