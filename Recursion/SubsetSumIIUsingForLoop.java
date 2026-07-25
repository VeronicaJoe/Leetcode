class Solution {
    //Optimal: Using For Loop Backtracking
    //Note: For-loop Backtracking → No explicit base case; the loop itself stops the recursion.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        generate(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void generate(int ind, int[] arr, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1])
                continue;

            curr.add(arr[i]);
            generate(i + 1, arr, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
