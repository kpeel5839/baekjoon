import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

// 15558 : 점프 게임

/**
 * Example
 * 7 3
 * 1110110
 * 1011001
 */
public class Main {

    public static int N;
    public static int K;
    public static boolean[][] isSafety;
    public static boolean[][] visited;

    public static boolean outOfRange(int index) {
        return index <= 0;
    }

    public static boolean isSuccess(int index) {
        return N < index;
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 0, 1});
        visited[0][1] = true;
        List<Function<int[], int[]>> function = List.of(
                v -> new int[] {v[0] - 1, v[1]},
                v -> new int[] {v[0] + 1, v[1]},
                v -> new int[] {v[0] + K, (v[1] + 1) % 2}
        );

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (Function<int[], int[]> fun : function) {
                int[] next = fun.apply(p);

                if (outOfRange(next[0])) {
                    continue;
                }

                if (isSuccess(next[0])) {
                    return 1;
                }

                if (!isSafety[next[1]][next[0]] || visited[next[1]][next[0]] || next[0] <= p[2]) {
                    continue;
                }

                q.add(new int[] {next[0], next[1], p[2] + 1});
                visited[next[1]][next[0]] = true;
            }

        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_15558_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[2][N + 1];
        isSafety = new boolean[2][N + 1];

        for (int i = 0; i < 2; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                int c = s.charAt(j - 1) - '0';

                if (c == 1) {
                    isSafety[i][j] = true;
                } else {
                    isSafety[i][j] = false;
                }
            }
        }

        System.out.println(bfs());
    }
}