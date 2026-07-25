class Solution {
    //Optimal: Using For Loop Backtracking
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length==0||target==0)
        return res;
        Arrays.sort(candidates);
        generate(0,target,candidates,new ArrayList<>(),res);
        return res;
    }
    private void generate(int ind,int target,int[] arr,List<Integer> currList,List<List<Integer>> res)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(currList));
            return;
        }

        for(int i=ind;i<arr.length;i++)
        {
            //duplicate check
            if(i>ind&&arr[i]==arr[i-1])
            {
                continue;
            }
            if(arr[i]>target)
            {
                break;
            }

            currList.add(arr[i]);
            generate(i+1,target-arr[i],arr,currList,res);
            currList.remove(currList.size()-1);
        }
    }
}
