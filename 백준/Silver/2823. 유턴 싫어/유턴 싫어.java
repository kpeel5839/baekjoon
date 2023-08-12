import java.util.*;
import java.io.*;

// 2823 : 유턴싫어

/**
 * Example
 * 5 5
 * XX.XX
 * X...X
 * .....
 * X...X
 * XX.XX
 */
public class Main {
    public static int H;
    public static int W;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public boolean ans = true;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static boolean bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[H][W];
        q.add(new int[] {y, x, -1, -1});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny ,nx) || map[ny][nx] == 'X' || (ny == p[2] && nx == p[3])) {
                    continue;
                }

                cnt++;

                if (visited[ny][nx]) {
                    continue;
                }

                q.add(new int[] {ny, nx, p[0], p[1]});
                visited[ny][nx] = true;
            }

            if (cnt == 0) {
                return false;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '.' && !visited[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2823_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        int startY = 0;
        int startX = 0;

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == '.') {
                    startY = i;
                    startX = j;
                }
            }
        }

        if (bfs(startY, startX)) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}