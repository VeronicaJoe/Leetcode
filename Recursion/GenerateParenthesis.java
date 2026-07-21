class Solution {
    public List<String> generateParenthesis(int n) 
    {
        List<String> list=new ArrayList<>();

        generate(n,"",list,0,0);

        return list;    
    }
    private void generate(int n,String str,List<String> list,int open,int close)
    {
        if(str.length()==2*n)
        {
            list.add(str);
            return;¯
        }

        if(open<n)
        {
            generate(n,str+"(",list,open+1,close);
        }
        if(close<open)
        {
            generate(n,str+")",list,open,close+1);
        }
    }
}
