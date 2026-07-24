class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        HashSet<Integer> s1=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                s1.add(nums[i]^nums[j]);
            }
        }
        HashSet<Integer> s2=new HashSet<>();
        for(int k:s1){
            for(int num:nums){
                s2.add(k^num);
            }
        }
        return s2.size();
        
    }
}