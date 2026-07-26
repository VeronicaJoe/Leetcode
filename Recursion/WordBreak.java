class Solution {
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        return generateSplits(0,s,wordDict); 
    }
    private boolean generateSplits(int start,String s,List<String> wordDict)
    {
        //base case
        if(start==s.length())
        return true;

        for(int end = start;end<s.length();end++)
        {
            String subStr = s.substring(start,end+1);
            if(wordDict.contains(subStr))
            {
                if(generateSplits(end+1,s,wordDict))
                return true;
            }
        }
        return false;
    }
}
