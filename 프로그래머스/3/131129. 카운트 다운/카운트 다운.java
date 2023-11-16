import java.util.*;

class Solution {
    
    public int target;
    public int[][] dp;
    public final int INF = 100_000_000;
    
    public void swap(int[] b, int[] min) {
       	if (b[0] <= min[0]) {
            if (b[0] == min[0]) {
                if (min[1] < b[1]) {
                    min[0] = b[0];
                    min[1] = b[1];
                }
            } else {
                min[0] = b[0];
                min[1] = b[1];
            }
        }
    }
    
    public int[] dfs(int score) {
        if (target < score) {
            return new int[] {INF, INF};
        }
        
        if (score == target) {
            return new int[] {0, 0};
       	}
        
        if (dp[score][0] != -1) {
            return dp[score];
        }
        
        int[] min = new int[] {INF, INF};
        
        for (int i = 1; i <= 20; i++) {
            int[] a = dfs(score + (i * 1));
            int[] b = new int[] {a[0] + 1, a[1] + 1};
            swap(b, min);
        }
        
        for (int i = 1; i <= 20; i++) {
            int[] a = dfs(score + (i * 2));
            int[] b = new int[] {a[0] + 1, a[1]};
            swap(b, min);
        }
        
        for (int i = 1; i <= 20; i++) {
            int[] a = dfs(score + (i * 3));
            int[] b = new int[] {a[0] + 1, a[1]};
            swap(b, min);
        }
        
        int[] a = dfs(score + 50);
        int[] b = new int[] {a[0] + 1, a[1] + 1};
        swap(b, min);
        dp[score] = min;
        
        return dp[score];
    }
    
    public int[] solution(int target) {
        this.target = target;
        dp = new int[target + 1][2];
        
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return dfs(0);
    }
}