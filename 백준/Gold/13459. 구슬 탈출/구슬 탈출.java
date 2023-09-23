import java.util.*;
import java.io.*;

// 13459 : 구슬 탈출

/**
 * Example
 * 5 5
 * #####
 * #..B#
 * #.#.#
 * #RO.#
 * #####
 */
public class Main {

    public static int H;
    public static int W;
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {-1, 0, 1, 0};
    public static int[] redStart;
    public static int[] blueStart;
    public static char[][] map;
    public static boolean[][][][] visited;
    public static int[] INVALID_POSITION = new int[] {-1, -1, -1, -1};

    public static boolean isWall(int y, int x) {
        return map[y][x] == '#';
    }

    public static boolean isWhole(int y, int x) {
        return map[y][x] == 'O';
    }

    public static boolean isNotPossible(int[] next) {
        return next[0] == -1 && next[1] == -1 && next[2] == -1 && next[3] == -1;
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {redStart[0], redStart[1], blueStart[0], blueStart[1], 0});
        visited[redStart[0]][redStart[1]][blueStart[0]][blueStart[1]] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (10 < p[4]) {
                continue;
            }

            if (isWhole(p[0], p[1])) {
                return 1;
            }

            for (int i = 0; i < 4; i++) {
                int[] next = move(p[0], p[1], p[2], p[3], i);

                if (isNotPossible(next)) {
                    continue;
                }

                int ry = next[0];
                int rx = next[1];
                int by = next[2];
                int bx = next[3];

                if (visited[ry][rx][by][bx]) {
                    continue;
                }

                q.add(new int[] {ry, rx, by, bx, p[4] + 1});
                visited[ry][rx][by][bx] = true;
            }
        }

        return 0;
    }

    public static int[] move(int ry, int rx, int by, int bx, int dir) {
        boolean redWhole = false;
        boolean blueWhole = false;

        int nry = ry;
        int nrx = rx;
        int nby = by;
        int nbx = bx;

        while (true) {
            nry += dy[dir];
            nrx += dx[dir];

            if (isWall(nry, nrx)) {
                break;
            }
            if (isWhole(nry, nrx)) {
                redWhole = true;
                break;
            }
        }

        while (true) {
            nby += dy[dir];
            nbx += dx[dir];

            if (isWall(nby, nbx)) {
                break;
            }
            if (isWhole(nby, nbx)) {
                blueWhole = true;
                break;
            }
        }

        if (!redWhole && blueWhole) {
            return INVALID_POSITION;
        }

        if (redWhole && blueWhole) {
            return INVALID_POSITION;
        }

        if (redWhole) {
            return new int[] {nry, nrx, nby, nbx};
        }

        while (true) {
            boolean redWall = false;
            boolean blueWall = false;

            ry += dy[dir];
            rx += dx[dir];
            by += dy[dir];
            bx += dx[dir];

            if (isWall(ry, rx)) {
                redWall = true;
                ry -= dy[dir];
                rx -= dx[dir];
            }

            if (isWall(by, bx)) {
                blueWall = true;
                by -= dy[dir];
                bx -= dx[dir];
            }

            if (redWall && blueWall) {
                break;
            }

            if (ry == by && rx == bx) { // 둘의 위치가 같은 경우
                if (redWall) {
                    by -= dy[dir];
                    bx -= dx[dir];
                } else {
                    ry -= dy[dir];
                    rx -= dx[dir];
                }

                break;
            }
        }

        return new int[] {ry, rx, by, bx};
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13459_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visited = new boolean[H][W][H][W];
        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = s.charAt(j);

                if (c == 'R') {
                    map[i][j] = '.';
                    redStart = new int[] {i, j};
                } else if (c == 'B') {
                    map[i][j] = '.';
                    blueStart = new int[] {i, j};
                } else {
                    map[i][j] = c;
                }
            }
        }

        System.out.println(bfs());
    }
}