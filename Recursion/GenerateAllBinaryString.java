class Solution {
    public List<String> validStrings(int n) 
    {
        List<String> res = new ArrayList<>();
        generate(n,"",res);

        return res;    
    }
    private void generate(int n,String str,List<String> res)
    {
        if(str.length()==n)
        {
            res.add(str);
            return;
        }

        generate(n,str+"1",res);

        if(str.isEmpty()||str.charAt(str.length()-1)!='0')
        {
            generate(n,str+"0",res);
        }
    }
}
