class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int l=patterns.length;
        int len=word.length();
        int cnt=0;
        for(int i=0;i<l;i++){
            if(word.contains(patterns[i])){
                cnt++;
            }
        }
        return cnt;
        
    }
}