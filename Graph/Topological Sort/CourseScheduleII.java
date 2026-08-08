class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Step 1: Build Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        //Step 2: indegree[]
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] preReq : prerequisites) {
            int courseA = preReq[0];
            int courseB = preReq[1];

            adj.get(courseB).add(courseA);
            indegree[courseA]++;
        }

        Queue<Integer> q = new LinkedList<>();
        //Step 3: Add all nodes with indegree 0 into queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        //Step 4: Perform BFS using Kahns
        int[] courses = new int[numCourses];
        int ind = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                courses[ind++] = node;

                //get the neighbors
                for (int neighbor : adj.get(node)) {
                    indegree[neighbor] = indegree[neighbor] - 1;
                    if (indegree[neighbor] == 0)
                        q.offer(neighbor);
                }
            }
        }
        //Edge Case:
        if (ind != numCourses)
            return new int[] {};

        return courses;
    }
}
