class Solution {
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for(int num=1;num<=n;num++)
        {
            nums[num-1]=num;
        }
        generate(0,nums,res,new ArrayList<>(),k);
        return res;    
    }
    private void generate(int ind,int[] nums,List<List<Integer>> res,List<Integer> currList,int k)
    {
        //base case
        if(currList.size()==k)
        {
            res.add(new ArrayList<>(currList));
            return;
        }

        //for loop backtracking
        for(int i=ind;i<nums.length;i++)
        {
            currList.add(nums[i]);
            generate(i+1,nums,res,currList,k);
            currList.remove(currList.size()-1);
        }
    }
}
