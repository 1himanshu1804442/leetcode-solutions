class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int grid[][]=new int[n][];
        
        for(int i=0;i<triangle.size();i++){
            List<Integer> list=triangle.get(i);
            grid[i]=new int[list.size()];
             for(int j=0;j<list.size();j++){
                grid[i][j]=triangle.get(i).get(j);
             }
                  
          }
          int dp[][]=new int[n][n];
          for(int d[]:dp){
            Arrays.fill(d,(int)1e9);
          }
          return helper(0,0,grid,n,dp);
     

    }
    public int helper(int i,int j,int mat[][],int n,int dp[][]){
        if(i==n-1)return mat[n-1][j];
        if(dp[i][j]!=(int)1e9)return dp[i][j];
        int down=mat[i][j]+helper(i+1,j,mat,n,dp);
        int dg=mat[i][j]+helper(i+1,j+1,mat,n,dp);
        return dp[i][j]=Math.min(down,dg);
    }
    

}