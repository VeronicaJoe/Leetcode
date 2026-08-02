class Solution {
    public int numEnclaves(int[][] grid) 
    {
        int n = grid.length, m =grid[0].length;
        int enclaves = 0;
        //Step 1: Make row 1 and n-1 (1's) and connected 1's as 0
        for(int col = 0;col < m;col++)
        {
            //1st row
            if(grid[0][col]==1)
            dfs(0,col,grid);

            //last row
            if(grid[n-1][col]==1)
            dfs(n-1,col,grid);
        }
        //Step 2: Make col 1 and m-1 (1's) and connected 1's as 0
        for(int row = 0;row < n;row++)
        {
            //1st col
            if(grid[row][0]==1)
            dfs(row,0,grid);

            //last col
            if(grid[row][m-1]==1)
            dfs(row,m-1,grid);
        }
        //Step 3: Count the 1s from grid - enclaves   
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                enclaves++;
            }
        } 
        return enclaves;
    }
    private void dfs(int row,int col,int[][] grid)
    {
        //boundary check
        if(row<0||col<0||row>=grid.length||col>=grid[0].length)
        return;

        //already visited or sea
        if(grid[row][col]==0)
        return;

        //mark as visited
        grid[row][col]=0;

        dfs(row-1,col,grid);
        dfs(row+1,col,grid);
        dfs(row,col-1,grid);
        dfs(row,col+1,grid);
    }
}
