class Solution {
    //Optimal : Using for loop backtracking
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> res = new ArrayList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        generate(0,n,arr,k,new ArrayList<>(),res);
        return res;
    }
    private void generate(int ind,int target,int[] arr,int len,List<Integer> curr,List<List<Integer>> res)
    {
        if(target==0&&curr.size()==len)
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=ind;i<arr.length;i++)
        {
            if(arr[i]>target)
            break;

            curr.add(arr[i]);
            generate(i+1,target-arr[i],arr,len,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}
