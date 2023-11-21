import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < road.length; i++) {
            graph.get(road[i][0]).add(new int[] {road[i][1], road[i][2]});
            graph.get(road[i][1]).add(new int[] {road[i][0], road[i][2]});
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        q.add(new int[] {1, 0});
        dist[1] = 0;
        
        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (dist[p[0]] < p[1]) {
                continue;
            }
            
            for (int[] next : graph.get(p[0])) {
                if (p[1] + next[1] < dist[next[0]]) {
                    dist[next[0]] = p[1] + next[1];
                    q.add(new int[] {next[0], dist[next[0]]});
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}