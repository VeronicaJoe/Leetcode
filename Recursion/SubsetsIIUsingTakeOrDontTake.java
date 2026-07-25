//Brute Force: Take/Dont Take using Set
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        generateSubsets(0,set,new ArrayList<>(),nums);
        List<List<Integer>> list=new ArrayList<>(set);
        return list;    
    }
    private void generateSubsets(int ind,Set<List<Integer>> set,List<Integer> currList,int[] nums)
    {
        if(ind>=nums.length)
        {
            set.add(new ArrayList<>(currList));
            return;
        }

        //add - take
        currList.add(nums[ind]);
        //call
        generateSubsets(ind+1,set,currList,nums);
        //remove - not take
        currList.remove(currList.size()-1);
        //call
        generateSubsets(ind+1,set,currList,nums);
    }
}
