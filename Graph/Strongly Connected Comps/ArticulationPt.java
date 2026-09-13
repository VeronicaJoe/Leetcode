class Solution {
    static int timer = 1;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) 
    {
        // code here
        ArrayList<Integer> artPt = new ArrayList<>();
        
        //Step 1: Build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        //Step 2: Initial config
        int parent = -1;
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] mark = new boolean[V];//if same node comes as multiple times as A.P. use this mark[]
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                dfs(i,parent,graph,visited,mark,tin,low,artPt);
            }
        }
        for(int i=0;i<V;i++)
        {
            if(mark[i]==true)
            artPt.add(i);
        }
        if(artPt.isEmpty())
        {
            artPt.add(-1);
        }
        return artPt;
    }
    private static void dfs(int node,int parent,List<List<Integer>> graph,boolean[] visited,boolean[] mark,int[] tin,int[] low,ArrayList<Integer> artPt)
    {
        visited[node]=true;
        tin[node] = low[node] = timer++;
        int child = 0;
        //get the adj
        for(int neighbor:graph.get(node))
        {
            if(neighbor==parent)
            continue;
            
            if(!visited[neighbor])
            {
                dfs(neighbor,node,graph,visited,mark,tin,low,artPt);
                low[node]=Math.min(low[node],low[neighbor]);
                //check for art pt
                if(parent!=-1&&low[neighbor]>=tin[node])
                {
                    mark[node]=true;
                }
                child++;
            }
            else
            {
                //neighbor -> visited
                low[node]=Math.min(low[node],tin[neighbor]);
            }
        }
        //Edge Case : If node (root) has more than 1 adj then it is also a A.P.
        if(parent==-1&&child>1)
        {
            mark[node]=true;
        }
    }
}
