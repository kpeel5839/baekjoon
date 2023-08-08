import java.util.*;
import java.io.*;

// 18404 : 현명한 나이트

/**
 * Example
 * 5 3
 * 2 4
 * 3 2
 * 3 5
 * 4 5
 */
public class Main {
    public static int N;
    public static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[][] visited;
    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }
    public static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x, 0});
        visited = new int[N][N];
        visited[y][x] = 0;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] != 0) {
                    continue;
                }

                q.add(new int[] {ny, nx, p[2] + 1});
                visited[ny][nx] = p[2] + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_18404_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] start = new int[] {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        bfs(start[0], start[1]);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            System.out.print(visited[y][x] + " ");
        }
    }
}