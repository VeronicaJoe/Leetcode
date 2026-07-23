class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        generate(0,0,arr,list);//ind,sum
        return list;
    }
    private void generate(int ind,int sum,int[] arr,List<Integer> list)
    {
        if(ind>=arr.length)
        {
            list.add(sum);
            return;
        }
        
        //take
        //call
        generate(ind+1,sum+arr[ind],arr,list);
        //not take
        //call
        generate(ind+1,sum,arr,list);
    }
}
