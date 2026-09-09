class Solution {
    //Linear Search
    //Binary Search (low,mid,high)
    //Approach:
    //          1) Find in which row range does target fall under
    //          2) Perform Binary Search on that row alone
    //TC: O(N)+O(log M)

    public boolean searchMatrix1(int[][] matrix, int target) 
    {
        int n = matrix.length, m = matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==target)
                {
                    return true;
                }
            }
        }    
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) 
    {
        int n = matrix.length, m = matrix[0].length;
        for(int i=0;i<n;i++)
        {
            if(matrix[i][0]<=target&&target<=matrix[i][m-1])
            {
                return binarySearch(matrix[i],target);
            }
        }
        return false;
    }
    public boolean binarySearch(int[] matrix,int target)
    {
        int low = 0,high = matrix.length-1;
        while(low<high)
        {
            int mid = low+high/2;
            if(target<matrix[mid])
            {
                high = mid-1;
            }
            else if(target>matrix[mid])
            {
                low = mid+1;
            }
            else
            {
                return true;//found
            }
        }
        return false;
    }
    //Approach 3: Hypothetically Flatten the 2D -> 1D
    //          -> low = 0; high = n*m-1
    //          -> mid = low+high/2
    //          -> midRow = mid/totalCol
    //          -> midCol = mid%totalCol
    //          -> if(target<matrix[midRow][midCol]) so on other operations
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int n = matrix.length,m=matrix[0].length;
        int low = 0,high = n*m-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int midRow = mid/m;
            int midCol = mid%m;
            if(target<matrix[midRow][midCol])
            {
                high = mid-1;
            }
            else if(target>matrix[midRow][midCol])
            {
                low = mid+1;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
