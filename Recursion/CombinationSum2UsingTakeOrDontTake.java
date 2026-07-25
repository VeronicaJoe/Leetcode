class Solution {
    //Brute Force: Using Take /Dont Take (Set)
    public List<List<Integer>> combinationSum21(int[] candidates, int target) 
    {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        generate1(0,target,candidates,new ArrayList<>(),res);
        return new ArrayList<>(res);    
    }
    private void generate1(int ind,int target,int[] arr,List<Integer> list,Set<List<Integer>> res)
    {
        //base case
        if(ind==arr.length)
        {
            if(target==0)
            res.add(new ArrayList<>(list));
            return;
        }

        //take
        if(arr[ind]<=target)
        {
            list.add(arr[ind]);
            generate1(ind+1,target-arr[ind],arr,list,res);
            list.remove(list.size()-1);
        }
        //dont take
        generate1(ind+1,target,arr,list,res);
    }
}
