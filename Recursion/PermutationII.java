class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        generate(nums,res,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }
    private void generate(int[] nums,List<List<Integer>> res, List<Integer> list,boolean[] visited)
    {
        //base case:
        if(list.size()==nums.length)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int ind = 0;ind<nums.length;ind++)
        {
            //The first occurrence of a number must be used before its second occurrence.
            if(visited[ind]||(ind>0&&nums[ind]==nums[ind-1]&&!visited[ind-1]))
            {
                continue;
            }

            visited[ind]=true;
            list.add(nums[ind]);
            generate(nums,res,list,visited);
            visited[ind]=false;
            list.remove(list.size()-1);
        }
    }
}
