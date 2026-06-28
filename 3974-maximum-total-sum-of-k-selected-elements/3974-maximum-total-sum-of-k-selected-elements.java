class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        int n=nums.length;
        long sum=0;
        int arr[]=new int[k];
        Arrays.sort(nums);
        int j=0;
        for(int i=n-1;i>=0;i--){
            if(j>=k){
                break;
            }
            arr[j++]=nums[i];
            
            
        }
        for(int i=0;i<k;i++){
            long num=(long)arr[i];
            if(mul>0){
                num=num*mul;
                mul--;
             
            }
               sum+=num;
        }

        return sum;
        
    }
}