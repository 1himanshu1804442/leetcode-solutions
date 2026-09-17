class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int mini=prices[0];
        int profit=0;
        int maxprofit=0;
                for(int i=1;i<n;i++){
                    if(prices[i]<mini){
                        mini=prices[i];
                    }
                    else{
                        profit=prices[i]-mini;
                        maxprofit=Math.max(profit,maxprofit);

                    }


        }
        return maxprofit;
        
    }
}