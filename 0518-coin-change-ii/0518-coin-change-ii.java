import java.util.Arrays;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        // Initialize the DP table: [index][amount]
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return solve(amount, coins, n - 1, dp);
    }
    
    public int solve(int amt, int[] coins, int index, int[][] dp) {
        // Base Case 1: We perfectly hit the target amount
        if (amt == 0) {
            return 1;
        }
        
        // Base Case 2: We are on the last available coin
        if (index == 0) {
            // Can the remaining amount be perfectly made using ONLY this coin?
            if (amt % coins[0] == 0) return 1;
            else return 0;
        }
        
        // Memoization Check
        if (dp[index][amt] != -1) {
            return dp[index][amt];
        }
        
        // Choice 1: Do not pick the coin (Move to the next coin: index - 1)
        int notPick = solve(amt, coins, index - 1, dp);
        
        // Choice 2: Pick the coin (STAY on the same coin: index)
        int pick = 0;
        if (coins[index] <= amt) {
            pick = solve(amt - coins[index], coins, index, dp);
        }
        
        // Store and return the total number of ways
        return dp[index][amt] = pick + notPick;
    }
}