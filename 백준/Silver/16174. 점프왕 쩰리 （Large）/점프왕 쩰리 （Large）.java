import java.util.*;
import java.io.*;

// 16174 : 점프왕 쩰리 (Large)

/**
 * Example
 * 3
 * 1 1 10
 * 1 5 1
 * 2 2 -1
 */
public class Main {
    public static final String WIN = "HaruHaru";
    public static final String LOSE = "Hing";
    public static int N;
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};
    public static int[][] map;
    public static boolean[][] visited;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16174_problem/src/input.txt"));
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

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == N - 1 && p[1] == N - 1) {
                System.out.println(WIN);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int ny = p[0] + map[p[0]][p[1]] * dy[i];
                int nx = p[1] + map[p[0]][p[1]] * dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx]) {
                    continue;
                }

                q.add(new int[] {ny, nx});
                visited[ny][nx] = true;
            }
        }

        System.out.println(LOSE);
    }
}