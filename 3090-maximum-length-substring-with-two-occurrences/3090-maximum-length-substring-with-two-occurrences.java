class Solution {

    public int maximumLengthSubstring(String s) {
        int l=s.length();
        int left=0;
        int maxlen=0;
        int freq[]=new int[26];
        for(int right=0;right<l;right++){
            char c=s.charAt(right);
            freq[c-'a']++;
            while(freq[c-'a']>2){
                char leftchar=s.charAt(left);
                freq[leftchar-'a']--;
                left++;
            }
            maxlen=Math.max((right-left+1),maxlen);
        }
        return maxlen;
        
    }
}