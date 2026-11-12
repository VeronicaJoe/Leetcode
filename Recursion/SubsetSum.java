class Solution {
    //Brute Force: Using Bit Manip
    public ArrayList<Integer> subsetSums(int[] arr)
    {
        int n = arr.length;
        int total = 1<<n;
        ArrayList<Integer> res = new ArrayList<>();
        for(int mask = 0;mask<total;mask++)
        {
            int sum = 0;
            for(int i=0;i<n;i++)
            {
                if((mask&(1<<i))!=0)
                {
                    sum+=arr[i];
                }
            }
            res.add(sum);
        }
        return res;
    }
    //Optimized Version:
    public ArrayList<Integer> subsetSums1(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        generateSubsetSums(arr,res,0,0);
        return res;
    }
    private void generateSubsetSums(int[] arr,ArrayList<Integer> res, int ind,int sum)
    {
        if(ind>=arr.length)
        {
            res.add(sum);
            return;
        }
        
        //take
        generateSubsetSums(arr,res,ind+1,sum+arr[ind]);
        //dont take
        generateSubsetSums(arr,res,ind+1,sum);
    }
    
}
