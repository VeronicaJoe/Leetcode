class Solution {
    //Using PSE
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        //Edge Case: If no pse - 1
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&arr[st.peek()]<=arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                res.add(i+1); //No PGE found: eg:[1,2,3,4]
            }
            else
            {
                res.add(i-st.peek());//curr - PGE
            }
            st.push(i);
        }
        return res;
    }
}
