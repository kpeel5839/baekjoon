import java.util.*;
import java.io.*;
import java.util.function.Function;

// 14562 : 태권왕

/**
 * Example
 * 6
 * 10 20
 * 2 7
 * 15 62
 * 10 37
 * 11 50
 * 34 59
 */
public class Main {
    public static Map<Integer, Function<Integer, Integer>> da = Map.of(
            0, v -> v + 1,
            1, v -> v * 2
    );
    public static Map<Integer, Function<Integer, Integer>> db = Map.of(
            0, v -> v,
            1, v -> v + 3
    );

    public static boolean outOfRange(int a, int b) {
        return 201 <= a || 201 <= b;
    }

    public static int bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[201][201];
        q.add(new int[] {a, b, 0});
        visited[a][b] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == p[1]) {
                return p[2];
            }

            for (int i = 0; i < 2; i++) {
                int na = da.get(i).apply(p[0]);
                int nb = db.get(i).apply(p[1]);

                if (outOfRange(na, nb) || visited[na][nb]) {
                    continue;
                }

                q.add(new int[] {na, nb, p[2] + 1});
                visited[na][nb] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_14562_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(bfs(a, b));
        }
    }
}