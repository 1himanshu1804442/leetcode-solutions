class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        int maxi=-(int)1e9;
        for(int num:nums){
            set.add(num);
            maxi=Math.max(maxi,num);
        }
        int lastnum=0;
        for(int i=k;i<=maxi;i+=k){
            if(!set.contains(i)){
                return i;
                
            }
            lastnum=i;
        }
        return lastnum+k;
    }
}