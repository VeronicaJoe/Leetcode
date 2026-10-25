class Solution {
    public ArrayList<Integer> preGreaterEle(int[] arr) {
        // code here
        ArrayList<Integer> pge = new ArrayList<>();
        Deque<Integer> st = new ArrayDeque<>();
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&st.peek()<=arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                pge.add(-1);
            }
            else
            {
                pge.add(st.peek());
            }
            st.push(arr[i]);
        }
        return pge;
    }
}
