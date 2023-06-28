import java.util.*;
import java.io.*;

// 1303 : 전쟁 - 전투

/**
 * Example
 * 5 5
 * WBWWW
 * WWWWW
 * BBBBB
 * BBBWW
 * WWWWW
 */
public class Main {

    public static int H;
    public static int W;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static Map<Character, Integer> m = Map.of('B', 0, 'W', 1);
    public static int[] ans = new int[2];

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static void bfs(int y, int x, char c) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        visited[y][x] = true;
        q.add(new int[] {y, x});

        while (!q.isEmpty()) {
            int[] point = q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || map[ny][nx] != c) {
                    continue;
                }

                visited[ny][nx] = true;
                q.add(new int[] {ny, nx});
            }
        }

        ans[m.get(c)] += count * count;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1303_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        visited = new boolean[H][W];
        map = new char[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                }
            }
        }

        System.out.println(ans[1] + " " + ans[0]);
    }
}