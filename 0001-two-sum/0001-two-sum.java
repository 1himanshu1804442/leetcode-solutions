class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer> map =new HashMap<>();
        int sum=0;
        for(int i=0;i<n;i++){
            
            int t=target-nums[i];
            if(map.containsKey(t)){
                return new int[]{i,map.get(t)};
            }
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }
        return new int[]{};
        
    }
}