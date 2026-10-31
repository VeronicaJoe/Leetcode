class Solution {
    public int[] maxSlidingWindow1(int[] nums, int k) 
    {
        if(k==1&&nums.length==1)
        {
            return nums;
        }
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int left = 0;left<=n-k;left++)
        {
            int maxWindow = Integer.MIN_VALUE;
            for(int right=left;right<left+k;right++)
            {
                maxWindow = Math.max(maxWindow,nums[right]);
            }
            res[left]=maxWindow;
        }   
        return res; 
    }
    //Approach: Using ArrayDeque(QUEUE)
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[n-k+1];
        int ind = 0;
        for(int i=0;i<n;i++)
        {
            //Window exceeded
            if(!q.isEmpty()&&q.peekFirst()==i-k)
            {
                q.pollFirst();
            }
            //NGE
            while(!q.isEmpty()&&nums[q.peekLast()]<=nums[i])
            {
                q.pollLast();
            }
            q.offerLast(i);
            if(i>=k-1)
            {
                res[ind++]=nums[q.peekFirst()];
            }
        }
        return res;
    }
}
