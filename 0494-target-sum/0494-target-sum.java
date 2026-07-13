class Solution {
    static final int MOD=(int)1e9+7;
     public int countPartitions(int n, int d, int[] arr) {
        int total = 0;
        for (int num : arr) total += num;

        // Edge cases
        if (total < d || (total + d) % 2 != 0) return 0;

        int target = (total + d) / 2;
        return countSubsets(arr, target);
    }

    private int countSubsets(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        // Base case initialization
        if (nums[0] == 0)
            dp[0][0] = 2; // either pick or not pick zero
        else
            dp[0][0] = 1; // don't pick anything to get sum 0

        if (nums[0] != 0 && nums[0] <= target)
            dp[0][nums[0]] = 1;

        // Build table
        for (int i = 1; i < n; i++) {
            for (int sum = 0; sum <= target; sum++) {
                int notTake = dp[i - 1][sum];
                int take = 0;
                if (nums[i] <= sum) take = dp[i - 1][sum - nums[i]];
                dp[i][sum] = (take + notTake)%MOD;
            }
        }

        return dp[n - 1][target];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return countPartitions(n,Math.abs(target),nums);
        
    }
}