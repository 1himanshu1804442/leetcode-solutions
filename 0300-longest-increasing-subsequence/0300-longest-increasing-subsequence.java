class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
      int maxi=1;
      for(int ind=0;ind<=n-1;ind++){
        for(int prev=0;prev<=ind-1;prev++){
            if(nums[prev]<nums[ind]){
                dp[ind]=Math.max(1+dp[prev],dp[ind]);
            }
        }
        maxi=Math.max(dp[ind],maxi);
      }
      return maxi;
        
    }
    public int helper(int nums[],int ind,int prev,int[][] dp){
        int n=nums.length;
        if(ind==n)return 0;
        if(dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
        }
        int nottake=0+helper(nums,ind+1,prev,dp);
        int take=0;
        if(prev==-1||nums[ind]>nums[prev]){
             take=1+helper(nums,ind+1,ind,dp);
        }
        return dp[ind][prev+1]=Math.max(take,nottake);
    }
}