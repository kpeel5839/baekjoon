import java.util.*;
import java.io.*;

// 13023 : ABCDE

/**
 * Example
 * 5 4
 * 0 1
 * 1 2
 * 2 3
 * 3 4
 */
public class Main {
    public static int N;
    public static int M;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static boolean dfs(int index, int depth) {
        if (visited[index]) {
            return false;
        }
        
        if (depth == 4) {
            return true;
        }

        visited[index] = true;

        for (Integer next : graph.get(index)) {
            if (dfs(next, depth + 1)) {
                return true;
            }
        }

        visited[index] = false;
        return false;
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13023_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            if (dfs(i, 0)) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}