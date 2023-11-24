class Solution {
    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length][n + 1];
        int MOD = 1_000_000_007;
        
        for (int i = 0; i < money.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= n; j++) {
                int up = (j - money[i] < 0 ? 0 : dp[i][j - money[i]]);
                int left = (i == 0 ? 0 : dp[i - 1][j]);
                dp[i][j] = (up + left) % MOD;
            }
        }
        
        return dp[money.length - 1][n];
    }
}