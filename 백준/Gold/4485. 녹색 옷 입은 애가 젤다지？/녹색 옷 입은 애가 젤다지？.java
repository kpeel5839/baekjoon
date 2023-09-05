import java.util.*;
import java.io.*;

// 4485 : 녹색 옷 입은 젤다

/**
 * Example
 * 3
 * 5 5 4
 * 3 9 1
 * 3 2 7
 * 5
 * 3 7 2 0 1
 * 2 8 0 9 1
 * 1 2 1 8 1
 * 9 8 9 2 0
 * 3 6 5 1 5
 * 7
 * 9 0 5 1 1 5 3
 * 4 1 2 1 6 5 3
 * 0 7 6 1 6 8 5
 * 1 1 7 8 3 2 3
 * 9 4 0 7 6 4 1
 * 5 8 3 2 4 8 3
 * 7 4 8 4 8 3 4
 * 0
 */
public class Main {

    public static int N;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static int dfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int[][] dist = new int[N][N];

        for (final int[] ints : dist) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        q.add(new int[] {0, 0, map[0][0]});
        dist[0][0] = map[0][0];

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (dist[p[0]][p[1]] < p[2]) {
                continue;
            }

            if (p[0] == N - 1 && p[1] == N - 1) {
                return p[2];
            }

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny, nx)) {
                    continue;
                }

                if (p[2] + map[ny][nx] < dist[ny][nx]) {
                    dist[ny][nx] = p[2] + map[ny][nx];
                    q.add(new int[] {ny, nx, p[2] + map[ny][nx]});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_4485_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int index = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = dfs();
            bw.write(String.format("Problem %s: %s", index++, result) + "\n");
        }

        bw.flush();
        bw.close();
    }
}

