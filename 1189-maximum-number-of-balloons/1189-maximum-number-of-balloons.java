class Solution {
    public int maxNumberOfBalloons(String text) {
        int l=text.length();
        int freq[]=new int[26];
        for(char c:text.toCharArray()){
            freq[c-'a']++;
        }
        int minball=freq['b'-'a'];
        minball=Math.min(minball,freq['a'-'a']);
        minball=Math.min(minball,freq['l'-'a']/2);
        minball=Math.min(minball,freq['o'-'a']/2);
        minball=Math.min(minball,freq['n'-'a']);
        return minball;





        
    }
}