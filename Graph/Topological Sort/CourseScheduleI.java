class Solution {
    //Using TOPO Sort(Using Kahns) - Detect Cycle in a Directed Graph (might Cyclic or Acyclic)
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        //Step 1: Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        } 
        for(int[] preReq:prerequisites)
        {
            int courseA = preReq[0];
            int courseB = preReq[1];

            adj.get(courseA).add(courseB);
        }

        //Step 2: Indegree[]
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            for(int course:adj.get(i))
            {
                indegree[course]++;
            }
        }

        //Step 3: Add all courses with 0 indegree into Queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            q.offer(i);
        }

        //Step 4: Perform Kahns Algo
        List<Integer> res = new ArrayList<>();
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
                    indegree[neighbor] = indegree[neighbor]-1;
                    if(indegree[neighbor]==0)
                    q.offer(neighbor);
                }
            }
        }

        return res.size()==numCourses;//no cycle 
    }
}
