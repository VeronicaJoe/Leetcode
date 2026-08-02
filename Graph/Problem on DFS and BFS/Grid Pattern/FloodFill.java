class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int oldColor = image[sr][sc];
        dfs(image,sr,sc,color,oldColor);
        return image;
    }
    private void dfs(int[][] image,int sr,int sc,int color,int oldColor)
    {
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length)
        return;
        if(image[sr][sc]!=oldColor||image[sr][sc]==color)
        {
            return;
        }

        image[sr][sc]=color;
        //up
        dfs(image,sr-1,sc,color,oldColor);
        //down
        dfs(image,sr+1,sc,color,oldColor);
        //right
        dfs(image,sr,sc+1,color,oldColor);
        //left
        dfs(image,sr,sc-1,color,oldColor);
    }
}
