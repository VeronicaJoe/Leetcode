class Solution {
     public List<List<String>> partition(String s) 
    {
        // code here
        List<List<String>> res = new ArrayList<>();
        generate(0,s,new ArrayList<>(),res);
        return res;
    }
    private void generate(int start,String s,List<String> curr,List<List<String>> res)
    {
        //base case
        if(start==s.length())
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        //recursive
        for(int end = start;end<s.length();end++)
        {
            String subStr = s.substring(start,end+1);
            if(palindrome(subStr))
            {
                curr.add(subStr);
                generate(end+1,s,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean palindrome(String s)
    {
        int start = 0, end = s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            return false;
            start++;
            end--;
        }
        return true;
    }
}
