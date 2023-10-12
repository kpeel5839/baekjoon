import java.util.*;
import java.io.*;

// 22352 : 항체 인식

/**
 * Example
 * 4 4
 * 2 2 2 1
 * 2 2 1 3
 * 2 1 3 3
 * 1 3 3 3
 * 4 4 4 1
 * 4 4 1 3
 * 4 1 3 3
 * 1 3 3 3
 */
public class Main {

    public static int H;
    public static int W;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static int[][] visited;
    public static int count = 1;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static void bfs(int y, int x, int number) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        visited[y][x] = count;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] != 0 || map[ny][nx] != number) {
                    continue;
                }

                visited[ny][nx] = count;
                q.add(new int[] {ny, nx});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_22352_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j, map[i][j]);
                    count++;
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        int[][] compare = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                int a = Integer.parseInt(st.nextToken());
                compare[i][j] = a;

                if (map[i][j] != a) {
                    set.add(visited[i][j]);
                }
            }
        }

        if (set.size() == 1) {
            int number = set.iterator().next();
            Set<Integer> setset = new HashSet<>();

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (visited[i][j] == number) {
                        setset.add(compare[i][j]);
                    }
                }
            }

            if (2 <= setset.size()) {
                System.out.println("NO");
                return;
            }
        }

        if (set.size() <= 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}