class Solution {
    public boolean exist(char[][] board, String word) 
    {
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(generate(i,j,0,board,word))
                return true;
            }
        }    
        return false;
    }
    private boolean generate(int row,int col,int ind,char[][] board,String word)
    {
        //word found
        if(ind==word.length())
        return true;

        //invalid cell
        if(row<0||col<0||
           row>=board.length||col>=board[0].length||
           board[row][col]!=word.charAt(ind))
        {
            return false;
        }

        //char matched
        //mark as visited
        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = generate(row-1,col,ind+1,board,word)||
                        generate(row+1,col,ind+1,board,word)||
                        generate(row,col+1,ind+1,board,word)||
                        generate(row,col-1,ind+1,board,word);
        
        //backtrack
        board[row][col]=temp;//restore

        return found;
    }
}
