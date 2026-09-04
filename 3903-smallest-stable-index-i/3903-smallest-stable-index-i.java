class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int score=maximum(nums,0,i)-minimum(nums,i,n-1);
            if(score<=k){
                return i;
            }
        }
        return -1;
        
    }
    public int maximum(int nums[],int start,int end){
        int maxi=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            maxi=Math.max(maxi,nums[i]);
        }
        return maxi;
    }
      public int minimum(int nums[],int start,int end){
        int mini=Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            mini=Math.min(mini,nums[i]);
        }
          return mini;
    }
}