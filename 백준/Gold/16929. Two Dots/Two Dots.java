import java.util.*;
import java.io.*;

// 16929 : Two Dots

/**
 * Example
 * 3 4
 * AAAA
 * ABCA
 * AAAA
 */
public class Main {

    public static int H;
    public static int W;
    public static char[][] map;
    public static int[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static boolean dfs(int y, int x, int distance, char color) {
        visited[y][x] = distance;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (outOfRange(ny, nx) || map[ny][nx] != color) {
                continue;
            }

            if (visited[ny][nx] != -1 && (distance - visited[ny][nx]) >= 3) {
                return true;
            }

            if (visited[ny][nx] != -1) {
                continue;
            }

            if (dfs(ny, nx, distance + 1, color)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16929_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visited = new int[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
                visited[i][j] = -1;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (visited[i][j] == -1) {
                    if (dfs(i, j, 0, map[i][j])) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");
    }
}