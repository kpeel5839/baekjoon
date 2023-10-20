import java.util.*;
import java.io.*;

// 9335 : 소셜광고

/**
 * Example
 * 2
 * 5
 * 4 2 3 4 5
 * 4 1 3 4 5
 * 4 1 2 4 5
 * 4 1 2 3 5
 * 4 1 2 3 4
 * 5
 * 2 4 5
 * 2 3 5
 * 1 2
 * 2 1 5
 * 3 1 2 4
 */
public class Main {

    public static int N;
    public static List<List<Integer>> graph;
    public static boolean[] visited;
    public static int count = 0;
    public static int ans = Integer.MAX_VALUE;

    public static void dfs(int index, int selected) {
        if (count == N) {
            ans = Math.min(ans, selected);
            return;
        }

        if (index == N) {
            return;
        }

        dfs(index + 1, selected);

        List<Integer> list = new ArrayList<>();
        for (int next : graph.get(index)) {
            if (!visited[next]) {
                visited[next] = true;
                count++;
                list.add(next);
            }
        }

        dfs(index + 1, selected + 1);

        for (int next : list) {
            visited[next] = false;
            count--;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9335_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N];
            graph = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int M = Integer.parseInt(st.nextToken());

                for (int j = 0; j < M; j++) {
                    graph.get(i).add(Integer.parseInt(st.nextToken()) - 1);
                }

                graph.get(i).add(i);
            }

            count = 0;
            ans = Integer.MAX_VALUE;
            dfs(0, 0);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}