class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int dp[][]=new int[n+1][n+1];
        for(int d[]:dp){
            Arrays.fill(d,-1);

        }
        boolean check=solve(piles,n,0,n-1,dp)>0;
        return check;

        
    }
    public int solve(int piles[],int n,int i,int j,int dp[][]){
        if(i==j){
            return piles[i];
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int leftpick=piles[i]-solve(piles,n,i+1,j,dp);
        int rightpick=piles[j]-solve(piles,n,i,j-1,dp);
        return dp[i][j]=Math.max(leftpick,rightpick);
        

    }
}