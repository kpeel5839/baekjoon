import java.util.*;
import java.io.*;

// 5972 : 택배 배송

/**
 * Example
 * 6 8
 * 4 5 3
 * 2 4 0
 * 4 1 4
 * 2 1 1
 * 5 6 1
 * 3 6 2
 * 3 2 6
 * 3 4 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_5972_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<int[]>> graph = new ArrayList<>();
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

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] dist = new int[N + 1];
        q.add(new int[] {1, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (dist[p[0]] < p[1]) {
                continue;
            }

            if (p[0] == N) {
                System.out.println(p[1]);
                return;
            }

            for (int[] next : graph.get(p[0])) {
                if (next[1] + p[1] < dist[next[0]]) {
                    q.add(new int[] {next[0], next[1] + p[1]});
                    dist[next[0]] = next[1] + p[1];
                }
            }
        }

        System.out.println(-1);
    }
}