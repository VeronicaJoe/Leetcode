class Solution {
    //Find the NSE and PSE of the given array
    //For each element: element * (nse-i) * (i-pse)
    //In the stack we store indices instead of the elements
    private int[] findNSE(int[] arr)
    {
        int n = arr.length;
        int[] nse = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        //from right -> left
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nse[i] = n;
            }
            else
            {
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }
    private int[] findPSE(int[] arr)
    {
        int n = arr.length;
        int[] pse = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        //move from left -> right
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&arr[st.peek()]>arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                pse[i]=-1;
            }
            else
            {
                pse[i]=st.peek();
            }
            st.push(i);
        }
        return pse;
    }
    public int sumSubarrayMins(int[] arr)
    {
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        long sum = 0;
        final int MOD = (int)1e9+7;
        for(int i=0;i<n;i++)
        {
            long left = i-pse[i];
            long right = nse[i]-i;
            sum=(sum+(long)arr[i]*left*right)%MOD;
        }
        return (int)sum;
    }
}
