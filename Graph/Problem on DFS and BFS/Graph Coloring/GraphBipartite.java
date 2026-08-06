class Solution {
    public boolean isBipartite(int[][] graph) {
       // color the graph with 2 colors such that no adjacent nodes have same color. 

        int vertices = graph.length;
        //note: neighbors already constructed
        int[] colors = new int[vertices];
        Arrays.fill(colors,-1);//unvisited

        Queue<Integer> q = new LinkedList<>();
        int color = 0;

        for(int i=0;i<vertices;i++)
        {
            if(colors[i]==-1)
            {
            if(!bfs(i,color,q,colors,graph))
            return false;
            }
        }
return true;
}

    private boolean bfs(int n, int color, Queue<Integer> q, int[] colors, int[][] graph) {

        q.offer(n);
        colors[0] = color;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                int nodeColor = colors[node];

                int neighborColor = nodeColor == 1 ? 0 : 1;
                for (int neighbor : graph[node]) {
                    if (colors[neighbor] != -1) {
                        if (colors[neighbor] == nodeColor) {
                            return false;
                        }
                        //neighbor!=nodeColor
                    } else {
                        //unvisited
                        q.offer(neighbor);
                        colors[neighbor] = neighborColor;
                    }
                }

            }
        }
        return true;
    }
}
