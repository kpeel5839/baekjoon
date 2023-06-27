import java.util.*;
import java.io.*;

// 4963 : 섬의 개수

/**
 * Example
 * 1 1
 * 0
 * 2 2
 * 0 1
 * 1 0
 * 3 2
 * 1 1 1
 * 1 1 1
 * 5 4
 * 1 0 1 0 0
 * 1 0 0 0 0
 * 1 0 1 0 1
 * 1 0 0 1 0
 * 5 4
 * 1 1 1 0 1
 * 1 0 1 0 1
 * 1 0 1 0 1
 * 1 0 1 1 1
 * 5 5
 * 1 0 1 0 1
 * 0 0 0 0 0
 * 1 0 1 0 1
 * 0 0 0 0 0
 * 1 0 1 0 1
 * 0 0
 */
public class Main {

    public static int H;
    public static int W;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int i = 0; i < 8; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || arr[ny][nx] == 0) {
                    continue;
                }

                visited[ny][nx] = true;
                q.add(new int[] {ny, nx});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_4693_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (H == 0 && W == 0) {
                break;
            }

            arr = new int[H][W];
            visited = new boolean[H][W];
            int numberOfIsland = 0;

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        numberOfIsland++;
                        bfs(i, j);
                    }
                }
            }

            bw.write(numberOfIsland + "\n");
        }

        bw.flush();
        bw.close();
    }
}