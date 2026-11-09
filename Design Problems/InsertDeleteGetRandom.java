class RandomizedSet {

    //Using 2 D.S.
    Map<Integer,Integer> map;//value -> index (note: we are storing index so that we can delete in O(1))
    List<Integer> list;
    Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) 
    {
        if(map.containsKey(val))    
        {
            return false;
        }
        map.put(val,list.size());
        list.add(val);

        return true;
    }
    
    public boolean remove(int val) 
    {
        if(!map.containsKey(val))
        return false;

        //1) get the index
        int index = map.get(val);
        //2) get the last element in the list
        int newVal = list.get(list.size()-1);
        //3) update the newVal in the index in the list
        list.set(index,newVal);
        //4) remove the last element in list
        list.remove(list.size()-1);
        //5) update the index value in the map
        map.put(newVal,index);

        //6) remove the actual val from map
        map.remove(val);   

        return true; 
    }
    
    public int getRandom() {
        int index = random.nextInt(list.size());//0->n-1(we randomly get a index)
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
