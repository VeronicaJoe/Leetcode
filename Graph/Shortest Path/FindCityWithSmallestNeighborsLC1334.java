class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //Using Floyd Warshall
        //Step 1: Constuct graph - adjacency matrix
        int[][] dist = new int[n][n];
        int inf = (int)1e9;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], inf);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //diagonal
                if (i == j)
                    dist[i][j] = 0;
            }
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            //bidirectional
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        //Step 2: Perform Floyd Warshall
        for(int via = 0;via<n;via++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][via]==inf||dist[via][j]==inf)
                    continue;

                    //no direct edge
                    if(dist[i][j]==inf)
                    {
                        dist[i][j]=dist[i][via]+dist[via][j];
                    }

                    dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                }
            }
        }

        //Step 3:Traverse through the last generated dist and keep a cnt of cnt, maxCnt and city
        int city = -1,maxCnt = inf;
        for(int i=0;i<n;i++)
        {
            int cnt =0;
            for(int j=0;j<n;j++)
            {
                if(i!=j&&dist[i][j]<=distanceThreshold)
                cnt++;
            }
            if(cnt<=maxCnt)
            {
                maxCnt = cnt;
                city = i;
            }
        }
        return city;
    }
}
