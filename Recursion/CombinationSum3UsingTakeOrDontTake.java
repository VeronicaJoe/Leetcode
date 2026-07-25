class Solution {
    //Brute Force: Using Take / Dont Take
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        Set<List<Integer>> res = new HashSet<>();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        generate(0,n,arr,k,new ArrayList<>(),res);
        return new ArrayList<>(res);    
    }
    private void generate(int ind,int target,int[] arr,int len,List<Integer> curr,Set<List<Integer>> set)
    {
        if(ind>=arr.length)
        {
            if(target==0&&curr.size()==len)
            {
                set.add(new ArrayList<>(curr));
            }
            return;
        }

        //take
        if(arr[ind]<=target)
        {
            curr.add(arr[ind]);
            generate(ind+1,target-arr[ind],arr,len,curr,set);
            curr.remove(curr.size()-1);
        }
        generate(ind+1,target,arr,len,curr,set);
    }
}
