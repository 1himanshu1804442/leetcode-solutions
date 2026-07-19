class Solution {
    int dp[];
    public int minCut(String s) {
        int l=s.length();
        dp=new int[l];
        Arrays.fill(dp,-1);
        return solve(0,l,s)-1;
        
    }
    public int solve(int i,int n,String s){
        if(i==n)return 0;
        if(dp[i]!=-1)return dp[i];
        int mini=(int)1e9;
        for(int j=i;j<n;j++){
           
            if(isPalindrome(s,i,j)){
                int cost=1+solve(j+1,n,s);
                  mini=Math.min(mini,cost);
              
            }
            
        }
        return dp[i]=mini;
    }
    public boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;

        }
        return true;
}
}