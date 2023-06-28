import java.util.*;
import java.io.*;

// 24480 : 알고리즘 수업 - 깊이 우선 탐색 2

/**
 * Example
 * 5 5 1
 * 1 4
 * 1 2
 * 2 3
 * 2 4
 * 3 4
 */
public class Main {

    public static List<List<Integer>> g = new ArrayList<>();
    public static int[] visited;
    public static int count = 1;

    public static void dfs(int c) {
        if (visited[c] != 0) {
            return;
        }

        visited[c] = count++;

        for (Integer next : g.get(c)) {
            dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_24479_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g.get(a).add(b);
            g.get(b).add(a);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(g.get(i), (o1, o2) -> o2 - o1);
        }

        dfs(X);

        for (int i = 1; i <= N; i++) {
            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
