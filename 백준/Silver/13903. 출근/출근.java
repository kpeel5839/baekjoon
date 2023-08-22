import java.util.*;
import java.io.*;

// 13903 : 출근

/**
 * Example
 * 4 5
 * 1 0 1 0 1
 * 0 1 1 0 0
 * 1 1 0 1 0
 * 1 0 1 1 1
 * 8
 * -2 -1
 * -2 1
 * -1 -2
 * -1 2
 * 1 -2
 * 1 2
 * 2 -1
 * 2 1
 */
public class Main {

    public static int H;
    public static int W;
    public static int[][] map;
    public static List<Integer> dy = new ArrayList<>();
    public static List<Integer> dx = new ArrayList<>();

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[H][W];
        for (int i = 0; i < W; i++) {
            if (map[0][i] == 1) {
                q.add(new int[] {0, i, 0});
                visited[0][i] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == H - 1) {
                return p[2];
            }

            for (int i = 0; i < dy.size(); i++) {
                int ny = p[0] + dy.get(i);
                int nx = p[1] + dx.get(i);

                if (outOfRange(ny, nx) || visited[ny][nx] || map[ny][nx] == 0) {
                    continue;
                }

                q.add(new int[] {ny, nx, p[2] + 1});
                visited[ny][nx] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13903_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dy.add(Integer.parseInt(st.nextToken()));
            dx.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(bfs());
    }
}