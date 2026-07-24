class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        boolean haspair[]=new boolean[2048];
        boolean istriplet[]=new boolean[2048];
       
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
               haspair[nums[i]^nums[j]]=true;
            }
        }
      
        for(int num:nums){
            for(int i=0;i<2048;i++){
                if(haspair[i]){
                    istriplet[num^i]=true;
                }
            }
        }
        int cnt=0;
        for(boolean present:istriplet){
            if(present){
                cnt++;
            }
        }
        return cnt;
        
    }
}