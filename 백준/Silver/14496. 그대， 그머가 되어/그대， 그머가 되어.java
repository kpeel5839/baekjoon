import java.util.*;
import java.io.*;

// 14496 : 그대, 그머가 되어

/**
 * Example
 * 1 2
 * 4 4
 * 1 3
 * 1 4
 * 3 2
 * 4 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_14496_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[N + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {A, 0});
        visited[A] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == B) {
                System.out.println(p[1]);
                return;
            }

            for (Integer next : graph.get(p[0])) {
                if (!visited[next]) {
                    q.add(new int[] {next, p[1] + 1});
                    visited[next] = true;
                }
            }
        }

        System.out.println(-1);
    }
}