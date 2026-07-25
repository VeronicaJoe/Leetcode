class Solution {
    //Optimal: Using For Loop Backtracking
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 || target == 0)
            return res;

        generate(0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    private void generate(int ind, int target, int[] arr, List<Integer> currList, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (arr[i] > target)
                continue;

            currList.add(arr[i]);
            generate(i, target - arr[i], arr, currList, res);
            currList.remove(currList.size() - 1);
        }
    }
}
