class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int currsum=0;
        int maxsum=0;
        for(int i=0;i<k;i++){
            currsum+=cardPoints[i];
        }
        maxsum=currsum;
        int leftindex=k-1;
        int rightindex=n-1;
        while(leftindex>=0){
            currsum-=cardPoints[leftindex];
            currsum+=cardPoints[rightindex];
            maxsum=Math.max(maxsum,currsum);
            leftindex--;
            rightindex--;

        }
        return maxsum;


        
    }
}