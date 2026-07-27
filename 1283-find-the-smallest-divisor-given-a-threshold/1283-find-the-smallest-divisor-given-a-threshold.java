class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        int high = 0;
        for (int num : nums) {
            high = Math.max(high, num);
        }
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, nums, threshold)) {
                ans = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }

        }
        return ans;

    }
    public boolean check(int mid,int nums[],int threshold){
        int sum=0;
        for(int num:nums){
            int div=(num+mid-1)/mid;
            sum+=div;


        }
        if(sum<=threshold){
            return true;
        }return false;
    }
}