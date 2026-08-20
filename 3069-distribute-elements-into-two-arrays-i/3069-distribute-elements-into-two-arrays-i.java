class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int a[]=new int[n];
        int a2[]=new int[n];
        int count1=1;
        int count2=1;
        a[0]=nums[0];
        a2[0]=nums[1];
        for(int i=2;i<n;i++){
            if(a[count1-1]>a2[count2-1]){
                a[count1++]=nums[i];
            }
            else if(a[count1-1]<a2[count2-1]){
                a2[count2++]=nums[i];
            }
        }
        int res[]=new int[n];
        for(int i=0;i<count1;i++){
            nums[i]=a[i];
        }
        for(int j=0;j<count2;j++){
            nums[j+count1]=a2[j];
        }
        return nums;

        
    }
}