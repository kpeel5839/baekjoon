import java.util.*;
import java.io.*;

// 15900 : 나무 탈출

/**
 * Example
 * 2
 * 2 1
 */
public class Main {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static int ans;

    public static void dfs(int p, int c, int distance) {
        int childCount = 0;

        for (Integer next : graph.get(c)) {
            if (next != p) {
                childCount++;
                dfs(c, next, distance + 1);
            }
        }

        if (childCount == 0) {
            ans += distance;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_15900_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
            graph.get(a).add(b);
        }

        dfs(-1, 1, 0);
        System.out.println(ans % 2 == 0 ? "No" : "Yes");
    }
}

