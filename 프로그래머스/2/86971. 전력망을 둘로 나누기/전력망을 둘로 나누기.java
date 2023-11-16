import java.util.*;

class Solution {
    
    public List<List<Integer>> graph;
    
    public int dfs(int cur, int parent, int ban) {
        int nodeCount = 1;
        
        for (Integer next : graph.get(cur)) {
            if (next != parent && next != ban) {
                nodeCount += dfs(next, cur, ban);
            }
        }
        
        return nodeCount;
    }
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList<>();
        int ans = n;
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < wires.length; i++) {
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        for (int i = 2; i <= n; i++) {
            int firstSubtreeCount = dfs(1, -1, i);
            int secondSubtreeCount = n - firstSubtreeCount;
            
            ans = Math.min(ans, Math.abs(firstSubtreeCount - secondSubtreeCount));
        }
        
        return ans;
    }
}