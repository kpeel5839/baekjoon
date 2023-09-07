import java.util.*;
import java.io.*;

// 11437 : LCA

/**
 * Example
 * 15
 * 1 2
 * 1 3
 * 2 4
 * 3 7
 * 6 2
 * 3 8
 * 4 9
 * 2 5
 * 5 11
 * 7 13
 * 10 4
 * 11 15
 * 12 5
 * 14 7
 * 6
 * 6 11
 * 10 9
 * 2 6
 * 7 6
 * 8 13
 * 8 15
 */
public class Main {

    public static List<List<Integer>> g = new ArrayList<>();
    public static int[][] p;
    public static int[] d;

    public static void dfs(int parent, int cur, int depth) { // depth == 1 부터 시작
        d[cur] = depth;

        for (Integer next : g.get(cur)) {
            if (next != parent) {
                p[0][next] = cur;
                dfs(cur, next, depth + 1);
            }
        }
    }

    public static void getP() {
        for (int i = 1; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                p[i][j] = p[i - 1][p[i - 1][j]];
            }
        }
    }

    public static int lca(int a, int b) {
        if (d[a] < d[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = p.length - 1; 0 <= i; i--) {
            if ((1 << i) <= (d[a] - d[b])) {
                a = p[i][a];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = p.length - 1; 0 <= i; i--) {
            if (p[i][a] != p[i][b]) {
                a = p[i][a];
                b = p[i][b];
            }
        }

        return p[0][a];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11437_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            g.get(b).add(a);
        }

        p = new int[(int) Math.ceil(Math.log(N) / Math.log(2)) + 1][N + 1];
        d = new int[N + 1];
        dfs(-1, 1, 1);
        getP();

        int M = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ans.append(lca(a, b)).append("\n");
        }
        System.out.println(ans);
    }
}