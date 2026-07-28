class Solution {
    public String smallestPalindrome(String s) {
        int l=s.length();
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;

        }
        int left=0;
        int right=l-1;
        char ans[]=new char[l];
        for(int i=0;i<26;i++){
            while(freq[i]>=2){
                ans[left]=(char)(i+'a');
                ans[right]=(char)(i+'a');
                left++;
                right--;
                freq[i]-=2;
            }
            if(freq[i]==1){
                ans[l/2]=(char)(i+'a');
            }
        }
        return new String(ans);
        
    }
}