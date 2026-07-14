class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length();
        int l2=text2.length();
        int dp[][]=new int[l1+1][l2+1];
       for(int i=1;i<=l1;i++){
        for(int j=1;j<=l2;j++){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
            }
            else{
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }

        }
       }
       return dp[l1][l2];

        
    }
    public int solve(int i,int j,int dp[][],String text1,String text2){
        if(i<0||j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j]=1+solve(i-1,j-1,dp,text1,text2);
        }
        else{
            int skips1=0+solve(i-1,j,dp,text1,text2);
            int skips2=0+solve(i,j-1,dp,text1,text2);
            return dp[i][j]=Math.max(skips1,skips2);
        }


    }
}