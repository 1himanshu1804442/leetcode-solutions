class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f=first(nums,target);
        int s=second(nums,target);
        return new int[]{f,s};
    }
    public int first(int nums[],int target){
        int low=0;
        int high=nums.length-1;
        int f=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                f=mid;
                high=mid-1;


            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return f;
    }
    public int second(int nums[],int target){
        int low=0;
        int high=nums.length-1;
        int s=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                s=mid;
                low=mid+1;


            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return s;
    }
}