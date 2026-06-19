class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return slidingwindow(nums,k)-slidingwindow(nums,k-1);
    }
    public int slidingwindow(int nums[],int k){
        if(k<0)return 0;
        int left=0;
        int n=nums.length;
        int currsum=0;
        int oddcount=0;
        int totalsum=0;
        for(int right=0;right<n;right++){
            if(nums[right]%2!=0){
                oddcount++;
            }
            while(oddcount>k){
                if(nums[left]%2!=0){
                    oddcount--;
                }
                left++;
            }
            
            totalsum+=(right-left+1);
        }
        return totalsum;
    }
}