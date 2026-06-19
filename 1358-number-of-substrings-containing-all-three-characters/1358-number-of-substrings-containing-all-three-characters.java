class Solution {
    public int numberOfSubstrings(String s) {
        int l=s.length();
        int lastseen[]={-1,-1,-1};
        int count=0;
        for(int i=0;i<l;i++){
            char ch=s.charAt(i);
            lastseen[ch-'a']=i;
            if(lastseen[0]!=-1&&lastseen[1]!=-1&&lastseen[2]!=-1){
                int mini=Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2]));
                count+=(mini+1);
            }
       
        }
        return count;
        
    }
}