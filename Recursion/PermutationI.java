class Solution {
    //Intuition: Generate all possible permutation by maintaining the visited elements 
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        generate(nums,res,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }
    private void generate(int[] nums,List<List<Integer>> res,List<Integer> list,boolean[] visited)
    {
        //base case
        if(list.size()==nums.length)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        //recursive: for loop / take or dont take approach
        for(int ind = 0;ind<nums.length;ind++)
        {
            if(visited[ind])
            continue;

            //Mark as visited
            visited[ind]=true;
            list.add(nums[ind]);
            //recurse
            generate(nums,res,list,visited);
            //Backtracking - mark as unvisited and remove from the list 
            visited[ind]=false;
            list.remove(list.size()-1);
        }
    }
}
