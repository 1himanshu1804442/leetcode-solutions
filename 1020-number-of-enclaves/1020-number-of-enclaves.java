class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int delrow[] = { -1, 0, 1, 0 };
        int delcol[] = { 0, -1, 0, 1 };
        int vis[][] = new int[m][n];
        for (int j = 0; j < n; j++) {
            if (vis[0][j] == 0 && grid[0][j] == 1) {
                dfs(delrow,delcol,0,j,grid,vis,m,n);
            }  if (vis[m - 1][j] == 0 && grid[m - 1][j] == 1) {
                dfs(delrow,delcol,m-1,j,grid,vis,m,n);
            }
        }
        for (int i = 0; i < m; i++) {
            if (vis[i][0] == 0 && grid[i][0] == 1) {
                dfs(delrow,delcol,i,0,grid,vis,m,n);
            }  if (vis[i][n - 1] ==0&& grid[i][n - 1] == 1) {
                dfs(delrow,delcol,i,n-1,grid,vis,m,n);
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    cnt++;

                }
            }
        }
        return cnt;

    }

    public void dfs(int delrow[], int delcol[], int i, int j, int grid[][], int vis[][],int m,int n) {
        vis[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int r=i+delrow[k];
            int c=j+delcol[k];
            if(r>=0&&c>=0&&r<m&&c<n&&vis[r][c]==0&&grid[r][c]==1){
                dfs(delrow,delcol,r,c,grid,vis,m,n);
            }

        }
    }
}