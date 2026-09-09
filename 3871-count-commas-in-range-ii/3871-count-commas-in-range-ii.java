class Solution {
    public long countCommas(long n) {
         long limit=1000;
        long commas=0;
        while(limit<=n){
            commas+=(n-limit+1);
            limit*=1000;
            
        }
        return commas;
    }
}