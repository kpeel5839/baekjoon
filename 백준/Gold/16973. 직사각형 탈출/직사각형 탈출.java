import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 16973 : 직사각형 탈출

/**
 * Example
 * 4 5
 * 0 0 0 0 0
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 0 0
 * 2 2 1 1 1 4
 */
public class Main {

    public static int H;
    public static int W;
    public static int rh;
    public static int rw;
    public static int rsh;
    public static int rsw;
    public static int rdh;
    public static int rdw;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static boolean outOfRange(int y, int x) {
        return outOfRangeVertex(y, x) ||
                outOfRangeVertex(y, x + rw - 1) ||
                outOfRangeVertex(y + rh - 1, x) ||
                outOfRangeVertex(y + rh - 1, x + rw - 1);
    }

    public static boolean outOfRangeVertex(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static boolean isPossibleMoveNextPosition(int y, int x, int dir) {
        boolean isPossible = true;
        if (dir == 0) {
            for (int i = x; i < x + rw; i++) {
                if (map[y][i] == 1) {
                    isPossible = false;
                }
            }
        } else if (dir == 1) {
            for (int i = y; i < y + rh; i++) {
                if (map[i][x + rw - 1] == 1) {
                    isPossible = false;
                }
            }
        } else if (dir == 2) {
            for (int i = x; i < x + rw; i++) {
                if (map[y + rh - 1][i] == 1) {
                    isPossible = false;
                }
            }
        } else {
            for (int i = y; i < y + rh; i++) {
                if (map[i][x] == 1) {
                    isPossible = false;
                }
            }
        }

        return isPossible;
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {rsh, rsw, 0});
        visited[rsh][rsw] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == rdh && p[1] == rdw) {
                return p[2];
            }

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || !isPossibleMoveNextPosition(ny, nx, i)) {
                    continue;
                }

                visited[ny][nx] = true;
                q.add(new int[] {ny, nx, p[2] + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16973_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        rh = Integer.parseInt(st.nextToken());
        rw = Integer.parseInt(st.nextToken());
        rsh = Integer.parseInt(st.nextToken()) - 1;
        rsw = Integer.parseInt(st.nextToken()) - 1;
        rdh = Integer.parseInt(st.nextToken()) - 1;
        rdw = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs());
    }
}