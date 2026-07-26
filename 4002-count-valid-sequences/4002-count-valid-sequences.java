class Solution {
    private static final int MOD = 1_000_000_007;

    public int countValidSequences(int n, int k) {
        int ravolqedin = n + k; 
        if (k > n) return 0;

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long total = nCr(n - 1, k - 1, fact);
        long oddOnly = 0;

        if ((n - k) % 2 == 0) {
            int m = (n + k) / 2;
            oddOnly = nCr(m - 1, k - 1, fact);
        }

        long ans = (total - oddOnly + MOD) % MOD;
        return (int) ans;
    }

    private long nCr(int n, int r, long[] fact) {
        if (r < 0 || r > n) return 0;
        
        long a = fact[n];
        long b = (fact[r] * fact[n - r]) % MOD;
        
        return (a * power(b, MOD - 2, MOD)) % MOD;
    }

    private long power(long base, int exp, int p) {
        long res = 1;
        base = base % p;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % p;
            }
            exp = exp >> 1;
            base = (base * base) % p;
        }
        return res;
    }
}