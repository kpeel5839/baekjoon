import java.util.*;
import java.io.*;

// 16948 : 데스 나이트

/**
 * Example
 * 7
 * 6 6 0 1
 */
public class Main {

    public static int N;
    // (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)
    public static int[] dx = {-1, 1, -2, 2, -1, 1};
    public static int[] dy = {-2, -2, 0, 0, 2, 2};

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static int bfs(int y, int x, int desY, int desX) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x, 0});
        boolean[][] visited = new boolean[N][N];
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[0] == desY && point[1] == desX) {
                return point[2];
            }

            for (int i = 0; i < dy.length; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;
                q.add(new int[] {ny, nx, point[2] + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16948_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        System.out.println(bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
}