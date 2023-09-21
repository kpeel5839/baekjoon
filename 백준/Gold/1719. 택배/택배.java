import java.util.*;
import java.io.*;

// 1719 : 택배

/**
 * Example
 * 6 10
 * 1 2 2
 * 1 3 1
 * 2 4 5
 * 2 5 3
 * 2 6 7
 * 3 4 4
 * 3 5 6
 * 3 6 7
 * 4 6 4
 * 5 6 2
 */
public class Main {

    public static int N;
    public static int M;
    public static List<List<int[]>> graph = new ArrayList<>();
    public static int[][] ans;

    public static void dijkstra(int start) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] dist = new int[N + 1];
        int[] first = new int[N + 1];
        q.add(new int[] {start, 0, -1});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[1] < dist[start]) {
                continue;
            }

            for (int[] next : graph.get(p[0])) {
                if (p[1] + next[1] < dist[next[0]]) {
                    int firstVertex = p[2];

                    if (firstVertex == -1) {
                        firstVertex = next[0];
                    }

                    first[next[0]] = firstVertex;
                    dist[next[0]] = p[1] + next[1];
                    q.add(new int[] {next[0], dist[next[0]], firstVertex});
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            ans[start - 1][i - 1] = first[i];
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1719_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[N][N];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[] {b, c});
            graph.get(b).add(new int[] {a, c});
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    sb.append("-").append(" ");
                } else {
                    sb.append(ans[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}