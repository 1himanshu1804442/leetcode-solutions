class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=s.length();
        int maxlen=0;
        int left=0;
        int lastseen[]=new int[128];
        Arrays.fill(lastseen,-1);
        for(int right=0;right<l;right++){
            char ch=s.charAt(right);
            if(lastseen[ch]>=left){
                left=lastseen[ch]+1;
            }
            lastseen[ch]=right;
            maxlen=Math.max(maxlen,right-left+1);


        } 
        return maxlen;
    }
}