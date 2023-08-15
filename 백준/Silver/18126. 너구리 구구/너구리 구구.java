import java.util.*;
import java.io.*;

// 18126 : 너구리 구구

/**
 * Example
 * 4
 * 1 2 3
 * 2 3 2
 * 2 4 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_18126_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<List<int[]>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new int[] {b, c});
            list.get(b).add(new int[] {a, c});
        }

        Queue<long[]> q = new LinkedList<>();
        q.add(new long[] {1, 0});
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        long ans = 0;

        while (!q.isEmpty()) {
            long[] p = q.poll();

            for (int[] next : list.get((int) p[0])) {
                if (!visited[next[0]]) {
                    long cost = p[1] + next[1];
                    q.add(new long[] {next[0], cost});
                    visited[next[0]] = true;
                    ans = Math.max(ans, cost);
                }
            }
        }

        System.out.println(ans);
    }
}