class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int n=nums[0];
        for(int num:nums){
            if(count==0){
                n=num;
            }
            if(n==num){
                count++;
            }
            else {
                count--;
            }
            
        }
        return n;
        
    }
}