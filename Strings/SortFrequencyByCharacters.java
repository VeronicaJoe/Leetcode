class Solution {
    public String frequencySort(String s) 
    {
        //Step 1: Count using HashMap
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char ch:s.toCharArray())
        {
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        //Step 2: Store the keys in a list
        List<Character> list = new ArrayList<>(freqMap.keySet());
        //Step 3: Sort the list in desc
        list.sort((a,b)->Integer.compare(freqMap.get(b),freqMap.get(a)));//DESC
        //Step 4: Store the result and return
        StringBuilder res = new StringBuilder();
        for(char ch:list)
        {
            int freq = freqMap.get(ch);
            while(freq>0)
            {
                res.append(ch);
                freq--;
            }
        }
        return res.toString();
    }
}
