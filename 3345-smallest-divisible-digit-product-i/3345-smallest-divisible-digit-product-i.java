class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(getproduct(n)%t==0){
                return n;
            }
            n++;
        }
        
        
    }
    public int getproduct(int n){
        int prod=1;
        while(n>0){
            int rem=n%10;
            prod=prod*rem;
            n/=10;
        }
        return prod;
    }
}