class Solution {
    //Brute Force: Hypothetically double the array and compare next elements one by one
    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        for (int i = 0; i < n; i++) {
            nge[i] = -1;
            for (int j = i + 1; j <= i + n - 1; j++) {
                int ind = j % n;
                if (nums[ind] > nums[i]) {
                    nge[i] = nums[ind];
                    break;
                }
            }
        }
        return nge;
    }

    //Optimal: Hypothetically double the array and find nge from right -> left
    //         If i < n => store the nge to res
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] nge = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            int ind = i % n;
            while (!st.isEmpty() && st.peek() <= nums[ind]) {
                st.pop();
            }
            if (i < n) {
                if (st.isEmpty()) {
                    nge[i] = -1;
                } else {
                    nge[i] = st.peek();
                }
            }
            st.push(nums[ind]);
        }
        return nge;
    }
}
