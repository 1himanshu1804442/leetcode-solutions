class Solution {
    static class DisjointSet{
        public int size[],par[];
        public DisjointSet(int n){
            par=new int[n];
            size=new int[n];
            for(int i=0;i<n;i++){
                par[i]=i;
                size[i]=1;
            }
        }
        int find(int x){
            if(par[x]!=x){
                par[x]=find(par[x]);
            }
            return par[x];
        }
        public void union(int x,int y){
            int pa=find(x);
            int pb=find(y);
            if(pa==pb)return;
            if(size[pa]<size[pb]){
                par[pa]=pb;
                size[pb]+=size[pa];
            }
            else{
                par[pb]=pa;
                size[pa]+=size[pb];            }

        }
        int getsize(int x){
            return size[find(x)];
        }
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        int dr[]={-1,0,+1,0};
        int dc[]={0,-1,0,+1};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                int node=i*n+j;
                for(int d=0;d<4;d++){
                    int nr=i+dr[d];
                    int nc=j+dc[d];
                    if(nr>=0&&nc>=0&&nr<n&&nc<n){
                        if(grid[nr][nc]==1){
                            int adjnode=nr*n+nc;
                            ds.union(node,adjnode);

                        }
                    }
                    
                }
                }
            }
        }
        int maxisland=0;
        boolean haszero=false;

         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    haszero=true;
                    HashSet<Integer> uniqueparents=new HashSet<>();
                for(int d=0;d<4;d++){
                    int nr=i+dr[d];
                    int nc=j+dc[d];
                    if(nr>=0&&nc>=0&&nr<n&&nc<n){
                        if(grid[nr][nc]==1){
                            int adjnode=nr*n+nc;
                           int parent=ds.find(adjnode);
                           uniqueparents.add(parent);

                        }
                    }
                    
                }
                int possiblearea=1;
                for(int parent:uniqueparents){
                    possiblearea+=ds.size[parent];
                }
                maxisland=Math.max(maxisland,possiblearea);
                }
            }
        }
        if(!haszero){
            for(int i=0;i<n*n;i++){
                maxisland=Math.max(maxisland,ds.size[ds.find(i)]);
            }

        }
        return maxisland;
    }
}