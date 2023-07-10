import java.util.*;
import java.io.*;

// 17086 : 아기 상어 2

/**
 * Example
 * 5 4
 * 0 0 1 0
 * 0 0 0 0
 * 1 0 0 0
 * 0 0 0 0
 * 0 0 0 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17086_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                visited[i][j] = -1;
                if (Integer.parseInt(st.nextToken()) == 1) {
                    q.add(new int[] {i, j, 0});
                    visited[i][j] = 0;
                }
            }
        }

        int ans = 0;
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!q.isEmpty()) {
            int[] point = q.poll();
            ans = Math.max(ans, point[2]);

            for (int i = 0; i < 8; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (ny < 0 || ny >= H || nx < 0 || nx >= W || visited[ny][nx] != -1) {
                    continue;
                }

                q.add(new int[] {ny, nx, point[2] + 1});
                visited[ny][nx] = point[2] + 1;
            }
        }

        System.out.println(ans);
    }
}