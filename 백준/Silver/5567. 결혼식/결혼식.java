import java.util.*;
import java.io.*;

// 5567 : 결혼식

/**
 * Example
 * 6
 * 5
 * 1 2
 * 1 3
 * 3 4
 * 2 3
 * 4 5
 */
public class Main {

    public static List<ArrayList<Integer>> g = new ArrayList<>();
    public static boolean[] visited;
    public static int count;

    public static void bfs(int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {c, 0});
        visited[c] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[1] == 1 || point[1] == 2) {
                count++;
            }

            for (Integer next : g.get(point[0])) {
                if (!visited[next]) {
                    q.add(new int[] {next, point[1] + 1});
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_5567_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g.get(a).add(b);
            g.get(b).add(a);
        }

        bfs(1);
        System.out.println(count);
    }
}