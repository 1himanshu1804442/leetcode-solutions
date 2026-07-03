class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int j=0;j<m;j++){
            if(vis[0][j]==0&&board[0][j]=='O'){
                dfs(0,j,delrow,delcol,board,vis,n,m);
            }
            if(vis[n-1][j]==0&&board[n-1][j]=='O'){
                dfs(n-1,j,delrow,delcol,board,vis,n,m);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][m-1]==0&&board[i][m-1]=='O'){
                dfs(i,m-1,delrow,delcol,board,vis,n,m);
            }
            if(vis[i][0]==0&&board[i][0]=='O'){
                dfs(i,0,delrow,delcol,board,vis,n,m);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'&&vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
        
    }
    public void dfs(int r,int c,int delrow[],int delcol[],char board[][],int vis[][],int n,int m){
        vis[r][c]=1;
        for(int i=0;i<4;i++){
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&board[nrow][ncol]=='O'){
                dfs(nrow,ncol,delrow,delcol,board,vis,n,m);
            }
        }

    }

}
