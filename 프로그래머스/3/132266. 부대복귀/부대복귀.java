import java.util.*;

class Solution {
    
    public List<List<Integer>> graph;
    public int[] distance;
    
    public void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});
        distance[start] = 0;
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            
            for (Integer next : graph.get(p[0])) {
                if (distance[next] != -1) {
                    continue;
                }
                
                q.add(new int[] {next, p[1] + 1});
                distance[next] = p[1] + 1;
            }
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList<>();
        distance = new int[n + 1];
        Arrays.fill(distance, -1);
        int[] answer = new int[sources.length];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        
        bfs(destination);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
    
}