class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return solve(dp,prices,0,0);
        
    }
    public int solve(int dp[][],int prices[],int day,int hold){
        if(day>=prices.length)return 0;
        if(dp[day][hold]!=-1)return dp[day][hold];
        int profit=0;
        if(hold==1){
            int sell=prices[day]+solve(dp,prices,day+2,0);
            int rest=solve(dp,prices,day+1,1);
            profit=Math.max(sell,rest);
        }
        else{
            int buy=-prices[day]+solve(dp,prices,day+1,1);
            int rest=solve(dp,prices,day+1,0);
            profit=Math.max(buy,rest);
        }
        return dp[day][hold]=profit;
    }
}