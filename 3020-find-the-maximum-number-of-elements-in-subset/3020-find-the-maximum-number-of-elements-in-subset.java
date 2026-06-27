class Solution {
    public int maximumLength(int[] nums) {
        int n=nums.length;
        HashMap<Long,Integer> mp=new HashMap<>();
        for(int num:nums){
            long x=num;
            mp.put(x,mp.getOrDefault(x,0)+1);
        }
        int maxlen=1;
        if(mp.containsKey(1L)){
            int ones=mp.get(1L);
            int oneslen=ones%2==0?ones-1:ones;
            maxlen=Math.max(oneslen,maxlen);
            mp.remove(1L);

        }
        for(long x:mp.keySet()){
            long curr=x;
            int currlen=0;
            while(mp.containsKey(curr)){
                int count=mp.get(curr);
            if(count>=2){
                currlen+=2;
                curr=curr*curr;

            }
            else{
                currlen+=1;
                break;
            }
}
             if(!mp.containsKey(curr)){
                currlen-=1;
             }
             maxlen=Math.max(maxlen,currlen);

        }
        return maxlen;

        
    }
}