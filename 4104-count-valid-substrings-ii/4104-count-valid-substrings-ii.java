class Solution {
    public long countValidSubstrings(String s) {
        long validCount = 0;
        int last_a = -1, last_ab_start = -1, last_abc_start = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == 'a') last_a = i;
            else if (ch == 'b') last_ab_start = Math.max(last_ab_start, last_a);
            else if (ch == 'c') last_abc_start = Math.max(last_abc_start, last_ab_start);
            
            validCount += (i - last_abc_start);
        }
        return validCount;

        
    }
}