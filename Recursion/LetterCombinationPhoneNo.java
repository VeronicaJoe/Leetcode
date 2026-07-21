class Solution {
    public List<String> letterCombinations(String digits) 
    {
        List<String> list = new ArrayList<>();
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length()==0)
        return list;

        backtrack(digits,0,"",list,map);   

        return list; 
    }
    private void backtrack(String digits,int ind,String curr,List<String> list,String[] map)
    {
        if(ind==digits.length())
        {
            list.add(curr);
            return;
        }

        String letters = map[digits.charAt(ind)-'0'];

        for(int i=0;i<letters.length();i++)
        {
            backtrack(digits,ind+1,curr+letters.charAt(i),list,map);
        }
    }
}
