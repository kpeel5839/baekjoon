class Solution {
    public int solution(String s) {
        int n = s.length(); 
        boolean[][] dp = new boolean[n][n];
        int answer = 1;
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int rightIndex = j + i - 1;
                
                if (i == 2) {
                    if (s.charAt(j) == s.charAt(rightIndex)) {
                        dp[j][rightIndex] = true;
                    }
                } else {
                    if (s.charAt(j) == s.charAt(rightIndex) && dp[j + 1][rightIndex - 1]) { 
                        dp[j][rightIndex] = true;
                    }
                }
                
                if (dp[j][rightIndex]) {
                    answer = Math.max(answer, i);
                }
            }
        }
       
        return answer;
    }
}