import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        
        // 1. Build the Adjacency List
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        
        // 2. Binary Search for the maximum bottleneck (minimum edge cost)
        int low = 0;
        int high = 1_000_000_000; // Max possible edge cost given in constraints
        int maxScore = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if there is a path where EVERY edge is >= mid and total cost <= k
            if (isValidDijkstra(mid, n, adj, online, k)) {
                maxScore = mid;  // This score works, try to find a higher one
                low = mid + 1;
            } else {
                high = mid - 1;  // This score is too strict, lower the threshold
            }
        }
        
        return maxScore;
    }
    
    // Helper function using Dijkstra's Algorithm
    private boolean isValidDijkstra(int minEdgeCost, int n, List<int[]>[] adj, boolean[] online, long k) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        // Min-Heap ordered by the total accumulated cost to reach the node
        // Array format: {node_index, current_total_cost}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0L});
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];
            
            // Stale state check: If we found a shorter path to u already, skip it
            if (d > dist[u]) {
                continue;
            }
            
            // Early exit: We reached the target node, check if the cost is valid
            if (u == n - 1) {
                return dist[u] <= k;
            }
            
            for (int[] edge : adj[u]) {
                int v = edge[0];
                int cost = edge[1];
                
                // Skip the edge if the destination is offline or the cost is below our binary search threshold
                if (!online[v] || cost < minEdgeCost) {
                    continue;
                }
                
                // Relaxation step
                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                    pq.offer(new long[]{v, dist[v]});
                }
            }
        }
        
        // If we exhaust the queue, check if the target node was ever reached within cost k
        return dist[n - 1] <= k;
    }
}