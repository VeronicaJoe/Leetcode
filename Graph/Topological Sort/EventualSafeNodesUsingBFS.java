    //Using BFS (Kahns Algo)
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        List<Integer> res = new ArrayList<>();
        //Step 1: Reverse the edges and add to Adjacency List
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int neighbor:graph[i])
            {
                adj.get(neighbor).add(i);
                indegree[i]++;
            }
        }
        //Step 2: Add all nodes with indegree 0 -> queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            q.offer(i);
        }

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int node = q.poll();
                res.add(node);

                //get the neighbors
                for(int neighbor:adj.get(node))
                {
                    indegree[neighbor]--;
                    if(indegree[neighbor]==0)
                    q.offer(neighbor);
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}
