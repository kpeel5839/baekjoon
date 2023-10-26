import java.util.*;
import java.io.*;

// 17484 : 진우의 달 여행 (small)

/**
 * Example
 * 6 4
 * 5 8 5 1
 * 3 5 8 4
 * 9 77 65 5
 * 2 1 5 2
 * 5 98 1 5
 * 4 95 67 58
 */
public class Main {

    public static int H;
    public static int W;
    public static int[][][] visited;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1};
    public static int[] dy = {1, 1, 1};

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (outOfRange(ny, nx)) {
                continue;
            }

            visited[i][ny][nx] = map[y][x] + map[ny][nx];
            q.add(new int[] {ny, nx, i, visited[i][ny][nx]});
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int i = 0; i < 3; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (p[2] == i || outOfRange(ny, nx) || visited[i][ny][nx] <= p[3] + map[ny][nx]) {
                    continue;
                }

                visited[i][ny][nx] = p[3] + map[ny][nx];
                q.add(new int[] {ny, nx, i, visited[i][ny][nx]});
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < W; j++) {
                min = Math.min(min, visited[i][H - 1][j]);
            }
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17484_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new int[3][H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                for (int c = 0; c < 3; c++) {
                    visited[c][i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < W; i++) {
            ans = Math.min(ans, bfs(0, i));
        }

        System.out.println(ans);
    }
}