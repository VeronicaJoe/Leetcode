class Solution {
    // 3 pointer approach 
    // i,left,right
    // i-any point in the nums and left = i+1 and right = n-1
    // Be aware of duplicate handling
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            //skip duplicates
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = n - 1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0)
                {
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;

                    //skip duplicates
                    while(left<right&&nums[left]==nums[left-1])
                    {
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right+1])
                    {
                        right--;
                    }
                }
                else if(sum<0)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }

        }
        return list;
    }
}

//Mistakes made on 16/7/26:
//1) nums[i]+nums[left]+nums[right] => wrong , nums[i],nums[left],nums[right] => correct
//2) list.add(new ArrayList...) => wrong , list.add(Arrays.asList(a,b,c))
//3) forgot to add Arrays.sort() => helps in duplicate checking


//TC:O(N^2) SC: O(1)
