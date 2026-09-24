class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        int mini=(int)1e9;
        for(int i=0;i<n;i++){
            if(digitsum(nums[i])==i){
                mini=Math.min(mini,digitsum(nums[i]));
            }

        }
        return mini!=(int)1e9?mini:-1;
        
    }
    public int digitsum(int n){
        int l=(n+"").length();
        
        int sum=0;
        while(n>0){
             sum=sum+n%10;
             n/=10;

        }
        return sum;
    }
}