class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int len=0;
        int maxlen=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0)k--;
            len++;
            while(k<0){
                if(nums[left]==0){
                    k++;
                }
                len--;
                left++;
            }
            maxlen=Math.max(len,maxlen);
            
        }
        
        return maxlen;
    }
}