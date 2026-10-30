class Solution {
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
            candidate = i;
        }
        //Step 2:Verify Candidate: check col candidate
        if(candidate==-1)
        return -1;
        for(int row=0;row<n;row++)
        {
            if(row!=candidate)
            {
                if(mat[row][candidate]==0)
                return -1;
            }
        }
        return candidate;
    }
}
