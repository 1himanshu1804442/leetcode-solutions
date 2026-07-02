class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int inicolor=image[sr][sc];
        if(inicolor!=color){
        dfs(image,sr,sc,inicolor,color);}
        return image;
    }
    public void dfs(int[][] image, int sr,int sc,int inicolor,int color){
        image[sr][sc]=color;
        int m=image.length;
        int n=image[0].length;
        int nrow[]={-1,0,1,0};
        int ncol[]={0,-1,0,1};
        for(int i=0;i<4;i++){
            int r=sr+nrow[i];
            int c=sc+ncol[i];
            if(r>=0&&r<m&&c>=0&&c<n&&image[r][c]==inicolor){
                dfs(image,r,c,inicolor,color);
            }
        }
    }
}