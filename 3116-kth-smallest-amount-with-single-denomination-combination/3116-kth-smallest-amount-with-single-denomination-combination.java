class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int maxMask = 1 << n; 
        
        long[] lcm = new long[maxMask];
        int[] sign = new int[maxMask];
        
        for (int i = 1; i < maxMask; i++) {
            long currentLcm = 1;
            int setBits = 0; 
            
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    setBits++;
                    currentLcm = getLcm(currentLcm, coins[j]);
                }
            }
            lcm[i] = currentLcm;
            sign[i] = (setBits % 2 == 1) ? 1 : -1;
        }
        
        long left = 1;
        long right = (long) k * 25; 
        for (int coin : coins) {
            right = Math.min(right, (long) k * coin);
        }
        
        long answer = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;
            
            for (int i = 1; i < maxMask; i++) {
                count += sign[i] * (mid / lcm[i]);
            }
            
            if (count >= k) {
                answer = mid;
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        
        return answer;
    }
    
    private long getLcm(long a, long b) {
        return (a / getGcd(a, b)) * b; 
    }
    
    private long getGcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}