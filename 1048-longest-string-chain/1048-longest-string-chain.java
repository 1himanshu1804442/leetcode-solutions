class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
      
        Map<String, Integer> dp = new HashMap<>();
        int maxChain = 1;
        for (String word : words) {
            int bestLengthForCurrentWord = 1;
            for (int i = 0; i < word.length(); i++) {
                
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                
                if (dp.containsKey(predecessor)) {
                    bestLengthForCurrentWord = Math.max(bestLengthForCurrentWord, dp.get(predecessor) + 1);
                }
            }
            dp.put(word, bestLengthForCurrentWord);
            maxChain = Math.max(maxChain, bestLengthForCurrentWord);
        }
        
        return maxChain;
    }
}