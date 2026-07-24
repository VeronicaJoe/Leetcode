class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length==0||target==0)
        return res;
        generate(0,target,candidates,new ArrayList<>(),res);
        return res;    
    }
    private void generate(int ind,int target,int[] candidates,List<Integer> currList,List<List<Integer>> res)
    {
        //base case
        if(ind==candidates.length)
        {
            if(target==0)
            res.add(new ArrayList<>(currList));
            return;   
        }

        //take
        if(candidates[ind]<=target)
        {
        currList.add(candidates[ind]);
        generate(ind,target-candidates[ind],candidates,currList,res);
        currList.remove(currList.size()-1);
        }
        //dont take
        generate(ind+1,target,candidates,currList,res);
    }
}
