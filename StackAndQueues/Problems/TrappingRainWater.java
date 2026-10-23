class Solution {
    //Brute Force: Using PrefixMax and SuffixMax - precompute
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
    public int trap(int[] height) 
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
}
