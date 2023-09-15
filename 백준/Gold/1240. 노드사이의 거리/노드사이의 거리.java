import java.util.*;
import java.io.*;

// 1240 : 노드 사이의 거리

/**
 * Example
 * 4 2
 * 2 1 2
 * 4 3 2
 * 1 4 3
 * 1 2
 * 3 2
 */
public class Main {

    public static boolean end;
    public static int ans;
    public static int goal;
    public static List<List<int[]>> graph = new ArrayList<>();

    public static void dfs(int parent, int current, int distance) {
        if (end) {
            return;
        }

        if (goal == current) {
            end = true;
            ans = distance;
            return;
        }

        for (int[] next : graph.get(current)) {
            if (next[0] != parent) {
                dfs(current, next[0], distance + next[1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1240_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[] {b, c});
            graph.get(b).add(new int[] {a, c});
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ans = 0;
            end = false;
            goal = b;

            dfs(-1, a, 0);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}