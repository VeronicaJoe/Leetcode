class Solution {
    //Approach(1): Using Horizontal Scanning
    public String longestCommonPrefix1(String[] strs) 
    {
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++)
        {
            while(!strs[i].startsWith(prefix))
            {
                //remove letter one by one and check
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.length()==0)
                return "";
            }
        }
        return prefix;
    }
    //Approach(2): Using Vertical Scanning
    public String longestCommonPrefix(String[] strs) 
    {
        for(int i=0;i<strs[0].length();i++)
        {
            char ch = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++)
            {
                if(i>=strs[j].length()||strs[j].charAt(i)!=ch)
                return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
    //TC: O(N X M) SC: O(1)
}
