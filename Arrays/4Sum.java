class Solution {
    //Brute force: 4 for loops
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> ls = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(ls);
                            res.add(ls);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    //Better : HashSet + 3 Sum
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        //i and j = fixed
        //k = variable
        //find the complement 
        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int fourth = target - (nums[i] + nums[j] + nums[k]);
                    if (set.contains(fourth)) {
                        List<Integer> ls = Arrays.asList(nums[i], nums[j], nums[k], fourth);
                        Collections.sort(ls);
                        res.add(ls);
                    }
                    set.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    //Optimal: Sorting + 2 pointer
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //duplicate check
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i+1 && nums[j - 1] == nums[j])
                    continue;

                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> ls = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        res.add(ls);

                        left++;
                        right--;

                        //duplicate check
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        return res;
    }
}
