class Solution {
    //Brute Force: 2 pointer approach + 2 sum
    public List<List<Integer>> threeSum1(int[] nums) 
    {
        Set<List<Integer>> res = new HashSet<>();
        //Step 1: Sort the array
        Arrays.sort(nums); 
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            Set<Integer> set = new HashSet<>();
            for(int j=i+1;j<n;j++)
            {
                int complement = -(nums[i]+nums[j]);//take the complement
                if(set.contains(complement))
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(complement);
                    Collections.sort(list);
                    res.add(list);
                }
                set.add(nums[j]);
            }

        }
        return new ArrayList<>(res);
    }
    //Optimal Approach: Using 2 sum + 2 pointer approach
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();

        //Step 1: Sort the array
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-2;i++)
        {
            //duplicate check
            if(i>0&&nums[i]==nums[i-1])
            continue;
            int start = i+1;
            int end = n-1;
            while(start<end)
            {
                int sum = nums[i]+nums[start]+nums[end];
                if(sum==0)
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    res.add(list);
                    start++;
                    end--;

                    //duplicate checks
                    while(start<end&&nums[start]==nums[start-1])
                    {
                        start++;
                    }
                    while(start<end&&nums[end]==nums[end+1])
                    {
                        end--;
                    }
                }
                else if(sum<0)
                {
                    start++;
                }
                else
                {
                    end--;
                }
            }
        }
        return res;
    }
}
