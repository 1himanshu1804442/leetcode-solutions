class Solution {
    public int countCommas(int n) {
        long limit=1000;
        long commas=0;
        while(limit<=n){
            commas+=(n-limit+1);
            limit*=1000;
            
        }
        return (int)commas;
    }
}