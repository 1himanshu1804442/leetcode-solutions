class Solution {
    public int minCost(int n, int[] cuts) {
        int c=cuts.length;
        int newcuts[]=new int[c+2];
        for(int i=1;i<c+1;i++){
            newcuts[i]=cuts[i-1];

        }
        newcuts[0]=0;
        newcuts[c+1]=n;
        Arrays.sort(newcuts);
        int dp[][]=new int[c+2][c+2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(dp,newcuts,0,c+1);
        
    }
    public int solve(int dp[][],int newcuts[],int l,int r){
        if(r-l<2)return 0;
        if(dp[l][r]!=-1)return dp[l][r];
        int mini=(int)1e9;
        for(int k=l+1;k<=r-1;k++){
            int value=(newcuts[r]-newcuts[l])+solve(dp,newcuts,l,k)+solve(dp,newcuts,k,r);
            mini=Math.min(value,mini);

        }
        return dp[l][r]=mini;
    }
}