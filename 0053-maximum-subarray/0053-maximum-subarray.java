class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int sum=0;
        int maxsum=-(int)1e9;
        
        for(int num:nums){
            sum+=num;
            
            maxsum=Math.max(maxsum,sum);
            if(sum<0){
                sum=0;
            }

        }
        return maxsum;
        
    }
}