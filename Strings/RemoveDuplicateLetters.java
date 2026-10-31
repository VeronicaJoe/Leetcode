
class Solution {
    //Brute Force:
    String removeDuplicates1(String s)
    {
         StringBuilder sb = new StringBuilder();
         for(char ch:s.toCharArray())
         {
            if(sb.indexOf(String.valueOf(ch))==-1)
            {
                sb.append(ch);
            }
         } 
         return sb.toString();
    }
    //Optimal:
    String removeDuplicates(String s)
    {
        //Linked Hash Set - Unique + Maintain Order
        HashSet<Character> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(!set.contains(ch))
            {
                set.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
        
    }
}
