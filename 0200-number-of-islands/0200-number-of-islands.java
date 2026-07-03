class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,n,m,delrow,delcol,i,j);

                }
                
            }
        }
        return count;

        
    }
    public void dfs(char[][] grid,int n,int m,int delrow[],int delcol[],int r,int c){
        grid[r][c]='0';
        for(int i=0;i<4;i++){
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&grid[nrow][ncol]=='1'){
                dfs(grid,n,m,delrow,delcol,nrow,ncol);
            }
        }
    }
}