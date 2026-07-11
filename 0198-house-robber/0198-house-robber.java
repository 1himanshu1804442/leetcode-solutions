class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums,n-1);
    }
    public int solve(int nums[],int ind){
        if(ind==0){
            return nums[0];

        }
        if(dp[ind]!=-1)return dp[ind];
        int notpick=solve(nums,ind-1);
        int pick=nums[ind];
        if(ind>=2){
         pick=solve(nums,ind-2)+nums[ind];
}
return dp[ind]=Math.max(pick,notpick);

    }
}