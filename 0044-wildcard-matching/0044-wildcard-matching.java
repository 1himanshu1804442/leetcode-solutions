class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean dp[][]=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int j=1;j<=m;j++){
            if(p.charAt(j-1)=='*'){
            dp[0][j]=dp[0][j-1];
            }

        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
        
    }
    public boolean helper(String s,String t,int i,int j,Boolean[][] dp){
        if(i<0&&j<0)return true;
        if(i<0&&j>=0)return false;
        if(j<0&&i>=0){
            for(int k=0;k<=i;k++){
                if(s.charAt(k)!='*'){
                    return false;
                }
            }
            return true;

        }
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)||s.charAt(i)=='?'){
           return dp[i][j]=helper(s,t,i-1,j-1,dp);
        }
        if(s.charAt(i)=='*'){
            return dp[i][j]=helper(s,t,i-1,j,dp)||helper(s,t,i,j-1,dp);
        }
        return dp[i][j]=false;
      
    }
}