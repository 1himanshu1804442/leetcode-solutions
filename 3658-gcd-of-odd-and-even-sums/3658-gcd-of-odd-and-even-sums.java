class Solution {
    public int gcdOfOddEvenSums(int n) {
        return gcd(sumOdd(n),sumEven(n));
        
    }
    public int sumOdd(int n){
        int sum=0;
        int j=1;
        for(int i=1;i<=n;i++){
            sum+=j;
            j+=2;
        }
        return sum;
    }
    public int sumEven(int n){
        int sum=0;
      int j=2;
        for(int i=1;i<=n;i++){
            sum+=j;
            j+=2;
        }
        return sum;
    }
    public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}