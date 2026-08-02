class Solution {
    //Note: Instead of using a visited array - mark the visited node - 0(Water)
    public int numIslands(char[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int numberOfIslands = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                //1-water (not visited yet)
                if(grid[i][j]=='1')
                {
                    numberOfIslands++;
                    dfs(i,j,grid);
                }
            }
        }
        return numberOfIslands;
    }
    private void dfs(int row,int col,char[][] grid)
    {
        //Edge case 1:
        if(row<0||col<0||row>=grid.length||col>=grid[0].length)
        return;

        //Edge case 2: already visited or its water
        if(grid[row][col]=='0')
        return;

        grid[row][col]='0';//mark as visited

        //up
        dfs(row-1,col,grid);
        //down
        dfs(row+1,col,grid);
        //left
        dfs(row,col-1,grid);
        //right
        dfs(row,col+1,grid);
    }
}
