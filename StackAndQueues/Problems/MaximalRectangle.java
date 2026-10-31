class Solution {
    //Pre-Req: Largest Rectangle in a Histogram
    //Approach:
    //         Using prefixSum
    private int largestRectangle(int[] heights)
    {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int largestRect = 0;
        //[1,2,3,4] - dry run to understand why <=n 
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
            if(i<n)
            st.push(i);
        }
        return largestRect;

    }
    public int maximalRectangle(char[][] matrix) 
    {
        int n =matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m]; 

        int maxRect = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //Important edge case only if 1 then increment else make it a 0
                if(matrix[i][j]=='1')
                {
                    heights[j]++;
                }
                else
                {
                    heights[j]=0;
                }
            }
            //Calculate Largest Rectangle in a Histogram
            maxRect = Math.max(maxRect,largestRectangle(heights));
        }  
        return maxRect;
    }
}
