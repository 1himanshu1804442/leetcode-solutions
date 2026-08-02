class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int dp[]=new int[target+1];
        Arrays.fill(dp,-1);
        return solve(nums,dp,target);

        
    }
    public int solve(int nums[],int dp[],int target){
       if(target==0)return 1;
       if(target<0)return 0;
       if(dp[target]!=-1)return dp[target];
       int totalways=0;
       for(int i=0;i<nums.length;i++){
        totalways+=solve(nums,dp,target-nums[i]);
       }
       return dp[target]=totalways;

    }
}