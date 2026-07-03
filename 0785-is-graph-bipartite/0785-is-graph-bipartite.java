class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,graph)==false)return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int c,int[] color,int[][] graph){
        color[node]=c;
        for(int neighbour:graph[node]){
            if(color[neighbour]==-1){
                if(dfs(neighbour,1-c,color,graph)==false)return false;
            }
                else if(color[neighbour]==c)return false;
            
        }
        return true;
    }
}