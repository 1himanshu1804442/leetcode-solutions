class Solution {
    public int maxProduct(int n) {
        int prod=1;
        int maxprod=1;
        int l=(n+"").length();
        int digits[]=new int[l];
        int n1=n;
        for(int i=l-1;i>=0;i--){
            digits[i]=n1%10;
            n1/=10;
        }
        Arrays.sort(digits);
        return digits[l-1]*digits[l-2];
        
    }
}