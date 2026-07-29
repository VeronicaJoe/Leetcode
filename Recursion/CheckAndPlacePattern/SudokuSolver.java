class Solution {
    public void solveSudoku(char[][] board) 
    {
        solve(board);
    }
    private boolean solve(char[][] board)
    {
        //get the empty cell
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    //Try every number - for-loop backtracking
                    for(char ch='1';ch<='9';ch++)
                    {
                        //check if possible to add num in board[i][j]
                        if(isPossible(i,j,ch,board))
                        {
                            //assign
                            board[i][j]=ch;
                            //check for next empty cell
                            if(solve(board))
                            return true;
                            //backtrack
                            board[i][j]='.';
                        }
                    }
                    return false;//still empty cells left
                }
            }
        }
        return true;//no more empty cell
    }
    private boolean isPossible(int row,int col,char ch,char[][] board)
    {
        //check row
        for(int c=0;c<9;c++)
        {
            if(board[row][c]==ch)
            return false;
        }
        //check col
        for(int r=0;r<9;r++)
        {
            if(board[r][col]==ch)
            return false;
        }
        //check 3x3
        int rowStart = (row/3)*3;
        int colStart = (col/3)*3;

        for(int i=rowStart;i<rowStart+3;i++)
        {
            for(int j=colStart;j<colStart+3;j++)
            {
                if(board[i][j]==ch)
                return false;
            }
        }
        return true;
    }
}
