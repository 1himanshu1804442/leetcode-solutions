class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][]=image;
        int inicolor=image[sr][sc];
        dfs(image,ans,sr,sc,inicolor,color);
        return ans;
    }
    public void dfs(int[][] image,int ans[][], int sr,int sc,int inicolor,int color){
        ans[sr][sc]=color;
        int m=image.length;
        int n=image[0].length;
        int nrow[]={-1,0,1,0};
        int ncol[]={0,-1,0,1};
        for(int i=0;i<4;i++){
            int r=sr+nrow[i];
            int c=sc+ncol[i];
            if(r>=0&&r<m&&c>=0&&c<n&&image[r][c]==inicolor&&ans[r][c]!=color){
                dfs(image,ans,r,c,inicolor,color);
            }
        }
    }
}