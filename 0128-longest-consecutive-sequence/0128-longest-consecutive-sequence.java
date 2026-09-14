import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
      
       if(nums==null||nums.length==0){
        return 0;
       }

       HashSet<Integer> set=new HashSet<>();
       for(int num:nums){
        set.add(num);
       }
       int longest=0;
       for(int num:set){
        if(!set.contains(num-1)){
            int currnum=num;
            int currlongest=1;
            while(set.contains(currnum+1)){
                currnum+=1;
                currlongest+=1;
            }
            longest=Math.max(longest,currlongest);
        }
       }
       return longest;
       
    }
}
