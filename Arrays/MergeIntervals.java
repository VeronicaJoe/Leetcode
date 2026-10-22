class Solution {
    //Brute Force: Sort the array and compare adjacent intervals and merge them
    //TC: O(NlogN)+O(N^2)
    //SC: O(1) - excluding output space
    public int[][] merge1(int[][] intervals) 
    {
        //Step 1: Sort
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        //Step 2: Compare adjacent intervals
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        for(int i=0;i<n;)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i+1;
            //overlap
            while(j<n&&intervals[j][0]<=end)//2nd interval start <= 1st interval end
            {
                end = Math.max(end,intervals[j][1]);//keep updating the end with maxValue
                j++;
            }
            res.add(new int[]{start,end});
            i=j;
        }
        return res.toArray(new int[res.size()][]);
    }
    //Optimal Solution: Sort + compare the last inserted interval
    //TC: O(NlogN)+O(N)     SC:O(1)
    public int[][] merge(int[][] intervals)
    {
        List<int[]> res = new ArrayList<>();
        //Step 1: Sort 
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        //Step 2: Compare with the last inserted interval
        res.add(intervals[0]);
        int n = intervals.length;
        for(int i=1;i<n;i++)
        {
            int[] prev = res.get(res.size()-1);
            int[] current = intervals[i];

            if(current[0]<=prev[1])
            {
                //overlap
                prev[1] = Math.max(prev[1],current[1]);
            }
            else
            {
                //no overlap
                res.add(current);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
