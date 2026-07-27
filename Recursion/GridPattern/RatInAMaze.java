class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> paths = new ArrayList<>();
        generate(0,0,"",paths,maze);
        return paths;
    }
    private void generate(int row,int col,String curr,ArrayList<String> paths,int[][] maze)
    {
        
        //invalid 
        if(row<0||col<0||
           row>=maze.length||col>=maze.length||
           maze[row][col]!=1)
        {
            return;
        }
        
        //base case
        if(row==maze.length-1&&col==maze.length-1)
        {
            paths.add(curr);
            return;
        }
        
        //mark as visted
        int temp = maze[row][col];
        maze[row][col]=-1;
        
        //lexicographical order -> DLRU
         //DOWN
        generate(row+1,col,curr+"D",paths,maze);
         //LEFT
        generate(row,col-1,curr+"L",paths,maze);
        //RIGHT
        generate(row,col+1,curr+"R",paths,maze);
        //UP
        generate(row-1,col,curr+"U",paths,maze);
        
        //bactrack
        //restore
        maze[row][col]=temp;
    }
}
