class Solution {
    //Brute Force: Using Bit Manip check if a ith bit is set and consider
    static boolean isSubsetSum(int[] arr,int sum)
    {
        int n = arr.length;
        int total = 1<<n;
        for(int mask = 0;mask<total;mask++)
        {
            int computeSum = 0;
            for(int bit = 0;bit<n;bit++)
            {
                if((mask&(1<<bit))!=0)
                {
                    computeSum+=arr[bit];
                }
            }
            if(computeSum==sum)
            return true;
        }
        return false;
    }
    //Optimal: Using recursion [Take and Dont Take]
    static boolean isSubsetSum1(int arr[], int sum) {
        // code here
        return findSubsetSum(arr,sum,0);
    }
    static boolean findSubsetSum(int[] arr,int target,int ind)
    {
        //base case:
        if(target==0)
        return true;
        
        if(ind>=arr.length||target<0)
        return false;
        
        //take and dont take
        return findSubsetSum(arr,target-arr[ind],ind+1)||findSubsetSum(arr,target,ind+1);
    }
}
