import java.util.*;
import java.io.*;

// 18405 : 경쟁적 전염

/**
 * Example
 * 3 3
 * 1 0 2
 * 0 0 0
 * 3 0 0
 * 2 3 2
 */
public class Main {

    public static int N;
    public static int K;
    public static int[][] map;
    public static int S;
    public static int X;
    public static int Y;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static int bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) {
                return o1[3] - o2[3];
            }

            return o1[2] - o2[2];
        });

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    q.add(new int[] {i, j, 0, map[i][j]});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (S <= p[2]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny, nx) || map[ny][nx] != 0) {
                    continue;
                }

                map[ny][nx] = p[3];
                q.add(new int[] {ny, nx, p[2] + 1, p[3]});
            }
        }

        return map[X][Y];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_18405_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;
        System.out.println(bfs());
    }
}