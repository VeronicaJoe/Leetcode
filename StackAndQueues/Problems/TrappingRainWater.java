class Solution {
    //Brute Force: Using PrefixMax and SuffixMax - precompute
    //TC: O(N) and SC: O(N)
    //Left boundary
    private int[] prefixMax(int[] height)
    {
        int n = height.length;
        int[] prefix = new int[n];
        prefix[0]=height[0];
        int max = prefix[0];
        for(int i=1;i<n;i++)
        {
            max = Math.max(max,height[i]);
            prefix[i]=max;
        }
        return prefix;
    }
    //Right boundary
    private int[] suffixMax(int[] height)
    {
        int n = height.length;
        int[] suffix = new int[n];
        suffix[n-1]=height[n-1];
        int max = suffix[n-1];
        for(int i=n-2;i>=0;i--)
        {
            max = Math.max(max,height[i]);
            suffix[i]=max;
        }
        return suffix;
    }
    public int trap1(int[] height) 
    {
        int n = height.length;
        if(n==0)
        return -1;
        int[] maxLeftBoundary = prefixMax(height);
        int[] maxRightBoundary = suffixMax(height);
        int trap = 0;
        for(int i=0;i<n;i++)
        {
            //get the min boundary and subtract from the current height
            trap+=Math.min(maxLeftBoundary[i],maxRightBoundary[i])-height[i];
        }
        return trap;
    }
    //Optimal: Without using extra spaces - running max calc - using 2 pointer
    public int trap(int[] height) 
    {
        //Step 1: 2 pointer
        int n = height.length;
        int left = 0, right = n-1;
        int maxLeft = 0, maxRight = 0;
        int waterTrapped = 0;
        while(left<right)
        {
            //process the smallest height first 
            if(height[left]<height[right])
            {
                //get the maximum left height
                maxLeft = Math.max(maxLeft,height[left]);
                waterTrapped+=maxLeft-height[left];
                left++;
            }
            else
            {
                //get the maximum right height
                maxRight = Math.max(maxRight,height[right]);
                waterTrapped+=maxRight-height[right];
                right--;
            }
        }
        return waterTrapped;
    }
}

