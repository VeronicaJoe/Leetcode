class Solution {
    public void solve(char[][] board) 
    {
        int n = board.length,m = board[0].length;
        //Step 1: Boundary 'O's to be converted as '#'
        //Row(0 and n-1)
        for(int col=0;col<m;col++)
        {
            //1st row
            if(board[0][col]=='O')
            dfs(0,col,board);

            //last row
            if(board[n-1][col]=='O')
            dfs(n-1,col,board);
        }
        //Col(0 and m-1)
        for(int row = 0;row<n;row++)
        {
            //1st col
            if(board[row][0]=='O')
            dfs(row,0,board);
            //last col
            if(board[row][m-1]=='O')
            dfs(row,m-1,board);
        }
        //Step 2: Mark all 'O' -> 'X'
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O')
                board[i][j]='X';
            }
        }
        //Step 3: Restore '#' -> 'O'    
                //Row(0 and n-1)
         for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='#')
                board[i][j]='O';
            }
        }
    }
    private void dfs(int row,int col,char[][] board)
    {
        //Edge Case 1:
        if(row<0||col<0||row>=board.length||col>=board[0].length)
        return;

        //Edge Case 2:
        if(board[row][col]=='#'||board[row][col]=='X')
        return;

        board[row][col]='#';

        //up
        dfs(row-1,col,board);
        //down
        dfs(row+1,col,board);
        //left
        dfs(row,col-1,board);
        //right
        dfs(row,col+1,board);
    }
}
