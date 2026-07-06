class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>()); // 1-indexed nodes

        for (int[] t : times) {
            adj.get(t[0]).add(new Pair(t[1], t[2]));
        }

        // Dijkstra
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e9);
        dist[k] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Tuple(k, 0));

        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int node = curr.node;
            int d = curr.distance;

            if (d > dist[node]) continue; // already found a shorter path

            for (Pair p : adj.get(node)) {
                int nextNode = p.first;
                int weight = p.second;

                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.add(new Tuple(nextNode, dist[nextNode]));
                }
            }
        }

        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int)1e9) return -1; // unreachable node
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist;
    }
}

class Tuple {
    int node;
    int distance;
    Tuple(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Pair {
    int first; // destination node
    int second; // weight
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
