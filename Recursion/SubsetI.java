class Solution {
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();

        generate(0,res,new ArrayList<>(),nums);

        return res;
    }
    private void generate(int ind,List<List<Integer>> res,List<Integer> currList,int[] nums)
    {
        if(ind>=nums.length)
        {
            res.add(new ArrayList<>(currList));
            return;
        }
        //add
        currList.add(nums[ind]);
        //call
        generate(ind+1,res,currList,nums);//take
        //remove
        currList.remove(currList.size()-1);
        //call
        generate(ind+1,res,currList,nums);//not take
    }
}
