class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int d[]:dp){Arrays.fill(d,-1);
        }
        return solve(dp,prices,0,0,fee);

        
    }
     public int solve(int dp[][],int prices[],int day,int hold,int fee){
        if(day>=prices.length)return 0;
        if(dp[day][hold]!=-1)return dp[day][hold];
        int profit=0;
        if(hold==1){
            int sell=prices[day]-fee+solve(dp,prices,day+1,0,fee);
            int rest=solve(dp,prices,day+1,1,fee);
            profit=Math.max(sell,rest);
        }
        else{
            int buy=-prices[day]+solve(dp,prices,day+1,1,fee);
            int rest=solve(dp,prices,day+1,0,fee);
            profit=Math.max(buy,rest);
        }
        return dp[day][hold]=profit;
    }
}