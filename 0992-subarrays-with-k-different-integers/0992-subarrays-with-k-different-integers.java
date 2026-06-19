class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingwindow(nums,k)-slidingwindow(nums,k-1);
        
    }
    public int slidingwindow(int nums[],int k){
        int n=nums.length;
        if(k<0)return 0;
        int left=0;
        int freq[]=new int[n+1];
        int unique=0;
        int total=0;
        for(int right=0;right<n;right++){
            if(freq[nums[right]]==0){
                unique++;
            }
            freq[nums[right]]++;
            while(unique>k){
                freq[nums[left]]--;
                if(freq[nums[left]]==0){
                    unique--;
                }
                left++;
            }
            total+=(right-left+1);

        }
        return total;
    }
}