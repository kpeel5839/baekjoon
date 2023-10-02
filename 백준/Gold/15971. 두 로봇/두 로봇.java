import java.util.*;
import java.io.*;

// 15971 : 두 로봇

/**
 * Example
 * 5 1 5
 * 1 2 1
 * 2 3 2
 * 3 4 3
 * 4 5 4
 */
public class Main {

    public static List<List<int[]>> graph = new ArrayList<>();
    public static int A;
    public static int B;
    public static int[] ans = new int[2];

    public static void dfs(int parent, int current, int total, int max) {
        if (current == B) {
            ans[0] = total;
            ans[1] = max;
            return;
        }

        for (int[] next : graph.get(current)) {
            if (next[0] != parent) {
                dfs(current, next[0], total + next[1], Math.max(max, next[1]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_15971_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

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

        dfs(-1, A, 0, 0);
        System.out.println(ans[0] - ans[1]);
    }
}
