class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) 
    {
        // code here
        ArrayList<Integer> pse = new ArrayList<>();
        Deque<Integer> st = new ArrayDeque<>();
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&st.peek()>=arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                pse.add(-1);
            }
            else
            {
                pse.add(st.peek());
            }
            st.push(arr[i]);
        }
        return pse;
    }
}
