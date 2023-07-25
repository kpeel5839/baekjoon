import java.util.*;
import java.io.*;

// 16173 : 점프왕 쩰리 (Small)

/**
 * Example
 * 3
 * 1 1 10
 * 1 5 1
 * 2 2 -1
 */
public class Main {
    public static int N;
    public static int[] dx = {0, 1};
    public static int[] dy = {1, 0};
    public static int[][] map;
    public static boolean[][] visited;
    public static boolean ans = false;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static void dfs(int y, int x) {
        if (ans) {
            return;
        }

        if (y == N - 1 && x == N - 1) {
            ans = true;
            return;
        }

        if (outOfRange(y, x) || visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 2; i++) {
            int ny = y + (dy[i] * map[y][x]);
            int nx = x + (dx[i] * map[y][x]);

            dfs(ny, nx);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16173_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(ans ? "HaruHaru" : "Hing");
    }
}