class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        int dp[]=new int[n];
        int hash[]=new int[n];
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            hash[i]=i;
        }
        int lastindex=0;
        Arrays.fill(dp,1);
        int maxlis=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0&&dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }

            }
            if(maxlis<dp[i]){
                maxlis=dp[i];
                lastindex=i;
            }
        }
        list.add(nums[lastindex]);
        while(hash[lastindex]!=lastindex){
            lastindex=hash[lastindex];
            list.add(nums[lastindex]);   
         }
            return list;

        
    }
    
}