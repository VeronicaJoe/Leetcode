class Solution {
    //Optimal Solution 1:
    public boolean isIsomorphic1(String s, String t) 
    {
        //Test:
        //badc
        //baba
        //b is already mapped to b - false
        if(s.length()!=t.length())
        return false;
        int len = s.length();
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<len;i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {
                //add to map
                if(map.containsValue(t.charAt(i)))
                return false;
                map.put(s.charAt(i),t.charAt(i));
            }
            else
            {
                if(map.get(s.charAt(i))!=t.charAt(i))
                return false;
            }
        } 
        return true;
    }
    //Optimal Solution 2:
    public boolean isIsomorphic(String s, String t) 
    {
        //Using freq map
        if(s.length()!=t.length())
        return false;
        int[] sCharPos = new int[128];
        int[] tCharPos = new int[128];//128 signifies ascii
        int len = s.length();
        for(int i=0;i<len;i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(sCharPos[ch1]!=tCharPos[ch2])
            return false;
            sCharPos[ch1]=i+1;
            tCharPos[ch2]=i+1;
        }
        //Note: i+1 => to check whether s and t we're seen in the same pos atlast
        return true;
    }
}
