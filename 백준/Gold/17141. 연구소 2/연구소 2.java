import java.util.*;
import java.io.*;

// 17141 : 연구소 2

/**
 * Example
 * 7 3
 * 2 0 0 0 1 1 0
 * 0 0 1 0 1 2 0
 * 0 1 1 0 1 0 0
 * 0 1 0 0 0 0 0
 * 0 0 0 2 0 1 1
 * 0 1 0 0 0 0 0
 * 2 1 0 0 0 0 2
 */
public class Main {

    public static int N;
    public static int M;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static boolean[] selected;
    public static List<int[]> point;
    public static int ans = Integer.MAX_VALUE;
    public static int numberOfZero;

    public static void dfs(int index, int count) {
        if (index == point.size()) {
            if (count == M) {
                ans = Math.min(ans, spread());
            }

            return;
        }

        selected[index] = true;
        dfs(index + 1, count + 1);
        selected[index] = false;

        dfs(index + 1, count);
    }

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static int spread() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) {
                int y = point.get(i)[0];
                int x = point.get(i)[1];
                q.add(new int[] {y, x, 0});
                visited[y][x] = true;
            }
        }

        int maxTime = 0;
        int count = 0;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            maxTime = Math.max(maxTime, p[2]);
            count++;

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || map[ny][nx] != 0) {
                    continue;
                }

                q.add(new int[] {ny, nx, p[2] + 1});
                visited[ny][nx] = true;
            }
        }

        return count == numberOfZero ? maxTime : Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17141_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        point = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (value == 2) {
                    point.add(new int[] {i, j});
                    numberOfZero++;
                } else {
                    map[i][j] = value;

                    if (value == 0) {
                        numberOfZero++;
                    }
                }
            }
        }

        selected = new boolean[point.size()];
        dfs(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}