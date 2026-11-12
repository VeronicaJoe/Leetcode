class Solution {
    //Generating using bit manip
    //                          If ith bit is set then add to string (n&(1<<i))!=0 => SET)
    //                          No of combinations: 2^n eg: n = 3 then. 2^3 = 8
    public List<List<Integer>> subsets1(int[] nums) 
    {
        int len = nums.length;
        int total = 1<<len;//2^n
        List<List<Integer>> res = new ArrayList<>();
        for(int mask = 0;mask<total;mask++)
        {
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<len;i++)
            {
                if((mask&(1<<i))!=0)
                {
                    list.add(nums[i]);
                }
            }
            res.add(list);
        }
        return res;
    }
    //TC: O(2^N*N) -> generating subsets
    //Optimal: Using Recursion - Take/Not Take

    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        generate(nums,0,res,new ArrayList<>());
        return res;
    }
    private void generate(int[] nums,int ind,List<List<Integer>> res,List<Integer> list)
    {
        //Base Condition:
        if(ind>=nums.length)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        //Take
        list.add(nums[ind]);
        generate(nums,ind+1,res,list);
        //Not Take
        list.remove(list.size()-1);
        generate(nums,ind+1,res,list);
    }
}
