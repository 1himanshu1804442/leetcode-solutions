class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
       int cnt=0;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                cnt++;
            }
        }
        if(nums[n-1]>nums[0])cnt++;
        if(cnt>1)return false;
        else return true;

        
    }
}