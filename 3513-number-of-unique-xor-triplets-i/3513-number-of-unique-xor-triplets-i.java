class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n==1)return 1;
        if(n==2)return 2;
        int nextbitof2=1;
        while(nextbitof2<=n){
            nextbitof2<<=1;
        }
        return nextbitof2;
        
    }
}