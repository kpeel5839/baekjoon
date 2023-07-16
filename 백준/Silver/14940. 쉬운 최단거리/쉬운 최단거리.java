import java.util.*;
import java.io.*;

// 14940 : 쉬운 최단거리

/**
 * Example
 * 15 15
 * 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
 * 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
 * 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
 */
public class Main {

    public static int H;
    public static int W;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static int[][] visited;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static void bfs(int[] startPoint) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startPoint[0], startPoint[1], 0});
        visited[startPoint[0]][startPoint[1]] = 0;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] != -1) {
                    continue;
                }

                q.add(new int[] {ny, nx, point[2] + 1});
                visited[ny][nx] = point[2] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_14940_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new int[H][W];
        int[] startPoint = new int[2];

        for (int i = 0; i < H; i++) {

            st = new StringTokenizer(br.readLine());
            Arrays.fill(visited[i], -1);

            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    visited[i][j] = map[i][j];
                }

                if (map[i][j] == 2) {
                    startPoint[0] = i;
                    startPoint[1] = j;
                }
            }

        }

        bfs(startPoint);

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                bw.write(visited[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}