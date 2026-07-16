class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;
        
        int[][][] dp = new int[n][k + 1][2];
        
        for (int[][] dayCache : dp) {
            for (int[] tCache : dayCache) {
                Arrays.fill(tCache, -1);
            }
        }
        
        return solve(prices, 0, k, 0, dp);
    }
    
    private int solve(int[] prices, int day, int t, int hold, int[][][] dp) {
        if (day >= prices.length || t == 0) {
            return 0;
        }
        
        if (dp[day][t][hold] != -1) {
            return dp[day][t][hold];
        }
        
        int profit = 0;
        
        if (hold == 1) {
            int sell = prices[day] + solve(prices, day + 1, t - 1, 0, dp);
            int rest = solve(prices, day + 1, t, 1, dp);
            profit = Math.max(sell, rest);
        } else {
            int buy = -prices[day] + solve(prices, day + 1, t, 1, dp);
            int rest = solve(prices, day + 1, t, 0, dp);
            profit = Math.max(buy, rest);
        }
        
        return dp[day][t][hold] = profit;
    }
}