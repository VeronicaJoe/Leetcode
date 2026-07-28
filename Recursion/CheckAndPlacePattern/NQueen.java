class Solution {
    public List<List<String>> solveNQueens(int n) 
    {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        //fill the board with .
        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i],'.');//fill . row-wise
        }    
        generate(0,board,res);
        return res;
    }
    private void generate(int row,char[][] board,List<List<String>> res)
    {
        //base - if valid board found
        if(row==board.length)
        {
            List<String> curr = new ArrayList<>();
            for(char[] r:board)
            {
                curr.add(new String(r));
            }
            res.add(curr);
            return;
        }

        //for a particular row try every column
        //r0 -> c0,c1,c2,c3 for n=4
        for(int col=0;col<board.length;col++)
        {
            //check if safe to place the queen
            if(isSafe(row,col,board))
            {
                //place
                board[row][col]='Q';
                //next row
                generate(row+1,board,res);
                //backtrack
                board[row][col]='.';
            }
        }
    }
    private boolean isSafe(int row,int col,char[][] board)
    {
        //check column
        for(int r=0;r<board.length;r++)
        {
            if(board[r][col]=='Q')
            return false;
        }
        //check left-upper diagonal
        int r = row-1,c = col-1;
        while(r>=0&&c>=0)
        {
            if(board[r][c]=='Q')
            return false;

            r--;
            c--;
        }
        //check right-upper diagonal
        r = row-1;
        c=col+1;
        while(r>=0&&c<board.length)
        {
            if(board[r][c]=='Q')
            return false;

            r--;
            c++;
        }
        return true;
    }
}
