class Solution {
    class DisjointSet{
        int par[];
        int size[];
        public DisjointSet(int n){
             size=new int[n+1];
            par=new int[n+1];
            for(int i=0;i<=n;i++){
                size[i]=1;
                par[i]=i;
            }
        }
        public int findpar(int x){
            if(par[x]==x)return x;
            return par[x]=findpar(par[x]);
        }
        public void unionsize(int x,int y){
            int ux=findpar(x);
            int uy=findpar(y);
            if(ux==uy){
                return;
            }
            else if(size[ux]<size[uy]){
                par[ux]=uy;
                size[uy]+=size[ux];
            }
            else{
                par[uy]=ux;
                size[ux]+=size[uy];
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        DisjointSet ds=new DisjointSet(n);
        int cnt=n;
        for(int connection[]:connections){
            int x=connection[0];
            int y=connection[1];
            if(ds.findpar(x)!=ds.findpar(y)){
                ds.unionsize(x,y);
                cnt--;

            }
        }
        return cnt-1;
    }
}