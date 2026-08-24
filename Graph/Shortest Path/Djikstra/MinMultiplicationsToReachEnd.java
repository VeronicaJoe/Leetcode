class Solution {
    public int minSteps(int[] arr, int start, int end) 
    {
        int MOD = 1000;
        // code here
        if(start==end)
        return  0;
        
        //Step 1: intial configurations
        int[] dist = new int[1000];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        Queue<int[]> q = new LinkedList<>();//<steps,num>
        q.offer(new int[]{0,start});
        
        while(!q.isEmpty())
        {
            int[] popped = q.poll();
            int step = popped[0];
            int num = popped[1];
            
            for(int factor:arr)
            {
                int newStart = (num*factor)%MOD;
                if(step+1<dist[newStart])
                {
                    if(newStart==end)
                    return step+1;
                    dist[newStart] = step+1;
                    q.offer(new int[]{dist[newStart],newStart});
                }
            }
        }
        return -1;
        
    }
}
