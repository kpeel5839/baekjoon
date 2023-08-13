import java.util.*;
import java.io.*;

// 21938 : 영상처리

/**
 * Example
 * 3 3
 * 255 255 255 100 100 100 255 255 255
 * 100 100 100 255 255 255 100 100 100
 * 255 255 255 100 100 100 255 255 255
 * 101
 */
public class Main {
    public static int H;
    public static int W;
    public static int T;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static boolean[][] visited;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static void bfs(int y, int x) {
        // 255 만 간으
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || map[ny][nx] == 0) {
                    continue;
                }

                q.add(new int[] {ny, nx});
                visited[ny][nx] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_21938_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                for (int c = 0; c < 3; c++) {
                    map[i][j] += Integer.parseInt(st.nextToken());
                }
                map[i][j] /= 3;
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (T <= map[i][j]) {
                    map[i][j] = 255;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 255 && !visited[i][j]) {
                    bfs(i, j);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}