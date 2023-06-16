import java.util.*;
import java.io.*;

// 2468 : 안전 영역

/**
 * Example
 * 5
 * 6 8 2 6 2
 * 3 2 3 4 6
 * 6 7 3 3 2
 * 7 2 5 3 6
 * 8 9 5 2 7
 */
public class Main {

    public static int N;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {-1, 0, 1, 0};

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static void bfs(int y, int x, int value) {
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[] {y, x});

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || arr[ny][nx] <= value) {
                    continue;
                }

                visited[ny][nx] = true;
                q.add(new int[] {ny, nx});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2468_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                max = Math.max(max, v);
                arr[i][j] = v;
            }
        }

        int ans = 1;
        for (int k = 1; k < max; k++) {
            visited = new boolean[N][N];
            int numberOfIsland = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (k < arr[i][j] && !visited[i][j]) {
                        numberOfIsland++;
                        bfs(i, j, k);
                    }
                }
            }

            ans = Math.max(ans, numberOfIsland);
        }

        System.out.println(ans);
    }
}