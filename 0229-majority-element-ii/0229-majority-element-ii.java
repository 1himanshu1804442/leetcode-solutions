class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int c1=0;
        int c2=0;
        int count1=0;
        int count2=0;
        for(int num:nums){
            if(c1==num)count1++;
            else if(c2==num)count2++;
            else if(count1==0){
                c1=num;
                count1=1;

            }
            else if(count2==0){
                c2=num;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }

        }
        count1=0;
        count2=0;
        for(int num:nums){
            if(c1==num)count1++;
            else if(c2==num)count2++;
        }
        int threshold=(nums.length)/3;
        if(count1>threshold)ans.add(c1);
        if(count2>threshold)ans.add(c2);
        return ans;
        
    }
}