class Solution {
    class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (n == 1)
            return 0;

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }

        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] { 0, 0, 1 });
        dist[0][1] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int weight = current[0];
            int u = current[1];
            int consec = current[2];

            if (u == n - 1)
                return weight;

            if (weight > dist[u][consec])
                continue;

            for (Edge edge : adj.get(u)) {
                int v = edge.to;
                int w = edge.weight;

                int nextConsec = (labels.charAt(u) == labels.charAt(v)) ? consec + 1 : 1;

                if (nextConsec <= k) {
                    if (weight + w < dist[v][nextConsec]) {
                        dist[v][nextConsec] = weight + w;
                        pq.offer(new int[] { weight + w, v, nextConsec });
                    }
                }
            }
        }

        return -1;

    }
}