class Solution {
    //We have 2 choices:
    //                  1)Append 1
    //                  2)Append 0
    //We can append 1 in all cases
    //Bute we can append 0 only when prev char!=0
    public List<String> validStrings(int n) 
    {
        List<String> res = new ArrayList<>();
        generate(n,"",res);
        return res;    
    }
    private void generate(int n,String curr,List<String> res)
    {
        if(curr.length()==n)
        {
            res.add(curr);
            return;
        }
        generate(n,curr+"1",res);
        if(curr.isEmpty()||curr.charAt(curr.length()-1)!='0')
        {
            generate(n,curr+"0",res);
        }
    }
}
