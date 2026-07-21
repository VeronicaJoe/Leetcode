class Solution {
    public List<String> powerSet(String s) {
        // Code here
        List<String> list = new ArrayList<>();
        
        int n=s.length();
        int total = 1<<n;//2^n
        
        for(int i=0;i<total;i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++)
            {
                if((i&(1<<j))!=0)
                {
                    sb.append(s.charAt(j));
                }
            }
            list.add(sb.toString());
        }
        Collections.sort(list);
        return list;
    }
}
