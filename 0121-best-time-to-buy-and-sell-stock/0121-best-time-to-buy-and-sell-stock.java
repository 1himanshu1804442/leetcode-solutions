class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int n=prices.length;
        int minprice=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(prices[i]<minprice){
                minprice=prices[i];
            }
            else{
                int currprofit=prices[i]-minprice;
                if(maxprofit<currprofit){
                    maxprofit=currprofit;
                }
            }

        }
        return maxprofit;

    }

}