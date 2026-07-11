class Solution {
    static class DisjointSet{
        int par[];
        int size[];
        int edgecount[];
        public DisjointSet(int n){
            par=new int[n+1];
            size=new int[n+1];
            edgecount=new int[n+1];
            for(int i=0;i<=n;i++){
                par[i]=i;
                size[i]=1;
                edgecount[i]=0;
            }


        }
        public int find(int x){
            if(par[x]==x)return x;
            return par[x]=find(par[x]);

        }
        public void union(int x,int y){
            int ux=find(x);
            int uy=find(y);
            if(ux==uy){edgecount[ux]++;
            return;
            }
            if(size[ux]<size[uy]){
                par[ux]=uy;
                size[uy]+=size[ux];
                edgecount[uy]+=edgecount[ux]+1;
            }
            else{
                par[uy]=ux;
                size[ux]+=size[uy];
                edgecount[ux]+=edgecount[uy]+1;
            }

        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        DisjointSet ds=new DisjointSet(n);
        int len=edges.length;
        for(int edge[]:edges){ 
        int x=edge[0];
        int y=edge[1];
      
        ds.union(x,y);}
            int cnt=0;
    for(int i=0;i<n;i++){
        if(ds.find(i)==i){
            int v=ds.size[i];
            int e=ds.edgecount[i];
            if(e==((v*(v-1))/2)){
                cnt++;
            }
        }
    }
    return cnt;
    }


}