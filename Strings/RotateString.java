class Solution {
    //Optimal: Rotate String
    public boolean rotateString1(String s, String goal) 
    {
        if(s.length()!=goal.length())
        return false;
        s = s+s;
        return s.contains(goal);
    }
    //Brute Force: Check every possible rotation
    public boolean rotateString(String s, String goal) 
    {
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            s = s.substring(1)+s.charAt(0);
            if(s.equals(goal))
            return true;
        }
        return false;
    }
}
