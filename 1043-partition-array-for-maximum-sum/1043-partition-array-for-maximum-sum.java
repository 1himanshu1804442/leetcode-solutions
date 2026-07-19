class Solution {
    int dp[];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(arr,k,0,n);
        
    }
    public int solve(int arr[],int k,int i,int n){
        if(i==n)return 0;
        if(dp[i]!=-1)return dp[i];

        int limit=Math.min(n,i+k);
        int maxsum=0;
        int maxvalue=0;
        for(int j=i;j<limit;j++){
             maxvalue=Math.max(maxvalue,arr[j]);
            int len=j-i+1;
            int currentsum=(maxvalue*len)+solve(arr,k,j+1,n);
            maxsum=Math.max(currentsum,maxsum);

        }
        return dp[i]=maxsum;
    }

}