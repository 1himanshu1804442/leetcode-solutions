class Solution {
    public int findGCD(int[] nums) {
        int mini=(int)1e8;
        int maxi=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            maxi=Math.max(nums[i],maxi);
            mini=Math.min(nums[i],mini);

        }
        return gcd(maxi,mini);
        
    }
    public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}