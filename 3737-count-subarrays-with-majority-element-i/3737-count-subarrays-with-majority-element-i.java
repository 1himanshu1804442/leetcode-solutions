class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int cnt=0;
        int res=0;
        for(int i=0;i<n;i++){
            cnt=0;
            for(int j=i;j<n;j++){
                if(nums[j]==target){
                    cnt++;
                }
                else{
                    cnt--;
                }
                 if(cnt>0){
                res++;
            }

            }
           
        }
        return res;
    }
}