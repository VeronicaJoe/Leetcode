class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        for(int via = 0;via<n;via++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][via]==100000000||dist[via][j]==100000000)
                    continue;
                    
                    //no direct edge present - create indirect edge
                    if(dist[i][j]==100000000)
                    dist[i][j] = dist[i][via]+dist[via][j];
                    
                    dist[i][j] = Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                }
            }
        }
    }
}
