import java.util.*;
import java.io.*;

// 1389 : 케빈 베이컨의 6단계 법칙

/**
 * Example
 * 5 5
 * 1 3
 * 1 4
 * 4 5
 * 4 3
 * 3 2
 */
public class Main {

    public static int N;
    public static List<ArrayList<Integer>> graph = new ArrayList<>();

    public static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(new int[] {start, 0});
        visited[start] = true;
        int result = 0;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (Integer next : graph.get(point[0])) {
                if (!visited[next]) {
                    result += point[1] + 1;
                    q.add(new int[] {next, point[1] + 1});
                    visited[next] = true;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1389_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] result = new int[N + 1];

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

        for (int i = 1; i <= N; i++) {
            result[i] = bfs(i);
        }

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 1; i <= N; i++) {
            if (result[i] < min) {
                min = result[i];
                minIndex = i;
            }
        }

        System.out.println(minIndex);
    }
}