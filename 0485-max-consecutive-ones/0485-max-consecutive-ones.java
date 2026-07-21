class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int maxi=0;
        int cnt=0;
        for(int num:nums){
            if(num==1){
                cnt++;
                maxi=Math.max(cnt,maxi);
            }
            else cnt=0;
        }
        return maxi;
        
    }
}