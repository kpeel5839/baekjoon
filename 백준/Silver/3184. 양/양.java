import java.util.*;
import java.io.*;

// 3184 : 양

/**
 * Example
 * 6 6
 * ...#..
 * .##v#.
 * #v.#.#
 * #.o#.#
 * .###.#
 * ...###
 */
public class Main {

    public static int H;
    public static int W;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] ans = new int[2];

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        int[] count = new int[2];
        visited[y][x] = true;
        q.add(new int[] {y, x});

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (map[point[0]][point[1]] == 'v') {
                count[1]++;
            } else if (map[point[0]][point[1]] == 'o') {
                count[0]++;
            }

            for (int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || map[ny][nx] == '#') {
                    continue;
                }

                visited[ny][nx] = true;
                q.add(new int[] {ny, nx});
            }
        }

        if (count[1] < count[0]) {
            ans[0] += count[0];
        } else {
            ans[1] += count[1];
        }
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_3184_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]); // ans[0] == 양의 수, ans[1] = 늑대수
    }
}