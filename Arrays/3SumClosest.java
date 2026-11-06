class Solution {
    public int threeSumClosest(int[] nums, int target) 
    {
        //2 pointer
        Arrays.sort(nums);
        int n= nums.length;
        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int left = i+1,right=n-1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==target)
                return sum;
                int diff = Math.abs(target-sum);
                if(diff<minDiff)
                {
                    closestSum = sum;
                    minDiff = diff;
                }
                if(sum<target)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
