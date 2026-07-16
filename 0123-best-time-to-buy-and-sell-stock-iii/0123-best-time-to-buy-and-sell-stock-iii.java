class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][3][2];
        for(int d[][]:dp){
            for(int a[]:d){
                Arrays.fill(a,-1);
            }
        }
        return memo(dp,0,2,0,prices);

        
        
        
}
public int memo(int dp[][][],int day,int t,int hold,int prices[]){
    if(day>=prices.length||t==0)return 0;
    int profit=0;
    if(dp[day][t][hold]!=-1)return dp[day][t][hold];
    if(hold==1){
        int sell=prices[day]+memo(dp,day+1,t-1,0,prices);
        int rest=memo(dp,day+1,t,1,prices);
        profit=Math.max(sell,rest);
    }
    else{
        int buy=-prices[day]+memo(dp,day+1,t,1,prices);
        int rest=memo(dp,day+1,t,0,prices);
        profit=Math.max(buy,rest);
    }
    return dp[day][t][hold]=profit;
}
}