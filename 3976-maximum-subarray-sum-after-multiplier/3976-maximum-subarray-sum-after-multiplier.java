class Solution {
    Long memo[][];
    public long maxSubarraySum(int[] nums, int k) {
        long globalMax = (long) -1e17;
        int n = nums.length;

        memo = new Long[n][3];
        for (int i = 0; i < n; i++) {
            globalMax = Math.max(globalMax, solve(i, 1, k, true, nums));
            globalMax = Math.max(globalMax, solve(i, 2, k, true, nums));
        }
        memo = new Long[n][3];
        for (int i = 0; i < n; i++) {
            globalMax = Math.max(globalMax, solve(i, 1, k, false, nums));
            globalMax = Math.max(globalMax, solve(i, 2, k, false, nums));
        }

        return globalMax;
        
    }
    public long solve(int i, int state, int k, boolean isMulti, int[] nums) {
        if (i == 0) {
            if (state == 0) return nums[i];
            else if (state == 1) return isMulti ? (long)nums[i] * k : nums[i] / k;
            else if (state == 2) return (long) -1e17;
        }
        
        if (memo[i][state] != null) {
            return memo[i][state];
        }
        
        long val = nums[i];
        long mod = isMulti ? val * k : val / k;
        long ans = (long) -1e17;
        
        if (state == 0) {
            ans = Math.max(val, solve(i - 1, 0, k, isMulti, nums) + val);
        }
        if (state == 1) {
       
            ans = Math.max(mod, Math.max(solve(i - 1, 0, k, isMulti, nums) + mod, solve(i - 1, 1, k, isMulti, nums) + mod));
        }
        if (state == 2) {
            ans = Math.max(solve(i - 1, 1, k, isMulti, nums) + val, solve(i - 1, 2, k, isMulti, nums) + val);
        }
        
        
        return memo[i][state] = ans;
    }
}