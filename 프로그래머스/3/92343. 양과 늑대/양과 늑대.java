import java.util.*;

class Solution {
    
    public List<List<Integer>> graph;
    public int[] info;
    public boolean[] visited;
    public boolean[] nextPossible;
    public int answer = 1;
    
    public void dfs(int current, int sheepCount, int wolfCount) {
        if (visited[current]) {
            return;
        }
        
        if (sheepCount <= wolfCount) {
            return;
        }
        
        answer = Math.max(answer, sheepCount);
        // System.out.println(current + " " + sheepCount + " " + wolfCount);
        visited[current] = true;
        
        for (Integer next : graph.get(current)) {
            if (!visited[next]) {
                nextPossible[next] = true;
            }
        }
        
        for (int i = 0; i < nextPossible.length; i++) {
            if (nextPossible[i]) {
                dfs(i, sheepCount + (info[i] == 0 ? 1 : 0), wolfCount + (info[i] == 1 ? 1 : 0));
            }
        }
        
        for (Integer next : graph.get(current)) {
            if (!visited[next]) {
            	nextPossible[next] = false;
            }
        }
        
        visited[current] = false;
    }
        
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.graph = new ArrayList<>();
        visited = new boolean[info.length];
        nextPossible = new boolean[info.length];
        
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        dfs(0, 1, 0);
        return answer;
    }
}