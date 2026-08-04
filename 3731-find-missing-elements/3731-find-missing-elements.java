class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
       Arrays.sort(nums);
       int start=nums[0];
       int end=nums[n-1];
       int idx=0;
       for(int i=start;i<=end;i++){
        if(i!=nums[idx]){
            list.add(i);
        }else{
            idx++;
                    }
        
       }
       return list;
        
    }
}