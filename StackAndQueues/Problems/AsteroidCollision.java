class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
        Deque<Integer> st = new ArrayDeque<>();
        int n = asteroids.length;
        if(n==0)
        return new int[]{};

        for(int asteroid:asteroids)
        {
            //curr - pos
            if(asteroid>0)
            {
                st.push(asteroid);
            }
            else
            {
                //curr - neg
                boolean isAlive = true;
                //opp dir: -->(pos) (neg)<--
                while(!st.isEmpty()&&st.peek()>0)
                {
                    if(st.peek()==Math.abs(asteroid))
                    {
                        //pop + no push
                        st.pop();
                        isAlive = false;
                        break;
                    }
                    else if(st.peek()<Math.abs(asteroid))
                    {
                        //pop + push
                        st.pop();
                    }
                    else 
                    {
                        //st.peek > asteroid - no push + no pop
                        isAlive = false;
                        break;
                    }
                }
                if(isAlive)
                {
                    st.push(asteroid);
                }
            }
        }    
        int[] collisions = new int[st.size()];
        int ind = st.size()-1;
        while(!st.isEmpty())
        {
            collisions[ind--] = st.pop();
        }
        return collisions;
    }
}
