class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int totalxor=0;
        boolean hasnonzero=false;
        for(int num:nums){
            totalxor^=num;
            if(num!=0)hasnonzero=true;
        }
        
    
    if(totalxor!=0){
        return n;
        }
    else if(hasnonzero)return n-1;
    else return 0;
}
}