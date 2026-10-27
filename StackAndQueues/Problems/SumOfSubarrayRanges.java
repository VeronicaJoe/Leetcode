class Solution {
    //Pre-req: Sum of subarray minimums (nse and pse) 
    //edge case: no nse and no pge - (n)
    //Sum of subarray maximums (nge and pge)
    // edge case: no pse and no pge - (-1)
    //Store indices in the
    private int[] findNSE(int[] nums)
    {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] nse = new int[n];
        //move from right to left
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&nums[st.peek()]>=nums[i])
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
    private int[] findPSE(int[] nums)
    {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] pse = new int[n];
        //move from left to right
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&nums[st.peek()]>nums[i])
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
    private int[] findNGE(int[] nums)
    {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] nge = new int[n];
        //move from right to left
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&nums[st.peek()]<=nums[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nge[i]=n;
            }
            else
            {
                nge[i]=st.peek();
            }
            st.push(i);
        }
        return nge;
    }
    private int[] findPGE(int[] nums)
    {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] pge = new int[n];
        //move from left to right
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&nums[st.peek()]<nums[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                pge[i]=-1;
            }
            else
            {
                pge[i]=st.peek();
            }
            st.push(i);
        }
        return pge;
    }
    private long minSubarrSum(int[] nse,int[] pse,int[] nums)
    {
        long sum = 0;
        int n = nums.length;
        final int MOD = (int)1e9+7;
        for(int i=0;i<n;i++)
        {
            sum=sum+(long)nums[i]*(nse[i]-i)*(i-pse[i]);
        }
        return sum;
    }
    private long maxSubarrSum(int[] nge,int[] pge,int[] nums)
    {
        long sum = 0;
        int n = nums.length;
        final int MOD = (int)1e9+7;
        for(int i=0;i<n;i++)
        {
            sum=sum+(long)nums[i]*(nge[i]-i)*(i-pge[i]);
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) 
    {
        int[] nse = findNSE(nums);
        int[] pse = findPSE(nums);
        long smallest = minSubarrSum(nse,pse,nums);

        int[] nge = findNGE(nums);
        int[] pge = findPGE(nums);
        long largest = maxSubarrSum(nge,pge,nums);

        return largest-smallest;
    }
//DUPLICATE CHECKS:
// Minimums
// NSE: >=
// PSE: >

// Maximums
// NGE: <=
// PGE: <
}
