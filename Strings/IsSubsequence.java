class Solution {
    //2 pointer pattern:
    public boolean isSubsequence1(String s, String t) 
    {
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder t1 = new StringBuilder(t);
        int i = 0;
        int j = 0;
        while(j<t1.length()&&i<s1.length())
        {
            if(t1.charAt(j)!=s1.charAt(i))
            {
                t1.deleteCharAt(j);
            }
            else
            {
                //only if matched move i(s)
                i++;
                j++;
            }
        }
        return i==s.length();
    }
    //Optimal Approach: Without deleting char but moving the index alone
    public boolean isSubsequence(String s,String t)
    {
        int i=0,j=0;
        while(i<s.length()&&j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
            }
            j++;
        }
        return i==s.length();
    }
}
