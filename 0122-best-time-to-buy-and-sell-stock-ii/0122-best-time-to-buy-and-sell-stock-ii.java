class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int d[]:dp)Arrays.fill(d,-1);
        return solve(prices,0,0,dp);

        
    }
    public int solve(int prices[],int day,int hold,int dp[][]){
        if(day>=prices.length){
            return 0;
        }
        if(dp[day][hold]!=-1)return dp[day][hold];
        int profit=0;
        if(hold==1){
            int sell=prices[day]+solve(prices,day+1,0,dp);
            int rest=solve(prices,day+1,1,dp);
            profit=Math.max(rest,sell);
        }
        else{
            int buy=-prices[day]+solve(prices,day+1,1,dp);
            int rest=solve(prices,day+1,0,dp);
            profit=Math.max(buy,rest);
        }
        return dp[day][hold]=profit;
    }
}