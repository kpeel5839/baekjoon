import java.util.*;
import java.io.*;

// 11562 : 백양로 브레이크

/**
 * Example
 * 4 3
 * 1 2 0
 * 2 3 1
 * 3 4 0
 * 7
 * 1 1
 * 1 2
 * 2 1
 * 1 4
 * 4 1
 * 2 3
 * 4 3
 */
public class Main {

    public static int N;
    public static int M;
    public static int[][] visited;
    public static List<List<int[]>> graph = new LinkedList<>();

    public static void bfs(int start) {
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});

        while (!q.isEmpty()) {
            int[] p = q.pollFirst();

            if (visited[start][p[0]] != -1) {
                continue;
            }

            visited[start][p[0]] = p[1];

            for (int[] next : graph.get(p[0])) {
                if (next[1] == 0) {
                    q.addFirst(new int[] {next[0], p[1]});
                } else {
                    q.addLast(new int[] {next[0], p[1] + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11562_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(visited[i], -1);
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (c == 0) {
                graph.get(a).add(new int[] {b, 0});
                graph.get(b).add(new int[] {a, 1});
            } else {
                graph.get(a).add(new int[] {b, 0});
                graph.get(b).add(new int[] {a, 0});
            }
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        int queryCount = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < queryCount; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ans.append(visited[a][b]).append("\n");
        }

        System.out.println(ans);
    }
}