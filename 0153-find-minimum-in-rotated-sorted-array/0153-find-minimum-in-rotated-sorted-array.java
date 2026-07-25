class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            if(nums[low]<=nums[high]){
                ans=Math.min(ans,nums[low]);
                break;
            }
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[mid]){
                ans=nums[low];
                low=mid+1;

            }
            else{
                ans=nums[mid];
                high=mid-1;
            }
        }
        return ans;
        
    }
}