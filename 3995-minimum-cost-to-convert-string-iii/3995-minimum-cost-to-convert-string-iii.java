import java.util.List;

class Solution {
    Integer[] memo;
    int INF = (int) 1e9; 
    
    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {
        int n = source.length();
        int m = rules.size();
        
        memo = new Integer[n];
        
        int[] actualCosts = new int[m];
        for (int i = 0; i < m; i++) {
            String pattern = rules.get(i).get(0);
            int stars = 0;
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == '*') {
                    stars++;
                }
            }
            actualCosts[i] = costs[i] + stars;
        }
        
        int ans = solve(0, n, source, target, rules, actualCosts);
        return ans >= INF ? -1 : ans;
    }
    
    private int solve(int i, int n, String source, String target, List<List<String>> rules, int[] actualCosts) {
        if (i == n) return 0;
        
        if (memo[i] != null) return memo[i];
        
        int mini = INF;
        
        if (source.charAt(i) == target.charAt(i)) {
            mini = Math.min(mini, solve(i + 1, n, source, target, rules, actualCosts));
        }
        for (int j = 0; j < rules.size(); j++) {
            String pattern = rules.get(j).get(0);
            String replacement = rules.get(j).get(1);
            int len = pattern.length();
            
            if (i + len <= n) {
                boolean isValid = true;
                
                for (int k = 0; k < len; k++) {
                    if (pattern.charAt(k) != '*' && source.charAt(i + k) != pattern.charAt(k)) {
                        isValid = false; 
                        break;
                    }
                    if (replacement.charAt(k) != target.charAt(i + k)) {
                        isValid = false; 
                        break;
                    }
                }
                
                if (isValid) {
                    int nextCost = solve(i + len, n, source, target, rules, actualCosts);
                    
                    if (nextCost != INF) {
                        mini = Math.min(mini, actualCosts[j] + nextCost);
                    }
                }
            }
        }
        return memo[i] = mini;
    }
}