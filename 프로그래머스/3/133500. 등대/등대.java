import java.util.*;

class Solution {
    
    public int[][] dp;
    public List<List<Integer>> graph = new ArrayList<>();
    public final int INF = 1_000_000;
        
    public int dfs(int preSelected, int parent, int current) {
        if (dp[preSelected][current] != -1) {
            return dp[preSelected][current];
        }
        
        int selected = 0;
        int notSelected = preSelected == 0 ? INF : 0;
        
        for (Integer next : graph.get(current)) {
            if (next == parent) {
                continue;
            }
            
            if (preSelected == 1) {
                notSelected += dfs(0, current, next);
                selected += dfs(1, current, next);
            } else {
                selected += dfs(1, current, next);
            }
        }
        
        dp[preSelected][current] = Math.min(selected + 1, notSelected);
        
        return dp[preSelected][current];
    }
    
    public int solution(int n, int[][] lighthouse) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < lighthouse.length; i++) {
            graph.get(lighthouse[i][0]).add(lighthouse[i][1]);
            graph.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        
        dp = new int[2][n + 1];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        
        return dfs(1, -1, 1);
    }
}