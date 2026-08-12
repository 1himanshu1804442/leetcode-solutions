class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0;
        int maxlen=0;
        for(int right=0;right<n;right++ ){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right])>k){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
            maxlen=Math.max((right-left+1),maxlen);
        }
      
        return maxlen;
        
    }
}