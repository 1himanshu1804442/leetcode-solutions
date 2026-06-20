class Solution {
    private Long[][][][] memo;
    private int kLimit;
    public long goodIntegers(long l, long r, int k) {
        this.kLimit = k;
        return calculate(r) - calculate(l - 1);
    }
    private long calculate(long num) {
        if (num < 0) return 0;
        String s = Long.toString(num);
        memo = new Long[s.length()][11][2][2];
        return dp(s, 0, 10, true, true);
    }
    private long dp(String s, int idx, int prev, boolean isTight, boolean isLeadingZero) {
        if (idx == s.length()) {
            return 1;
        }

        int tight = isTight ? 1 : 0;
        int lz = isLeadingZero ? 1 : 0;

        if (memo[idx][prev][tight][lz] != null) {
            return memo[idx][prev][tight][lz];
        }

        int limit = isTight ? (s.charAt(idx) - '0') : 9;
        long ans = 0;

        for (int d = 0; d <= limit; d++) {
            boolean nextTight = isTight && (d == limit);
            boolean nextLeadingZero = isLeadingZero && (d == 0);

            if (isLeadingZero) {
                ans += dp(s, idx + 1, nextLeadingZero ? 10 : d, nextTight, nextLeadingZero);
            } else {
                if (Math.abs(d - prev) <= kLimit) {
                    ans += dp(s, idx + 1, d, nextTight, false);
                }
            }
        }

        return memo[idx][prev][tight][lz] = ans;
    }
}