class Solution {
    //Compute NGE for nums2
    //Use hashmap and get nge for nums1
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        int n=nums1.length;
        int[] res = new int[n];
        Map<Integer,Integer> nums2NGE = helperNGE(nums2);
        for(int i=0;i<n;i++)
        {
            res[i]=nums2NGE.get(nums1[i]);
        }
        return res;
    }
    private Map helperNGE(int[] nums)
    {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        Map<Integer,Integer> nge = new HashMap<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&st.peek()<=nums[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nge.put(nums[i],-1);
            }
            else
            {
                nge.put(nums[i],st.peek());
            }
            st.push(nums[i]);
        }
        return nge;
    }
}
