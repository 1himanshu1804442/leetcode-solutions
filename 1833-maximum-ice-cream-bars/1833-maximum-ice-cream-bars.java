class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n=costs.length;
        int maxi=0;
        for(int c:costs){
            if(maxi<c){
                maxi=c;
            }
        }
        int freq[]=new int[maxi+1];
         for(int c:costs){
           freq[c]++;
        }
        int cnt=0;
        for(int price=1;price<=maxi;price++){
            if(freq[price]==0)continue;
            if(price>coins)break;
            int buy=Math.min(freq[price],coins/price);
            cnt+=buy;
            coins-=(buy*price);
        }
        return cnt;
        
    }
}