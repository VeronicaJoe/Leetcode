class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) 
    {
        // code here
        ArrayList<Integer> nse = new ArrayList<>();
        Deque<Integer> st = new ArrayDeque<>();
        int n = arr.length;
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&st.peek()>=arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nse.add(-1);
            }
            else
            {
                nse.add(st.peek());
            }
            st.push(arr[i]);
        }
        Collections.reverse(nse);
        return nse;
    }
}
