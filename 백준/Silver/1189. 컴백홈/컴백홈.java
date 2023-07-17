import java.util.*;
import java.io.*;

// 1189 : 컴백홈

/**
 * Example
 * 3 4 6
 * ....
 * .T..
 * ....
 */
public class Main {

    public static int H;
    public static int W;
    public static int K;
    public static int ans = 0;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static boolean[][] visited;
    public static char[][] map;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static void dfs(int y, int x, int count) {
        if (K < count || visited[y][x]) {
            return;
        }

        if (y == 0 && x == W - 1) {
            if (count == K) {
                ans++;
            }
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (outOfRange(ny, nx) || map[ny][nx] == 'T') {
                continue;
            }

            dfs(ny, nx, count + 1);
        }

        visited[y][x] = false;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1189_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        if (map[0][0] != 'T') {
            dfs(H - 1, 0, 1);
        }

        System.out.println(ans);
    }
}