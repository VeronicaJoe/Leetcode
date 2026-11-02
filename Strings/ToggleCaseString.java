class Solution {
    public String toggleCase(String s) {
        // code here
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(Character.isLowerCase(ch))
            {
                sb.append(Character.toUpperCase(ch));
            }
            else
            {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }
}
