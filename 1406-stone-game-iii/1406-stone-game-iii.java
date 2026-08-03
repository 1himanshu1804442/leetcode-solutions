class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] dp = new Integer[n];
        
        int scoreDiff = solve(stoneValue, 0, n, dp);
        
        if (scoreDiff > 0) return "Alice";
        if (scoreDiff < 0) return "Bob";
        return "Tie";
    }
    
    public int solve(int[] stone, int ind, int n, Integer[] dp) {
        if (ind >= n) {
            return 0;
        }
        
        if (dp[ind] != null) {
            return dp[ind];
        }
        
        int pickone = stone[ind] - solve(stone, ind + 1, n, dp);
        
        int picktwo = Integer.MIN_VALUE;
        if (ind + 1 < n) {
            picktwo = stone[ind] + stone[ind + 1] - solve(stone, ind + 2, n, dp);
        }
        
        int pickthree = Integer.MIN_VALUE;
        if (ind + 2 < n) {
            pickthree = stone[ind] + stone[ind + 1] + stone[ind + 2] - solve(stone, ind + 3, n, dp);
        }
        
        return dp[ind] = Math.max(pickone, Math.max(picktwo, pickthree));
    }
}