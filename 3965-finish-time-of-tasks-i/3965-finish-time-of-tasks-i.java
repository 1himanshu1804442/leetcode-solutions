class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }
        
        return dfs(0, adj, baseTime);
    }
    private long dfs(int node, List<Integer>[] adj, int[] baseTime) {
        if (adj[node].isEmpty()) {
            return baseTime[node];
        }
        
        long earliest = Long.MAX_VALUE;
        long latest = Long.MIN_VALUE;
        
        for (int child : adj[node]) {
            long childFinishTime = dfs(child, adj, baseTime);
            earliest = Math.min(earliest, childFinishTime);
            latest = Math.max(latest, childFinishTime);
        }
        
        long ownDuration = (latest - earliest) + baseTime[node];
        return latest + ownDuration;
    }
    
}