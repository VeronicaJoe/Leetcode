class Solution 
{
    //Remember: One side pops >=, the other pops >, so equal heights don't block the largest rectangle.
    //Dry Run: [2,2,2]
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
    public int largestRectangleArea1(int[] heights) 
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

    //Optimal Approach: Using a single pass
    // _pse__ __st.pop()__ __nse(currInd)__

    //Why i traversing till <= n? not why not < n?
    //Dry run [1,2,3,4] - all increasing - will never be able to pop and never to able to find the largest rect soo got till n
    //Edge Case:
    //          No NSE = n
    //          No PSE = -1
    public int largestRectangleArea(int[] heights) 
    {
        int n = heights.length;
        int largestRect = 0;
        Deque<Integer> st = new ArrayDeque<>();//store indexes in increasing order
        for(int i=0;i<=n;i++)
        {
            int currInd = i;
            while(!st.isEmpty()&&heights[st.peek()]>=(currInd==n?0:heights[currInd]))
            {
                int height = heights[st.pop()];
                int nse = currInd;
                int pse = st.isEmpty()?-1:st.peek();
                int width = nse-pse-1;
                int area = height*width;
                largestRect = Math.max(largestRect,area);
            }           
            st.push(currInd);
        }
        return largestRect;
    }
}
