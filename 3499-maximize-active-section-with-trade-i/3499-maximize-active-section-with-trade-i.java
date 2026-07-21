class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int initialOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                initialOnes++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append('1').append(s).append('1');
        String t = sb.toString();
        
        List<Integer> blocks = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < t.length(); i++) {
            if (t.charAt(i) == t.charAt(i - 1)) {
                count++;
            } else {
                blocks.add(count);
                count = 1;
            }
        }
        blocks.add(count);
        
        int k = blocks.size() / 2;
        
        if (k < 2) {
            return initialOnes;
        }
        
        int[] Z = new int[k + 1];
        int[] O = new int[k];
        
        for (int i = 1; i <= k; i++) {
            Z[i] = blocks.get(2 * i - 1); 
        }
        for (int i = 1; i <= k - 1; i++) {
            O[i] = blocks.get(2 * i);
        }
        
        int[] pref = new int[k + 2];
        for (int i = 1; i <= k; i++) {
            pref[i] = Math.max(pref[i - 1], Z[i]);
        }
        
        int[] suff = new int[k + 2];
        for (int i = k; i >= 1; i--) {
            suff[i] = Math.max(suff[i + 1], Z[i]);
        }
        
        int maxNetGain = 0;
        
        for (int i = 1; i <= k - 1; i++) {
            int mOther = Math.max(pref[i - 1], suff[i + 2]);
            int merged = Z[i] + O[i] + Z[i + 1];
            int bestFlip = Math.max(merged, mOther);
            int netGain = bestFlip - O[i];
            
            maxNetGain = Math.max(maxNetGain, netGain);
        }
        
        return initialOnes + maxNetGain;
        
    }
}