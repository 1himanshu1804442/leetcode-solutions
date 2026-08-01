class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int d[]:dp){
            Arrays.fill(d,Integer.MIN_VALUE);
        }
        return solve(0,n-1,nums,dp)>=0;


    }
    public int solve(int i,int j,int nums[],int dp[][]){
        if(i==j)return nums[i];
        if(dp[i][j]!=Integer.MIN_VALUE)return dp[i][j];
        int pickleft=nums[i]-solve(i+1,j,nums,dp);
        int pickright=nums[j]-solve(i,j-1,nums,dp);
        return dp[i][j]=Math.max(pickleft,pickright);
    }
}