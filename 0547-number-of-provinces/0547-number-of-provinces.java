class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean visited[]=new boolean[n+1];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected,visited,i,n);
                cnt++;
            }
        }
        return cnt;
        
    }
    public void dfs(int connected[][],boolean vis[],int node,int n){
        vis[node]=true;
        for(int j=0;j<n;j++){
            if(connected[node][j]==1&&vis[j]==false){
                dfs(connected,vis,j,n);
            }
        }
    }
}