import java.util.*;
import java.io.*;

// 17204 : 죽음의 게임

/**
 * Example
 * 5 3
 * 1
 * 3
 * 2
 * 1
 * 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17204_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            graph.get(i).add(Integer.parseInt(br.readLine()));
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(new int[] {0, 1});

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == K) {
                System.out.println(p[1] - 1);
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