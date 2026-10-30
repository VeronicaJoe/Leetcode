class Solution 
{
    private int[] findNSE(int[] heights)
    {
        int n = heights.length;
        int[] nse = new int[n];
        //move from right -> left
        Deque<Integer> st = new ArrayDeque<>();
        for(int i =n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nse[i]=n;
            }
            else
            {
                nse[i]=st.peek();
            }
            st.push(i);
        }
        return nse;
    }
    private int[] findPSE(int[] heights)
    {
        int n = heights.length;
        int[] pse = new int[n];
        //move from left to right
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&heights[st.peek()]>heights[i])
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
    public int largestRectangleArea(int[] heights) 
    {
        //largest rectangle : nse-pse-1
        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);

        int n = heights.length;
        int largestRect = 0;
        for(int i=0;i<n;i++)
        {
            int width = nse[i]-pse[i]-1;
            largestRect = Math.max(largestRect,heights[i]*width);
        }
        return largestRect;
    }
}
