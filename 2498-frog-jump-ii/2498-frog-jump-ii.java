class Solution {
    public int maxJump(int[] stones) {
        int n=stones.length;
        if(n==2)return stones[1]-stones[0];
        int maxijump=-(int)1e9;
        for(int i=0;i<n-2;i++){
            maxijump=Math.max(maxijump,stones[i+2]-stones[i]);

        }
        return maxijump;
        
    }
}