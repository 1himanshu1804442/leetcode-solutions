class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
   
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        int ans = helper(amount, coins, n - 1, dp);
        return (ans >= (int)1e9) ? -1 : ans;
    }

    public int helper(int target, int[] coins, int index, int[][] dp) {
       
        if (index == 0) {
            if (target % coins[0] == 0) return target / coins[0];
            return (int)1e9;
        }

        if (dp[index][target] != -1) return dp[index][target];

      
        int notPick = helper(target, coins, index - 1, dp);

   
        int pick = (int)1e9;
        if (coins[index] <= target) {
            pick = 1 + helper(target - coins[index], coins, index, dp);
        }

        return dp[index][target] = Math.min(pick, notPick);
    }
}