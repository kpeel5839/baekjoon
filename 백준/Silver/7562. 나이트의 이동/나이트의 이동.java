import java.util.*;
import java.io.*;

// 7562 : 나이트의 이동

/**
 * Example
 * 3
 * 8
 * 0 0
 * 7 0
 * 100
 * 0 0
 * 30 50
 * 10
 * 1 1
 * 1 1
 */
public class Main {

    public static int N;
    public static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] start = new int[2];
    public static int[] goal = new int[2];
    public static boolean[][] visited;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[0] == goal[0] && point[1] == goal[1]) {
                return point[2];
            }

            for (int i = 0; i < dx.length; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx]) {
                    continue;
                }

                q.add(new int[] {ny, nx, point[2] + 1});
                visited[ny][nx] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_7562_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());

            visited = new boolean[N][N];
            bw.write(bfs() + "\n");
        }

        bw.flush();
        bw.close();
    }
}