class Solution1 {
    //Intuition:
    //          In each level choose a digit
    //          Each branch represents the each letter of the digit
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) 
    {
        List<String> res = new ArrayList<>();
        if(digits.length()==0)
        return res;

        backtrack(digits,0,"",res);
        return res;
    }
    private void backtrack(String digits,int index,String curr,List<String> res)
    {
        //base case:
        if(index==digits.length())
        {
            res.add(curr);
            return;
        }

        String letters = map[digits.charAt(index)-'0'];
        //for each letter - backtrack
        for(int i=0;i<letters.length();i++)
        {
            backtrack(digits,index+1,curr+letters.charAt(i),res);
        }
    }
}
//Take and Not Take
class Solution 
{
    //Intuition:
    //          In each level choose a digit
    //          Each branch represents the each letter of the digit
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) 
    {
        List<String> res = new ArrayList<>();
        if(digits.length()==0)
        {
            return res;
        }

        backtrack(digits,0,new StringBuilder(),res);
        return res;
    }
    private void backtrack(String digits,int ind,StringBuilder curr,List<String> res)
    {
        //base case
        if(ind==digits.length())
        {
            res.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(ind)-'0'];
        for(int i=0;i<letters.length();i++)
        {
            curr.append(letters.charAt(i));
            backtrack(digits,ind+1,curr,res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
