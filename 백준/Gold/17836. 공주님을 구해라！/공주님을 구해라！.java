import java.util.*;
import java.io.*;

// 17836 : 공주님을 구해라

/**
 * Example
 * 6 6 16
 * 0 0 0 0 1 1
 * 0 0 0 0 0 2
 * 1 1 1 0 1 0
 * 0 0 0 0 0 0
 * 0 1 1 1 1 1
 * 0 0 0 0 0 0
 */
public class Main {

    public static int H;
    public static int W;
    public static int T;
    public static int[][] map;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static boolean[][][] visited;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (T < p[3]) {
                continue;
            }

            if (p[0] == H - 1 && p[1] == W - 1) {
                return p[3];
            }

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny, nx) || (p[2] != 2 && map[ny][nx] == 1)) {
                    continue;
                }

                int sword = p[2];

                if (map[ny][nx] != 1) {
                    sword |= map[ny][nx];
                }

                if (visited[sword][ny][nx]) {
                    continue;
                }

                visited[sword][ny][nx] = true;
                q.add(new int[] {ny, nx, sword, p[3] + 1});
            }
        }

        return -1;
    }


    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17836_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        visited = new boolean[3][H][W];
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();

        if (result == -1) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }
}