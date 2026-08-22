class Solution {
    public int shortestPath(int[][] mat, int[] src, int[] dest) {
        // code here
        if(mat[src[0]][src[1]]==0||mat[dest[0]][dest[1]]==0)
        return -1;
        if(src[0]==dest[0]&&src[1]==dest[1])
        return 0;
        Queue<int[]> q = new LinkedList<>();//<dist,row,col>
        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);//make each row as large max value
        }
        
        //mark src dist as 0 and add to q
        dist[src[0]][src[1]]=0;
        q.offer(new int[]{0,src[0],src[1]});
        int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
            int[] node = q.poll();//{dist,row,col}
            int row = node[1];
            int col = node[2];
            int nodeDist = node[0];
            
            //get the neighbors
            //right,left,up,down
            for(int i=0;i<4;i++)
            {
                
                int nr = row+DIR[i][0];//row
                int nc = col+DIR[i][1];//col

                if(nr>=0&&nc>=0&&nr<n&&nc<m&&mat[nr][nc]!=0)//not blocked
                {
                    if(nodeDist+1<dist[nr][nc])//dist check
                    {
                        if(nr==dest[0]&&nc==dest[1])//reached dest
                        {
                            return nodeDist+1;
                        }
                        dist[nr][nc] = nodeDist+1;
                        q.offer(new int[]{dist[nr][nc],nr,nc});
                    }
                }
            }
        }
        return -1;//dest cannot be reached from the src,
    }
}
