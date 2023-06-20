import java.util.*;
import java.io.*;

// 1325 : 효율적인 해킹

/**
 * Example
 * 5 4
 * 3 1
 * 3 2
 * 4 3
 * 5 3
 */
public class Main {

    public static int N;
    public static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] hack;
    public static boolean[] visited;

    public static void bfs(int c) {
        Queue<Integer> q = new LinkedList<>();
        q.add(c);
        visited[c] = true;

        while (!q.isEmpty()) {
            int point = q.poll();

            for (Integer next : graph.get(point)) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    hack[next]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1325_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        hack = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        int max = Arrays.stream(hack).max().getAsInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (max == hack[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}