import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        long MOD = 1_000_000_007;

        // Step 1: Build the Adjacency List
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            long u = road[0];
            long v = road[1];
            long time = road[2];
            adj.get((int) u).add(new long[]{v, time});
            adj.get((int) v).add(new long[]{u, time}); // Bi-directional roads
        }

        // Step 2: Initialize the Twin Arrays
        long[] dist = new long[n];
        long[] ways = new long[n];
        
        Arrays.fill(dist, Long.MAX_VALUE);
        
        dist[0] = 0;  // Start at intersection 0 with 0 time
        ways[0] = 1;  // There is exactly 1 way to be at the start

        // Step 3: Setup Min-Heap (Priority Queue) sorted by distance
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0}); // {node, current_distance}

        // Step 4: Run Dijkstra with Twin Array Logic
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            int u = (int) current[0];
            long currTime = current[1];

            if (currTime > dist[u]) continue;

            for (long[] neighbor : adj.get(u)) {
                int v = (int) neighbor[0];
                long roadTime = neighbor[1];
                long newTime = currTime + roadTime;

                // Scenario A: Found a strictly faster path to 'v'
                if (newTime < dist[v]) {
                    dist[v] = newTime;
                    ways[v] = ways[u]; // Reset paths to match the parent's paths
                    pq.offer(new long[]{v, dist[v]});
                } 
                // Scenario B: Found an alternate path that ties the record
                else if (newTime == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD; // Combine the paths together
                }
            }
        }

        return (int) ways[n - 1];
    }
}