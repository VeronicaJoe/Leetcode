class Solution {
    //logic: For each row : n-findFirstOneIndex
    public int rowWithMax1s(int[][] arr) {
        // code here
        int n = arr.length,m = arr[0].length;
        int maxOnes = -1;
        int maxOnesRow = -1;
        for(int i=0;i<n;i++)
        {
            int ones = binarySearch(arr[i]);
            if(ones>maxOnes)
            {
                maxOnes = ones;
                maxOnesRow = i;
            }
        }
        return maxOnesRow;

    }
    private int binarySearch(int[] arr)
    {
        int n = arr.length;
        int low = 0,high = n-1;
        int candidate=Integer.MIN_VALUE;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid]==1)
            {
                //move left
                candidate = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return (candidate==Integer.MIN_VALUE)?candidate:n-candidate;
    }
};
