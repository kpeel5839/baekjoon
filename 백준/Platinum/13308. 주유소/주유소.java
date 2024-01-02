import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 13308 : 주유소

/**
 * Example
 * 4 4
 * 5 2 4 1
 * 3 1 3
 * 1 2 2
 * 4 3 4
 * 2 4 15
 */
public class Main {

    public static int n;
    public static int m;
    public static final long INF = Long.MAX_VALUE;
    public static int[] oil;
    public static List<List<int[]>> graph;
    public static long[][] dp;

    public static long dijkstra() {
        PriorityQueue<long[]> q = new PriorityQueue<>((o1, o2) -> Long.compare(o1[2], o2[2]));
        q.add(new long[] {oil[1], 1, 0});
        dp[oil[1]][1] = 0;

        while (!q.isEmpty()) {
            long[] p = q.poll();
            int minOil = (int) p[0];
            int index = (int) p[1];

            if (dp[minOil][index] < p[2]) {
                continue;
            }

            if (p[1] == n) {
                return p[2];
            }

            for (int[] next : graph.get(index)) {
                int nextMinOil = Math.min(minOil, oil[next[0]]);

                if (p[2] + ((long) minOil * next[1]) < dp[nextMinOil][next[0]]) {
                    dp[nextMinOil][next[0]] = p[2] + ((long) minOil * next[1]);
                    q.add(new long[] {nextMinOil, next[0], dp[nextMinOil][next[0]]});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_13308_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        oil = new int[n + 1];
        dp = new long[2501][n + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[] {b, c});
            graph.get(b).add(new int[] {a, c});
        }

        System.out.println(dijkstra());
    }
}