class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        //src = {0,0}
        //dest = {n-1,n-1}

        //0 -> allowed and 1 -> blocked

        //directions : 8 dir (up,down,left,right,diagonals)
        int n = grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1)
        return -1;//blocked path

        if(n==1)
        return 1;//single cell - start==end

         //Step 1: Queue , Dist and Dir configurations
        Queue<int[]> q = new LinkedList<>();//{dist,row,col}
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        int[][] DIR = {{0,1},{1,0},{0,-1},{-1,0},{-1,1},{1,-1},{-1,-1},{1,1}};
        //Step 2: Add src to q and update src in dist as 0
        dist[0][0] = 1;
        q.offer(new int[]{1,0,0});//{dist,row,col}

        //Step 3: pop and get the neighbors and compare and add to q and update dist accordingly
        while(!q.isEmpty())
        {
            int[] node = q.poll();
            int row = node[1];
            int col = node[2];
            int nodeDist = node[0];

            //get the adjacents
            for(int i=0;i<8;i++)
            {
                int nr = row+DIR[i][0];
                int nc = col+DIR[i][1];

                if(nr>=0&&nc>=0&&nr<n&&nc<n&&grid[nr][nc]==0)
                {
                    if(nodeDist+1<dist[nr][nc])
                    {
                        if(nr==n-1&&nc==n-1)
                        return nodeDist+1;

                        dist[nr][nc]=nodeDist+1;
                        q.offer(new int[]{dist[nr][nc],nr,nc});
                    }
                }
            }
        }
        return -1;
    }
}
