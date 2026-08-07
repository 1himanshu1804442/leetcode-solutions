class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean vis[]=new boolean[n+1];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected,vis,i,n);
                cnt++;
            }

        }
        return cnt;
        
    }
    public void dfs(int[][] isCon,boolean vis[],int node,int n){
        vis[node]=true;
        for(int j=0;j<n;j++){
            if(isCon[node][j]==1&&vis[j]==false){
                dfs(isCon,vis,j,n);
            }

        }
    }
}