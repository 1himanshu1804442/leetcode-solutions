class Solution {
    static class Pair{
        int row;
        int col;
        int steps;
        public Pair(int row,int col,int steps){
            this.row=row;
            this.col=col;
            this.steps=steps;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Pair> q=new LinkedList<>();
        int vis[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int dist[][]=new int[m][n];
        int nrow[]={-1,0,1,0};
        int ncol[]={0,1,0,-1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.row;
            int c=p.col;
            int step=p.steps;
            dist[r][c]=step;
            for(int i=0;i<4;i++){
                int row=r+nrow[i];
                int col=c+ncol[i];
                if(row>=0&&col>=0&&row<m&&col<n&&vis[row][col]==0){
                    vis[row][col]=1;
                    q.add(new Pair(row,col,step+1));
                }

            }
        }
        return dist;

        
    }
}