class Solution1 {
    //Brute Force
    private boolean knows(int a,int b,int[][] mat)
    {
        return mat[a][b]==1;
    }
    public int celebrity(int mat[][]) 
    {
        // code here
        //Step 1: Identify the candidate
        int candidate = -1;
        int n = mat.length;
        for(int i=0;i<n;i++)
        {
            boolean isCelebrity = true;
            for(int j=0;j<n;j++)
            {
                //Ignore diagonal
                if(i==j)
                continue;
                
                if(knows(i,j,mat)||!knows(j,i,mat))
                {
                    isCelebrity = false;
                    break;
                }
            }
            if(isCelebrity)
           return i;
        }
        return -1;
    }
}
//Optimal:
class Solution {
    //Brute Force
    private boolean knows(int a,int b,int[][] mat)
    {
        return mat[a][b]==1;
    }
    public int celebrity(int mat[][]) 
    {
        int n = mat.length;
        //Step 1: Identify the Candidate
        int candidate = 0;
        for(int i=1;i<n;i++)
        {
            if(knows(candidate,i,mat))
            candidate = i;
        }
        
        //Step 2: Verify the candidate
        for(int i=0;i<n;i++)
        {
            if(i==candidate)
            continue;
            
            if(knows(candidate,i,mat)||!knows(i,candidate,mat))
            return -1;
        }
        return candidate;
    }
}
