class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int mxi=0;
        int prefixGcd[]=new int[n];
        for(int i=0;i<n;i++){
            mxi=Math.max(mxi,nums[i]);
            prefixGcd[i]=calculateGcd(nums[i],mxi);
        }
        Arrays.sort(prefixGcd);
        long totalsum=0;
        int left=0;
        int right=n-1;
        while(left<right){
            totalsum=totalsum+calculateGcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return totalsum;
    }
    public int calculateGcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}