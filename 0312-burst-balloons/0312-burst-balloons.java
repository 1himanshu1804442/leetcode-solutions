class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        int dp[][]=new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(arr,1,n,dp);
        
    }
    public int helper(int nums[],int i,int j,int[][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int mini=-(int)1e9;
        for(int ind=i;ind<=j;ind++){
            int cost=nums[i-1]*nums[ind]*nums[j+1]+helper(nums,i,ind-1,dp)+helper(nums,ind+1,j,dp);
            mini=Math.max(cost,mini);
        }
        return dp[i][j]=mini;
    }
}