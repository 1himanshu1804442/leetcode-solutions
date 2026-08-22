class Solution {
    public boolean checkDivisibility(int n) {
        return (n%(sum(n)+product(n)))==0?true:false;
        
    }
    public int sum(int n){
        int sum=0;
        while(n!=0){
            int rem=n%10;
            sum+=rem;
            n/=10;
        }
        return sum;
    }
    public int product(int n){
        int prod=1;
        while(n!=0){
            int rem=n%10;
            prod*=rem;
            n/=10;
        }
        return prod;
    }
}