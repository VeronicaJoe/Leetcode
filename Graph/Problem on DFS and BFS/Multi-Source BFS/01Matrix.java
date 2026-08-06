class Solution {
    public int[][] updateMatrix(int[][] mat) 
    {
        //Muti-source BFS

        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(mat[i][j]==0)
                {
                q.offer(new int[]{i,j});
                dist[i][j]=0;
                }
                else
                dist[i][j]=-1;//unvisited ones
            }
            
        }   

        //perform muti-source BFS
        int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
            int size = q.size();
            while(!q.isEmpty())
            {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                for(int[] d:DIR)
                {
                    int nr = r+d[0];
                    int nc = c+d[1];

                    if(nr>=0&&nc>=0&&nr<rows&&nc<cols&&dist[nr][nc]==-1)
                    {
                        dist[nr][nc]=dist[r][c]+1;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        } 
        return dist;
    }
}
