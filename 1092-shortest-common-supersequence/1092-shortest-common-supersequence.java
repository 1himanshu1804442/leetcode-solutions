class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return lcs(str1,str2);
        
    }
    public String lcs(String s1,String s2){
        int l1=s1.length();
        int l2=s2.length();
        int dp[][]=new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];

                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=l1;
        int j=l2;
        StringBuilder sb=new StringBuilder();
        while(i>0&&j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(s1.charAt(i-1));
                i--;
            }
            else{
                sb.append(s2.charAt(j-1));
                j--;
            }}
            while(i>0){
                sb.append(s1.charAt(i-1));
                i--;
            }
            while(j>0){
                sb.append(s2.charAt(j-1));
                j--;
            }

            


        return sb.reverse().toString();
    }
}