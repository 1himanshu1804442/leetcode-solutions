class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
      int min=Integer.MAX_VALUE;
        boolean checkodd=false;
        for(int i=0;i<n;i++){
            if(nums1[i]<min){
                min=nums1[i];
            }
            if(nums1[i]%2!=0){
                checkodd=true;
            }
        }
        if(min%2!=0)return true;
        if(min%2==0&&checkodd==true){
            return false;
        }
        return true;
    }
}