import java.util.*;
import java.io.*;

// 1743 : 음식물 피하기

/**
 * Example
 * 3 4 5
 * 3 2
 * 2 2
 * 3 1
 * 2 3
 * 1 1
 */
public class Main {

    public static int H;
    public static int W;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static boolean[][] visited;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        visited[y][x] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || map[ny][nx] != 1) {
                    continue;
                }

                visited[ny][nx] = true;
                q.add(new int[] {ny, nx});
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1743_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        int ans = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }

        System.out.println(ans);
    }
}