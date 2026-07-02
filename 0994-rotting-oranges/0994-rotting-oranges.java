class Solution {
    static class Pair {
        int r;
        int c;
        int t;

        public Pair(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;

        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 2;
                    q.add(new Pair(i, j, 0));

                } else if (grid[i][j] == 0) {
                    vis[i][j] = 0;

                } else {
                    cnt++;
                }

            }
        }
        int nrow[] = { -1, 0, 1, 0 };
        int ncol[] = { 0, -1, 0, 1 };
        int time = 0;
        int cntFresh = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;
            time = p.t;

            for (int i = 0; i < 4; i++) {
                int rw = row + nrow[i];
                int cl = col + ncol[i];
                if (rw >= 0 && rw < m && cl >= 0 && cl < n && vis[rw][cl] == 0 && grid[rw][cl] == 1) {
                    vis[rw][cl] = 2;
                    q.add(new Pair(rw, cl, time + 1));
                    cntFresh++;

                }

            }
        }
        if (cnt != cntFresh)
            return -1;
       
        return time;

    }
}