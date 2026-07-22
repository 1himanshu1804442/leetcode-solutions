class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int posindex = 0;
        int negindex = 1;
        int temp[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                temp[posindex]=nums[i];
                posindex+=2;
                

            }
            else{
                temp[negindex]=nums[i];
                negindex+=2;
            }
        }
        return temp;

    }
}