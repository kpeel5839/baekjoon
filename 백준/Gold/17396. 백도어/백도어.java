import java.util.*;
import java.io.*;

// 17396 : 백도어

/**
 * Example
 * 5 7
 * 0 0 0 1 1
 * 0 1 7
 * 0 2 2
 * 1 2 4
 * 1 3 3
 * 1 4 6
 * 2 3 2
 * 3 4 1
 */
public class Main {

    public static int N;
    public static int M;
    public static int[] isArrive;
    public static List<List<int[]>> graph = new ArrayList<>();

    public static long dijkstra() {
        PriorityQueue<long[]> q = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
        long[] dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        q.add(new long[] {0, 0});
        dist[0] = 0;

        while (!q.isEmpty()) {
            long[] p = q.poll();

            if (dist[(int) p[0]] < p[1]) {
                continue;
            }

            if (p[0] == N - 1) {
                return p[1];
            }

            for (int[] next : graph.get((int) p[0])) {
                if (isArrive[next[0]] == 0 && p[1] + next[1] < dist[next[0]]) {
                    dist[next[0]] = p[1] + next[1];
                    q.add(new long[] {next[0], dist[next[0]]});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17396_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isArrive = new int[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            isArrive[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[] {b, c});
            graph.get(b).add(new int[] {a, c});
        }

        isArrive[N - 1] = 0;
        System.out.println(dijkstra());
    }
}