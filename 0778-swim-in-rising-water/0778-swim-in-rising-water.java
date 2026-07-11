class Solution {
    static class DisjointSet{
        int rank[];
        int par[];
        public DisjointSet(int n){
            rank=new int[n];
            par=new int[n];
            for(int i=0;i<n;i++){
                rank[i]=0;
                par[i]=i;
            }

        }
        int find(int x){
            if(par[x]!=x){
                par[x]=find(par[x]);
            }
            return par[x];
        }
        public void union(int x,int y){
            int px=find(x);
            int py=find(y);
            if(px==py){
                return;
            }
            if(rank[px]<rank[py]){
                par[px]=py;
            }
            else if(rank[py]<rank[px]){
                par[py]=px;
            }
            else{
                par[px]=py;
                rank[py]++;
            }
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int total=n*n;
        DisjointSet ds =new DisjointSet(total);
        List<int[]> store=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
            store.add(new int[]{grid[i][j],i,j});
            }
        }
        Collections.sort(store,(a,b)->a[0]-b[0]);
        boolean vis[][]=new boolean[n][n];
        int dirs[][]={{-1,0},{0,-1},{0,+1},{+1,0}};
        for(int g[]:store){
            int elevation=g[0];
            int row=g[1];
            int col=g[2];
            int node=row*n+col;
            vis[row][col]=true;
            for(int d[]:dirs){
                int nr=row+d[0];
                int nc=col+d[1];
                if(nr>=0&&nc>=0&&nr<n&&nc<n&&vis[nr][nc]){
                    ds.union(node,nr*n+nc);
                }
                
            }
            if(ds.find(0)==ds.find(total-1)){
                return elevation;
            }

        }
        return -1;
        
    }
}