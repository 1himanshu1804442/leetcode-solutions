class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp1=new int[n+1];
        int dp2[]=new int[n+1];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        if(n==1)return nums[0];
        int case1=solve(nums,0,n-2,dp1);
        int case2=solve(nums,1,n-1,dp2);
        return Math.max(case1,case2);
        
        
    }
    public int solve(int nums[],int start,int ind,int dp[]){
        if(ind<start)return 0;
        if(ind==start)return nums[ind];
        if(dp[ind]!=-1)return dp[ind];
        int pick=solve(nums,start,ind-2,dp)+nums[ind];
        int notpick=solve(nums,start,ind-1,dp);
        return dp[ind]=Math.max(pick,notpick);

    }
}