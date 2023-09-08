import java.util.*;
import java.io.*;

// 2665 : 미로 만들기

/**
 * Example
 * 8
 * 11100110
 * 11010010
 * 10011010
 * 11101100
 * 01000111
 * 00110001
 * 11011000
 * 11000111
 */
public class Main {

    public static int N;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static int[][] visited;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static void bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        q.add(new int[] {0, 0, 0});
        visited[0][0] = 0;

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int y = p[0];
            int x = p[1];
            int count = p[2];

            if (visited[y][x] < count) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (outOfRange(ny, nx)) {
                    continue;
                }

                int nCount = count + (map[ny][nx] == 0 ? 1 : 0);

                if (visited[ny][nx] <= nCount) {
                    continue;
                }

                q.add(new int[] {ny, nx, nCount});
                visited[ny][nx] = nCount;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2665_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }


        bfs();

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(visited[N - 1][N - 1]);
    }
}